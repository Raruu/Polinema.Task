-- Bagian 1
-- Soal 1
SELECT name, database_id, create_date
FROM sys.databases;

-- Soal 2
SELECT object_id, name, schema_id, [type], type_desc, create_date, modify_date
FROM sys.objects;

-- Soal 3
SELECT object_id, name, schema_id, [type], type_desc, create_date, modify_date
FROM sys.tables
WHERE type = 'U';

-- Soal 4
SELECT COLUMN_NAME column_name,
    ORDINAL_POSITION coulmn_id,
    DATA_TYPE data_type,
    CHARACTER_MAXIMUM_LENGTH max_length,
    NUMERIC_PRECISION precision,
    NUMERIC_SCALE scale,
    COLLATION_NAME collation_name
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'Customers' AND TABLE_SCHEMA = 'Sales';

-- Bagian 2
-- Soal 5
SELECT
    DB_ID() database_id,
    DB_NAME() database_name,
    USER_ID() user_id,
    USER_NAME() user_name;

-- Soal 6
SELECT o.name,
    o.type_desc,
    o.object_id,
    s.name AS schema_name
FROM sys.objects o
    JOIN sys.schemas s ON o.schema_id = s.schema_id;

-- Soal 7
SELECT name AS column_name,
    OBJECT_NAME(object_id) AS table_name,
    OBJECT_SCHEMA_NAME(object_id) AS schema_name
FROM sys.columns
WHERE name LIKE '%name%'
    AND OBJECTPROPERTY(object_id, 'IsUserTable') = 1;

-- Soal 8
PRINT OBJECT_DEFINITION(OBJECT_ID('Sales.CustOrders'));

-- Bagian 3
-- Soal 9   
SELECT
    s.session_id, s.login_time, s.host_name,
    s.[language], s.login_name, s.date_format
FROM sys.dm_exec_sessions s
WHERE status = 'running';

-- Soal 10
SELECT
    cpu_count AS [Logical CPU Count],
    hyperthread_ratio AS [Hyperthread Ratio],
    cpu_count / hyperthread_ratio AS [Physical CPU Count],
    physical_memory_kb / 1024 AS [RAM (MB)],
    sqlserver_start_time AS [Last SQL Server Start]
FROM
    sys.dm_os_sys_info;

-- Soal 11
SELECT total_physical_memory_kb / (1024 * 1024) AS [Total RAM (GB)],
    available_physical_memory_kb / (1024 * 1024) AS [Available RAM (GB)],
    total_page_file_kb / (1024 * 1024) AS [Total Page File (GB)],
    available_page_file_kb / (1024 * 1024) AS [Available Page File (GB)],
    system_memory_state_desc AS [RAM Availability Status]
FROM sys.dm_os_sys_memory;
