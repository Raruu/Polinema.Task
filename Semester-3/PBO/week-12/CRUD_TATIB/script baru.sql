USE [master]
GO
/****** Object:  Database [tatib]    Script Date: 14/11/2024 08:07:03 ******/
CREATE DATABASE [tatib]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'tatib', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\tatib.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'tatib_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\tatib_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [tatib] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [tatib].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [tatib] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [tatib] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [tatib] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [tatib] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [tatib] SET ARITHABORT OFF 
GO
ALTER DATABASE [tatib] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [tatib] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [tatib] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [tatib] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [tatib] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [tatib] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [tatib] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [tatib] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [tatib] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [tatib] SET  DISABLE_BROKER 
GO
ALTER DATABASE [tatib] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [tatib] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [tatib] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [tatib] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [tatib] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [tatib] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [tatib] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [tatib] SET RECOVERY FULL 
GO
ALTER DATABASE [tatib] SET  MULTI_USER 
GO
ALTER DATABASE [tatib] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [tatib] SET DB_CHAINING OFF 
GO
ALTER DATABASE [tatib] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [tatib] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [tatib] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [tatib] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'tatib', N'ON'
GO
ALTER DATABASE [tatib] SET QUERY_STORE = ON
GO
ALTER DATABASE [tatib] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [tatib]
GO
/****** Object:  Table [dbo].[dosen]    Script Date: 14/11/2024 08:07:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dosen](
	[nip] [varchar](10) NOT NULL,
	[nama] [varchar](50) NOT NULL,
	[tmplahir] [varchar](50) NULL,
	[tgllahir] [date] NULL,
	[gender] [varchar](10) NOT NULL,
	[sebagai] [varchar](30) NOT NULL,
	[alamat] [varchar](100) NULL,
	[kabupatenkota] [varchar](50) NULL,
	[provinsi] [varchar](50) NULL,
 CONSTRAINT [PK_dosen] PRIMARY KEY CLUSTERED 
(
	[nip] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mahasiswa]    Script Date: 14/11/2024 08:07:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mahasiswa](
	[nim] [varchar](10) NOT NULL,
	[nama] [varchar](50) NOT NULL,
	[tmplahir] [varchar](50) NULL,
	[tgllahir] [date] NULL,
	[gender] [varchar](10) NOT NULL,
	[alamat] [varchar](100) NULL,
	[desa] [varchar](100) NULL,
	[kecamatan] [varchar](100) NULL,
	[kabupatenkota] [varchar](50) NULL,
	[provinsi] [varchar](50) NULL,
 CONSTRAINT [PK_mahasiswa] PRIMARY KEY CLUSTERED 
(
	[nim] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pelanggaran]    Script Date: 14/11/2024 08:07:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pelanggaran](
	[idpelanggaran] [int] NOT NULL,
	[jenispelanggaran] [varchar](100) NOT NULL,
	[levelpelanggaran] [int] NOT NULL,
 CONSTRAINT [PK_pelanggaran] PRIMARY KEY CLUSTERED 
(
	[idpelanggaran] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pengguna]    Script Date: 14/11/2024 08:07:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pengguna](
	[username] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[sebagai] [varchar](100) NOT NULL,
 CONSTRAINT [PK_pengguna] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sanksi]    Script Date: 14/11/2024 08:07:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanksi](
	[idsanksi] [int] NOT NULL,
	[jenissanksi] [varchar](100) NOT NULL,
	[levelpelanggaran] [int] NOT NULL,
 CONSTRAINT [PK_sanksi] PRIMARY KEY CLUSTERED 
(
	[idsanksi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[mahasiswa] ([nim], [nama], [tmplahir], [tgllahir], [gender], [alamat], [desa], [kecamatan], [kabupatenkota], [provinsi]) VALUES (N'12', N'234wqe', N'23wqe', CAST(N'2024-11-14' AS Date), N'Pria', N'23wqe', N'2wqe', N'23wqe', N'23wqe', N'23wqe')
INSERT [dbo].[mahasiswa] ([nim], [nama], [tmplahir], [tgllahir], [gender], [alamat], [desa], [kecamatan], [kabupatenkota], [provinsi]) VALUES (N'3e', N'e2e23', N'r23r32', CAST(N'2024-11-14' AS Date), N'Pria', N'r32r', NULL, NULL, N'3r', N'3r3r')
INSERT [dbo].[mahasiswa] ([nim], [nama], [tmplahir], [tgllahir], [gender], [alamat], [desa], [kecamatan], [kabupatenkota], [provinsi]) VALUES (N'wqe', N'wqe', N'weq', CAST(N'2024-11-14' AS Date), N'Pria', N'we', N'we', N'', N'we', N'we')
GO
ALTER TABLE [dbo].[dosen]  WITH CHECK ADD CHECK  (([gender]='Wanita' OR [gender]='Pria'))
GO
ALTER TABLE [dbo].[dosen]  WITH CHECK ADD CHECK  (([sebagai]='Dosen Pengajar' OR [sebagai]='DPA'))
GO
ALTER TABLE [dbo].[mahasiswa]  WITH CHECK ADD  CONSTRAINT [CK__mahasiswa__gende__3A81B327] CHECK  (([gender]='Wanita' OR [gender]='Pria'))
GO
ALTER TABLE [dbo].[mahasiswa] CHECK CONSTRAINT [CK__mahasiswa__gende__3A81B327]
GO
ALTER TABLE [dbo].[pengguna]  WITH CHECK ADD CHECK  (([sebagai]='Dosen Pengajar' OR [sebagai]='DPA' OR [sebagai]='Mahasiswa' OR [sebagai]='Administrator'))
GO
USE [master]
GO
ALTER DATABASE [tatib] SET  READ_WRITE 
GO
