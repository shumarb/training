-- Module 11: Filtering Aggregates – extra questions

-- 1. List stock ex ids with an average share amount above 1000 in the last 60 days.
SELECT 	stock_ex_id AS "Stock Ex ID"
FROM trades
WHERE transaction_time > DATE_ADD(CURDATE(), INTERVAL -60 DAY)
GROUP BY stock_ex_id
HAVING AVG(share_amount) > 1000;



-- 2. Modify your query to show the names of the stock exchanges.
SELECT se.name AS "Stock Exchange Name"
FROM stock_exchanges se
INNER JOIN trades t
ON t.stock_ex_id = se.stock_ex_id
WHERE transaction_time > DATE_ADD(CURDATE(), INTERVAL -60 DAY)
GROUP BY se.name
HAVING AVG(share_amount) > 1000;



-- 3. List broker ids who’s lowest share amount on stock ex id 1 is greater than 5000
SELECT broker_id
FROM trades
WHERE stock_ex_id = 1
GROUP BY broker_id
HAVING MIN(share_amount) > 5000;



-- 4. Modify your query to show the names of the brokers.
SELECT concat(b.first_name, ' ', b.last_name) AS "Broker Name"
FROM brokers b
INNER JOIN trades t
ON b.broker_id = t.broker_id
WHERE stock_ex_id = 1
GROUP BY concat(b.first_name, ' ', b.last_name)
HAVING MIN(share_amount) > 5000;



-- 5. List share ids which broker 1 has traded more than 10 times.
SELECT share_id
FROM trades
WHERE broker_id = 1
GROUP BY share_id
HAVING COUNT(broker_id) > 10;



-- 6. List the names of companies in London with an average share price above 150.
SELECT 	c.name AS "Company Name"
FROM places p
LEFT OUTER JOIN companies c
ON p.place_id = c.place_id
INNER JOIN shares s
ON c.company_id = s.company_id
INNER JOIN shares_prices sp
ON sp.share_id = s.share_id
WHERE city = "London"
GROUP BY c.name
HAVING AVG(sp.price) > 150;



-- 7. Display the name of the broker who has the highest average share amount.
-- HINT: user a subquery in your HAVING filter. The inner query should combine 2
-- aggregate functions to find the highest average share amount for a broker id.
SELECT 	concat(b.first_name, ' ', b.last_name) AS "Broker Name",
	AVG(share_amount) AS 'Average Share Amount'
FROM brokers b
INNER JOIN trades t
ON b.broker_id = t.broker_id
GROUP BY concat(b.first_name, ' ', b.last_name)
ORDER BY AVG(share_amount) DESC 
LIMIT 1;



-- 8. List share IDs whose lowest share amount is greater than the highest share amount for share ID 4.
-- HINT: use a subquery in your HAVING filter
SELECT share_id
FROM trades
GROUP BY share_id
HAVING MIN(share_amount) > (
	SELECT MAX(share_amount)
    	FROM trades t
    	WHERE share_id = 4
);

