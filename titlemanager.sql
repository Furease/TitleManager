-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2022 at 03:47 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `titlemanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', '5f4dcc3b5aa765d61d8327deb882cf99', 'admin'),
(6, '999', '81dc9bdb52d04dc20036dbd8313ed055', 'user'),
(7, '222333444', '5f4dcc3b5aa765d61d8327deb882cf99', 'user'),
(8, '12341234', '81dc9bdb52d04dc20036dbd8313ed055', 'user'),
(9, '111', '81dc9bdb52d04dc20036dbd8313ed055', 'user'),
(12, '222011622', '708661930aa9980c3e4b839912a77570', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `judul` text NOT NULL,
  `abstrak` text NOT NULL,
  `nim` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `judul`, `abstrak`, `nim`) VALUES
(1, 'Pengelola Hasil Nilai Ujian', 'Sebuah aplikasi untuk mengelola hasil nilai ujian', '222333444'),
(2, 'Aplikasi Pengelola Perpustakaan', 'Sebuah aplikasi yang membantu mengelola perpustakaan', '999'),
(3, 'Sistem Pengelola Jadwal Mata Kuliah', 'Membantu mengelola jadwal mata kuliah ', '222333444'),
(4, 'Pendaftaran UKM di STIS', 'Sebuah sistem untuk melakukan pendaftaran UKM', '222333444'),
(5, 'Aplikasi Penyimpan Catatan Mahasiswa', 'Membantu mahasiswa dalam mengelola catatannya', '222333444'),
(6, 'Chat bot tentang STIS', 'Sebuah bot yang memberikan berbagai informasi tentang STIS', '999'),
(7, 'Sistem pengumpulan tugas terpadu', 'Sebuah aplikasi untuk mengumpulkan tugas secara terpadu', '12341234'),
(8, 'Manajemen data pengguna lapangan', 'Memanajemen data pengguna lapangan mulai dari awal sampai akhir', '111'),
(9, 'Pendataan UKM Taekwondo', 'Aplikasi untuk menginput data anggota UKM Taekwondo', '999'),
(10, 'Penamaan File Random', 'Memberikan nama file secara random', '222333444'),
(15, 'Sistem Informasi Kantin', 'Sebuah sistem yang memberikan berbagai informasi tentang kantin, mulai dari menu yang dijual sampai siapa saja penjualnya\n', '222333444'),
(19, 'Sistem pengelola judul project', '', '222011622');

-- --------------------------------------------------------

--
-- Table structure for table `user_profiles`
--

CREATE TABLE `user_profiles` (
  `nim` varchar(64) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `nomor` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_profiles`
--

INSERT INTO `user_profiles` (`nim`, `nama`, `email`, `nomor`) VALUES
('111', 'riko', 'riko@gmail.com', '0898787676'),
('12341234', 'salmon', 'salmon@gmail.com', '222089123'),
('222011622', 'Moch. Daffa\' Al Faris', '222011622@stis.ac.id', '0895367350752'),
('222333444', 'Rico Maldini', 'maldini@email.com', '087567543234'),
('999', 'saya', 'sayahiyama@gmail.com', '0897654342');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_profiles`
--
ALTER TABLE `user_profiles`
  ADD PRIMARY KEY (`nim`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
