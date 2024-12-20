USE TSQL; 

--UNION
(   
	SELECT 1 ID
    UNION
    SELECT 2
    UNION
    SELECT 3
)
UNION
(
    SELECT 3
    UNION
    SELECT 4
    UNION
    SELECT 5
);


--UNION ALL
(   
	SELECT 1 ID
    UNION
    SELECT 2
    UNION
    SELECT 3
)
UNION ALL
(
    SELECT 3
    UNION
    SELECT 4
    UNION
    SELECT 5
);

SELECT country, region, city from HR.Employees
UNION
SELECT country, region, city from Sales.Customers;


SELECT country, region, city from HR.Employees
UNION ALL
SELECT country, region, city from Sales.Customers;

--INTERSECT
(
    SELECT 1 ID
    UNION
    SELECT 2
    UNION
    SELECT 3
)
INTERSECT
(
    SELECT 3
    UNION
    SELECT 4
    UNION
    SELECT 5
);

SELECT country, region, city from HR.Employees
INTERSECT
SELECT country, region, city from Sales.Customers;


--except
(
    SELECT 1
    UNION
    SELECT 2
    UNION
    SELECT 3
)
EXCEPT
(
    SELECT 3 
    UNION
    SELECT 4
    UNION
    SELECT 5
);

SELECT country, region, city from HR.Employees
EXCEPT
SELECT country, region, city from Sales.Customers;

SELECT country, region, city from Sales.Customers
EXCEPT
SELECT country, region, city from HR.Employees;

---------------------------------------------CROSS APPLY--------------------------------------------------------------------------
-- Step 2: Create inline Table-valued Function
-- Create a TVF to accept a supplier id and return
-- the top 3 most expensive products for that shipper
CREATE FUNCTION dbo.fn_TopProductsByShipper
(@supplierid int)
RETURNS TABLE
AS
RETURN
    SELECT TOP (3) productid, productname, unitprice
    FROM Production.Products
    WHERE supplierid = @supplierid
    ORDER BY unitprice DESC;
GO


SELECT S.supplierid, s.companyname, P.productid, P.productname, P.unitprice
	FROM Production.Suppliers AS S
		CROSS APPLY dbo.fn_TopProductsByShipper(S.supplierid) AS P;


---------------------------------------------OUTER APPLY--------------------------------------------------------------------------
SELECT C.custid, TopOrders.orderid, TopOrders.orderdate
	FROM Sales.Customers AS C
	OUTER APPLY
		(SELECT TOP (3) orderid, orderdate
		FROM Sales.Orders AS O
		WHERE O.custid = C.custid
		ORDER BY orderdate DESC, orderid DESC) AS TopOrders;

---------------------------------------------INTERSECT--------------------------------------------------------------------------

SELECT country, city
FROM Production.Suppliers
INTERSECT
SELECT country, city
FROM Sales.Customers;


---------------------------------------------EXCEPT--------------------------------------------------------------------------

SELECT country, city
FROM Production.Suppliers
EXCEPT
SELECT country, city
FROM Sales.Customers;


SELECT country, city
FROM Sales.Customers
EXCEPT
SELECT country, city
FROM Production.Suppliers;


USE polinema;

---------------------------------------------TRIGGER--------------------------------------------------------------------------
create table Anggota(
Id_Anggota varchar(10) not null primary key,
Nama varchar(35),
Alamat varchar(35),
Tempat_Lahir varchar(20),
Tgl_Lahir datetime,
Jenis_Kelamin varchar(10),
Pekerjaan varchar(20),
No_Telephone varchar(15))

drop table Anggota;

------------PROCEDURE---------
CREATE procedure SelectAnggota
AS
SELECT * FROM Anggota
GO; 
EXEC SelectAnggota;

-----------------------------------------------------------------------------------------------------------------------
---membuat tabel buku perpustakaan---
create table Buku(
Id_Buku varchar(10) not null primary key,
Judul varchar(50),
Pengarang varchar(35),
Penerbit varchar(35),
Tahun_Terbit varchar(10),
No_Rak varchar(10),
Jumlah_Buku int)

drop table Buku;
-----------------------------------------------------------------------------------------------------------------------
---membuat tabel administrasi perpustakaan---
create table Administrasi(
Id_Admin varchar(10) not null primary key,
Nama varchar(35),
Alamat varchar(35),
Tempat_Lahir varchar(20),
Tgl_Lahir datetime,
Jenis_Kelamin varchar(10),
No_Telephone varchar(15))

