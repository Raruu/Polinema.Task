-- CREATE VIEW Sales.CustGroups
-- AS
--     SELECT custid,
--         CHOOSE(custid % 3 + 1, N'A', N'B', N'C') AS custgroup, country
--     FROM Sales.Customers;
-- GO

-- Bagian 1
-- Soal 1
SELECT *
FROM Sales.CustGroups;

-- Soal 2
SELECT country, [A], [B], [C]
FROM (
        SELECT *
    FROM Sales.CustGroups
    ) cg
PIVOT (
    COUNT(cg.custid)
    FOR cg.custgroup IN ([A], [B], [C])
) as pvt;
GO

-- Bagian 2
ALTER VIEW Sales.CustGroups
AS
    SELECT
        custid,
        CHOOSE(custid % 3+1, N'A', N'B', N'C') AS custgroup,
        country,
        city,
        contactname
    FROM Sales.Customers;
    GO

-- Soal 3    
SELECT country, [A], [B], [C]
FROM (
        SELECT *
    FROM Sales.CustGroups
    ) cg
PIVOT (
    COUNT(cg.custid)
    FOR cg.custgroup IN ([A], [B], [C])
) as pvt;

-- Soal 4   
SELECT country, city, contactname, [A], [B], [C]
FROM (
        SELECT *
    FROM Sales.CustGroups
    ) cg
PIVOT (
    COUNT(cg.custid)
    FOR cg.custgroup IN ([A], [B], [C])
) as pvt;

-- Bagian 3
-- Soal 5
WITH
    PivotCustGroups
    AS
    (
        SELECT custid, country, custgroup
        FROM Sales.CustGroups
    )
SELECT
    pvt.country, [A], [B], [C]
FROM PivotCustGroups pcg
PIVOT (
    COUNT(pcg.custid)
    FOR pcg.custgroup IN ([A], [B], [C])
) as pvt;
GO

-- Bagian 4
-- Soal 8
WITH
    SalesByCategory
    AS
    (
        SELECT o.custid,
            SUM(od.qty * od.unitprice) OVER (PARTITION BY c.categoryname, od.orderid) salesvalue,
            c.categoryname
        FROM Sales.Orders o
            INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
            INNER JOIN Production.Products p ON od.productid = p.productid
            INNER JOIN Production.Categories c ON p.categoryid = c.categoryid
        WHERE YEAR(o.orderdate) = 2008
    )
SELECT
    custid,
    [Beverages], [Condiments], [Confections], [Dairy Products],
    [Grains/Cereals], [Meat/Poultry], [Produce], [Seafood]
FROM SalesByCategory sbc
PIVOT (
        SUM(sbc.salesvalue)
        FOR sbc.categoryname IN 
        ([Beverages], [Condiments], [Confections], [Dairy Products], 
        [Grains/Cereals], [Meat/Poultry], [Produce], [Seafood])
    ) AS pvt;
GO

-- Bagian 5
-- CREATE VIEW Sales.PivotCustGroups
-- AS
--     WITH
--         PivotCustGroups
--         AS
--         (
--             SELECT
--                 custid,
--                 country,
--                 custgroup
--             FROM Sales.CustGroups
--         )
--     SELECT
--         country,
--         p.A,
--         p.B,
--         p.C
--     FROM PivotCustGroups
-- PIVOT (COUNT(custid) FOR custgroup IN (A, B, C)) AS p;
GO

-- Soal 9
SELECT * FROM Sales.PivotCustGroups;

-- Bagian 6
-- Soal 10
SELECT
    custgroup, country, custid numberofcustomers
FROM Sales.PivotCustGroups 
UNPIVOT(custid FOR custgroup IN ([A], [B], [C])) AS unp;

-- Bagian 7
-- Soal 11?
SELECT
    c.country, c.city, COUNT(c.custid) noofcustomers
FROM Sales.Customers c
GROUP BY
GROUPING SETS(
    (c.country, c.city),
    (c.country),
    (c.city),
    ()
);

-- Bagian 8
-- Soal 12
SELECT 
    YEAR(o.orderdate) orderyear, MONTH(o.orderdate) ordermounth, 
    DAY(o.orderdate) orderday, SUM(o.val) salesvalue
FROM Sales.OrderValues o
GROUP BY
CUBE (YEAR(o.orderdate), MONTH(o.orderdate), DAY(o.orderdate));

-- Bagian 9
-- Soal 13
SELECT 
    YEAR(o.orderdate) orderyear, MONTH(o.orderdate) ordermounth, 
    DAY(o.orderdate) orderday, SUM(o.val) salesvalue
FROM Sales.OrderValues o
GROUP BY
ROLLUP (YEAR(o.orderdate), MONTH(o.orderdate), DAY(o.orderdate));

-- Bagian 10
-- Soal 15?
SELECT
    GROUPING_ID(YEAR(ov.orderdate), MONTH(ov.orderdate)) groupid,
    YEAR(ov.orderdate) orderyear, MONTH(ov.orderdate) ordermounth,
    SUM(ov.val) salesvalue
FROM Sales.OrderValues ov
GROUP BY
GROUPING SETS(
    (YEAR(ov.orderdate), MONTH(ov.orderdate))
)
ORDER BY groupid, orderyear, ordermounth;
