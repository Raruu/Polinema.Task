USE polinema;

CREATE TABLE student
(
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    DOB datetime NOT NULL,
    total_score INT NOT NULL,
    city VARCHAR(50) NOT NULL
 )

INSERT INTO student

VALUES (1, 'Jolly', 'Female', '12-JUN-1989', 500, 'London'), 
(2, 'Jon', 'Male', '02-FEB-1974', 545, 'Manchester'), 
(3, 'Sara', 'Female', '07-MAR-1988', 600, 'Leeds'), 
(4, 'Laura', 'Female', '22-DEC-1981', 400, 'Liverpool'), 
(5, 'Alan', 'Male', '29-JUL-1993', 500, 'London'), 
(6, 'Kate', 'Female', '03-JAN-1985', 500, 'Liverpool'), 
(7, 'Joseph', 'Male', '09-APR-1982', 643, 'London'), 
(8, 'Mice', 'Male', '16-AUG-1974', 543, 'Liverpool'), 
(9, 'Wise', 'Male', '11-NOV-1987', 499, 'Manchester'), 
(10, 'Elis', 'Female', '28-OCT-1990', 400, 'Leeds');

select * from student;

--1. select db
SELECT 
	city,
	total_score
FROM 
	student

--2. derived- buat temporary data set
SELECT * FROM

(SELECT 
	city,
	total_score
FROM 
	student
)
AS StudentTable

--3. implementasikan pivot
SELECT * FROM

(SELECT 
	city,
	total_score
FROM 
	student
)
AS StudentTable
PIVOT(
	AVG(total_score)
	FOR city IN ([London],[Liverpool],[Leeds],[Manchester])
) AS StudentPivotTable

--4.menambahkan baris grup
SELECT * FROM

(SELECT 
	city,
	gender,
	total_score
FROM 
	student
)
AS StudentTable
PIVOT(
	AVG(total_score)
	FOR city IN ([London],[Liverpool],[Leeds],[Manchester])
) AS StudentPivotTable

--12 cube
SELECT
YEAR(orderdate) AS orderyear,
MONTH(orderdate) AS ordermonth,
DAY(orderdate) AS orderday,
SUM(val) AS salesvalue
FROM Sales.OrderValues
GROUP BY
CUBE (YEAR(orderdate), MONTH(orderdate), DAY(orderdate));

--13 rollup
SELECT
YEAR(orderdate) AS orderyear,
MONTH(orderdate) AS ordermonth,
DAY(orderdate) AS orderday,
SUM(val) AS salesvalue
FROM Sales.OrderValues
GROUP BY
ROLLUP (YEAR(orderdate), MONTH(orderdate), DAY(orderdate));

/* 14
ROLLUP dan CUBE adalah group function yang sering digunakan dalam desain query untuk data warehouse. 
ROOLUP digunakan untuk menghitung nilai 
sub total dan total dari suatu group data sedangkan CUBE digunakan untuk menghitung sub total 
dari group data dalam beberapa dimensi.
*/
