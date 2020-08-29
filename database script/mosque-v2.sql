CREATE DATABASE  IF NOT EXISTS `mosque_management`;
USE `mosque_management`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `mosque`;

CREATE TABLE `mosque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `credit_amount` double  DEFAULT NULL,
  `debit_amount` double default null,
  `way_of_payment` varchar(45) DEFAULT NULL,
  `trade_head` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `year_of_trade` varchar(45) DEFAULT NULL,
  `trade_by` varchar(45) DEFAULT NULL,
  `total_balance` double default  null,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


insert into `mosque` values
(1,'Majed Abdullah','UttarAlipur',25000,23,'Check','ORG DONATION','','2020','Tiles',212121.0
);


