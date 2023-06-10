-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 09, 2023 at 07:09 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SCMS`
--
CREATE DATABASE IF NOT EXISTS `SCMS` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `SCMS`;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(25) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `category_name`, `deleted`) VALUES
(1, 'Phones', 0),
(2, 'Laptop and Wearables', 0),
(3, 'Accessories', 0),
(4, 'Tablets and Audio Devices', 0);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `location` varchar(100) DEFAULT NULL,
  `date_added` date DEFAULT current_timestamp(),
  `expiry_date` date DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inventory_id`, `product_id`, `quantity`, `location`, `date_added`, `expiry_date`, `owner_id`, `info`) VALUES
(1, 1, 100, 'UNITED KINGDOM', '2023-06-07', '2021-01-01', 1, 'This is the all new iPhone 12 Pro Max with many new interesting features, Buy now and save yourself a discount of 20%.'),
(2, 2, 100, 'UNITED KINGDOM', '2023-06-07', '2021-02-02', 1, 'MacBook, the best laptop any one could ever ask for with high efficiency and horse power no other laptop has ever equipped, Buy now and get a start up.'),
(3, 3, 100, 'UNITED KINGDOM', '2023-06-07', '2021-03-03', 1, 'A Magic Keyboard Folio for your iPad, make your life even more easier with typing and getting what you desire with clicks of a keyboard, or shall I say magical keyboard.'),
(4, 4, 100, 'UNITED KINGDOM', '2023-06-07', '2021-04-04', 1, 'Have at it with your Home Pod, quality audio, clear voice, voice cancellation, upgraded sound frequencies, and more.'),
(5, 5, 100, 'AMERICA', '2023-06-07', '2021-05-05', 2, 'The ultimate creation, Google Pixels to get to the top, with their high quality camera clearness, small amount size occupied and more.'),
(6, 6, 100, 'AMERICA', '2023-06-07', '2021-06-06', 2, 'Your are running, maybe you are relaxing or waiting for planned alarm or just for fun, try our smart watches to add calendar and play as you like with the connection from your phone.'),
(7, 7, 100, 'AMERICA', '2023-06-07', '2021-07-07', 2, 'In the world filled with your dreams and imagination but unable to come to life, Buy VR to not let them know we can still.'),
(8, 8, 100, 'AMERICA', '2023-06-07', '2021-08-08', 2, 'The newly improved android 13 tablet that lets you control all activities with one making you connect everywhere digitally and accessing all your accessories in one device, YOUR TABLET. '),
(9, 11, 2000, '3', '2023-06-08', '2024-02-02', 4, '');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `order_quantity` int(11) DEFAULT NULL,
  `order_status` varchar(25) DEFAULT NULL,
  `order_date` date DEFAULT current_timestamp(),
  `note` varchar(255) DEFAULT NULL,
  `shipment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `user_id`, `company_id`, `product_id`, `order_quantity`, `order_status`, `order_date`, `note`, `shipment_id`) VALUES
(1, 2, 1, 1, 10, 'Shipped', '2023-06-07', 'Provide It Very Soon Please', 1),
(2, 2, 1, 2, 20, 'Accepted', '2023-06-07', 'Provide It Very Soon Please', NULL),
(3, 2, 1, 3, 30, 'Declined', '2023-06-07', 'Provide It Very Soon Please', NULL),
(4, 2, 1, 4, 40, 'Waiting', '2023-06-07', 'Provide It Very Soon Please', NULL),
(5, 2, 2, 5, 50, 'Shipped', '2023-06-07', 'Provide It Very Soon Please', 1),
(6, 2, 2, 6, 60, 'Accepted', '2023-06-07', 'Provide It Very Soon Please', NULL),
(7, 2, 2, 7, 70, 'Waiting', '2023-06-07', 'Provide It Very Soon Please', NULL),
(8, 2, 2, 8, 80, 'Declined', '2023-06-07', 'Provide It Very Soon Please', NULL),
(9, 1, 4, 1, 70, 'Accepted', '2023-06-08', 'Please deliver the product on time.', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `name`, `code`, `price`, `unit`, `category_id`, `description`, `image`, `supplier_id`, `deleted`) VALUES
(1, 'Apple iPhone Pro Max 12', 'I12', 1000.00, '$', 1, 'This is the all new iPhone 12 Pro Max with many new interesting features, Buy now and save yourself a discount of 20%.', 'lib/product.png', 1, 1),
(2, 'Apple MacBook Pro ', 'MPO', 2000.00, '$', 2, 'MacBook, the best laptop any one could ever ask for with high efficiency and horse power no other laptop has ever equipped, Buy now and get a start up.', 'lib/product.png', 1, 0),
(3, 'A Magic Keyboard Folio', 'P3', 250.00, '$', 3, 'A Magic Keyboard Folio for your iPad, make your life even more easier with typing and getting what you desire with clicks of a keyboard, or shall I say magical keyboard.', 'lib/product.png', 1, 0),
(4, 'HomePod - Midnight', 'HPM', 300.00, '$', 4, 'Have at it with your Home Pod, quality audio, clear voice, voice cancellation, upgraded sound frequencies, and more.', 'lib/product.png', 1, 0),
(5, 'Google Pixels', 'GP', 1100.00, '$', 1, 'The ultimate creation, Google Pixels to get to the top, with their high quality camera clearness, small amount size occupied and more.', 'lib/product.png', 2, 0),
(6, 'Google Smart Watch', 'SW', 750.00, '$', 2, 'Your are running, maybe you are relaxing or waiting for planned alarm or just for fun, try our smart watches to add calendar and play as you like with the connection from your phone.', 'lib/product.png', 2, 0),
(7, 'Google Virtual Reality Models', 'VR', 1000.00, '$', 3, 'In the world filled with your dreams and imagination but unable to come to life, Buy VR to not let them know we can still.', 'lib/product.png', 2, 0),
(8, 'Google Android 13 Tablet', '13T', 1200.00, '$', 4, 'The newly improved android 13 tablet that lets you control all activities with one making you connect everywhere digitally and accessing all your accessories in one device, YOUR TABLET. ', 'lib/product.png', 2, 0),
(9, 'sdsd', 'code81', 200.00, 'kg', 1, '', 'lib/product.png', 1, 1),
(10, 'Laptop', 'code74', 20000.00, 'pc', 2, '', 'lib/product.png', 3, 0),
(11, 'screen', 'code97', 2000.00, 'pc', 3, '', 'lib/product.png', 4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `shipments`
--

CREATE TABLE `shipments` (
  `shipment_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `shipment_date` date DEFAULT current_timestamp(),
  `shipment_status` varchar(25) DEFAULT NULL,
  `starting_point` varchar(25) DEFAULT NULL,
  `destination` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `shipments`
