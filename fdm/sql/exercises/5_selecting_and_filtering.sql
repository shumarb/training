/*
 Module 5 Exercise – Selecting & Filtering
 */

-- 1. What currencies are available to price shares in? 
SELECT name
FROM currencies;

-- 2. What trades have been made this month?
SELECT * 
FROM trades
WHERE MONTH(transaction_time) = MONTH(curdate())
AND YEAR(transaction_time) = YEAR(curdate());

-- 3. What companies have their head quarters in New York (place_id 3)?
SELECT * 
FROM COMPANIES
WHERE place_id = 3;

-- 4. What is the Symbol used for the London Stock Exchange?
SELECT symbol 
FROM stock_exchanges
WHERE name = 'London Stock Exchange';

-- 5. What cities are associated with France?
SELECT city 
FROM places
WHERE country = 'France';

-- 6. There are two brokers called John, what are their last names?
SELECT last_name
FROM brokers
WHERE first_name = 'John';

-- 8. List the broker ids who work at the stock exchange id of 1.
SELECT broker_id
FROM broker_stock_ex
WHERE stock_ex_id = 1;

-- 9. Display the company that has a company id of 2.
SELECT name
FROM companies
WHERE company_id = 2;

-- 10. Display the currency that has a currency id of 1.
SELECT name
FROM currencies
WHERE currency_id = 1;

-- 11. Display the name of the Stock exchange with the symbol TSE.
SELECT name
FROM stock_exchanges
WHERE symbol = 'TSE';

-- 12. Display the last name of the broker whose id is 2.
SELECT last_name
FROM brokers
WHERE broker_id = 2;

-- 13. List the trade ids & price totals of the trades which have taken place at 
-- the stock ex id of 3 and share_amount greater than 20000.
SELECT trade_id, price_total
FROM trades
WHERE stock_ex_id = 3
AND share_amount > 20000;

-- 14. What are the broker ids for the brokers working at stock exchange 2? 
-- Sort the broker ids into ascending order.
SELECT broker_id
FROM broker_stock_ex
WHERE stock_ex_id = 2;

-- 15. Which currencies have the word "British" in them?
SELECT *
FROM currencies
WHERE name LIKE '%British%';

-- 16. Which stock exchanges contain "SE" in their symbol. 
-- What are their full names? Sort them into descending order.
SELECT name
FROM stock_exchanges
WHERE symbol LIKE '%SE%'
ORDER BY name DESC;

-- 17. Which share ids have their prices between 400 and 500?
SELECT share_id
FROM shares_prices
WHERE price >= 400
AND price <= 500;

-- 19. Which trade ids took place in this calendar year (i.e. since 1 January)?
SELECT trade_id
FROM trades
WHERE YEAR(transaction_time) = YEAR(curdate())
AND MONTH(transaction_time) = MONTH(curdate());

-- 20. Display full details of all trades which took place last year.
SELECT *
FROM trades
WHERE YEAR(transaction_time) = 2023;

-- 21. Display full details of all trades which took place in the previous quarter.
SELECT *
FROM trades
WHERE DATE_ADD(curdate(), INTERVAL 4 QUARTER);

-- 23. Calculate and display the cost per share for each trade.
SELECT  trade_id, 
		price_total / share_amount
FROM trades;

-- 22. Which trade ids have had price totals of over 1,000,000 in the last 90 days?
SELECT 	trade_id, 
		transaction_time
FROM trades
WHERE price_total > 1000000
AND DATE_ADD(NOW(), INTERVAL -90 DAY);

-- 18. Which shares were traded in the last year? (i.e. since this day last year)
SELECT *
FROM trades
WHERE transaction_time > DATE_ADD(NOW(), INTERVAL -1 YEAR);

-- 7. What trades have been made in the last 7 days?
SELECT *
FROM trades
WHERE transaction_time > DATE_ADD(NOW(), INTERVAL -7 DAY);

COMMIT;