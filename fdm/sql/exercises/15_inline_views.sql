-- Module 15: Inline views

-- 1. Write a query which shows the average share amount for each broker_id rounded to zero
-- decimal places. (this query is not an inline view)
SELECT 	broker_id, 
	ROUND(AVG(share_amount), 0) AS 'Average share amount'
FROM trades
GROUP BY broker_id;



-- 2. Write a query which shows the lowest average share amount for any broker.
-- HINT: turn the query in question 1 into an inline view and select the lowest number from
-- the average share amount column.
SELECT MIN(average_share_amount)
FROM (
	SELECT 	broker_id, 
		ROUND(AVG(share_amount), 0) AS average_share_amount
	FROM trades
    	GROUP BY broker_id
) a;



-- 3. Write a query which shows the average share amount for every broker including those
-- brokers who haven’t made any trades. 
-- Your query should return 2 columns: broker name, average share amount.
-- HINT: turn the query from question 1 into an inline view and join it to the brokers table.
SELECT 	concat(b.first_name, ' ', b.last_name) AS 'Broker Name',
	a.average_share_amount
FROM brokers b
LEFT OUTER JOIN
(
	SELECT  broker_id,
		AVG(share_amount) AS average_share_amount
	FROM trades
	GROUP BY broker_id
) a
ON a.broker_id = b.broker_id;



-- 4. Write a query which shows the number of trades for each share. (this query is not an inline view)
SELECT 	share_id, 
	COUNT(trade_id) AS "Number of trades"
FROM trades t
GROUP BY share_id;



-- 5. Write a query which shows the highest number of trades for any share.
-- HINT: turn the query from question 4 into an inline view and select the highest number of trades from it.
SELECT MAX(number_of_trades)
FROM (
	SELECT 	share_id, 
		COUNT(*) AS number_of_trades
	FROM trades
    	GROUP BY share_id
) a;

