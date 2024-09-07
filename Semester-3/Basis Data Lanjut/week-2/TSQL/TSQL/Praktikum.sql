-- Bagian 1
SELECT *
FROM [Sales].[Customers];

SELECT custid, companyname, contactname, contacttitle, address, city, region, postalcode, country, phone, fax
FROM Sales.Customers;

-- Bagian 3
SELECT DISTINCT country
FROM Sales.Customers;


-- Bagian 4
SELECT
	c.contactname AS Name, c.contacttitle AS Title, c.companyname AS [Company Name]
FROM Sales.Customers AS c;


-- Bagian 5
SELECT
	p.categoryid, p.productname
FROM Production.Products AS p;

SELECT
	p.categoryid, p.productname,
	CASE 
		WHEN p.categoryid = 1 THEN 'Beverages' 
		WHEN p.categoryid = 2 THEN 'Condiments' 
		WHEN p.categoryid = 3 THEN 'Confections' 
		WHEN p.categoryid = 4 THEN 'Dairy Products' 
		WHEN p.categoryid = 5 THEN 'Grains/Cereals' 
		WHEN p.categoryid = 6 THEN 'Meat/Poultry' 
		WHEN p.categoryid = 7 THEN 'Produce'
		WHEN p.categoryid = 8 THEN 'Seafood' 
		ELSE 'Other' 
	END AS categoryname
FROM Production.Products AS p;

-- soal 6
SELECT
	p.categoryid,
	p.productname,
	CASE
		WHEN p.categoryid = 1 THEN 'Beverages'
		WHEN p.categoryid = 2 THEN 'Condiments'
		WHEN p.categoryid = 3 THEN 'Confections'
		WHEN p.categoryid = 4 THEN 'Dairy Products'
		WHEN p.categoryid = 5 THEN 'Grains/Cereals'
		WHEN p.categoryid = 6 THEN 'Meat/Poultry'
		WHEN p.categoryid = 7 THEN 'Produce'
		WHEN p.categoryid = 8 THEN 'Seafood'
		ELSE 'Other'
	END AS categoryname,
	CASE
		WHEN p.categoryid IN (1, 7, 8) THEN 'Campaign Products'
		ELSE 'Non-Campaign Products'
	END AS iscampaign
FROM
	Production.Products AS p;

-- soal 7
SELECT
	p.categoryid ID_KATEGORI,
	p.productname NAMA_PRODUK,
	CASE
		WHEN p.categoryid = 1 THEN 'Beverages'
		WHEN p.categoryid = 2 THEN 'Condiments'
		WHEN p.categoryid = 3 THEN 'Confections'
		WHEN p.categoryid = 4 THEN 'Dairy Products'
		WHEN p.categoryid = 5 THEN 'Grains/Cereals'
		WHEN p.categoryid = 6 THEN 'Meat/Poultry'
		WHEN p.categoryid = 7 THEN 'Produce'
		WHEN p.categoryid = 8 THEN 'Seafood'
		ELSE 'Other'
	END NAMA_KATEGORI ,
	CASE
		WHEN p.categoryid IN (1, 7, 8) THEN 'Campaign Products'
		ELSE 'Non-Campaign Products'
	END STATUS
FROM
	Production.Products p
WHERE
    p.categoryid = 8;

-- soal 8
SELECT
	em.firstname FIRST_NAME, em.lastname LAST_NAME, EM.city CITY, em.country COUNTRY
FROM HR.Employees em
WHERE em.country = 'USA';


-- Bagian 6
-- soal 9
SELECT
	p.productname, c.categoryname
FROM Production.Products p
	INNER JOIN Production.Categories c
	ON p.categoryid = c.categoryid;

-- Bagian 7
-- soal 11
-- SELECT
-- custid, contactname, orderid
-- FROM Sales.Customers
-- INNER JOIN Sales.Orders ON Customers.custid = Orders.custid;

--soal 12 13 
SELECT
	c.custid, c.contactname, o.orderid
FROM Sales.Customers c
	INNER JOIN Sales.Orders o ON c.custid = o.custid;

-- Bagian 8
-- soal 16
SELECT
	e.empid, e.lastname, e.firstname, e.title, e.mgrid
FROM HR.Employees e;

-- soal 18
SELECT
	e.empid, e.lastname, e.firstname, e.title, e.mgrid,
	e2.lastname mgrlastname, e2.firstname mgrfirstname
FROM HR.Employees e, HR.Employees e2
WHERE e2.empid = e.mgrid;

-- Bagian 9
-- soal 21
SELECT
	c.custid, c.contactname, o.orderid
FROM Sales.Customers c
	LEFT JOIN Sales.Orders o
	ON c.custid = o.custid;

-- Bagian 10
-- Soal 25
-- SELECT
-- 	e.empid, e.firstname, e.lastname, c.calendardate
-- FROM HR.Employees e
-- CROSS JOIN HR.Calendar c;

-- Bagian 11
-- Soal 26
SELECT
	custid, companyname, contactname, address, city, country, phone
FROM Sales.Customers
WHERE
country = N'Brazil';

-- soal 28
SELECT
	c.custid, c.companyname, c.contactname, c.address, c.city, c.country, c.phone
FROM Sales.Customers c
WHERE c.country IN (N'Brazil', N'UK', N'USA');

-- Soal 30
SELECT
	c.custid, c.companyname, o.orderid
FROM Sales.Customers AS c
	LEFT OUTER JOIN Sales.Orders AS o ON c.custid = o.custid
WHERE c.city = 'Paris';

-- Bagian 11
-- Soal 31
SELECT
	c.custid, c.contactname, o.orderid, o.orderdate
FROM Sales.Customers c
	INNER JOIN Sales.Orders o ON c.custid = o.custid
WHERE o.orderdate >= '2008-04-01'
ORDER BY o.orderdate DESC, o.custid ASC;

-- Soal 33
-- SELECT
-- 	e.empid, e.lastname, e.firstname, e.title, e.mgrid, m.lastname AS mgrlastname, m.firstname AS mgrfirstname
-- FROM HR.Employees AS e
-- 	INNER JOIN HR.Employees AS m ON e.mgrid = m.empid
-- WHERE mgrlastname = N'Buck';

-- Soal 34
SELECT
	e.empid, e.lastname, e.firstname, e.title, e.mgrid, m.lastname AS mgrlastname, m.firstname AS mgrfirstname
FROM HR.Employees AS e
	INNER JOIN HR.Employees AS m ON e.mgrid = m.empid
WHERE m.lastname = N'Buck';

-- SOAL 35
SELECT
	e.empid, e.lastname, e.firstname, e.title, e.mgrid, m.lastname AS mgrlastname, m.firstname AS mgrfirstname
FROM HR.Employees AS e
	INNER JOIN HR.Employees AS m ON e.mgrid = m.empid
ORDER BY m.firstname;

-- Bagian 12
-- Soal 37
SELECT
	p.productname, p.unitprice
FROM Production.Products p
ORDER BY p.unitprice DESC;

-- Soal 38
SELECT TOP 10 PERCENT
	p.productname, p.unitprice
FROM Production.Products p
ORDER BY p.unitprice DESC;

-- Bagian 13
-- Soal 40
SELECT
	o.custid, o.orderid, o.orderdate
FROM Sales.Orders o
ORDER BY o.orderdate, o.orderid
OFFSET 0 rows
FETCH NEXT 20 ROWS ONLY;

-- Soal 41
SELECT
	o.custid, o.orderid, o.orderdate
FROM Sales.Orders o
ORDER BY o.orderdate, o.orderid
OFFSET 20 rows
FETCH NEXT 20 ROWS ONLY;