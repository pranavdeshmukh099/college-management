-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2023 at 03:32 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `collegemanagementdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(255) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mail_id` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `admin_name`, `password`, `mail_id`, `mobile_no`) VALUES
(1, 'abhinav', 'Abhinav@123', 'abhi@gmail.com', '7845891244');

-- --------------------------------------------------------

--
-- Table structure for table `demo`
--

CREATE TABLE `demo` (
  `Name` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `demo`
--

INSERT INTO `demo` (`Name`) VALUES
('ds');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Enrollment_no` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `admission_date` date NOT NULL,
  `DOB` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `Name`, `Enrollment_no`, `mobile_no`, `email_id`, `address`, `gender`, `admission_date`, `DOB`) VALUES
(1, 'Aman', '19008001', '8956214756', 'aman12@gmail.com', 'Nashik', 'male', '2020-08-03', '2001-02-15'),
(2, 'Amita', '19008002', '4645122578', 'amita1243@gmail.com', 'Akole', 'female', '2020-08-10', '2001-12-09'),
(3, 'Anita', '19008003', '3644122578', 'anita1243@gmail.com', 'Sangamner', 'female', '2020-09-10', '2002-04-09'),
(4, 'Ani', '19008004', '9644126578', 'ani1243@gmail.com', 'Rajur', 'female', '2020-10-10', '2002-08-09'),
(5, 'Ananya', '19008005', '4645125578', 'ananya643@gmail.com', 'Pune', 'female', '2020-09-06', '2001-05-15'),
(6, 'Nikk', '19008006', '4625122534', 'nikk121@gmail.com', 'Pune', 'male', '2020-09-08', '2003-02-09'),
(7, 'Amita', '19008007', '8645622578', 'amita2243@gmail.com', 'Akole', 'female', '2020-08-11', '2000-02-05'),
(8, 'Aniket', '19008008', '6645622574', 'aniket1743@gmail.com', 'Sangamner', 'male', '2020-08-15', '2001-05-20'),
(9, 'Raj', '19008009', '4625123572', 'raj1283@gmail.com', 'Akole', 'male', '2020-09-19', '2001-04-25'),
(10, 'Om', '19008010', '7645512578', 'om1643@gmail.com', 'Nashik', 'male', '2020-10-23', '2001-11-10');

--
-- Triggers `students`
--
DELIMITER $$
CREATE TRIGGER `TriggerOnstudents` AFTER DELETE ON `students` FOR EACH ROW BEGIN
   insert into studentsbackup (`Name`,`Enrollment_no`,`mobile_no`,`email_id`,`address`,`gender`,`admission_date`,`DOB`)  values (old.Name,old.Enrollment_no,old.mobile_no,old.email_id,old.address,old.gender,old.admission_date,old.DOB);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `studentsbackup`
--

CREATE TABLE `studentsbackup` (
  `id` int(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Enrollment_no` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `admission_date` date NOT NULL,
  `DOB` date NOT NULL,
  `Date_Deleted` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentsbackup`
--

INSERT INTO `studentsbackup` (`id`, `Name`, `Enrollment_no`, `mobile_no`, `email_id`, `address`, `gender`, `admission_date`, `DOB`, `Date_Deleted`) VALUES
(1, 'Amar', '19008011', '9642122562', 'amar1743@gmail.com', 'Rajur', 'male', '2020-11-03', '2001-02-04', '2023-11-04');

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `education` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `join_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`id`, `Name`, `mobile_no`, `email_id`, `address`, `education`, `gender`, `join_date`) VALUES
(1, 'W.K.Saskarrr', '8956457812', 'rajesh@gmail.com', 'Sangamner', 'ME', 'male', '2020-07-26'),
(2, 'D.S.Wilyam', '9856451235', 'wilyamsd@gmail.com', 'Pune', 'B.SC', 'male', '2020-09-18'),
(3, 'J.S.Vikhe', '7845126589', 'jsvikhe@gmail.com', 'Sangamner', 'M.Tech', 'male', '2020-09-24'),
(4, 'M.S.Joshi', '5689451378', 'msjoshi@gmail.com', 'Nashik', 'M.Tech', 'male', '2020-08-21'),
(5, 'W.S.Agrawal', '8945235698', 'agrawal@gmail.com', 'Sangamner', 'B.ED', 'female', '2020-09-05'),
(6, 'J.S.Podar', '7856235489', 'podarjs@gmail.com', 'Akole', 'M.SC', 'female', '2020-10-23'),
(7, 'S.D.Dange', '8756458952', 'sddange@gmail.com', 'Pune', 'M.Ed', 'female', '2020-08-13'),
(11, 'df', '23423423', 'ds@gmail.com', 'rfrf', 'sgf', 'male', '2023-11-24');

--
-- Triggers `teachers`
--
DELIMITER $$
CREATE TRIGGER `TriggerOnteachers` AFTER DELETE ON `teachers` FOR EACH ROW BEGIN
   insert into teachersbackup (`Name`,`mobile_no`,`email_id`,`address`,`education`,`gender`,`join_date`)  values (old.Name,old.mobile_no,old.email_id,old.address,old.education,old.gender,old.join_date);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `teachersbackup`
--

CREATE TABLE `teachersbackup` (
  `id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `education` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `join_date` date NOT NULL,
  `Deleted_date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teachersbackup`
--

INSERT INTO `teachersbackup` (`id`, `Name`, `mobile_no`, `email_id`, `address`, `education`, `gender`, `join_date`, `Deleted_date`) VALUES
(1, 'dfdfgfd', '2323542', 'ds@gmail.com', 'sdfsdf', 'sdfsd', 'male', '2023-11-23', '2023-11-04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `studentsbackup`
--
ALTER TABLE `studentsbackup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teachersbackup`
--
ALTER TABLE `teachersbackup`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `studentsbackup`
--
ALTER TABLE `studentsbackup`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `teachersbackup`
--
ALTER TABLE `teachersbackup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
