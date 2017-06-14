-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2017 at 03:53 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banksystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `business`
--

CREATE TABLE `business` (
  `id` int(11) NOT NULL,
  `Companyname` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `phone` int(11) NOT NULL,
  `Account` int(11) NOT NULL,
  `Group_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `business`
--

INSERT INTO `business` (`id`, `Companyname`, `Username`, `Password`, `Email`, `phone`, `Account`, `Group_ID`) VALUES
(1, 'kssmabank', 'mori007', '007', 'mostafamorsy466@gmail.com', 1127813659, 1336225, 1),
(2, 'MSA', 'msa007', '007', 'msa@edu.com', 966532, 100000000, NULL),
(3, 'bankmasr', 'bank007', '007', 'bank@b.com', 16665599, 1000000, NULL),
(4, '', 'ksmaa', '0000', 'mostafamorsy466@gmail.com', 1127813659, 0, NULL),
(7, '', 'kmsaa', '000', 'mostafamorsy466@gmail.com', 1127813659, 0, NULL),
(10, '', 'omo', '321', 'mostafamorsy466@gmail.com', 1127813659, 10000000, NULL),
(12, 'bank', 'msa00', '0000', 'mostafamorsy466@gmail.com', 1127813659, 9000000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `business_accounts`
--

CREATE TABLE `business_accounts` (
  `id` int(11) NOT NULL,
  `b_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `business_accounts`
--

INSERT INTO `business_accounts` (`id`, `b_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `deposit_baccounts`
--

CREATE TABLE `deposit_baccounts` (
  `id` int(11) NOT NULL,
  `b_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deposit_baccounts`
--

INSERT INTO `deposit_baccounts` (`id`, `b_id`) VALUES
(1, 1),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `deposit_paccounts`
--

CREATE TABLE `deposit_paccounts` (
  `id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `Fullname` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Nationalid` int(11) NOT NULL,
  `phone` int(11) NOT NULL,
  `Account` int(11) NOT NULL,
  `Group_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `Fullname`, `Username`, `Password`, `Email`, `Nationalid`, `phone`, `Account`, `Group_ID`) VALUES
(1, 'mostafa', 'mroa007', '007', 'mo@mo.com', 6666363, 1127813659, 100000, 1),
(6, '$fullname', '$username', '$password', '$email', 0, 0, 0, 1),
(8, 'Mostafa Morsy', 'asd', '123', 'mostafamorsy466@gmail.com', 1231, 1127813659, 124124, NULL),
(10, 'Mostafa Morsy Hassan', 'mora0', '000', 'mostafamorsy466@gmail.com', 66693, 1127813659, 966332, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `person_accounts`
--

CREATE TABLE `person_accounts` (
  `id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `withdraw_baccounts`
--

CREATE TABLE `withdraw_baccounts` (
  `id` int(11) NOT NULL,
  `b_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `withdraw_baccounts`
--

INSERT INTO `withdraw_baccounts` (`id`, `b_id`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `withdraw_paccounts`
--

CREATE TABLE `withdraw_paccounts` (
  `id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `business`
--
ALTER TABLE `business`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Username` (`Username`,`Password`);

--
-- Indexes for table `business_accounts`
--
ALTER TABLE `business_accounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `accounting` (`b_id`);

--
-- Indexes for table `deposit_baccounts`
--
ALTER TABLE `deposit_baccounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `depositings` (`b_id`);

--
-- Indexes for table `deposit_paccounts`
--
ALTER TABLE `deposit_paccounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `depositing` (`p_id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Username` (`Username`,`Nationalid`);

--
-- Indexes for table `person_accounts`
--
ALTER TABLE `person_accounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `accounts` (`p_id`);

--
-- Indexes for table `withdraw_baccounts`
--
ALTER TABLE `withdraw_baccounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `depositine` (`b_id`);

--
-- Indexes for table `withdraw_paccounts`
--
ALTER TABLE `withdraw_paccounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `depositin` (`p_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `business`
--
ALTER TABLE `business`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `business_accounts`
--
ALTER TABLE `business_accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `deposit_baccounts`
--
ALTER TABLE `deposit_baccounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `deposit_paccounts`
--
ALTER TABLE `deposit_paccounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `person_accounts`
--
ALTER TABLE `person_accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `withdraw_baccounts`
--
ALTER TABLE `withdraw_baccounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `withdraw_paccounts`
--
ALTER TABLE `withdraw_paccounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `business_accounts`
--
ALTER TABLE `business_accounts`
  ADD CONSTRAINT `accounting` FOREIGN KEY (`b_id`) REFERENCES `business` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `deposit_baccounts`
--
ALTER TABLE `deposit_baccounts`
  ADD CONSTRAINT `depositings` FOREIGN KEY (`b_id`) REFERENCES `business_accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `deposit_paccounts`
--
ALTER TABLE `deposit_paccounts`
  ADD CONSTRAINT `depositing` FOREIGN KEY (`p_id`) REFERENCES `person_accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `person_accounts`
--
ALTER TABLE `person_accounts`
  ADD CONSTRAINT `accounts` FOREIGN KEY (`p_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `withdraw_baccounts`
--
ALTER TABLE `withdraw_baccounts`
  ADD CONSTRAINT `depositine` FOREIGN KEY (`b_id`) REFERENCES `business_accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `withdraw_paccounts`
--
ALTER TABLE `withdraw_paccounts`
  ADD CONSTRAINT `depositin` FOREIGN KEY (`p_id`) REFERENCES `person_accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
