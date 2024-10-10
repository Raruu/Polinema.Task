-- Bagian 1
-- Soal 1
SELECT
    ov.orderid, ov.orderdate, ov.val,
    ROW_NUMBER() OVER(ORDER BY ov.orderdate) rowno
FROM Sales.OrderValues ov;

-- Soal 2
SELECT
    ov.orderid, ov.orderdate, ov.val,
    ROW_NUMBER() OVER(ORDER BY ov.orderdate) rowno,
    RANK() OVER(ORDER BY ov.orderdate) rankno
FROM Sales.OrderValues ov;

-- Soal 4
SELECT
    ov.orderid, ov.orderdate, ov.custid, ov.val,
    RANK() OVER(PARTITION BY ov.custid ORDER BY ov.val DESC) orderrankno
FROM Sales.OrderValues ov;

-- Soal 7
WITH
    OrderRows
    AS
    (
        SELECT
            ov.orderid, ov.orderdate, ov.val,
            ROW_NUMBER() OVER(ORDER BY ov.orderdate, ov.orderid) rowno
        FROM Sales.OrderValues ov
    )

-- Soal 8
SELECT
    or1.orderid, or1.orderdate, or1.val,
    or2.val prevval,
    or1.val - or2.val diffprev
FROM OrderRows or1
    LEFT JOIN OrderRows or2 ON or1.rowno - 1 = or2.rowno;

-- Soal 9
SELECT
    ov.orderid, ov.orderdate, ov.val,
    LAG(ov.val) OVER(ORDER BY ov.orderdate) prevval,
    ov.val - LAG(ov.val) OVER(ORDER BY ov.orderdate) diffprev
FROM Sales.OrderValues ov;

-- Soal 12
SELECT
    ov.custid, ov.orderid, ov.orderdate, ov.val,
    ov.val / SUM(ov.val) OVER(PARTITION BY ov.custid 
    ) * 100 percoftotalcust
FROM Sales.OrderValues ov
ORDER BY ov.custid, ov.val DESC;


