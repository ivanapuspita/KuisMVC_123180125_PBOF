-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2020 at 02:57 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_film`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_film`
--

CREATE TABLE `tabel_film` (
  `id` int(11) NOT NULL,
  `judul` varchar(40) NOT NULL,
  `tipe` varchar(40) NOT NULL,
  `episode` varchar(40) NOT NULL,
  `genre` varchar(40) NOT NULL,
  `status` varchar(40) NOT NULL,
  `rating` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_film`
--

INSERT INTO `tabel_film` (`id`, `judul`, `tipe`, `episode`, `genre`, `status`, `rating`) VALUES
(1, 'Rindu', 'film', '16', 'komedi', 'Belum Selesai', '4'),
(4, 'Hujan', 'tv', '2', 'komedi', 'Selesai', '3'),
(6, 'Pelangi', 'tv', '10', 'horor', 'Selesai', '4'),
(7, 'Awan', 'film', '3', 'horor', 'Selesai', '3'),
(8, 'Tanah', 'tv', '4', 'komedi', 'Belum Selesai', '5'),
(9, 'Bintang', 'film', '1', 'romance', 'Selesai', '4'),
(10, 'Bulan', 'film', '2', 'komedi', 'Belum Selesai', '4'),
(11, 'Matahari', 'tv', '5', 'romance', 'Belum Selesai', '5'),
(12, 'Daun', 'tv', '10', 'horor', 'Belum Selesai', '3'),
(14, 'Daun hijau', 'tv', '12', 'komedi', 'Belum Selesai', '5'),
(16, 'Sepatu', 'film', '5', 'komedi', 'Selesai', '5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_film`
--
ALTER TABLE `tabel_film`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tabel_film`
--
ALTER TABLE `tabel_film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
