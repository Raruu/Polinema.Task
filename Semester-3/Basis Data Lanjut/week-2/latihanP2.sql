USE [TSQL];
-- 2 Tabel
-- INNER JOIN eksplisit
SELECT Customers.custid, contactname,orderid  
FROM Sales.Customers
INNER JOIN Sales.Orders ON Customers.custid=Orders.custid;
GO

SELECT c.custid, contactname,orderid 
FROM Sales.Customers c
INNER JOIN Sales.Orders o ON c.custid=o.custid

-- inner join implisit
select c.custid, contactname,orderid 
from Sales.Customers c, Sales.Orders o
where c.custid=o.custid;
GO
-- Lebih dari 2 tabel (3 tabel c o d)
-- inner join eksplisit
SELECT c.custid, contactname,o.orderid, d.productid, d.qty,d.unitprice
    FROM Sales.Customers c
    INNER JOIN Sales.Orders o ON c.custid=o.custid  -- plus tabel order detail
    INNER JOIN Sales.OrderDetails d ON d.orderid=o.orderid
    INNER JOIN HR.Employees e ON e.empid=o.empid
    INNER JOIN Production.Products p ON p.productid=d.productid
    WHERE c.custid=1
    ORDER BY c.custid asc;

-- inner join eksplisit 
SELECT c.custid, contactname,o.orderid, d.productid, d.qty,d.unitprice 
    FROM Sales.Customers c, Sales.orders o, Sales.OrderDetails d
    WHERE c.custid=o.custid AND o.orderid=d.orderid

-- LEFT OUTER JOIN/LEFT JOIN (isi tabel sebelah kiri ditampilkan semua)
SELECT c.custid, contactname,orderid 
    FROM Sales.Customers c
        LEFT OUTER JOIN Sales.Orders o ON c.custid=o.custid

 SELECT c.custid, contactname,orderid 
    FROM Sales.Customers c
        LEFT JOIN Sales.Orders o ON c.custid=o.custid

    SELECT c.custid, contactname,orderid 
    FROM Sales.Customers c
        LEFT JOIN Sales.Orders o ON c.custid=o.custid where o.orderid = null;

-- RIGHT OUTER JOIN/LEFT JOIN (isi tabel sebelah KANAN ditampilkan semua)
SELECT c.custid, contactname,orderid 
    FROM Sales.Customers c
        RIGHT OUTER JOIN Sales.Orders o ON c.custid=o.custid

 SELECT c.custid, contactname,orderid 
    FROM Sales.Customers c
        RIGHT JOIN Sales.Orders o ON c.custid=o.custid

    SELECT c.custid, contactname,orderid 
    FROM Sales.Customers c
        RIGHT JOIN Sales.Orders o ON c.custid=o.custid where c.custid IS NULL;

-- cross join
SELECT 
	calendardate
     FROM HR.Calendar;    

SELECT * FROM HR.Employees;

SELECT e.empid, e.firstname, e.lastname,cal.calendardate
    FROM HR.Employees e
    CROSS JOIN HR.Calendar cal;


-- filter -> where
SELECT
custid, companyname, contactname, address, city, country, phone
    FROM Sales.Customers
        WHERE
        country = N'Brazil';

SELECT
custid, companyname, contactname, address, city, country, phone
    FROM Sales.Customers
        WHERE
        country = N'Brazil' OR country=N'UK' OR country=N'USA' 
        ORDER by country ASC;

SELECT
custid, companyname, contactname, address, city, country, phone
    FROM Sales.Customers
        WHERE
        country IN (N'BRAZIL', N'UK', N'USA')
        ORDER by country ASC;
GO
--SELF JOIN 
SELECT [empid],[lastname],[firstname],[mgrid] 
FROM HR.Employees;

select e.empid, e.lastname, e.firstname,e.title,e.mgrid, m.lastname mngrlastname, m.firstname mngrfirstname
    from HR.employees e
    inner JOIN HR.Employees m ON e.mgrid=m.empid
    order by e.empid asc;
    