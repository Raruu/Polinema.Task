use sampledb;

/*
CREATE TRIGGER [schema_name.]trigger_name
ON table_name
AFTER  {[INSERT],[UPDATE],[DELETE]}
[NOT FOR REPLICATION]
AS
*/

/*
After Triggers
These triggers are executed after an action such as Insert, Update or Delete is performed.
*/

CREATE TABLE Employee
(
  Id int Primary Key,
  Name nvarchar(30),
  Salary int,
  Gender nvarchar(10),
  DepartmentId int
)


GO
-- Insert data into Employee table
INSERT INTO Employee VALUES (1,'Pranaya', 5000, 'Male', 3)
INSERT INTO Employee VALUES (2,'Priyanka', 5400, 'Female', 2)
INSERT INTO Employee VALUES (3,'Anurag', 6500, 'male', 1)
INSERT INTO Employee VALUES (4,'sambit', 4700, 'Male', 2)

-- Create EmployeeAudit Table
CREATE TABLE EmployeeAudit
(
  ID INT IDENTITY(1,1) PRIMARY KEY,
  AuditData VARCHAR(MAX),
  AuditDate DATETIME
)

drop table Employee;
drop table EmployeeAudit;

--Create a Trigger that will restrict the INSERT operation on the Employee table.
CREATE TRIGGER trInsertEmployee 
ON Employee
FOR INSERT
AS
BEGIN
  PRINT 'YOU CANNOT PERFORM INSERT OPERATION'
  ROLLBACK TRANSACTION
END

INSERT INTO Employee VALUES (6, 'Saroj', 7600, 'Male', 1);

--Create a Trigger which will restrict the UPDATE operation on the Employee table.
CREATE TRIGGER trUpdateEmployee 
ON Employee
FOR UPDATE
AS
BEGIn
  PRINT 'YOU CANNOT PERFORM UPDATE OPERATION'
  ROLLBACK TRANSACTION
END

UPDATE Employee SET Salary = 90000 WHERE Id = 1;

--Create a Trigger which will restrict the DELETE operation on the Employee table.
CREATE TRIGGER trDeleteEmployee 
ON Employee
FOR DELETE
AS
BEGIN
  PRINT 'YOU CANNOT PERFORM DELETE OPERATION'
  ROLLBACK TRANSACTION
END

DISABLE TRIGGER trDeleteEmployee ON Employee;
ENABLE TRIGGER trDeleteEmployee ON Employee;

DELETE FROM Employee WHERE Id = 1;

--drop trigger
DROP TRIGGER trDeleteEmployee;
DROP TRIGGER trInsertEmployee;
DROP TRIGGER trUpdateEmployee;

select * from employee;


--select * from sys.tables;

--AFTER TRIGGER for INSERT event
CREATE TRIGGER tr_Employee_For_Insert
ON Employee
FOR INSERT
AS
BEGIN
  -- Declare a variable to hold the ID Value
  DECLARE @ID INT
  -- Declare a variable to hold the Name value
  DECLARE @Name VARCHAR(100)
  -- Declare a variable to hold the Audit data
  DECLARE @AuditData VARCHAR(100)
  -- Get the ID and Name from the INSERTED Magic table


  SELECT @ID = ID, @Name = Name FROM INSERTED--ambil data dari tabel


  -- Set the AuditData to be stored in the EmployeeAudit table
  SET @AuditData = 'Pegawai baru ditambahkan dengan ID  = ' + Cast(@ID AS VARCHAR(10)) + ' and Name ' + @Name
  -- Insert the data into the EmployeeAudit table
        INSERT INTO EmployeeAudit (AuditData, AuditDate)
        VALUES(@AuditData, GETDATE())
END
--
drop trigger tr_Employee_For_Insert;

INSERT INTO Employee VALUES (7, 'Hannah', 3300, 'Female', 2);
INSERT INTO Employee VALUES (8, 'HannahHHHHH', 3300, 'Female', 2);


SELECT * FROM Employee;
SELECT * FROM EmployeeAudit;

