-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2019 at 05:10 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `railway_`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_company` (IN `name` VARCHAR(30) CHARSET utf8, IN `id` INT UNSIGNED)  NO SQL
INSERT INTO railway_.company (company.company_id,company.co_name) VALUES (id,name)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_customer` (IN `name` VARCHAR(30) CHARSET utf8, IN `lname` VARCHAR(30) CHARSET utf8, IN `id` INT, IN `phone` VARCHAR(30) CHARSET utf8)  NO SQL
INSERT INTO customer(customer.customer_id,customer.customer_name,customer.customer_lname,customer.phone) VALUES (id,name,lname,phone)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_destination` (IN `id` INT, IN `name` VARCHAR(30) CHARSET utf8, IN `price` INT)  NO SQL
insert into destination(destination.destination_id,destination.destination_name,destination.destination_price) VALUES (id,name,price)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_driver` (IN `name` VARCHAR(30) CHARSET utf8, IN `lname` VARCHAR(30) CHARSET utf8, IN `phone` VARCHAR(30), IN `id` INT, IN `co` INT)  NO SQL
INSERT into locomotive_driver(locomotive_driver.locomotive_driver_name,locomotive_driver.locomotive_driver_lname,locomotive_driver.locomotive_driver_phone,locomotive_driver.locomotive_driver_id,locomotive_driver.locomotive_driver_co) values (name,lname,phone,id,co)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_ticket` (IN `cus_id` INT, IN `tr_id` INT, IN `ch_id` INT, IN `wa_id` INT, IN `date1` DATETIME)  NO SQL
INSERT INTO ticket (ticket.customer_id,ticket.travel_id,ticket.chair_id,ticket.wagon_id,ticket.status,ticket.date) VALUES (cus_id,tr_id,ch_id,wa_id,1,date1)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_train` (IN `id` INT, IN `name` VARCHAR(30) CHARSET utf8, IN `co_id` INT, IN `class_id` INT, IN `wagons` INT)  NO SQL
INSERT INTO train(train.train_name,train.train_id,train.co_id,train.wagons,train.class_id)VALUES(name,id,co_id,wagons,class_id)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_travel` (IN `train_id` INT, IN `loco_id` INT, IN `date1` DATETIME, IN `des` INT)  NO SQL
INSERT INTO travel (travel.train_id,travel.locomotive_driver_id,travel.date,travel.destination_id) VALUES (train_id,loco_id,date1,des)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `add_travel_group` (IN `train_id` INT, IN `driver_id` INT, IN `date` DATETIME)  NO SQL
INSERT INTO travel_group(travel_group.train_id,travel_group.locomotive_driver_id,travel_group.date) VALUES (train_id,driver_id,date)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Cancel_ticket` (IN `id` INT)  NO SQL
UPDATE ticket SET ticket.status=0 WHERE ticket.ticket_serial=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `check_if_cancel` (IN `date` DATETIME)  NO SQL
SELECT ticket.customer_id,travel.travel_id,ticket.date,ticket.ticket_serial,ticket.chair_id,ticket.wagon_id,ticket.status,travel.destination_id FROM ticket INNER JOIN travel ON travel.travel_id=ticket.travel_id  WHERE travel.date=date AND ticket.status=0 LIMIT 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_company` (IN `name` VARCHAR(30) CHARSET utf8, IN `id` INT)  NO SQL
UPDATE company SET company.co_name=name WHERE company.company_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_customer` (IN `name` VARCHAR(30), IN `lname` VARCHAR(30), IN `phone` VARCHAR(30), IN `id` INT)  NO SQL
UPDATE railway_.customer SET customer.customer_name=name,customer.customer_lname=lname,customer.phone=phone WHERE customer.customer_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_destination` (IN `price` INT, IN `id` INT)  NO SQL
UPDATE destination set destination.destination_price=price WHERE destination.destination_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_driver` (IN `id` INT, IN `name` VARCHAR(30) CHARSET utf8, IN `lname` VARCHAR(30) CHARSET utf8, IN `phone` VARCHAR(30) CHARSET utf8, IN `co` INT)  NO SQL
UPDATE locomotive_driver SET locomotive_driver.locomotive_driver_name=name,locomotive_driver.locomotive_driver_lname=lname,locomotive_driver.locomotive_driver_phone=phone,locomotive_driver.locomotive_driver_co=co WHERE locomotive_driver.locomotive_driver_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_ticket` (IN `tr_id` INT, IN `cus_id` INT, IN `ch_id` INT, IN `wa_id` INT, IN `sa` INT)  NO SQL
UPDATE ticket SET ticket.customer_id=cus_id,ticket.chair_id=ch_id,ticket.wagon_id=wa_id,ticket.status=sa WHERE ticket.travel_id=tr_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_train` (IN `id` INT, IN `name` VARCHAR(30) CHARSET utf8, IN `wagon` INT, IN `class` INT, IN `co` INT)  NO SQL
UPDATE train set train.train_name=name,train.co_id=co,train.wagons=wagon,train.class_id=class WHERE train.train_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_travel` (IN `date` DATETIME, IN `loco_id` INT, IN `tr_id` INT, IN `des_id` INT)  NO SQL
UPDATE travel SET travel.train_id=tr_id,travel.locomotive_driver_id=loco_id,travel.destination_id=des_id WHERE travel.date=date$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_travel_group` (IN `train_id` INT, IN `lc_id` INT, IN `date` DATETIME)  NO SQL
UPDATE travel_group SET travel_group.train_id=train_id,travel_group.locomotive_driver_id=lc_id WHERE travel_group.date=date$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_date` ()  NO SQL
SELECT date from travel_group$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `list_ticket` ()  NO SQL
SELECT customer.customer_id,customer.customer_name,customer.customer_lname,ticket.chair_id,ticket.wagon_id,ticket.ticket_serial,travel.date,destination.destination_id,destination.destination_name,train.train_id,train.train_name,travel.travel_id
FROM
ticket
INNER JOIN 
customer 
ON customer.customer_id=ticket.customer_id

INNER JOIN
travel 
ON ticket.travel_id=travel.travel_id 

INNER JOIN 
train ON travel.train_id=train.train_id


INNER JOIN 
destination 
ON destination.destination_id=travel.destination_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `list_travel` ()  NO SQL
SELECT travel.date, train.train_name,train.train_id,locomotive_driver.locomotive_driver_name,locomotive_driver.locomotive_driver_lname,locomotive_driver.locomotive_driver_id,destination.destination_id,destination.destination_name,travel.travel_id,company.co_name 
FROM travel INNER JOIN train ON travel.train_id=train.train_id INNER JOIN company ON company.company_id=train.co_id INNER JOIN locomotive_driver ON locomotive_driver.locomotive_driver_id = travel.locomotive_driver_id INNER JOIN destination on destination.destination_id=travel.destination_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `list_travel_group` ()  NO SQL
SELECT train.train_name,train.train_id,locomotive_driver.locomotive_driver_name,locomotive_driver.locomotive_driver_lname,locomotive_driver.locomotive_driver_id, travel_group.date FROM travel_group INNER JOIN train ON travel_group.train_id = train.train_id INNER JOIN locomotive_driver ON locomotive_driver.locomotive_driver_id=travel_group.locomotive_driver_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `reserve_ticket` (IN `id` INT)  NO SQL
UPDATE ticket SET ticket.status=1 WHERE ticket.ticket_serial=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_class` (IN `id` INT)  NO SQL
SELECT * FROM class WHERE class.class_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_company` (IN `id` INT)  NO SQL
SELECT * FROM company WHERE company.company_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_customer` (IN `id` INT)  NO SQL
SELECT * from customer where customer.customer_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_destination_by_id` (IN `id` INT)  NO SQL
SELECT * FROM destination WHERE destination.destination_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_des_by_name` (IN `name` VARCHAR(30) CHARSET utf8)  NO SQL
SELECT * FROM destination WHERE destination.destination_name=name$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_driver` (IN `id` INT)  NO SQL
SELECT * FROM locomotive_driver WHERE locomotive_driver.locomotive_driver_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_num_ticket` (IN `date` DATETIME)  NO SQL
SELECT ticket.customer_id,travel.travel_id,travel.train_id,ticket.date,ticket.ticket_serial,ticket.chair_id,ticket.wagon_id,ticket.status,travel.destination_id FROM ticket INNER JOIN travel ON travel.travel_id=ticket.travel_id WHERE travel.date=date and ticket.status=1 ORDER BY
ticket.wagon_id DESC,
ticket.chair_id DESC LIMIT 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_ticket` (IN `id` INT)  NO SQL
SELECT customer.customer_id,customer.customer_name,customer.customer_lname,ticket.chair_id,ticket.wagon_id,ticket.ticket_serial,travel.date,destination.destination_id,destination.destination_name,train.train_id,train.train_name,travel.travel_id
FROM
ticket
INNER JOIN 
customer 
ON customer.customer_id=ticket.customer_id

INNER JOIN
travel 
ON ticket.travel_id=travel.travel_id 

INNER JOIN 
train ON travel.train_id=train.train_id


INNER JOIN 
destination 
ON destination.destination_id=travel.destination_id
WHERE ticket.customer_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_train` (IN `id` INT)  NO SQL
SELECT * FROM train INNER JOIN class ON class.class_id=train.class_id WHERE train.train_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_travel` (IN `date` DATETIME, IN `des` INT)  NO SQL
SELECT train.train_name,train.train_id,locomotive_driver.locomotive_driver_name,locomotive_driver.locomotive_driver_lname,locomotive_driver.locomotive_driver_id,destination.destination_id,destination.destination_name,travel.travel_id FROM travel INNER JOIN train ON travel.train_id=train.train_id INNER JOIN locomotive_driver ON locomotive_driver.locomotive_driver_id = travel.locomotive_driver_id INNER JOIN destination on destination.destination_id=travel.destination_id WHERE travel.date=date AND travel.destination_id=des$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `search_travel_group` (IN `date1` DATE)  NO SQL
SELECT train.train_name,train.train_id,locomotive_driver.locomotive_driver_name,locomotive_driver.locomotive_driver_lname,locomotive_driver.locomotive_driver_id, travel_group.date 
FROM
travel_group 
INNER JOIN
train 
ON travel_group.train_id = train.train_id 
INNER JOIN
locomotive_driver 
ON locomotive_driver.locomotive_driver_id=travel_group.locomotive_driver_id 
WHERE 
DATE(travel_group.date)=date1$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(20) NOT NULL,
  `chairs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `class_name`, `chairs`) VALUES
