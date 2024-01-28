/* Assessment 2 */

-- 1. Write a query which shows the highest price total. (1 row)
SELECT MAX(price_total) AS 'Highest price total'
FROM trades;



-- 2. Write a query which shows the highest and lowest price totals in the trades table.
-- The results should be displayed in a single column. (2 rows)
SELECT MAX(price_total) AS 'Highest and Lowest price totals'
FROM trades
UNION
SELECT MIN(price_total)
FROM trades;



-- 3. Write a query which shows the average share price for each share ID - use the shares_prices table. 
-- Round the averages to zero decimal places and order by the share_id (8 rows)
SELECT share_id, ROUND(AVG(price), 0) AS 'Average share price'
FROM shares_prices
GROUP BY share_id
ORDER BY share_id;



-- 4. Write a query which shows the trade_id with the lowest price_total for each share_id and order it by price_total. 
-- Also display the broker_id and broker_name (first name and last name under the column “Broker Name”) (8 rows)
SELECT 	concat(b.first_name, ' ', b.last_name) AS "Broker Name",
		t.trade_id,
        t.share_id,
        MIN(t.price_total) AS "Minimum Price Total"
FROM trades t
INNER JOIN brokers b
ON t.broker_id = t.broker_id
GROUP BY concat(b.first_name, ' ', b.last_name), 
		 t.trade_id,
		 share_id
ORDER BY price_total;


-- 5. Write a query which shows any share IDs where broker 1 has made more than 2 trades. (3 rows) 
SELECT share_id
FROM trades
WHERE broker_id = 1
GROUP BY share_id
HAVING COUNT(trade_id) > 2;
