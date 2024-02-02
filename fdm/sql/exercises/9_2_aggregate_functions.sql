-- Module 9 – Extra questions: Aggregate functions, GROUP BY & Joins

-- 1. How many trades have been made ON NYSE.
-- HINT: use WHERE and a join
SELECT se.symbol, COUNT(se.symbol)
FROM trades t
INNER JOIN stock_exchanges se
ON se.stock_ex_id = t.stock_ex_id
WHERE se.symbol = 'NYSE'
GROUP BY se.symbol, se.name;



-- 2. How many shares have been traded ON the LSE (total share_amount).
-- HINT: use WHERE and a join
SELECT se.symbol, sum(t.share_amount) as "Total shares traded"
FROM stock_exchanges se
INNER JOIN trades t
ON se.stock_ex_id = t.stock_ex_id
WHERE se.symbol = 'LSE'
GROUP BY se.symbol;



-- 3. How many companies based in the UK have names starting with B.
-- HINT: use WHERE and a join
SELECT COUNT(name)
FROM companies c
INNER JOIN places p
ON c.place_id = p.place_id
WHERE name like 'B%'
and p.country = 'United Kingdom';



-- 4. The number of trades made by any broker in the last 10 days. 
-- Show 2 columns: broker name and number of trades.
-- HINT: use WHERE, a join & GROUP BY
SELECT 	concat(b.first_name, ' ', b.last_name) AS broker_name,
	count(t.trade_id) AS "Number of Trades"
FROM brokers b
INNER JOIN trades t
ON b.broker_id = t.broker_id
WHERE transaction_time > DATE_ADD(NOW(), INTERVAL -10 DAY)
GROUP BY concat(b.first_name, ' ', b.last_name);



-- 5. The total share_amount for any company in the last 90 days. 
-- Show 2 columns: company name and total share amount.
-- HINT: use WHERE, a join & GROUP BY
SELECT 	c.name, SUM(t.share_amount) AS "Total share amount",
	t.transaction_time
FROM companies c
INNER JOIN shares s
ON s.company_id = c.company_id
INNER JOIN trades t
ON s.share_id = t.share_id
WHERE transaction_time > DATE_ADD(NOW(), INTERVAL -90 DAY)
GROUP BY c.name, t.transaction_time;



-- 6. Create a list showing the number of companies per city. 
-- The result should have two columns: City and number of companies.
-- HINT: use a join & GROUP BY
SELECT p.city, COUNT(c.name) AS "Number of companies"
FROM companies c
INNER JOIN places p
ON c.place_id = p.place_id
GROUP BY p.city;



-- 7. Find the average price total for each company. 
-- The results should have two columns:
-- company name and average price total. Round the average to 0 decimal places.
-- HINT: use a join & GROUP BY
SELECT c.name, ROUND(AVG(t.price_total), 0) AS "Average price total"
FROM companies c
INNER JOIN shares s
ON c.company_id = s.company_id
INNER JOIN trades t
ON t.share_id = s.share_id
GROUP BY c.name;



-- 8. Create a list showing the name of each broker and the number of stock exchanges that they
-- trade ON. The result should have two columns: broker name, number of exchanges.
-- HINT: use a join & GROUP BY

SELECT  concat(b.first_name, ' ', b.last_name) AS "Broker name",
	COUNT(bse.broker_id) AS "Number of exchanges"
FROM brokers b
INNER JOIN broker_stock_ex bse
ON b.broker_id = bse.broker_id
GROUP BY concat(b.first_name, ' ', b.last_name);



-- 9. Create a list of names of currencies and the number of shares each currency is used to price.
-- The result should have two columns: currency name, number of shares.
-- HINT: use a join & GROUP BY
SELECT c.name, COUNT(s.share_id) AS "Number of shares"
FROM shares s
INNER JOIN currencies c
ON s.currency_id = c.currency_id
GROUP BY c.name;



-- 10. Create a list showing the average of share price per month per company. The result should
-- have three columns: company name, month and average price (rounded to 2 decimal places).
-- Make sure the results are ordered by the company name and the month.
-- HINT: join shares_prices, shares and companies. GROUP BY 2 columns. Use TO_CHAR to
-- extract the month from the time_start column
SELECT 	c.name, 
	MONTH(NOW()) AS "month",
	ROUND(AVG(sp.price), 2) AS "Average price"
FROM companies c
INNER JOIN shares s
ON c.company_id = s.company_id
INNER JOIN shares_prices sp
ON sp.share_id = s.share_id
GROUP BY c.name, MONTH(NOW())
ORDER BY c.name, MONTH(NOW());

