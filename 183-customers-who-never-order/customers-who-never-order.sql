-- Write your PostgreSQL query statement below
select c.name as customers
from customers c
left join orders o
on c.id = o.customerid
where o.id is null;

-- select name as customers 
-- from customers
-- where id not in (select customerid from orders);