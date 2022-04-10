-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.22-MariaDB


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema loansystem
--

CREATE DATABASE IF NOT EXISTS loansystem;
USE loansystem;

--
-- Definition of table `audittrails`
--

DROP TABLE IF EXISTS `audittrails`;
CREATE TABLE `audittrails` (
  `idaudittrails` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `createdOn` datetime NOT NULL,
  `action` varchar(100) NOT NULL,
  `userid` varchar(45) NOT NULL,
  PRIMARY KEY (`idaudittrails`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `audittrails`
--

/*!40000 ALTER TABLE `audittrails` DISABLE KEYS */;
/*!40000 ALTER TABLE `audittrails` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `phonenumber` int(10) unsigned NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `secondname` varchar(45) NOT NULL,
  `idnumber` varchar(45) NOT NULL,
  PRIMARY KEY (`phonenumber`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `loanlimits`
--

DROP TABLE IF EXISTS `loanlimits`;
CREATE TABLE `loanlimits` (
  `idloanlimits` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customerid` int(10) unsigned NOT NULL,
  `loanlimit` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idloanlimits`),
  KEY `FK_loanlimits_1` (`customerid`),
  CONSTRAINT `FK_loanlimits_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`phonenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loanlimits`
--

/*!40000 ALTER TABLE `loanlimits` DISABLE KEYS */;
/*!40000 ALTER TABLE `loanlimits` ENABLE KEYS */;


--
-- Definition of table `loans`
--

DROP TABLE IF EXISTS `loans`;
CREATE TABLE `loans` (
  `idloan` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customerid` int(10) unsigned NOT NULL,
  `amount` int(10) unsigned NOT NULL,
  `datecreated` datetime NOT NULL,
  `duedate` datetime NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Acquired',
  PRIMARY KEY (`idloan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loans`
--

/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