(1, 'First_Class', 4),
(2, 'Second_Class', 6);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `company_id` int(11) NOT NULL,
  `co_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`company_id`, `co_name`) VALUES
(200, 'عسل'),
(201, 'الیاس'),
(202, 'مسلمی'),
(203, 'عماد');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(30) NOT NULL,
  `customer_lname` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_name`, `customer_lname`, `phone`) VALUES
(12, 'ممد', 'نراذی', '0917'),
(13, 'محسن', 'اصلی', '258'),
(33809, 'مجید', 'سلطانی', '09175389565'),
(338093, 'الیاس', 'متقی', '09172094535'),
(338965798, 'امیر مسعود', 'ظهوری', '0917');

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

CREATE TABLE `destination` (
  `destination_id` int(11) NOT NULL,
  `destination_name` varchar(30) NOT NULL,
  `destination_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `destination`
--

INSERT INTO `destination` (`destination_id`, `destination_name`, `destination_price`) VALUES
(66, 'مشهد', 990000),
(67, 'چابهار', 966000),
(68, 'bnd', 350000),
(69, 'ابادان', 450000);

-- --------------------------------------------------------

--
-- Table structure for table `locomotive_driver`
--

CREATE TABLE `locomotive_driver` (
  `locomotive_driver_name` varchar(30) NOT NULL,
  `locomotive_driver_lname` varchar(30) NOT NULL,
  `locomotive_driver_phone` varchar(30) NOT NULL,
  `locomotive_driver_id` int(11) NOT NULL,
  `locomotive_driver_co` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `locomotive_driver`
--

INSERT INTO `locomotive_driver` (`locomotive_driver_name`, `locomotive_driver_lname`, `locomotive_driver_phone`, `locomotive_driver_id`, `locomotive_driver_co`) VALUES
('محمد', 'داوری', '+98', 469, 200),
('غلامرضا', 'یونس', '0917', 537, 201),
('سعید', 'مرادی', '093745682', 3857, 201),
('حسین', 'زمانی', '09178', 9852, 200),
('علی', 'رضایی زاده', '0936', 338754, 200),
('محمدامین', 'رضایی زاده', '09027610444', 2147483647, 200);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `customer_id` int(11) NOT NULL,
  `travel_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `ticket_serial` int(11) NOT NULL,
  `chair_id` int(11) NOT NULL,
  `wagon_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`customer_id`, `travel_id`, `date`, `ticket_serial`, `chair_id`, `wagon_id`, `status`) VALUES
(338965798, 1, '2019-06-20 00:00:00', 14, 1, 1, 1),
(13, 1, '2019-06-20 00:00:00', 16, 1, 3, 1),
(12, 2, '2019-06-20 00:00:00', 17, 9, 2, 1),
(338093, 1, '2019-06-20 00:00:00', 21, 9, 1, 0),
(13, 14, '2019-06-23 23:00:00', 31, 1, 1, 1),
(33809, 14, '2019-06-23 23:00:00', 33, 2, 1, 1),
(12, 14, '2019-06-23 23:00:00', 34, 3, 1, 1),
(12, 10, '2019-06-19 07:00:00', 35, 1, 1, 1),
(12, 6, '2019-06-20 12:00:00', 39, 1, 1, 1),
(13, 8, '2019-06-19 07:00:00', 40, 2, 1, 1),
(33809, 8, '2019-06-19 07:00:00', 42, 3, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

CREATE TABLE `train` (
  `train_name` varchar(30) NOT NULL,
  `train_id` int(11) NOT NULL,
  `co_id` int(11) NOT NULL,
  `wagons` int(11) NOT NULL,
  `class_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `train`
--

INSERT INTO `train` (`train_name`, `train_id`, `co_id`, `wagons`, `class_id`) VALUES
('اصغر', 141, 203, 16, 1),
('همتی', 142, 200, 10, 1),
('گمراه', 143, 200, 10, 1),
('سپاه', 144, 201, 5, 2),
('امید', 146, 200, 10, 2);

-- --------------------------------------------------------

--
-- Table structure for table `travel`
--

CREATE TABLE `travel` (
  `train_id` int(11) NOT NULL,
  `locomotive_driver_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `destination_id` int(11) NOT NULL,
  `travel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `travel`
--

INSERT INTO `travel` (`train_id`, `locomotive_driver_id`, `date`, `destination_id`, `travel_id`) VALUES
(142, 537, '2019-06-20 00:00:00', 66, 1),
(142, 537, '2019-06-20 00:00:00', 67, 2),
(142, 537, '2019-06-20 00:00:00', 68, 5),
(143, 9852, '2019-06-19 07:00:00', 66, 8),
(143, 9852, '2019-06-19 07:00:00', 67, 10),
(144, 9852, '2019-06-20 12:00:00', 69, 6),
(146, 338754, '2019-06-23 23:00:00', 66, 14);

-- --------------------------------------------------------

--
-- Table structure for table `travel_group`
--

CREATE TABLE `travel_group` (
  `train_id` int(11) NOT NULL,
  `locomotive_driver_id` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `travel_group`
--

INSERT INTO `travel_group` (`train_id`, `locomotive_driver_id`, `date`) VALUES
(142, 537, '2019-06-20 00:00:00'),
(143, 9852, '2019-06-19 07:00:00'),
(144, 9852, '2019-06-20 12:00:00'),
(146, 338754, '2019-06-23 23:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`destination_id`),
  ADD UNIQUE KEY `destination_name` (`destination_name`);

--
-- Indexes for table `locomotive_driver`
--
ALTER TABLE `locomotive_driver`
  ADD PRIMARY KEY (`locomotive_driver_id`),
  ADD KEY `locomotive_driver_co` (`locomotive_driver_co`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_serial`),
  ADD UNIQUE KEY `customer_id` (`customer_id`,`travel_id`),
  ADD UNIQUE KEY `customer_id_2` (`customer_id`,`date`),
  ADD UNIQUE KEY `date` (`date`,`chair_id`,`wagon_id`) USING BTREE,
  ADD UNIQUE KEY `travel_id` (`travel_id`,`chair_id`,`wagon_id`);

--
-- Indexes for table `train`
--
ALTER TABLE `train`
  ADD PRIMARY KEY (`train_id`),
  ADD KEY `co_id` (`co_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `travel`
--
ALTER TABLE `travel`
  ADD PRIMARY KEY (`travel_id`),
  ADD UNIQUE KEY `train_id` (`train_id`,`locomotive_driver_id`,`date`,`destination_id`),
  ADD UNIQUE KEY `date` (`date`,`destination_id`),
  ADD KEY `destination_id` (`destination_id`),
  ADD KEY `locomotive_driver_id` (`locomotive_driver_id`);

--
-- Indexes for table `travel_group`
--
ALTER TABLE `travel_group`
  ADD PRIMARY KEY (`locomotive_driver_id`,`train_id`,`date`),
  ADD UNIQUE KEY `locomotive_driver_id` (`locomotive_driver_id`,`date`),
  ADD UNIQUE KEY `date` (`date`),
  ADD KEY `train_id` (`train_id`,`date`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_serial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `travel`
--
ALTER TABLE `travel`
  MODIFY `travel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `locomotive_driver`
--
ALTER TABLE `locomotive_driver`
  ADD CONSTRAINT `locomotive_driver_ibfk_1` FOREIGN KEY (`locomotive_driver_co`) REFERENCES `company` (`company_id`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`date`) REFERENCES `travel` (`date`),
  ADD CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`travel_id`);

--
-- Constraints for table `train`
--
ALTER TABLE `train`
  ADD CONSTRAINT `train_ibfk_1` FOREIGN KEY (`co_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `train_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `travel`
--
ALTER TABLE `travel`
  ADD CONSTRAINT `travel_ibfk_1` FOREIGN KEY (`destination_id`) REFERENCES `destination` (`destination_id`),
  ADD CONSTRAINT `travel_ibfk_3` FOREIGN KEY (`locomotive_driver_id`) REFERENCES `travel_group` (`locomotive_driver_id`),
  ADD CONSTRAINT `travel_ibfk_4` FOREIGN KEY (`train_id`) REFERENCES `travel_group` (`train_id`),
  ADD CONSTRAINT `travel_ibfk_5` FOREIGN KEY (`date`) REFERENCES `travel_group` (`date`);

--
-- Constraints for table `travel_group`
--
ALTER TABLE `travel_group`
  ADD CONSTRAINT `travel_group_ibfk_1` FOREIGN KEY (`locomotive_driver_id`) REFERENCES `locomotive_driver` (`locomotive_driver_id`),
  ADD CONSTRAINT `travel_group_ibfk_2` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
