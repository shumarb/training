-- Module 8 Exercise - Set Functions

-- Write a query which shows share ids traded by broker 1.
select share_id
from trades
where broker_id = 1;


-- Write a query which shows share ids traded on stock exchange 3.
select share_id
from trades
where stock_ex_id = 3;


-- 1. Use a set function to combine the two queries to show share ids 
-- which were traded by broker 1 or traded on stock exchange 3 (or both).
(select share_id
from trades
where broker_id = 1)
union
(select share_id
from trades
where stock_ex_id = 3);

select share_id, stock_ex_id
from trades
where broker_id = 1
or stock_ex_id = 3;

-- 2. Use a set function to show share ids which were traded by broker 1
-- but not traded on stock exchange 3.
-- redo
(select share_id
from trades
where broker_id = 1)
minus
(select share_id
from trades
where stock_ex_id != 3);

select share_id, stock_ex_id
from trades
where broker_id = 1
and stock_ex_id != 3;

-- 3. Use a set function to show share ids which were traded by broker 1 on stock exchange 3
(select share_id
from trades
where broker_id = 1)
intersect
(select share_id
from trades
where stock_ex_id = 3);

select share_id, count(share_id), stock_ex_id
from trades
where broker_id = 1
and stock_ex_id = 3
group by share_id
order by share_id;


/*
INTERSECT
select distinct share_id
from trades
WHERE  stock_ex_id = 3 and broker_id = 1;


MINUS
select distinct share_id
from trades
WHERE  stock_ex_id != 3 and broker_id = 1
*/
commit;
