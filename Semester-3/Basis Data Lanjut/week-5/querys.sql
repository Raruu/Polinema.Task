-- Bagian 1
-- Soal 1
SELECT
    p.productid, p.productname, p.supplierid,
    p.unitprice, p.discontinued
FROM Production.Products p
WHERE p.categoryid = 1;
GO

-- Soal 2
-- CREATE VIEW Production.ProductsBeverages
-- AS
--     SELECT
--         p.productid, p.productname, p.supplierid,
--         p.unitprice, p.discontinued
--     FROM Production.Products p
--     WHERE p.categoryid = 1;
-- GO

-- Soal 3
-- SELECT
--     pb.productid, pb.productname
-- FROM Production.ProductsBeverages pb
-- WHERE pb.supplierid = 1;
-- GO

-- Bagian 3
-- Soal 4
-- ALTER VIEW Production.ProductsBeverages
-- AS
--     SELECT
--         productid, productname, supplierid, unitprice, discontinued
--     FROM Production.Products
--     WHERE categoryid = 1
--     ORDER BY productname;

-- GO

-- Setelah 4
-- ALTER VIEW Production.ProductsBeverages
-- AS
--     SELECT TOP(100) PERCENT
--         productid, productname, supplierid, unitprice, discontinued
--     FROM Production.Products
--     WHERE categoryid = 1
--     ORDER BY productname;
-- GO

-- Bagian 4
-- Soal 6
-- ALTER VIEW Production.ProductsBeverages
-- AS
--     SELECT
--         productid, productname, supplierid, unitprice, discontinued,
--         CASE WHEN unitprice > 100. THEN N'high' ELSE N'normal' END
--     FROM Production.Products
--     WHERE categoryid = 1; 

-- Soal 7
-- ALTER VIEW Production.ProductsBeverages
-- AS
--     SELECT
--         productid, productname, supplierid, unitprice, discontinued,
--         CASE WHEN unitprice > 100. THEN N'high' ELSE N'normal' END pricetype
--     FROM Production.Products
--     WHERE categoryid = 1;
-- GO

-- Bagian 5
IF OBJECT_ID(N'Production.ProductsBeverages', N'V') IS NOT NULL
DROP VIEW Production.ProductsBeverages;

-- Bagian 6
-- Soal 8
SELECT
    p.productid, p.productname
FROM (
        SELECT
        productid, productname, supplierid, unitprice, discontinued,
        CASE WHEN unitprice > 100. THEN N'high' ELSE N'normal' END pricetype
    FROM Production.Products
    WHERE categoryid = 1
) p
WHERE pricetype = 'high';

-- Bagian 7
-- Soal 9
SELECT
    o.custid, SUM(o.totalsalesamountperorder) AS totalsalesamount,
    AVG(o.totalsalesamountperorder) AS avgsalesamount
FROM (        
    SELECT
        o.custid, o.orderid, SUM(od.unitprice * od.qty) totalsalesamountperorder
    FROM Sales.Orders o
        INNER JOIN Sales.OrderDetails od
        ON o.orderid = od.orderid
    GROUP BY o.custid,  o.orderid
) o
GROUP BY o.custid;

-- Bagian 8
-- Soal 10
SELECT
    currentYear.orderyear,
    currentYear.totalsalesamount curtotalsales,
    prevYear.totalsalesamount prevtotalsales,
    (currentYear.totalsalesamount - prevYear.totalsalesamount) 
    / prevYear.totalsalesamount * 100 percentgrowth
FROM
    (
    SELECT
        YEAR(ov.orderdate) orderyear, SUM(ov.val) totalsalesamount
    FROM Sales.OrderValues ov
    GROUP BY YEAR(ov.orderdate)
) currentYear
    LEFT JOIN
    (
    SELECT
        YEAR(ov.orderdate) orderyear, SUM(ov.val) totalsalesamount
    FROM Sales.OrderValues ov
    GROUP BY YEAR(ov.orderdate)
) prevYear ON currentYear.orderyear = prevYear.orderyear + 1
ORDER BY currentYear.orderyear;

-- Bagian 9
-- Soal 11
WITH
    ProductBeverages
    AS
    (
        SELECT
            productid, productname, supplierid, unitprice, discontinued,
            CASE WHEN unitprice > 100. THEN N'high' ELSE N'normal' END pricetype
        FROM Production.Products
        WHERE categoryid = 1
    )
SELECT
    productid, productname
FROM ProductBeverages
WHERE pricetype = 'high';

-- Bagian 10
-- Soal 12
WITH
    c2008
    AS
    (
        SELECT
            ov.custid, SUM(ov.val) salesamt2008
        FROM Sales.OrderValues ov
        WHERE YEAR(ov.orderdate) = 2008
        GROUP BY ov.custid
    )
SELECT
    c2008.custid, c.contactname, c2008.salesamt2008
FROM c2008
    INNER JOIN Sales.Customers c
    ON c2008.custid = c.custid;


-- Bagian 11
-- Soal 13
WITH
    c2008
    AS
    (
        SELECT
            ov.custid, SUM(ov.val) salesamt2008
        FROM Sales.OrderValues ov
        WHERE YEAR(ov.orderdate) = 2008
        GROUP BY ov.custid
    ),
    c2007
    AS
    (
        SELECT
            ov.custid, SUM(ov.val) salesamt2007
        FROM Sales.OrderValues ov
        WHERE YEAR(ov.orderdate) = 2007
        GROUP BY ov.custid
    )
SELECT
    c.custid, c.contactname,
    c2008.salesamt2008, c2007.salesamt2007,
    (c2008.salesamt2008 - c2007.salesamt2007) / c2007.salesamt2007 * 100 percentgrowth
FROM Sales.Customers c
    INNER JOIN c2008 ON c.custid = c2008.custid
    INNER JOIN c2007 ON c.custid = c2007.custid
ORDER BY percentgrowth DESC;

-- Bagian 12
-- Soal 14
SELECT
    ov.custid, SUM(ov.val) totalsalesamount
FROM Sales.OrderValues ov
WHERE YEAR(ov.orderdate) = 2007
GROUP BY ov.custid;
GO

-- Soal 15
-- CREATE FUNCTION dbo.fnGetSalesByCustomer
-- (@orderyear AS INT) RETURNS TABLE
-- AS
-- RETURN 
-- SELECT
--     ov.custid, SUM(ov.val) totalsalesamount
-- FROM Sales.OrderValues ov
-- WHERE YEAR(ov.orderdate) = 2007
-- GROUP BY ov.custid;
-- GO

-- Soal 16
CREATE FUNCTION dbo.fnGetSalesByCustomer
(@orderyear AS INT) RETURNS TABLE
AS
RETURN 
SELECT
    ov.custid, SUM(ov.val) totalsalesamount
FROM Sales.OrderValues ov
WHERE YEAR(ov.orderdate) = @orderyear 
GROUP BY ov.custid;
GO

-- Bagian 12
-- Soal 17
SELECT
    custid, totalsalesamount
FROM dbo.fnGetSalesByCustomer(2007);

-- Bagian 13
-- Soal 18

-- Table expression
-- 1-8 VIEW
-- 11, DERIVED
-- 12 CTE
-- 14 TVF