drop table Administrasi;
-----------------------------------------------------------------------------------------------------------------------
create table Pinjam(Id_Pinjam varchar(10) not null primary key,
Id_Buku varchar(10) constraint Id_Buku foreign key(Id_Buku) references
Buku(Id_Buku),
Id_Anggota varchar(10) constraint Id_Anggota foreign key(Id_Anggota)
references Anggota(Id_Anggota),
Id_Admin varchar(10) constraint Id_Admin foreign key(Id_Admin) references
Administrasi(Id_Admin),
Jumlah_Pinjam int,
Tgl_Pinjam datetime,
Tgl_Kembali datetime);

drop table Pinjam;
-----------------------------------------------------------------------------------------------------------------------
---input data tabel anggota perpustakaan---
insert into Anggota values ('ANG-001','ADUL SUKIRMAN','JL. SENTOSA NO. 12
MEDAN','JAKARTA','1990-09-21','LAKI-LAKI','WIRASWASTA','061-6646982');

insert into Anggota values ('ANG-002','BUDI ANDUK','JL. MAKMUR NO. 10
BELAWAN','MEDAN','1988-10-11','LAKI-LAKI','SUPIR','061-6643122');

insert into Anggota values ('ANG-003','CEPOT PAIJO','JL. MADIOSANTOSO NO.
32 TITIPAPAN','SUKABUMI','1991-09-10','LAKI-LAKI','MAHASISWA','085212343590');

insert into Anggota values ('ANG-004','DONO SANGKURIANG','JL. KRAKATAU NO.
18 MARELAN','MANDAILING NATAL','1980-03-09','LAKI-LAKI','WARTAWAN','083129876578');

insert into Anggota values ('ANG-005','EDY SUPONO','JL. PRAJURIT NO. 90
MARTUBUNG','ACEH','1989-06-05','LAKI-LAKI','BURUH PABRIK','061-6648976');


-----------------------------------------------------------------------------------------------------------------------
---input data tabel buku perpustakaan---
insert into Buku values ('BU-001','ALGORITMA DAN PEMROGRAMAN C','RINALDI
MUNIR','INFORMATIKA','2003','R-02',15)
insert into Buku values ('BU-002','APLIKASI DATABASE VB.NET DENGAN SQL
SERVER','MUHAMMAD RHIFKY','ANDI OFFSET','2013','R-02',25)
insert into Buku values ('BU-003','BAHASA C DASAR','JOGIYANTO PHD','ANDI
OFFSET','2007','R-01',10)
insert into Buku values ('BU-004','MATEMATIKA DISKRIT','RINALDI
MUNIR','INFORMATIKA','2010','R-01',5)
insert into Buku values ('BU-005','VISUAL BASIC.NET 2010','PRIYANTO
HIDAYATULLAH','INFORMATIKA','2012','R-03',20)


-----------------------------------------------------------------------------------------------------------------------
---input data tabel administrasi perpustakaan---
insert into Administrasi values ('ADM-001','ENJELIA AGUSTINA','JL. UMAR
NO. 34 MEDAN','MEDAN','1993-08-01','PEREMPUAN','085789844932')
insert into Administrasi values ('ADM-002','GHASSANI SYAFITRI','JL. BONO
NO. 58 MEDAN','BANDUNG','1990-01-21','PEREMPUAN','085209878909')
insert into Administrasi values ('ADM-003','HENY HANDAYANI','JL. MUSTAFA
NO. 02 MEDAN','JAKARTA','1989-07-05','PEREMPUAN','082187564765')
insert into Administrasi values ('ADM-004','JONO SANTOSO','JL. MARELAN NO.
44 MEDAN','MEDAN','1992-04-09','LAKI-LAKI','083123454312')
insert into Administrasi values ('ADM-005','SUMARDI ALFIANTO','JL. MANDOR
NO. 14 MEDAN','BOGOR','1990-09-28','LAKI-LAKI','061-6648989')


---lihat data tabel anggota, buku, administrasi, dan pinjam---
select * from Anggota
select * from Buku
select * from Administrasi

---membuat trigger---
---membuat trigger insert data anggota---
create trigger trig_Anggota
on Anggota for insert
as
print 'Data Anggota Berhasil Ditambahkan'
print 'Dimodifikasi : '+ CONVERT(VARCHAR ,GETDATE())
print 'Nama Host : '+HOST_NAME()


insert into Anggota values ('ANG-006','M. RHIFKY','JL. SENTOSA INDAH NO.
21 MEDAN','MEDAN','1980-06-23','LAKI-LAKI','GURU','085763155905')

select * from Anggota;

---membuat trigger insert data buku---
create trigger trig_Buku on Buku for insert
as
print 'Data Buku Berhasil Ditambahkan'
print 'Dimodifikasi : '+ CONVERT(VARCHAR ,GETDATE())
print 'Nama Host : '+HOST_NAME()

insert into Buku values ('BU-006','SQL SERVER 2008','PROF. WAYAHDI','ANDI
OFFSET','2013','R-03',25)

select * from Buku;


---membuat trigger insert data administrasi---
create trigger trig_Admin on Administrasi for insert
as
print 'Data Admin Berhasil Ditambahkan'
Print 'Dimodifikasi : '+ CONVERT(VARCHAR ,GETDATE())
Print 'Nama Host : '+HOST_NAME()

insert into Administrasi values ('ADM-006','PUSPITA SARI','JL. SETIA BUDI
NO. 43 MEDAN','SEMARANG','1993-10-01','PEREMPUAN','085743218989');

select * from Administrasi

---membuat trigger insert pada tabel pinjam dimana jumlah pinjam update dengan jumlah buku pada tabel buku---
create trigger Insert_Data_Pinjam on Pinjam
after insert
as
update Buku set Buku.Jumlah_Buku = Buku.Jumlah_Buku - INSERTED.Jumlah_Pinjam 
from INSERTED where Buku.Id_Buku = INSERTED.Id_Buku
print 'Data Pinjam Berhasil Ditambahkan'
print 'Jumlah Buku Pada Table Buku Juga Berhasil Ter-Update'
Print 'Dimodifikasi : '+ CONVERT(VARCHAR ,GETDATE())
Print 'Nama Host : '+HOST_NAME()

insert into Pinjam values
('PJM-001','BU-005','ANG-001','ADM-003',1,'2013-08-09',NULL)
insert into Pinjam values
('PJM-002','BU-004','ANG-002','ADM-003',2,'2013-08-11',NULL)
insert into Pinjam values
('PJM-003','BU-002','ANG-003','ADM-003',1,'2013-08-13',NULL)
insert into Pinjam values
('PJM-004','BU-002','ANG-004','ADM-002',1,'2013-08-20',NULL)
insert into Pinjam values
('PJM-005','BU-003','ANG-005','ADM-001',2,'2013-08-20',NULL)

select * from Pinjam
select * from Buku


---membuat trigger update pada tabel pinjam dimana jumlah pinjam update dengan jumlah buku pada tabel buku---
create trigger Ubah_Data_Pinjam on Pinjam
after update
as
update Buku set
Buku.Jumlah_Buku=(Buku.Jumlah_Buku+deleted.Jumlah_Pinjam)-inserted.Jumlah_Pinjam 
from deleted,inserted 
where Buku.Id_Buku=deleted.Id_Buku
print 'Data Pinjam Berhasil Diubah'
print 'Jumlah Buku Pada Table Buku Juga Berhasil Ter-Update'
Print 'Dimodifikasi : '+ CONVERT(VARCHAR ,GETDATE())
Print 'Nama Host : '+HOST_NAME()


update Pinjam set Jumlah_Pinjam=5 where Id_Pinjam='PJM-003'

select * from Pinjam
select * from Buku



---membuat trigger delete pada tabel pinjam dimana jumlah pinjam update dengan jumlah buku pada tabel buku
create trigger Hapus_Data_Pinjam on Pinjam
after delete
as
update Buku set
Buku.Jumlah_Buku = Buku.Jumlah_Buku + deleted.Jumlah_Pinjam
from deleted where Buku.Id_Buku = deleted.Id_Buku
print 'Data Pinjam Berhasil Dihapus'
print 'Jumlah Buku Pada Tabe Buku Juga Berhasil Ter-Update'
Print 'Dimodifikasi : '+ CONVERT(VARCHAR ,GETDATE())
Print 'Nama Host : '+HOST_NAME()


delete from Pinjam where Id_Pinjam='PJM-003'
select * from Pinjam
select * from Buku