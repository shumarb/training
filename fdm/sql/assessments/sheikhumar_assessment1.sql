-- Core SQL NEW Project - Phase 1
-- Submission by Sheikh Umar

-- 1. Write a query which shows full details of any trade made by the broker with broker ID 4. (6 rows)
SELECT *
FROM trades
WHERE broker_id = 4;



-- 2. Write a query showing the share_id, trade_id, price_total & share_amount 
-- for any trades where the price total is more than £2 million and the share amount is more than 20,000. (11 rows)
SELECT 	share_id, 
		trade_id, 
        price_total,
        share_amount
FROM trades
WHERE price_total > 2000000
AND share_amount > 20000;



-- 3. Write a query which shows the broker IDs of any brokers who’ve made a trade today. (1 row)
SELECT broker_id
FROM trades
WHERE transaction_time > CURDATE();



-- 4. Write a query to show the share_id of each share that has been traded more than 5 times, 
-- along with the number of times the share has been traded. 
-- Output the share with the largest number of trades first, the second-largest second and so on. (6 rows)
SELECT 	share_id,
		COUNT(share_id) AS "Number of times share has been traded"
FROM trades
GROUP BY share_id
HAVING COUNT(share_id) > 5
ORDER BY COUNT(share_id) DESC;



-- 5. Write a query which shows any share IDs which have never been traded. (1 row)
SELECT 	share_id
FROM trades
WHERE transaction_time IS NULL;

/*
Post-submission work

*/
