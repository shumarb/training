-- 1. Create a list of companies and their locations. 
-- The results should have three columns - company name, city & country.
SELECT  c.name,
		p.city,
        p.country
FROM 	companies c, 
		places p;

-- 2. Create a list of the companies and the stock exchanges they’re traded on. 
-- The results should show company name and stock exchange name.
-- HINT: join the companies table directly to the stock exchange table.
SELECT  c.name,
		se.name
FROM  		companies c
INNER JOIN 	stock_exchanges se
ON
	c.place_id = se.place_id;
    
-- 3. Create a list of shares and the currencies they’re priced in. 
-- The results should have two columns – share_id and currency name.
SELECT 	s.share_id,
		c.name
FROM currencies c
INNER JOIN shares s
ON c.currency_id = s.currency_id;

-- 4. Create a list of all currency names and any shares they’re used to price. 
-- The list should include currencies which are not used to price any share.
-- The results should show two columns: currency name and share_id.
-- HINT: modify your query from question 3 to use an outer join.
SELECT 	s.share_id,
		c.name
FROM currencies c
RIGHT OUTER JOIN shares s
ON c.currency_id = s.currency_id;



-- 5. Find the name of any currencies that are not used to price any share.
-- HINT: modify your query from question 4 to use a filter.

-- 6. Write a query that will give you the name of each company and the name of the currency their shares are traded in.
-- HINT: join 3 tables – companies, shares and currencies
SELECT c.name, s.company_id, s.share_id
FROM companies c
INNER JOIN shares s
ON c.company_id = s.company_id

INNER JOIN currencies curr
ON s.currency_id = curr.currency_id;

-- 7. Create a list of the brokers with the stock exchanges assigned to them. 
-- The results should have two columns – broker’s name & stock exchange name.
-- HINT: join 3 tables – brokers, broker_stock_ex and stock_exchanges.

-- 8. Without using the price_total column from trades table, work out the price total for each
-- trade_id (give it the alias "Base Price Total").
-- HINT: Finding the price of a share involves comparing its transaction time with the time
-- the share acquired a price and the time the share ended having the same price. For
-- shares that don't have time end, find their current price by comparing their transaction time with time start only.

-- 9. Amend the query produced in previous task to include the commission for each trade
-- (0.025 of the base price total), as well as the overall price total (base price total +
-- commission)

COMMIT;