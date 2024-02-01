-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2024 at 05:12 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_microservices`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nis` int(11) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `age`, `created_at`, `gender`, `name`, `nis`, `updated_at`) VALUES
(6, 25, '2024-02-01 09:39:49.000000', 'male', 'agung', 1231232, '2024-02-01 09:39:49.000000'),
(7, 25, '2024-02-01 09:39:58.000000', 'male', 'Icang', 1231232, '2024-02-01 09:39:58.000000'),
(8, 25, '2024-02-01 09:40:02.000000', 'male', 'Wahyu', 1231232, '2024-02-01 09:40:02.000000'),
(9, 25, '2024-02-01 09:40:09.000000', 'female', 'Caca', 1231232, '2024-02-01 09:40:09.000000'),
(10, 25, '2024-02-01 10:40:15.000000', 'female', 'Caca', 1231232, '2024-02-01 10:40:15.000000');

-- --------------------------------------------------------

--
-- Table structure for table `usercredential`
--

CREATE TABLE `usercredential` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usercredential`
--

INSERT INTO `usercredential` (`id`, `email`, `name`, `password`, `username`) VALUES
(1, 'eka@gmail.com', 'eka', '$2a$10$XOENANLN1vHeJpVGNRix5.afiWsoTjaJ4BAjrr54doGs5HYvdB1Zy', 'eka'),
(2, 'salbi@gmail.com', 'salbi', '$2a$10$JAMvUlQZMJ88X42ZB.pUo.oxblHVuoU1QxMIS27LxzTHEqEKgDDUu', 'salbi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usercredential`
--
ALTER TABLE `usercredential`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `usercredential`
--
ALTER TABLE `usercredential`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
