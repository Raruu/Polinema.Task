USE TSQL20;

--membuat store procedur
CREATE PROCEDURE stp_suplier
AS
BEGIN
    -- Insert statements for procedure here
 SELECT * FROM Production.Products
END
GO

EXEC stp_suplier;

--update prosedure
ALTER PROCEDURE stp_suplier
AS
    SELECT * FROM Production.Products  WHERE categoryid=1
	ORDER BY productid;
GO
EXEC stp_suplier;

--delete procedure
DROP PROCEDURE stp_suplier
GO


---------------------buat prosedure insert--------------------------------
CREATE PROCEDURE stp_insertcategory
 -- Add the parameters for the stored procedure here
 @id int,
 @nama varchar(50),
 @deskripsi nvarchar(200)
AS
BEGIN
 -- SET NOCOUNT ON added to prevent extra result sets from
 -- interfering with SELECT statements.
 SET NOCOUNT ON;
 -- Insert statements for procedure here
 insert into Production.Categories
			(categoryid, categoryname, description) 
	 values (@id, @nama, @deskripsi)
END
GO

--utk kolom auto increment
SET IDENTITY_INSERT production.categories ON;

--eksekusi sp insert
exec stp_insertcategory 9, 'sayuran', 'bayam, kangkung, wortel';
GO


SELECT * FROM Production.Categories;

--delete procedure
DROP PROCEDURE stp_insertcategory
GO


-----------------buat prosedure delete-----------------
CREATE PROCEDURE stp_deletecategory
 -- Add the parameters for the stored procedure here
 @id int
AS
BEGIN
 -- SET NOCOUNT ON added to prevent extra result sets from
 -- interfering with SELECT statements.
 SET NOCOUNT ON;
 -- Insert statements for procedure here
 DELETE FROM [Production].[Categories]
      WHERE categoryid=@id
END
GO
DROP PROCEDURE stp_deletecategory;
--eksekusi sp-delete
exec stp_deletecategory 9;
GO
DROP PROCEDURE Sales.GetTopCustomers ;

CREATE PROCEDURE Sales.GetTopCustomers 
AS 
SELECT TOP(10)  c.custid,  c.contactname,  
SUM(o.val) AS salesvalue 
FROM Sales.OrderValues AS o 
INNER JOIN Sales.Customers AS c 
ON c.custid = o.custid 
GROUP BY c.custid, c.contactname 
ORDER BY salesvalue DESC; 

EXECUTE Sales.GetTopCustomers;

ALTER PROCEDURE Sales.GetTopCustomers 
AS 
SELECT   c.custid,  c.contactname, 
SUM(o.val) AS salesvalue 
FROM Sales.OrderValues AS o 
INNER JOIN Sales.Customers AS c 
ON c.custid = o.custid 
GROUP BY c.custid, c.contactname 
ORDER BY salesvalue DESC 
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY; 


ALTER PROCEDURE Sales.GetTopCustomers   
@customerpos int = 1,  
@customername nvarchar(30) OUTPUT 
AS 
SET @customername = (  
						SELECT   c.contactname  
						FROM Sales.OrderValues AS o  
						INNER JOIN Sales.Customers AS c 
						ON c.custid = o.custid  
						GROUP BY c.custid, c.contactname  
						ORDER BY SUM(o.val) DESC  
						OFFSET @customerpos - 1 ROWS FETCH NEXT 1 ROW ONLY 
); 

---- dengan kembalian nilai
DECLARE @outcustomername nvarchar(30); 

EXECUTE Sales.GetTopCustomers @customerpos = 1, 
@customername = @outcustomername OUTPUT;  

SELECT @outcustomername AS customername;
----------------------



EXEC sys.sp_help N'Sales.Customers';

EXEC sys.sp_columns @table_name = N'Customers', @table_owner = N'Sales'; 



--sql dynamic
DECLARE @table_owner nvarchar(50)  
DECLARE @tablename nvarchar(50)  
DECLARE @sqlstatement nvarchar(500)

SELECT @table_owner = N'Sales'
SELECT @tablename = N'Customers'
SELECT @sqlstatement = 'SELECT * FROM '+ @table_owner + '.' + @tablename

exec sp_executesql @sqlstatement
go


SELECT COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH,
IS_NULLABLE
FROM INFORMATION_SCHEMA.COLUMNS
WHERE table_name = 'Customers'

exec sys.sp_help N'Sales.Customers'