-- DROP SCHEMA dbo;

CREATE SCHEMA dbo;

-- master.dbo.m_kategori definition

-- Drop table

-- DROP TABLE master.dbo.m_kategori;

CREATE TABLE master.dbo.m_kategori (
	kategori_id int IDENTITY(1,1) NOT NULL,
	kategori_kode varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	kategori_nama varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT m_kategori_pk PRIMARY KEY (kategori_id)
);


-- master.dbo.m_user definition

-- Drop table

-- DROP TABLE master.dbo.m_user;

CREATE TABLE master.dbo.m_user (
	user_id int IDENTITY(1,1) NOT NULL,
	username varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	nama varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[level] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	password varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT m_user_pk PRIMARY KEY (user_id)
);
 CREATE NONCLUSTERED INDEX m_user_user_id_IDX ON dbo.m_user (  user_id ASC  )  
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;

-- master.dbo.m_buku definition

-- Drop table

-- DROP TABLE master.dbo.m_buku;

CREATE TABLE master.dbo.m_buku (
	buku_id int IDENTITY(1,1) NOT NULL,
	kategori_id int NULL,
	buku_kode varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	buku_nama varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	jumlah int NULL,
	deskripsi text COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	gambar text COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT m_buku_pk PRIMARY KEY (buku_id),
	CONSTRAINT m_buku_m_kategori_FK FOREIGN KEY (kategori_id) REFERENCES master.dbo.m_kategori(kategori_id)
);
 CREATE NONCLUSTERED INDEX m_buku_kategori_id_IDX ON dbo.m_buku (  kategori_id ASC  )  
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;