-- FOR DELETE
CREATE TRIGGER tr_Employee_For_Delete
ON Employee
FOR DELETE
AS
BEGIN
  -- Declare a variable to hold the ID Value
  DECLARE @ID INT
    -- Declare a variable to hold the Name value
  DECLARE @Name VARCHAR(100)
    -- Declare a variable to hold the Audit data
  DECLARE @AuditData VARCHAR(100)
    -- Get the ID and Name from the DELETED table
  SELECT @ID = ID, @Name = Name FROM DELETED
    -- Set the AuditData to be stored in the EmployeeAudit table
  SET @AuditData = 'An employee is deleted with ID  = ' + Cast(@ID AS VARCHAR(10)) + ' and Name = ' + @Name
    -- Insert the data into the EmployeeAudit table
        INSERT INTO EmployeeAudit (AuditData, AuditDate)
        VALUES(@AuditData, GETDATE())
END

DELETE FROM Employee WHERE ID = 6;
SELECT * FROM EmployeeAudit;

--FOR DELETE
CREATE TRIGGER tr_Employee_For_Update
ON Employee
FOR Update
AS
BEGIN
      -- Declare the variables to hold old and updated data
      DECLARE @ID INT
      DECLARE @Old_Name VARCHAR(200), @New_Name VARCHAR(200)
      DECLARE @Old_Salary INT, @New_Salary INT
      DECLARE @Old_Gender VARCHAR(200), @New_Gender VARCHAR(200)
      DECLARE @Old_DepartmenttId INT, @New_DepartmenttId INT
     
      -- Declare Variable to build the audit string
      DECLARE @AuditData VARCHAR(MAX)
      
      -- Store the updated data into a temporary table
      SELECT *
      INTO #UpdatedDataTempTable
      FROM INSERTED
     
      -- Loop thru the records in the UpdatedDataTempTable temp table
      WHILE(Exists(SELECT ID FROM #UpdatedDataTempTable))
      BEGIN
            --Initialize the audit string to empty string
            SET @AuditData = ''
           
            -- Select first row data from temp table
            SELECT TOP 1 @ID = ID, 
              @New_Name = Name, 
              @New_Gender = Gender, 
              @New_Salary = Salary,
              @New_DepartmenttId = DepartmentId
            FROM #UpdatedDataTempTable
           
            -- Select the corresponding row from deleted table
            SELECT @Old_Name = Name, 
          @Old_Gender = Gender, 
          @Old_Salary = Salary, 
          @Old_DepartmenttId = DepartmentId
            FROM DELETED WHERE ID = @ID
   
      -- Build the audit data dynamically           
            Set @AuditData = 'Employee with Id = ' + CAST(@ID AS VARCHAR(6)) + ' changed'

      -- If old name and new name are not same, then its changed
            IF(@Old_Name <> @New_Name)
      BEGIN
                  Set @AuditData = @AuditData + ' Name from ' + @Old_Name + ' to ' + @New_Name
      END
            
      -- If old Gender and new gender are not same, then its changed     
            IF(@Old_Gender <> @New_Gender)
      BEGIN
                  Set @AuditData = @AuditData + ' Gender from ' + @Old_Gender + ' to ' + @New_Gender
      END
                
      -- If old Salary and new Salary are not same, then its changed  
            IF(@Old_Salary <> @New_Salary)
      BEGIN
                  Set @AuditData = @AuditData + ' Salary from ' + Cast(@Old_Salary AS VARCHAR(10))+ ' to ' 
            + Cast(@New_Salary AS VARCHAR(10))
      END
            
      -- If old Department ID and new Department ID are not same, then its changed      
      IF(@Old_DepartmenttId <> @New_DepartmenttId)
      BEGIN
                  Set @AuditData = @AuditData + ' DepartmentId from ' + Cast(@Old_DepartmenttId AS VARCHAR(10))+ ' to ' 
              + Cast(@New_DepartmenttId AS VARCHAR(10))
            END

      -- Then Insert the audit data into the EmployeeAudit table
            INSERT INTO EmployeeAudit(AuditData, AuditDate) VALUES(@AuditData, GETDATE())
            
            -- Delete the current row from temp table, so we can move to the next row
            DELETE FROM #UpdatedDataTempTable WHERE ID = @ID
      End
End


SELECT * FROM employee;
UPDATE Employee SET Name='Beta', Gender='Female' Where Id = 4;
SELECT * FROM EmployeeAudit;