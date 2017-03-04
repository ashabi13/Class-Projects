--Use CAP3 to answer all of these questions.

--1. Show the cities of agents booking an 
--order for a customer whose id is 'c002'. 
--Use joins; no subqueries.

SELECT a.city
FROM orders o 
	 JOIN customers c ON o.cid = c.cid
	 JOIN agents a    ON o.aid = a.aid
WHERE o.cid = 'c002';

--2. Show the ids of products ordered through 
--any agent who makes at least one order for a 
--customer in Dallas, sorted by pid from 
--highest to lowest. Use joins; no subqueries.

SELECT p.pid
FROM orders o
	JOIN products p	  ON o.pid = p.pid
	JOIN agents a 	  ON o.aid = a.aid
	JOIN customers c  ON o.cid = c.cid
WHERE 	c.city = 'Dallas'
ORDER BY p.pid DESC;
	

--3. Show the names of customers who have 
--never placed an order. Use a subquery.

SELECT name
FROM customers
WHERE cid NOT IN(SELECT DISTINCT cid
		 FROM	orders
		);
		
--4. Show the names of customers who have 
--never placed an order. Use an outer join.

SELECT name
FROM orders o
	RIGHT JOIN customers c  ON o.cid = c.cid
WHERE o.cid IS NULL;

--5. Show the names of customers who placed 
--at least one order through an agent in 
--their own city, along with those agent(s') 
--names.

SELECT DISTINCT c.name as customer , a.name as agent
FROM customers c
	JOIN orders o ON c.cid=o.cid
	JOIN agents a ON o.aid=a.aid
WHERE c.city = a.city;

--6. Show the names of customers and agents 
--living in the same city, along with the 
--name of the shared city, regardless of 
--whether or not the customer has ever placed 
--an order with that agent.

SELECT DISTINCT c.name as customer, a.name as agent, c.city
FROM customers c
	JOIN agents a ON c.city=a.city;

--7. Show the name and city of customers who 
--live in the city that makes the fewest 
--different kinds of products. (Hint: Use 
--count and group by on the Products table.)




SELECT DISTINCT c.name, count(p.city), c.city as leastC
FROM customers c 
	JOIN products p ON c.city=p.city
WHERE c.city IN (SELECT  p.city
		 FROM products p
		 GROUP BY p.city
		 ORDER BY count(p.city) ASC
		 LIMIT 1)
GROUP BY c.city, c.name
ORDER BY count ASC;

-- So for number seven above I was 
-- struggling with turning these two 
-- queries into one. It wasn’t until 
-- I figured out that the count could 
-- go after the 'ORDER BY' that I was
-- able to isolate the results of the 
-- inner query to output only the city 
-- name. So, it is helpful now to know
-- that the count can be called from
-- both the 'SELECT' and the 'ORDER BY'
--
-- SELECT  c.name, count(p.city), c.city
-- FROM customers c 
-- 	JOIN products p ON c.city=p.city
-- GROUP BY c.city, c.name
-- ORDER BY count ASC;
-- 
-- SELECT  p.city--, count(p.city)
-- FROM products p
-- GROUP BY p.city
-- ORDER BY count(p.city) ASC
-- LIMIT 1;

