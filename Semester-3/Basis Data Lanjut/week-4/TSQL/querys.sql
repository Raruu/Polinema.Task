-- Bagian 1
-- Soal 1
SELECT
    o.custid, c.contactname
FROM Sales.Orders o INNER JOIN Sales.Customers c
    ON o.custid = c.custid
WHERE o.empid = 5
GROUP BY o.custid, c.contactname;

-- Soal 2 & 4
SELECT
    o.custid, c.contactname, c.city
FROM Sales.Orders o INNER JOIN Sales.Customers c
    ON o.custid = c.custid
WHERE o.empid = 5
GROUP BY o.custid, c.contactname, c.city;

-- Soal 5
SELECT
    o.custid, YEAR(o.orderdate) orderyear
FROM Sales.Orders o
WHERE o.empid = 5
GROUP BY o.custid, YEAR(o.orderdate);

-- Soal 6
SELECT
    c.categoryid , c.categoryname
FROM Production.Categories c
    INNER JOIN Production.Products p ON c.categoryid = p.categoryid
    INNER JOIN Sales.OrderDetails od ON p.productid = od.productid
    INNER JOIN Sales.Orders o ON od.orderid = o.orderid
WHERE YEAR(o.orderdate) = 2008
GROUP BY c.categoryid , c.categoryname
ORDER BY c.categoryid ASC;

-- Bagian 2
-- Soal 7
SELECT
    o.orderid, o.orderdate, SUM(od.qty * od.unitprice) salesamount
FROM Sales.Orders o INNER JOIN Sales.OrderDetails od
    ON o.orderid = od.orderid
GROUP BY o.orderid, o.orderdate
ORDER BY salesamount DESC;

-- Soal 8
SELECT
    o.orderid, o.orderdate, SUM(od.qty * od.unitprice) salesamount,
    COUNT(*) nooforderlines, AVG(od.qty * od.unitprice) avgsalesamountperorderlines
FROM Sales.Orders o INNER JOIN Sales.OrderDetails od
    ON o.orderid = od.orderid
GROUP BY o.orderid, o.orderdate
ORDER BY salesamount DESC;

-- Soal 9
SELECT
    FORMAT(o.orderdate, 'yyyyMM') yearmonthno,
    SUM(od.qty * od.unitprice) saleamountpermonth
FROM Sales.Orders o INNER JOIN Sales.OrderDetails od
    ON o.orderid = od.orderid
GROUP BY FORMAT(o.orderdate, 'yyyyMM')
ORDER BY yearmonthno ASC;

-- Soal 10
SELECT
    c.custid, c.contactname,
    SUM(od.qty * od.unitprice) totalsalesamount,
    MAX(od.qty * od.unitprice) maxsalesamountperorderline,
    COUNT(*) numberofrows,
    COUNT(od.orderid) numberoforderlines
FROM Sales.Customers c
    LEFT JOIN Sales.Orders o ON c.custid = o.custid
    LEFT JOIN Sales.OrderDetails od ON o.orderid = od.orderid
GROUP BY c.custid, c.contactname
ORDER BY totalsalesamount;

-- Bagian 3
-- Soal 11 12
SELECT
    YEAR(orderdate) AS orderyear,
    COUNT(orderid) AS nooforders,
    COUNT(DISTINCT custid) AS noofcustomers
FROM Sales.Orders
GROUP BY YEAR(orderdate);

-- Soal 13
SELECT
    LEFT(c.contactname, 1) firstletter,
    COUNT(DISTINCT c.custid) noofcustomers,
    COUNT(o.custid) nooforders
FROM Sales.Customers c
    LEFT JOIN Sales.Orders o ON c.custid = o.custid
GROUP BY LEFT(c.contactname, 1)
ORDER BY firstletter ASC;

-- Soal 14
-- Something is wrong?
SELECT
    c.categoryid , c.categoryname,
    SUM(od.qty * od.unitprice) totalsalesamount,
    COUNT(DISTINCT od.orderid) nooforders,
    SUM(od.qty * od.unitprice) / COUNT(DISTINCT od.orderid) avgsalesamountperorder
FROM Production.Categories c
    INNER JOIN Production.Products p ON c.categoryid = p.categoryid
    INNER JOIN Sales.OrderDetails od ON p.productid = od.productid
    INNER JOIN Sales.Orders o ON od.orderid = o.orderid
WHERE YEAR(o.orderdate) = 2008
GROUP BY c.categoryid , c.categoryname
ORDER BY c.categoryid ASC;


-- Bagian
-- Soal 15
SELECT TOP 5
    o.custid, SUM(od.qty * od.unitprice) totalsalesamount
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
GROUP BY o.custid
ORDER BY totalsalesamount DESC;

