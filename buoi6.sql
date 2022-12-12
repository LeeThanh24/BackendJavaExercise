-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: QLBanSach
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CHUDE`
--

DROP TABLE IF EXISTS `CHUDE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CHUDE` (
  `MaChuDe` varchar(255) NOT NULL,
  `TenChuDe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaChuDe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHUDE`
--

LOCK TABLES `CHUDE` WRITE;
/*!40000 ALTER TABLE `CHUDE` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHUDE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DONHANG`
--

DROP TABLE IF EXISTS `DONHANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DONHANG` (
  `MaDonHang` varchar(255) NOT NULL,
  `DaThanhToan` varchar(255) DEFAULT NULL,
  `NgayGiao` varchar(255) DEFAULT NULL,
  `NgAyDat` varchar(255) DEFAULT NULL,
  `TinhTrangGH` varchar(255) DEFAULT NULL,
  `MaKH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaDonHang`),
  KEY `MaKH` (`MaKH`),
  CONSTRAINT `DONHANG_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `KHACHHANG` (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DONHANG`
--

LOCK TABLES `DONHANG` WRITE;
/*!40000 ALTER TABLE `DONHANG` DISABLE KEYS */;
/*!40000 ALTER TABLE `DONHANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DONHANG_SACH`
--

DROP TABLE IF EXISTS `DONHANG_SACH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DONHANG_SACH` (
  `MaDonHang` varchar(255) NOT NULL,
  `MaSach` varchar(255) NOT NULL,
  `DONGIA` decimal(10,2) DEFAULT NULL,
  `SOLUONG` int DEFAULT NULL,
  PRIMARY KEY (`MaDonHang`,`MaSach`),
  KEY `MaSach` (`MaSach`),
  CONSTRAINT `DONHANG_SACH_ibfk_1` FOREIGN KEY (`MaDonHang`) REFERENCES `DONHANG` (`MaDonHang`),
  CONSTRAINT `DONHANG_SACH_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `SACH` (`MaSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DONHANG_SACH`
--

LOCK TABLES `DONHANG_SACH` WRITE;
/*!40000 ALTER TABLE `DONHANG_SACH` DISABLE KEYS */;
/*!40000 ALTER TABLE `DONHANG_SACH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KHACHHANG`
--

DROP TABLE IF EXISTS `KHACHHANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KHACHHANG` (
  `MaKH` varchar(255) NOT NULL,
  `TaiKhoan` varchar(255) DEFAULT NULL,
  `MatKhau` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `DienThoai` varchar(255) DEFAULT NULL,
  `GioiTinh` varchar(255) DEFAULT NULL,
  `NgaySinh` varchar(255) DEFAULT NULL,
  `HoTen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KHACHHANG`
--

LOCK TABLES `KHACHHANG` WRITE;
/*!40000 ALTER TABLE `KHACHHANG` DISABLE KEYS */;
/*!40000 ALTER TABLE `KHACHHANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NHAXUATBAN`
--

DROP TABLE IF EXISTS `NHAXUATBAN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NHAXUATBAN` (
  `MaNSX` varchar(255) NOT NULL,
  `TenNSB` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `DienThoai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaNSX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NHAXUATBAN`
--

LOCK TABLES `NHAXUATBAN` WRITE;
/*!40000 ALTER TABLE `NHAXUATBAN` DISABLE KEYS */;
/*!40000 ALTER TABLE `NHAXUATBAN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SACH`
--

DROP TABLE IF EXISTS `SACH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SACH` (
  `MaSach` varchar(255) NOT NULL,
  `TenSach` varchar(255) DEFAULT NULL,
  `NgayCapNhat` varchar(255) DEFAULT NULL,
  `AnhBia` varchar(255) DEFAULT NULL,
  `MoTa` varchar(255) DEFAULT NULL,
  `GiaBan` decimal(10,2) DEFAULT NULL,
  `SoLuongTon` int DEFAULT NULL,
  `MaChuDe` varchar(255) DEFAULT NULL,
  `MaNSX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaSach`),
  KEY `MaChuDe` (`MaChuDe`),
  KEY `MaNSX` (`MaNSX`),
  CONSTRAINT `SACH_ibfk_1` FOREIGN KEY (`MaChuDe`) REFERENCES `CHUDE` (`MaChuDe`),
  CONSTRAINT `SACH_ibfk_2` FOREIGN KEY (`MaNSX`) REFERENCES `NHAXUATBAN` (`MaNSX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SACH`
--

LOCK TABLES `SACH` WRITE;
/*!40000 ALTER TABLE `SACH` DISABLE KEYS */;
/*!40000 ALTER TABLE `SACH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TACGIA`
--

DROP TABLE IF EXISTS `TACGIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TACGIA` (
  `MaTacGia` varchar(255) NOT NULL,
  `TenTacGia` varchar(255) DEFAULT NULL,
  `DienThoai` varchar(255) DEFAULT NULL,
  `TieuSu` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaTacGia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TACGIA`
--

LOCK TABLES `TACGIA` WRITE;
/*!40000 ALTER TABLE `TACGIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `TACGIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `THAMGIA`
--

DROP TABLE IF EXISTS `THAMGIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `THAMGIA` (
  `MaTacGia` varchar(255) NOT NULL,
  `MaSach` varchar(255) NOT NULL,
  `VaiTro` varchar(255) DEFAULT NULL,
  `ViTri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaTacGia`,`MaSach`),
  KEY `MaSach` (`MaSach`),
  CONSTRAINT `THAMGIA_ibfk_1` FOREIGN KEY (`MaTacGia`) REFERENCES `TACGIA` (`MaTacGia`),
  CONSTRAINT `THAMGIA_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `SACH` (`MaSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `THAMGIA`
--

LOCK TABLES `THAMGIA` WRITE;
/*!40000 ALTER TABLE `THAMGIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `THAMGIA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-12 10:41:56
