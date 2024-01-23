-- Module 10 Exercise Sub-queries – Part 2

-- 1. Show the stock_ex_id of the stock exchange where the most recent trade took place.
-- HINT: start by finding the date of the most recent trade
SELECT MAX(transaction_time)
FROM   trades;

-- 2. Show the broker_id of the broker who made the trade with the highest trade_id.
SELECT	broker_id,
	MAX(trade_id)
FROM	trades
GROUP BY broker_id;

-- 3. List the trade_ids which have an above average share_amount.
SELECT	trade_id
FROM 	trades
WHERE 	share_amount > (
	SELECT AVG(share_amount)
	FROM trades
);

