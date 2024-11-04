-- Bagian 1
SELECT
    productid, productname
FROM Production.Products
WHERE categoryid = 4;

SELECT
    p.productid, p.productname
FROM Production.Products p INNER JOIN Sales.OrderDetails od
    ON p.productid = od.productid
GROUP BY p.productid, p.productname
HAVING SUM(od.qty * od.unitprice) > 50000;

-- Soal 1
    SELECT
        productid, productname
    FROM Production.Products
    WHERE categoryid = 4
UNION
    SELECT
        p.productid, p.productname
    FROM Production.Products p INNER JOIN Sales.OrderDetails od
        ON p.productid = od.productid
    GROUP BY p.productid, p.productname
    HAVING SUM(od.qty * od.unitprice) > 50000;


-- Soal 2
    SELECT
        productid, productname
    FROM Production.Products
    WHERE categoryid = 4
UNION ALL
    SELECT
        p.productid, p.productname
    FROM Production.Products p INNER JOIN Sales.OrderDetails od
        ON p.productid = od.productid
    GROUP BY p.productid, p.productname
    HAVING SUM(od.qty * od.unitprice) > 50000;


-- Soal 4
    SELECT *
    FROM
        (SELECT DISTINCT TOP 10
            c.custid, c.contactname, ov.orderdate, ov.val
        FROM Sales.Customers c INNER JOIN Sales.OrderValues ov
            ON c.custid = ov.custid
        WHERE MONTH(ov.orderdate) = 1 AND YEAR(ov.orderdate) = 2008
        ORDER BY ov.val DESC) jan
UNION ALL
    SELECT *
    FROM
        (SELECT DISTINCT TOP 10
            c.custid, c.contactname, ov.orderdate, ov.val
        FROM Sales.Customers c INNER JOIN Sales.OrderValues ov
            ON c.custid = ov.custid
        WHERE MONTH(ov.orderdate) = 2 AND YEAR(ov.orderdate) = 2008
        ORDER BY ov.val DESC) feb;


-- Bagian 2
-- 1
SELECT
    p.productid, p.productname, o.orderid
FROM Production.Products p 
CROSS APPLY
(
    SELECT TOP(2)
        d.orderid
    FROM Sales.OrderDetails d
    WHERE d.productid = p.productid
    ORDER BY d.orderid DESC
) o
ORDER BY p.productid;

-- 2
IF OBJECT_ID('dbo.fnGetTop3ProductsForCustomer') IS NOT NULL
    DROP FUNCTION dbo.fnGetTop3ProductsForCustomer;
GO
CREATE FUNCTION dbo.fnGetTop3ProductsForCustomer (@custid AS INT)
RETURNS TABLE
AS RETURN
    SELECT TOP 3
    p.productid, p.productname, SUM(od.qty * od.unitprice) totalsalesamount
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
    INNER JOIN Production.Products p ON od.productid = p.productid
WHERE custid = @custid
GROUP BY p.productid, p.productname
ORDER BY totalsalesamount DESC;
GO

SELECT
    c.custid, c.contactname, p.productid, p.productname, p.totalsalesamount
FROM Sales.Customers c
    CROSS APPLY dbo.fnGetTop3ProductsForCustomer(c.custid) p
ORDER BY c.custid;

-- Soal 5
SELECT
    c.custid, c.contactname, p.productid, p.productname, p.totalsalesamount
FROM Sales.Customers c
    OUTER APPLY dbo.fnGetTop3ProductsForCustomer(c.custid) p
ORDER BY c.custid;

-- Soal 6
SELECT
    c.custid, c.contactname, p.productid, p.productname, p.totalsalesamount
FROM Sales.Customers c
    OUTER APPLY dbo.fnGetTop3ProductsForCustomer(c.custid) p
WHERE p.productid IS NULL
ORDER BY c.custid;

IF OBJECT_ID('dbo.fnGetTop3ProductsForCustomer') IS NOT NULL
    DROP FUNCTION dbo.fnGetTop3ProductsForCustomer;


-- Bagian 3

-- Soal pre-7
SELECT o.custid
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
GROUP BY o.custid
HAVING COUNT(DISTINCT od.productid) > 20;

-- Soal 7
    SELECT o.custid
    FROM Sales.Orders o
        INNER JOIN Sales.Customers c ON o.custid = c.custid
    WHERE o.shipcountry = 'USA'
EXCEPT
    SELECT o.custid
    FROM Sales.Orders o
        INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
    GROUP BY o.custid
    HAVING COUNT(DISTINCT od.productid) > 20;

