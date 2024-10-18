USE tokosepeda;

SELECT * FROM production.products;
SELECT * from production.categories;

-- seleksi berdasarkan nama kategori dan jumlah produk per kategori
SELECT 
    category_name, 
    COUNT(product_id) product_count
FROM 
    production.products p
    INNER JOIN production.categories c 
        ON c.category_id = p.category_id
GROUP BY 
    category_name;

-- langkah2 select a base dataset for pivoting.
--1. 

SELECT * FROM 
(
SELECT category_name, product_id 
FROM production.products p INNER JOIN production.categories c 
ON c.category_id = p.category_id
) t;

pivot

--2. select menggunakan derived tabel
SELECT * FROM (
    SELECT 
        category_name, 
        product_id
    FROM 
        production.products p
        INNER JOIN production.categories c 
            ON c.category_id = p.category_id
) t

-- 3. gunakan operator pivot
SELECT * FROM   
(
    SELECT 
        category_name, 
        product_id
    FROM 
        production.products p
        INNER JOIN production.categories c 
            ON c.category_id = p.category_id
) t 

PIVOT(
    COUNT(product_id) 
    FOR category_name IN (
        [Children Bicycles], 
        [Comfort Bicycles], 
        [Cruisers Bicycles], 
        [Cyclocross Bicycles], 
        [Electric Bikes], 
        [Mountain Bikes], 
        [Road Bikes])
) AS pivot_table;

--jika ingin menambahkan atribut yang lainnya pivot otomatis juga akan lagsung menyesuaikan outputnya
SELECT * FROM   
(
    SELECT 
        category_name, 
        product_id,
        model_year --kolom tambahan
    FROM 
        production.products p
        INNER JOIN production.categories c 
            ON c.category_id = p.category_id
) t 
PIVOT(
    COUNT(product_id) 
    FOR category_name IN (
        [Children Bicycles], 
        [Comfort Bicycles], 
        [Cruisers Bicycles], 
        [Cyclocross Bicycles], 
        [Electric Bikes], 
        [Mountain Bikes], 
        [Road Bikes])
) AS pivot_table;


-- demo pivot	TSQL20
USE TSQL;
--A. VIEW
CREATE VIEW Sales.CategoryQtyYear
AS
SELECT  c.categoryname AS Category,
        od.qty AS Qty,
        YEAR(o.orderdate) AS Orderyear
FROM    Production.Categories AS c
        INNER JOIN Production.Products AS p ON c.categoryid=p.categoryid
        INNER JOIN Sales.OrderDetails AS od ON p.productid=od.productid
        INNER JOIN Sales.Orders AS o ON od.orderid=o.orderid;
GO 


-- PIVOT CATEGORY BERDASAR ORDER YEAR

SELECT  Category, [2006],[2007],[2008]
FROM ( 
SELECT  Category, Qty, Orderyear FROM Sales.CategoryQtyYear) AS D 
    PIVOT(SUM(QTY) FOR orderyear IN ([2006],[2007],[2008])) AS pvt
ORDER BY Category;


-- DEMO UNPIVOT
CREATE TABLE [Sales].[PivotedCategorySales](
[Category] [nvarchar](15) NOT NULL,
[2006] [int] NULL,
[2007] [int] NULL,
[2008] [int] NULL);
GO
-- Populate it by pivoting from view
INSERT INTO Sales.PivotedCategorySales (Category, [2006],[2007],[2008])
SELECT Category, [2006],[2007],[2008] 
FROM (SELECT  Category, Qty, Orderyear FROM Sales.CategoryQtyYear) AS D 
    PIVOT(SUM(QTY) FOR orderyear IN ([2006],[2007],[2008]))AS p

--SELECT TABEL
SELECT * FROM Sales.PivotedCategorySales;

--UNPIVOT
SELECT category, qty, orderyear
		FROM Sales.PivotedCategorySales
		UNPIVOT(
					qty FOR orderyear IN([2006],[2007],[2008])
				) AS unpvt;

--PIVOT dengan CTE
--1. select data
SELECT shipperid, shipcity, freight
FROM Sales.Orders
WHERE shipcountry = N'Spain'
ORDER BY shipperid, shipcity;

--2. CTE
WITH PivotInput AS
 (
  SELECT shipperid, shipcity, freight
  FROM Sales.Orders
  WHERE shipcountry = N'Spain'
)
SELECT *
FROM PivotInput
  PIVOT( SUM(freight)
    FOR shipcity IN (Barcelona, Madrid, Sevilla) ) AS PivotOutput;

-- grouping set
SELECT Category, NULL AS Cust, SUM(Qty) AS TotalQty
FROM Sales.CategorySales
GROUP BY category
UNION ALL 
SELECT  NULL, Cust, SUM(Qty) AS TotalQty
FROM Sales.CategorySales
GROUP BY cust 
UNION ALL
SELECT NULL, NULL, SUM(Qty) AS TotalQty
FROM Sales.CategorySales;


