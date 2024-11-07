-- Bagian 1
CREATE PROCEDURE Sales.GetTopCustomers
AS
SELECT TOP(10)
    c.custid, c.contactname,
    SUM(o.val) AS salesvalue
FROM Sales.OrderValues AS o
    INNER JOIN Sales.Customers AS c
    ON c.custid = o.custid
GROUP BY c.custid, c.contactname
ORDER BY salesvalue DESC;
GO

-- Soal 1
EXEC Sales.GetTopCustomers;

-- Pre-Soal 3
GO
ALTER PROCEDURE Sales.GetTopCustomers
AS
SELECT c.custid, c.contactname,
    SUM(o.val) AS salesvalue
FROM Sales.OrderValues AS o
    INNER JOIN Sales.Customers AS c
    ON c.custid = o.custid
GROUP BY c.custid, c.contactname
ORDER BY salesvalue DESC
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;
GO

-- Soal 3
EXEC Sales.GetTopCustomers;

-- Bagian 2
GO
ALTER PROCEDURE Sales.GetTopCustomers
    @orderyear int
AS
SELECT c.custid, c.contactname,
    SUM(o.val) AS salesvalue
FROM Sales.OrderValues AS o
    INNER JOIN Sales.Customers AS c
    ON c.custid = o.custid
WHERE YEAR(o.orderdate) = @orderyear
GROUP BY c.custid, c.contactname
ORDER BY salesvalue DESC
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY; 
GO

-- Soal 6
EXEC Sales.GetTopCustomers 2007;


-- Soal 8
EXEC Sales.GetTopCustomers 2008;

-- Soal 9
EXEC Sales.GetTopCustomers;


-- After Soal 10
GO
ALTER PROCEDURE Sales.GetTopCustomers
    @orderyear int = NULL
AS
SELECT c.custid, c.contactname,
    SUM(o.val) AS salesvalue
FROM Sales.OrderValues AS o
    INNER JOIN Sales.Customers AS c
    ON c.custid = o.custid
WHERE YEAR(o.orderdate) = @orderyear
    OR @orderyear IS NULL
GROUP BY c.custid, c.contactname
ORDER BY salesvalue DESC
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;
GO

EXEC Sales.GetTopCustomers;

-- After 12
GO
ALTER PROCEDURE Sales.GetTopCustomers
    @orderyear int = NULL,
    @n int = 10
AS
SELECT c.custid, c.contactname,
    SUM(o.val) AS salesvalue
FROM Sales.OrderValues AS o
    INNER JOIN Sales.Customers AS c
    ON c.custid = o.custid
WHERE YEAR(o.orderdate) = @orderyear
    OR
    @orderyear IS NULL
GROUP BY c.custid, c.contactname
ORDER BY salesvalue DESC
OFFSET 0 ROWS FETCH NEXT @n ROWS ONLY;
GO

-- Soal 13
EXEC Sales.GetTopCustomers;

-- Soal 14
EXEC Sales.GetTopCustomers @n = 20;


-- After 15
GO
ALTER PROCEDURE Sales.GetTopCustomers
    @customerpos int = 1,
    @customername nvarchar(30) OUTPUT
AS
SET @customername = (
SELECT c.contactname
FROM Sales.OrderValues AS o
    INNER JOIN Sales.Customers AS c
    ON c.custid = o.custid
GROUP BY c.custid, c.contactname
ORDER BY SUM(o.val) DESC
OFFSET @customerpos - 1 ROWS FETCH NEXT 1 ROW ONLY);
GO

-- Bagian 3
-- Soal 16
GO
EXEC sys.sp_help;
GO

-- Soal 17
EXEC sys.sp_help 'Sales.Customers';

-- Soal 18
EXEC sys.sp_helptext 'Sales.GetTopCustomers';

-- Soal 19
EXEC sys.sp_columns @table_name = 'Customers', @table_owner = 'Sales';