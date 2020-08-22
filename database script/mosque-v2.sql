CREATE DATABASE  IF NOT EXISTS `Mosque_Management`;
USE `Mosque_Management`;

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
  `date` varchar(45) DEFAULT NULL,
  `year_of_trade` varchar(45) DEFAULT NULL,
  `trade_by` varchar(45) DEFAULT NULL,
  `total_balance` double default  null,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


insert into `mosque` values
(1,'Majed Abdullah','UttarAlipur',25000,23,'Check','ORG DONATION','02/02/2020/','2020','Tiles',212121.0),
(2,'Jane Alam','Chittagong',50000,23,'cash','PERSON DONATION','02/04/2020/','2020','Electric things',121212),
(3,'Rahim Bin Faysal','Dhaka',100000,23,'Cash','LAND SALE','12/02/2020/','2020','Windows',121212),
(4,'Johir Rayhan','Alampur',8999,23,'Check','UNNECESSARY EQUIPMENT SALE','09/08/2020/','2020','Air-conditioner',121212),
(5,'Alex Murphy','China',6000,23,'Check','COLLECTION JUMMAH','01/05/2020/','2020','Fan',121212),
(6,'Hossain Imran','Silonia',12550,23,'Check','SPECIAL COLLECTION (FITR)','17/01/2020/','2020','Curpet',121212),
(7,'Md Azhar','Matubhuiyan',12550,23,'Check','SPECIAL COLLECTION (ADHA)','17/01/2020/','2020','Curpet',121212),
(8,'Sagor Hossain','Jaylashkar',12550,23,'Check','SPECIAL COLLECTION (JUMMAH)','17/01/2020/','2020','Curpet',121212),
(9,'Abdur Rahman','Rajapur',12550,23,'Check','TARAWIH EXTRA','17/01/2020/','2020','Curpet',12121),
(10,'Sahidul Islam','Sebarhat',12550,23,'Check','SOCIAL','17/01/2020/','2020','Curpet',12121),
(11,'From Locker','None',6000,23,'None','OTHER COLLECTION','01/05/2020/','2020','Fan',121212
);