-- Soal pre-8
SELECT o.custid
FROM Sales.Orders o
    INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
GROUP BY o.custid
HAVING SUM(od.qty * od.unitprice) > 10000;

-- Soal 8
    SELECT c.custid
    FROM Sales.Customers c
EXCEPT
    SELECT o.custid
    FROM Sales.Orders o
        INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
    GROUP BY o.custid
    HAVING COUNT(DISTINCT od.productid) > 20
INTERSECT
    SELECT o.custid
    FROM Sales.Orders o
        INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
    GROUP BY o.custid
    HAVING SUM(od.qty * od.unitprice) > 10000;

-- Soal 10
    (
        SELECT c.custid
    FROM Sales.Customers c
EXCEPT
    SELECT o.custid
    FROM Sales.Orders o
        INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
    GROUP BY o.custid
    HAVING COUNT(DISTINCT od.productid) > 20
)
INTERSECT
    SELECT o.custid
    FROM Sales.Orders o
        INNER JOIN Sales.OrderDetails od ON o.orderid = od.orderid
    GROUP BY o.custid
    HAVING SUM(od.qty * od.unitprice) > 10000;

-- Bagian 4
-- AFTER INSERT
IF OBJECT_ID('Sales.trgAutoAddOrderDetailsForOrder') IS NOT NULL
    DROP TRIGGER Sales.trgAutoAddOrderDetailsForOrder;
GO
CREATE TRIGGER trgAutoAddOrderDetailsForOrder
ON Sales.Orders
AFTER INSERT
AS
BEGIN
    PRINT 'Trigger trgAutoAddOrderDetailsForOrder dipanggil!';
    DECLARE @orderid INT = (SELECT orderid
    FROM inserted);
    DECLARE @productid INT = 1;
    DECLARE @unitprice MONEY = 0;
    DECLARE @qty SMALLINT = 1;
    DECLARE @discount NUMERIC(4,3) = 0;
    INSERT INTO Sales.OrderDetails
    VALUES
        (@orderid, @productid, @unitprice, @qty, @discount);
    PRINT 'Data kosong ditambahkan secara otomatis ke tabel Sales.OrderDetails';
END
GO

INSERT INTO Sales.Orders
    (
    custid, empid, orderdate, requireddate, shipperid,
    freight, shipname, shipaddress, shipcity, shipcountry
    )
VALUES
    (85, 5, GETDATE(), GETDATE(), 3,
        100, 'Kapal Api', 'Jl.Soekarno-Hata', 'Malang', 'Indonesia');

SELECT *
FROM Sales.Orders;


GO
-- AFTER UPDATE
IF OBJECT_ID('Production.trgAutoUpdateOrderDetailsUnitPrice') IS NOT NULL
    DROP TRIGGER Production.trgAutoUpdateOrderDetailsUnitPrice;
GO
CREATE TRIGGER trgAutoUpdateOrderDetailsUnitPrice
ON Production.Products
AFTER UPDATE
AS
BEGIN
    PRINT 'Trigger trgAutoUpdateOrderDetailsUnitPrice dipanggil!';
    DECLARE @productid INT = (SELECT productid
    FROM inserted);
    DECLARE @unitprice MONEY = COALESCE((SELECT unitprice
    FROM inserted), 0.0);
    UPDATE Sales.OrderDetails SET unitprice = @unitprice
    WHERE productid = @productid;
    PRINT 'Harga di tabel Sales.OrderDetails secara otomatis disesuaikan..';
END
GO

UPDATE Production.Products SET unitprice = 100 WHERE productid = 11;
SELECT *
FROM Production.Products
WHERE productid = 11;
SELECT *
FROM Sales.OrderDetails
WHERE productid = 11

-- Soal 12
IF OBJECT_ID('Sales.trgAutoProductDiscontinue') IS NOT NULL
    DROP TRIGGER Sales.trgAutoProductDiscontinue;
GO
CREATE TRIGGER trgAutoProductDiscontinue
ON Sales.OrderDetails
AFTER DELETE
AS
BEGIN
    PRINT 'Trigger trgAutoProductDiscontinue dipanggil!';
    DECLARE @productid INT = (SELECT TOP 1
        productid
    FROM deleted);
    UPDATE Production.Products SET discontinued = 1 WHERE productid = @productid;
    PRINT 'Men-discontinue productid = ' + CONVERT(VARCHAR, @productid);
