-- Module 14: Correlated subqueries

/*
L, A, F
---------------------------------
-- L (Looking for)
-- A (Aggregate)
-- F (For each)
---------------------------------
*/

-- 1. Use a correlated subquery to show the trade_id of the earliest transaction_time for each stock_exchange. 
-- The output should have 3 columns: stock_ex_id, trade_id, transaction_time.
SELECT 	t.stock_ex_id,
	t.trade_id,
        t.transaction_time
FROM trades t
WHERE t.transaction_time = (
	SELECT MIN(t2.transaction_time)
	FROM trades t2
   	WHERE t2.stock_ex_id = t.stock_ex_id
);


	
-- 2. Use a correlated subquery to show the broker with the highest price total for each stock_exchange. 
-- The output should have 3 columns: stock_ex_id, broker_id, price_total.
SELECT 	t.stock_ex_id, -- L (Looking for: stock_ex_id, broker_id, price_total
	t.broker_id,
        t.price_total
FROM trades t
WHERE t.price_total = (
	SELECT MAX(t2.price_total) -- A (Aggregate): price_total
   	FROM trades t2
    	WHERE t.stock_ex_id = t2.stock_ex_id
);



-- 3. Modify your query from question 1 to show the name of the stock exchange instead of the stock_ex_id.
-- HINT: join the stock exchanges table to the trades table in the outer query.
-- Q. Use a correlated subquery to show the trade_id of the earliest transaction_time for each stock_exchange. 
-- The output should have 3 columns: name of stock exchange, trade_id, transaction_time.
SELECT 	se.name,
	t.trade_id,
        t.transaction_time
FROM stock_exchanges se
INNER JOIN trades t
ON t.stock_ex_id = se.stock_ex_id
WHERE transaction_time = (
	SELECT MIN(t2.transaction_time)
    	FROM trades t2
	WHERE t.stock_ex_id = t2.stock_ex_id
);



-- 4. Modify your query from question 2 to show the name of the stock exchange and the name of the broker instead of their IDs.
-- Q: Use a correlated subquery to show the broker with the highest price total for each stock_exchange. 
-- The output should have 3 columns: stock exchange name, broker_id, price_total.
SELECT 	se.stock_ex_id AS 'Stock Exchange Name',
	concat(b.first_name, ' ', b.last_name) AS 'Broker Name',
        t.price_total
FROM stock_exchanges se
INNER JOIN trades t
ON se.stock_ex_id = t.stock_ex_id
INNER JOIN brokers b
ON b.broker_id = t.broker_id
WHERE t.price_total = (
	SELECT	MAX(t2.price_total)
    	FROM trades t2
    	WHERE t2.stock_ex_id = t.stock_ex_id
);



-- 5. Use a correlated subquery to show the broker with the lowest share amount for each month.
--  The output should have 3 columns: month, broker_id, share_amount.
-- HINT: use the DATE function variants to extract the month from the transaction_time column
SELECT	MONTH(t.transaction_time) AS 'Month',
	t.broker_id,
        t.share_amount
FROM trades t
WHERE t.share_amount = (
	SELECT	MIN(share_amount)
    	FROM trades t2
    	WHERE MONTH(t.transaction_time) = MONTH(t2.transaction_time)
);



-- 6. Modify the previous query to show the name of the broker instead of the broker_id.
-- Q. Use a correlated subquery to show the broker with the lowest share amount for each month.
--  The output should have 3 columns: month, broker name, share_amount.
SELECT 	MONTH(t.transaction_time) AS 'Month',
	concat(b.first_name, ' ', b.last_name) AS 'Broker Name',
	t.share_amount
FROM brokers b
LEFT OUTER JOIN trades t
ON b.broker_id = t.broker_id
WHERE t.share_amount = (
	SELECT MIN(t2.share_amount)
    	FROM trades t2
    	WHERE MONTH(t.transaction_time) = MONTH(t2.transaction_time)
);

