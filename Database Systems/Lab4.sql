--1. Get the cities of agents booking an 
--order for a customer whose cid is 'c002'.

SELECT city
FROM agents
WHERE aid IN(SELECT aid
	       FROM orders
	      WHERE cid IN (SELECT cid
			      FROM customers
			      WHERE cid = 'c002')
	    );
--2. Get the ids of products ordered 
--through any agent who takes at least one
--order from a customer in Dallas, sorted 
--by pid from highest to lowest. (This is 
--not the same as asking for ids of 
--products ordered by customers in Dallas.)

SELECT pid
FROM orders
WHERE aid IN (SELECT aid
		FROM orders
	       WHERE cid IN (SELECT cid
			       FROM customers 
			      WHERE city = 'Dallas')
	     )
ORDER BY pid DESC;

--3. Get the ids and names of customers who 
--did not place an order through agent a01.

SELECT cid, name
FROM customers
WHERE cid NOT IN (SELECT cid
	        FROM orders
	       WHERE aid IN (SELECT aid
				FROM orders
			       WHERE aid <> 'a01')
	      );

--4. Get the ids of customers who ordered 
--both product p01 and p07.
SELECT cid
FROM customers
WHERE cid IN (
	SELECT cid
	FROM orders
	WHERE pid IN (SELECT pid 
			FROM orders
		       WHERE pid = 'p01'
			  OR pid = 'p07')
	    );

--5. Get the ids of products not ordered by
--any customers who placed any order through 
--agent a07 in pid order from highest to 
--lowest.

SELECT pid
FROM products
WHERE pid NOT IN (SELECT pid
		    FROM orders
		    WHERE cid IN (SELECT cid 
				    FROM customers
				   WHERE cid IN (SELECT cid
						   FROM orders
						   WHERE aid = 'a07')
				  )
		  )
ORDER BY pid DESC;


--6. Get the name, discounts, and city for 
--all customers who place orders through 
--agents in London or New York.

SELECT name, discount, city
FROM customers
WHERE cid IN (SELECT cid
	      FROM orders
	      WHERE aid IN (SELECT aid
			      FROM agents
			     WHERE city = 'London'
			     OR    city = 'New York')
	     );

--7. Get all customers who have the same 
--discount as that of any customers in 
--Dallas or London

SELECT *
FROM customers
WHERE discount IN (SELECT discount
		     FROM customers
		    WHERE city = 'Dallas'
		    OR    city = 'London');




--8. Tell me about check constraints: What 
--are they? What are they good for? What’s 
--the advantage of putting that sort of 
--thing inside the database? Make up some 
--examples of good uses of check constraints 
--and some examples of bad uses of check 
--constraints. Explain the differences in 
--your examples and argue your case.


--Check constraints are query modifiers 
--which refine query results. Check 
--constraints are food for displaying
--certain parts of the data and specific
--cross referencing table data. 

--A good example of a good use of a check 
--constraint is a modification of # 2 from 
--this lab. The addition of the DISTINCT 
--constraint removes all the duplicates in the 
--results for "the ids of products ordered 
--through any agent who takes at least one
--order from a customer in Dallas, sorted 
--by pid from highest to lowest." This function
--is helpful whenever there are duplicate rows
--in the data output.

SELECT DISTINCT pid
FROM orders
WHERE aid IN (SELECT aid
		FROM orders
	       WHERE cid IN (SELECT cid
			       FROM customers 
			      WHERE city = 'Dallas')
	     )
ORDER BY pid DESC;

-- A bad example of check constraints is  
--this query of all the orders in the CAP3 
--database. Using the DISTINCT constraint
--is not helpful on the ordnum because the 
--ordnum is a primary key meaning that 
--due to the rules of referential integrity
--there cannot be duplicate ordernums (it is 
--already distinct).

SELECT ordnum DISINCT, cid 
FROM orders;