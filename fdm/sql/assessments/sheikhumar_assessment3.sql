/* Assessment 3 */

-- 1. Using the ‘employees’ table. 
-- Assuming every employee is a boss, display a list showing bosses with or without employees. Order by boss name. (14 rows)
SELECT 	e1.name AS "Boss",
		e2.name AS "Employee"
FROM employees e1
LEFT OUTER JOIN employees e2
ON e1.employee_id = e2.boss_id
ORDER BY e1.name;



-- 2. Write a query showing the name of the broker who made the trade with the smallest share_amount. (1 row)
-- use a simple subquery and remove any duplicates
SELECT DISTINCT concat(b.first_name, ' ', b.last_name) AS 'Broker Name'
FROM brokers b
INNER JOIN trades t
ON b.broker_id = t.broker_id
WHERE share_amount = (
	SELECT MIN(share_amount)
    FROM trades
);



-- 3. Create a VIEW called trade_broker with the following columns (e.g. trade_id) to aliases (e.g. "Trade") (0 rows):
-- a) trade table 'trade_id' as "Trade"
-- b) brokers table 'first_name' and 'last_name' as "Broker"
-- c) trade table 'transaction_time' as "Transaction Time"
-- d) trade table 'share_id' as "Share"
-- e) trade table 'share_amount' as "Share Amount",
-- f) table 'price_total' as "Price Total"
CREATE OR REPLACE VIEW trade_broker AS
SELECT 	t.trade_id AS "Trade",
		concat(b.first_name, ' ', b.last_name) AS "Broker",
		t.transaction_time AS "Transaction Time",
		t.share_id AS "Share",
        t.share_amount AS "Share Amount",
        t.price_total AS "Price Total"
FROM trades t
INNER JOIN brokers b
ON t.broker_id = b.broker_id;



-- 4. Write using the view in the previous question, 
-- write a query that displays the brokers who have a price total greater than £1 million. (5 rows)
SELECT DISTINCT `Broker`
FROM trade_broker
WHERE `Price Total` > 1000000;