-- Soal 16
SELECT
    o.orderid, o.empid, SUM(od.qty * od.unitprice) totalsalesamount
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
WHERE YEAR(o.orderdate) = 2008
GROUP BY o.empid, o.orderid;

-- Soal 17
SELECT
    o.orderid, o.empid, SUM(od.qty * od.unitprice) totalsalesamount
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
WHERE YEAR(o.orderdate) = 2008
GROUP BY o.empid, o.orderid
HAVING SUM(od.qty * od.unitprice) > 10000;

-- Soal 18
SELECT
    o.orderid, o.empid, SUM(od.qty * od.unitprice) totalsalesamount
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
WHERE YEAR(o.orderdate) = 2008
GROUP BY o.empid, o.orderid
HAVING SUM(od.qty * od.unitprice) > 10000 AND o.empid = 3;

-- Soal 19
SELECT
    o.custid, MAX(o.orderdate) lastorderdate,
    SUM(od.qty * od.unitprice) totalsalesamount
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
GROUP BY  o.custid
HAVING COUNT(DISTINCT o.orderid) > 25
ORDER BY totalsalesamount DESC;

-- Bagian 5
-- Soal 20
SELECT
    MAX(o.orderdate) lastorderdate
FROM Sales.Orders o;

-- Soal 21
SELECT
    o.orderid, o.orderdate, o.empid, o.custid
FROM Sales.Orders o
WHERE o.orderdate = (SELECT MAX(o.orderdate)
FROM Sales.Orders o);

-- Soal 22 24
SELECT
    orderid, orderdate, empid, custid
FROM Sales.Orders
WHERE
custid IN
(
SELECT custid
FROM Sales.Customers
WHERE contactname LIKE N'B%'
);

-- Soal 25
WITH
    TotalPenjualanMei
    AS
    (
        SELECT SUM(od.qty * od.unitprice) totalpenjualan
        FROM Sales.Orders o
            INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
        WHERE MONTH(o.orderdate) = 5 AND YEAR(o.orderdate) = 2008
    )
SELECT
    o.orderid, SUM(od.qty * od.unitprice) totalsalesamount,
    (SUM(od.qty * od.unitprice) /  tpm.totalpenjualan) * 100 salespctoftotal
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
CROSS JOIN TotalPenjualanMei tpm
WHERE MONTH(o.orderdate) = 5 AND YEAR(o.orderdate) = 2008
GROUP BY 
    o.orderid, tpm.totalpenjualan;

-- Bagian 6
-- Soal 26
SELECT
    p.productid, p.productname
FROM Production.Products p
    INNER JOIN Sales.OrderDetails od ON p.productid = od.productid
WHERE od.qty > 100
GROUP BY p.productid, p.productname;

-- Soal 27
SELECT
    c.custid, c.contactname
FROM Sales.Customers c
WHERE c.custid NOT IN (SELECT o.custid
FROM Sales.Orders o);

-- Soal 28
INSERT INTO Sales.Orders
    (
    custid, empid, orderdate, requireddate, shippeddate, shipperid, freight, shipname, shipaddress, shipcity, shipregion, shippostalcode, shipcountry)
VALUES
    (NULL, 1, '20111231', '20111231', '20111231', 1, 0,
        'ShipOne', 'ShipAddress', 'ShipCity', 'RA', '1000', 'USA');

-- Soal 29
SELECT
    c.custid, c.contactname
FROM Sales.Customers c
WHERE c.custid NOT IN (SELECT o.custid
FROM Sales.Orders o
WHERE o.custid IS NOT NULL);

-- Bagian 7
-- Soal 30
SELECT
    c.custid, c.contactname,
    (SELECT MAX(o.orderdate)
    FROM Sales.Orders o
    WHERE o.custid = c.custid) lastorderdate
FROM Sales.Customers c;

-- Soal 31
SELECT
    c.custid, c.contactname
FROM Sales.Customers c
WHERE NOT EXISTS (SELECT *
FROM Sales.Orders o
WHERE o.custid = c.custid);

-- Soal 32
SELECT
    c.custid, c.contactname
FROM Sales.Customers c
WHERE EXISTS (SELECT *
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
WHERE o.custid = c.custid
    AND o.orderdate >= '2008-04-01'
    AND od.unitprice > 100);

-- Soal 33
SELECT
    YEAR(o.orderdate) orderyear, SUM(od.qty * od.unitprice) totalsales,
    (SELECT SUM(od2.qty * od2.unitprice)
    FROM Sales.Orders o2
        INNER JOIN Sales.OrderDetails od2 ON o2.orderid = od2.orderid
    WHERE YEAR(o2.orderdate) <= YEAR(o.orderdate)
    )  runsales
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
GROUP BY 
    YEAR(o.orderdate)
ORDER BY runsales ASC;