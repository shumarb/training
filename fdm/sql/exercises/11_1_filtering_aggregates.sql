-- Module 11 Exercise: Filtering Aggregates

-- 1. List broker IDs which have an average price total of over 4,000,000
-- HINT: modify your query from module 9 part 1.
SELECT 	broker_id AS "Broker ID"
FROM trades
GROUP BY broker_id
HAVING AVG(price_total) > 4000000;



-- 2. List stock exchange IDs where each stock exchange’s earliest transaction time took place
-- within the last 365 days.
-- HINT: modify your query from module 9 part 2.
SELECT stock_ex_id AS "Stock Exchange ID"
FROM trades
GROUP BY stock_ex_id
HAVING MIN(transaction_time) > DATE_ADD(NOW(), INTERVAL -365 DAY);



-- 3. List currency IDs used to price 4 or more shares.
-- HINT: modify your query from module 9 part 3.
SELECT currency_id AS "Currency ID"
FROM shares
GROUP BY currency_id
HAVING COUNT(currency_id) >= 4;



-- 4. List share IDs with a total share amount above 100,000
-- HINT: modify your query from module 9 part 4.
SELECT 	share_id AS "Share ID"
FROM trades
GROUP BY share_id
HAVING SUM(share_amount) > 100000;



-- 5. List place IDs with more than 2 companies.
-- HINT: find the number of companies for each place ID and then filter your results.
SELECT 	place_id AS "Place ID"
FROM companies
GROUP BY place_id
HAVING COUNT(company_id) > 2;



-- 6. List share IDs whose highest price total is above 1 million.
-- HINT: find the highest price total for each share ID and then filter your results.
SELECT 	share_id AS "Share ID"
FROM trades
GROUP BY share_id
HAVING MAX(price_total) > 1000000;



-- 7. List share IDs which have been traded more than twice by broker ID 1.
-- HINT: use WHERE and HAVING
SELECT 	share_id AS "Share ID"
FROM trades
WHERE broker_id = 1
GROUP BY share_id
HAVING COUNT(broker_id) > 2;



-- 8. List share IDs which have more than 5 trades with a price_total above 1 million.
-- HINT: use WHERE and HAVING
SELECT 	share_id AS "Share ID"
FROM trades
WHERE price_total > 1000000
GROUP BY share_id
HAVING COUNT(share_id) > 5;