--

INSERT INTO `shipments` (`shipment_id`, `order_id`, `shipment_date`, `shipment_status`, `starting_point`, `destination`) VALUES
(1, NULL, '2023-06-08', 'In Transit', 'warehouse1', 'warehouse4'),
(2, NULL, '2023-06-08', 'In Transit', 'warehouse1', 'warehouse4');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(25) DEFAULT NULL,
  `supplier_address` varchar(25) DEFAULT NULL,
  `supplier_phone` varchar(25) DEFAULT NULL,
  `supplier_email` varchar(25) DEFAULT NULL,
  `manager_name` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_phone`, `supplier_email`, `manager_name`) VALUES
(1, 'Apple Inc.', 'AMERICA', ' (800) 692–7753.', 'domain@apple.com', 'Apple'),
(2, 'Google', 'UNITED KINGDOM', '(020) 444-555', 'domain@google.com', 'Google'),
(3, 'Meta corp', 'meta', 'meta', 'meta@fb.com', 'meta'),
(4, 'new', 'new', '4455555555', 'new@gmail.com', 'newuser');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `fname` varchar(25) DEFAULT NULL,
  `lname` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `address` varchar(25) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `image_data` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `fname`, `lname`, `email`, `phone`, `address`, `role`, `company_id`, `image_data`) VALUES
(1, 'admin', 'admin', 'Bisrat', '', 'kiyyakebere@gmail.com', 'admin', 'admin', 'Administrator', 1, NULL),
(2, 'Biruk_M', '12345', 'Biruk', 'Mesfin', 'birukmesfin@apple.com', '(800) 643-7542', 'AMERICA', 'Manager', 1, NULL),
(3, 'Bisry', '12345', 'Bisrat', 'Kebere', 'bisry@apple.com', '(020) 443-542', 'UNITED KINGDOM', 'Manager', 2, NULL),
(4, 'meta', 'meta', NULL, NULL, 'meta@gmail.com', NULL, NULL, 'Manager', 3, NULL),
(5, 'newuser', '1234', NULL, NULL, 'user@gmail.com', NULL, NULL, 'Manager', 4, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`),
  ADD UNIQUE KEY `category_name` (`category_name`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventory_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `owner_id` (`owner_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `company_id` (`company_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `shipment_id` (`shipment_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `shipments`
--
ALTER TABLE `shipments`
  ADD PRIMARY KEY (`shipment_id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `company_id` (`company_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inventory_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `shipments`
--
ALTER TABLE `shipments`
  MODIFY `shipment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`owner_id`) REFERENCES `suppliers` (`supplier_id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `suppliers` (`supplier_id`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`shipment_id`) REFERENCES `shipments` (`shipment_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `suppliers` (`supplier_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;