END
GO


-- Soal 12 post
DELETE FROM Sales.OrderDetails WHERE productid = 10;
SELECT *
FROM Production.Products
WHERE productid = 10;

-- Soal 13
-- 1.1
INSERT INTO HR.EmployeesBackup
    (
    lastname, firstname, title, titleofcourtesy, birthdate, hiredate, [address],
    city, region, postalcode, country, phone, mgrid
    )
SELECT
    lastname, firstname, title, titleofcourtesy, birthdate, hiredate, [address],
    city, region, postalcode, country, phone, mgrid
FROM HR.Employees;

-- 1.2
IF OBJECT_ID('HR.trgDivertInsertEmployeeToBackup') IS NOT NULL
    DROP TRIGGER HR.trgDivertInsertEmployeeToBackup;
GO
CREATE TRIGGER trgDivertInsertEmployeeToBackup ON HR.Employees
INSTEAD OF INSERT
AS
BEGIN
    PRINT 'Trigger trgDivertInsertEmployeeToBackup dipanggil!';
    INSERT INTO HR.EmployeesBackup
        (
        lastname, firstname, title, titleofcourtesy, birthdate, hiredate, [address],
        city, region, postalcode, country, phone, mgrid
        )
    SELECT
        lastname, firstname, title, titleofcourtesy, birthdate, hiredate, [address],
        city, region, postalcode, country, phone, mgrid
    FROM inserted;
    PRINT 'Employee baru disimpan di tabel HR.EmployeesBackup..';
END
GO

INSERT INTO HR.Employees
VALUES
    ('Santoso', 'Adi', 'Staff', 'Mr.', '19830101', '20170101',
        'J1. Soekarno-Hatta', 'Malang', 'Jawa Timur', '65150', 'Indonesia',
        '(085) 123-456', 1);
SELECT *
FROM HR.EmployeesBackup;

-- Soal 13
IF OBJECT_ID('HR.trgDivertUpdateEmployeeToBackup') IS NOT NULL
    DROP TRIGGER HR.trgDivertUpdateEmployeeToBackup;
GO
CREATE TRIGGER trgDivertUpdateEmployeeToBackup ON HR.Employees
INSTEAD OF UPDATE
AS
BEGIN
    PRINT 'Trigger trgDivertUpdateEmployeeToBackup dipanggil!';
    DECLARE @empid INT = (SELECT TOP 1 empid FROM inserted);
    UPDATE HR.EmployeesBackup 
    SET
        lastname = i.lastname,
        firstname = i.firstname,
        title = i.title,
        titleofcourtesy = i.titleofcourtesy,
        birthdate = i.birthdate,
        hiredate = i.hiredate,
        [address] = i.[address],
        city = i.city,
        region = i.region,
        postalcode = i.postalcode,
        country = i.country,
        phone = i.phone,
        mgrid = i.mgrid
    FROM HR.EmployeesBackup e
    INNER JOIN inserted i ON e.empid = i.empid;  
    PRINT 'Karyawan dengan empid: ' + CONVERT(VARCHAR, @empid) + ' yang ada di HR.EmployeesBackup yang diupdate.';
END
GO

UPDATE HR.Employees SET title='DEPAN',
lastname='BELAKANG' 
WHERE firstname='Adi';
SELECT *
FROM HR.EmployeesBackup;

-- Soal 14
IF OBJECT_ID('HR.trgDivertDeleteEmployeeToBackup') IS NOT NULL
    DROP TRIGGER HR.trgDivertDeleteEmployeeToBackup;
GO
CREATE TRIGGER trgDivertDeleteEmployeeToBackup ON HR.Employees
INSTEAD OF DELETE
AS
BEGIN
    PRINT 'Trigger trgDivertDeleteEmployeeToBackup dipanggil!';
    DECLARE @empid INT = (SELECT TOP 1 empid FROM deleted);
    DECLARE @firstname VARCHAR(100) = (SELECT TOP 1 firstname FROM deleted);
    DECLARE @lastname VARCHAR(100) = (SELECT TOP 1 lastname FROM deleted);
    DELETE FROM HR.EmployeesBackup
    WHERE empid = @empid;
    PRINT 'Karyawan dengan nama: ' + @firstname +' ' + @lastname + ' dihapus di HR.EmployeesBackup saja. Di tabel aslinya tetap.';
END
GO

DELETE FROM HR.Employees WHERE firstname = 'Maria'
SELECT * FROM HR.EmployeesBackup;