-- Module 7 Exercise – Subqueries – Part 1

-- 1. Write a query which shows the names of stock exchanges where some trades have been made.
-- HINT: Use the stock exchanges and trades tables.
SELECT se.name
FROM stock_exchanges se
WHERE se.stock_ex_id IN (
	SELECT stock_ex_id
    	FROM trades
);

/*
Answer
SELECT name 
FROM   stock_exchanges
WHERE  stock_ex_id IN (
	SELECT stock_ex_id
	FROM   trades
);
*/



-- 2. Modify your previous query so that it shows the names of stock exchanges where no trades have been made.

SELECT se.name
FROM stock_exchanges se
WHERE se.stock_ex_id NOT IN
(
	SELECT stock_ex_id
    FROM trades
);

/*
Answer
SELECT name 
FROM   stock_exchanges
WHERE  stock_ex_id NOT IN
(
SELECT stock_ex_id
FROM   trades
);
*/



-- 3. Write a query which shows the names of cities which have a stock exchange.
-- HINT: Use the stock exchanges and places tables.

SELECT city
FROM places
WHERE place_id IN
(
	SELECT place_id
    FROM stock_exchanges
);

/*
Answer
SELECT city
FROM   places
WHERE  place_id IN
(
SELECT place_id 
FROM   stock_exchanges
);
*/



-- 4. Modify your previous query to show cities which don’t have a stock exchange.

SELECT city
FROM places
WHERE place_id NOT IN
(
	SELECT place_id
    FROM stock_exchanges
);

/*
Answer
SELECT city
FROM   places
WHERE  place_id NOT IN
(
SELECT place_id 
FROM   stock_exchanges
);
*/
