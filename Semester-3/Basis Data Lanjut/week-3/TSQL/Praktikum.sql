-- Bagian 1
-- Soal 1
SELECT
    GETDATE() currentdatetime, CAST(GETDATE() AS DATE) currentdate,
    CAST(GETDATE() AS TIME) currenttime, YEAR(GETDATE()) currentyear,
    MONTH(GETDATE()) currentmounth, DAY(GETDATE()) currentday,
    DATEPART(WEEK, GETDATE()) currentweeknumber,
    DATENAME(MONTH, GETDATE()) currentmonthname;


-- Bagian 2
-- Soal 3
SELECT
    CAST(GETDATE() AS DATE) todaysdate,
    CONVERT(varchar(12), GETDATE(), 107) todaysdate,
    FORMAT(GETDATE(), 'dd MMM yyyy') todaysdate;


-- Bagian 3
-- Soal 4
SELECT
    DATEADD(MONTH, 5, GETDATE()) fivemouths,
    DATEDIFF(DAY, GETDATE(), DATEADD(MONTH, 5, GETDATE())) diffdays,
    DATEDIFF(WEEK, '1945-08-17', '2022-08-17') diffweeks,
    DATEADD(day, 1 - DAY(GETDATE()), CAST(GETDATE() AS DATE)) firstday;


-- Bagian 4
-- CREATE TABLE Sales.Somedates
-- (
--     isitdate varchar(9)
-- );
INSERT INTO Sales.Somedates
    (isitdate)
VALUES
    ('20230101'),
    ('20230102'),
    ('20230103X'),
    ('20230104'),
    ('20230105'),
    ('20230106'),
    ('20230107Y'),
    ('20230108');

-- Soal 5
SELECT
    s.isitdate, 
    IIF(ISDATE(s.isitdate) = 1, CONVERT(date, s.isitdate), NULL) converteddate
FROM Sales.Somedates s;

-- Soal 6
SELECT SYSDATETIME() sysdatetime, CURRENT_TIMESTAMP currenttimestamp;

-- Bagian 5
-- Soal 8
SELECT
    o.custid, o.shipname, o.shippeddate
FROM Sales.Orders o 
WHERE DATEPART(MONTH, o.shippeddate) = 03 
AND DATEPART(YEAR, o.shippeddate) = 2008
ORDER BY o.custid ASC;