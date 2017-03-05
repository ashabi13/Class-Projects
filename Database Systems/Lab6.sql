-- Use CAP3 to answer all of these questions.
-- 1. Display the name and city of customers 
--who live in any city that makes the most 
-- different kinds of products. (There are two 
-- cities that make the most different products. 
-- Return the name and city of customers from 
-- either one of those.)

SELECT*
FROM customers
WHERE city IN (SELECT  city
		FROM products
		GROUP BY city
		ORDER BY count(name) DESC
		LIMIT 1);


-- 2. Display the names of products whose 
--priceUSD is strictly above the average priceUSD,
--in reverse-alphabetical order.

SELECT name
FROM products
WHERE priceUSD BETWEEN	(SELECT avg(priceUSD)
			FROM products
			ORDER BY avg(priceUSD))
		AND	(SELECT max(priceUSD)
			FROM products
			ORDER BY max(priceUSD))
ORDER BY name DESC;


-- 3. Display the customer name, pid ordered, and 
--the total for all orders, sorted by total from 
--high to low.

SELECT c.name, o.pid, totalUSD
FROM orders o
	JOIN customers c ON o.cid = c.cid
GROUP BY c.name, o.pid, totalUSD
ORDER BY totalUSD DESC;

-- 4. Display all customer names (in alphabetical 
--order) and their total ordered, and nothing more. 
--Use coalesce to avoid showing NULLs.

SELECT c.name, COALESCE(o.qty, o.totalUSD), o.cid
FROM orders o
	JOIN customers c ON o.cid=c.cid
GROUP BY  c.name, o.qty, o.totalUSD, o.cid
ORDER BY sum(o.qty);

-- 5. Display the names of all customers who bought 
--products from agents based in Tokyo along with 
--the names of the products they ordered, and the 
--names of the agents who sold it to them.

SELECT c.name AS customer, p.name AS product, a.name AS agent
FROM orders o
	JOIN	agents a    ON o.aid = a.aid 
	JOIN	customers c ON o.cid = c.cid
	JOIN 	products p  ON o.pid = p.pid
WHERE a.city = 'Tokyo';

-- 6. Write a query to check the accuracy of the 
--dollars column in the Orders table. This means 
--calculating Orders.totalUSD from data in other 
--tables and comparing those values to the values in 
--Orders.totalUSD. Display all rows in Orders where 
--Orders.totalUSD is incorrect, if any.
--the ones that are wrong are:
--ordnum 1015 (projectedtotal 1098.00, totalusd 1104.00, sold by "Perry")
--ordnum 1026 (projectedtotal 70.00, totalusd 1104.00, sold by "Perry")
--Perry you sneeky devil! ^o^ =D 

SELECT 	o.ordnum, 
	o.qty, 
	p.priceUSD, 
	c.discount, 
	ROUND((p.priceUSD*(1-(c.discount/100))),2) 
		AS discountedPrice, 
	ROUND((p.priceUSD*(1-(c.discount/100))*o.qty),2)
		AS projectedTotal,
	o.totalUSD,
	a.name AS soldBy
FROM orders o
	JOIN	agents a    ON o.aid = a.aid 
	JOIN	customers c ON o.cid = c.cid
	JOIN 	products p  ON o.pid = p.pid;


-- 7. What’s the difference between a LEFT OUTER JOIN 
--and a RIGHT OUTER JOIN? Give example queries in SQL 
--to demonstrate. (Feel free to use the CAP2 (<<CAP3??)
--database to make your points here.)

--So, outer joins generate tuples that are "padded" with 
--NULL values where matches do not exist. So if you do a
--full outer join on orders and agents you will see all 
--the existing relationships and where ther do not exist.

SELECT 	a.*, p.*
FROM orders o
	FULL OUTER JOIN agents a    ON o.aid = a.aid
	FULL OUTER JOIN products p  ON o.pid = p.pid;

--For example, every order has an agent and a product
--but not every product and agent are associated with an
--order we see because of the null valued order, agent and 
--product tuples, that there are no orders associated with
--agent 'Bond' or product 'clip.'  in a LEFT OUTER JOIN
--all rows in the table on the left side of the join will 
--be displayed in the data output whether or not they have 
--a relation to the table on the right side of the join. 
--Likewise, RIGHT OUTER JOIN all rows in the table on the
--right side of the join will be displayed whether or not
--they hav a relation to the table on the left side of the
--join.

SELECT 	*
FROM orders o
	RIGHT OUTER JOIN agents a    ON o.aid = a.aid;
--The right join outputs the one agent who is not 
--assocciated with any orders. Bond is not associated with 
--any orders

SELECT 	*
FROM orders o
	LEFT OUTER JOIN agents a    ON o.aid = a.aid;
--Since the orders is an associative entity it is a bad 
--example of a left join because there are no orders that
--can lack an agent by definition.