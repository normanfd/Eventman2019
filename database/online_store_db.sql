-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2019 at 12:07 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `online_store_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_user_table`
--

CREATE TABLE `app_user_table` (
  `email` varchar(40) NOT NULL,
  `username` varchar(30) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_user_table`
--

INSERT INTO `app_user_table` (`email`, `username`, `pass`) VALUES
('norman@gmail.com', 'Norman', 'akulaku'),
('jancok@gmail.com', 'Norman', 'akulaku'),
('gilang@gmail.com', 'gilang', '1234'),
('a@a.com', 'a', 'a'),
('b@b.com', 'b', 'b');

-- --------------------------------------------------------

--
-- Table structure for table `electronic_products`
--

CREATE TABLE `electronic_products` (
  `id` int(100) NOT NULL,
  `name` varchar(20) NOT NULL,
  `brand` varchar(20) NOT NULL,
  `price` int(100) NOT NULL,
  `picture` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `electronic_products`
--

INSERT INTO `electronic_products` (`id`, `name`, `brand`, `price`, `picture`) VALUES
(1, 'iPad', 'Apple', 1000, 'ipad.png'),
(2, 'iPhone', 'Apple', 100, 'iphone.png'),
(3, 'J8', 'Samsung', 50, 'samsungj8.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `temporary_place_order`
--

CREATE TABLE `temporary_place_order` (
  `email` varchar(40) NOT NULL,
  `product_id` int(20) NOT NULL,
  `amount` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temporary_place_order`
--

INSERT INTO `temporary_place_order` (`email`, `product_id`, `amount`) VALUES
('a@a.com', 5, 7),
('a@a.com', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electronic_products`
--
ALTER TABLE `electronic_products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `electronic_products`
--
ALTER TABLE `electronic_products`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
