-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
-- 
-- Host: localhost    Database: momentum
-- ------------------------------------------------------
-- Server version	6.0.8-alpha-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `recordid` int(11) NOT NULL,
  `line1` varchar(45) DEFAULT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `addresstype` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Arekrer','bannergatta rd','bangalore','karnataka','560078',1,1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresstype`
--

DROP TABLE IF EXISTS `addresstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresstype` (
  `recordid` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`recordid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresstype`
--

LOCK TABLES `addresstype` WRITE;
/*!40000 ALTER TABLE `addresstype` DISABLE KEYS */;
INSERT INTO `addresstype` VALUES (1,'home');
/*!40000 ALTER TABLE `addresstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment`
--

DROP TABLE IF EXISTS `assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment` (
  `stateOfResidence` varchar(45) DEFAULT NULL,
  `trainingFunded` varchar(1) DEFAULT NULL,
  `currentOccupationOnList` varchar(1) DEFAULT NULL,
  `relevantJobMatches` varchar(1) DEFAULT NULL,
  `trainingOnList` varchar(1) DEFAULT NULL,
  `occupationTrainedOn` varchar(45) DEFAULT NULL,
  `hoursPerWeekInTraining` varchar(45) DEFAULT NULL,
  `trainingStartDate` varchar(45) DEFAULT NULL,
  `trainingEndDate` varchar(45) DEFAULT NULL,
  `fundingSourceOfTraining` varchar(45) DEFAULT NULL,
  `houseHoldReceivesTANF` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment`
--

LOCK TABLES `assessment` WRITE;
/*!40000 ALTER TABLE `assessment` DISABLE KEYS */;
/*!40000 ALTER TABLE `assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `recordid` int(11) NOT NULL AUTO_INCREMENT,
  `countryid` int(11) DEFAULT NULL,
  `countrycode` char(2) DEFAULT NULL,
  `description` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`recordid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,1,'DL','Delhi');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hhs_commission`
--

DROP TABLE IF EXISTS `hhs_commission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hhs_commission` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SSN` varchar(50) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `age` varchar(25) DEFAULT NULL,
  `disabilities` varchar(100) DEFAULT NULL,
  `mobility` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `PhoneNumber` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `SSN_UNIQUE` (`SSN`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hhs_commission`
--

LOCK TABLES `hhs_commission` WRITE;
/*!40000 ALTER TABLE `hhs_commission` DISABLE KEYS */;
INSERT INTO `hhs_commission` VALUES (1,'123-88-6789','Craig Mickel','M','04/01/1964','No','Yes','US','789-654-3219');
/*!40000 ALTER TABLE `hhs_commission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `language_id` int(11) NOT NULL,
  `language_name` varchar(45) NOT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'English'),(2,'French'),(3,'Hindi'),(4,'Chinese'),(5,'German'),(6,'Russian');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `momentum_unemployment_benefits`
--

DROP TABLE IF EXISTS `momentum_unemployment_benefits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `momentum_unemployment_benefits` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SSN` varchar(50) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `age` varchar(25) DEFAULT NULL,
  `employment_status` char(1) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phoneNumber` varchar(100) DEFAULT NULL,
  `SkillsandAptitudes` varchar(100) DEFAULT NULL,
  `GradeLevel` varchar(100) DEFAULT NULL,
  `Reading` char(1) DEFAULT NULL,
  `writing` char(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `SSN_UNIQUE` (`SSN`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `momentum_unemployment_benefits`
--

LOCK TABLES `momentum_unemployment_benefits` WRITE;
/*!40000 ALTER TABLE `momentum_unemployment_benefits` DISABLE KEYS */;
INSERT INTO `momentum_unemployment_benefits` VALUES (1,'123-77-6789','John Krain','M','04/06/1984','U','US','765-789-6543','Driving','Nine','Y','Y');
/*!40000 ALTER TABLE `momentum_unemployment_benefits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `recordid` int(11) NOT NULL AUTO_INCREMENT,
  `phonenumber` varchar(45) DEFAULT NULL,
  `countryid` int(11) DEFAULT NULL,
  `phonetype` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordid`),
  KEY `userphonenew_idx` (`userid`),
  KEY `country_fk_idx` (`countryid`),
  CONSTRAINT `` FOREIGN KEY (`countryid`) REFERENCES `country` (`recordid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (1,'9916001284',1,1,1),(2,'999999999',1,1,1),(3,'999999999',1,1,1),(4,'999999999',1,1,1),(5,'999999999',1,1,1),(6,'999999999',1,1,1),(7,'999999999',1,1,1),(8,'999999999',1,1,1),(9,'999999999',1,1,1),(10,'999999999',1,1,1),(11,'999999999',1,1,1),(12,'999999999',1,1,1),(13,'999999999',1,1,1),(14,'999999999',1,1,1),(15,'999999999',1,1,1),(16,'999999999',1,1,1),(17,'999999999',1,1,1),(18,'999999999',1,1,1),(19,'999999999',1,1,1);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonetype`
--

DROP TABLE IF EXISTS `phonetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phonetype` (
  `recordid` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`recordid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonetype`
--

LOCK TABLES `phonetype` WRITE;
/*!40000 ALTER TABLE `phonetype` DISABLE KEYS */;
INSERT INTO `phonetype` VALUES (1,'home');
/*!40000 ALTER TABLE `phonetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Basic');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `service_id` int(11) NOT NULL,
  `service_name` varchar(45) NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'ChildCare Service'),(2,'Disability Service'),(3,'Senior Citiizen Service');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `texasuser`
--

DROP TABLE IF EXISTS `texasuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `texasuser` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SSN` varchar(50) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Gender` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `age` varchar(25) DEFAULT NULL,
  `LanguagesKnown` varchar(100) DEFAULT NULL,
  `Disabilities` varchar(100) DEFAULT NULL,
  `Mobility` varchar(100) DEFAULT NULL,
  `EmploymentStatus` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `PhoneNumber` varchar(100) DEFAULT NULL,
  `SkillsandAptitudes` varchar(100) DEFAULT NULL,
  `GradeLevel` varchar(100) DEFAULT NULL,
  `Reading` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `Writing` char(1) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `SSN_UNIQUE` (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `texasuser`
--

LOCK TABLES `texasuser` WRITE;
/*!40000 ALTER TABLE `texasuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `texasuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SSN` varchar(50) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Gender` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `age` varchar(25) DEFAULT NULL,
  `LanguagesKnown` varchar(100) DEFAULT NULL,
  `Disabilities` varchar(100) DEFAULT NULL,
  `Mobility` varchar(100) DEFAULT NULL,
  `EmploymentStatus` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `PhoneNumber` varchar(100) DEFAULT NULL,
  `SkillsandAptitudes` varchar(100) DEFAULT NULL,
  `GradeLevel` varchar(100) DEFAULT NULL,
  `Reading` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `Writing` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `role` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `userObject` int(11) DEFAULT NULL,
  `userphone` int(11) DEFAULT NULL,
  `phoneid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `SSN_UNIQUE` (`SSN`),
  KEY `role_id_idx` (`role`),
  KEY `userphone_idx` (`userphone`),
  KEY `userObject_idx` (`userObject`),
  KEY `userphone_idx1` (`phoneid`),
  CONSTRAINT `userObject` FOREIGN KEY (`userObject`) REFERENCES `address` (`recordid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'987-34-3849','Alex','F','12/23/1968','German','N','N','E','Texas','987-287-2979','Recruitment and Training','Bachelors','Y','Y','Admin','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(6,'132-44-8922','Jerilyn','F','02/15/1971','English','Y','Y','U','Seattle','979-879-8798','Java','Masters','Y','Y','Basic','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(7,'123-33-4545','John','M','04/03/1979','English','Y','Y','S','California','714-778-9776','Management','Doctorate','Y','Y','Admin','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(8,'343-87-5593','Sarah','F','09/01/1988','English','N','y','S','123 Seasame Street','128-389-3983','Singer','Bachelors, Masters','Y','Y','Basic','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(9,'282-44-9894','Mark','M','07/20/1960','Russian','N','Y','U','34 Cienega, Irvine','233-989-4584','Fashion Designing','Masters','Y','Y','Basic','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(10,'456-34-3938','Dan','M','04/01/1964','English','N','Y','U','Bellvue','343-343-4545','Agilist','Masters','Y','Y','Basic','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(11,'837-34-3434','Matt','M','04/17/1984','English','Y','N','U','SanJose','343-343-4545','All','Doctorate','Y','Y','Basic','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(12,'345-34-5465','Felix','M','04/07/2014','English','Y','Y','U','Los Angeles','454-454-4545','Translator','Masters','Y','Y','Basic','Alex','akmail@gmail.com','Alex','Kumar',1,1,1),(13,'234-32-2324','Maria','M','04/01/2014','English','Y','Y','U','Orlando','343-454-3432','Driving','High School','Y','Y','Basic','Alex','akmail@gmail.com','Alex','Kumar',1,1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userphone`
--

DROP TABLE IF EXISTS `userphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userphone` (
  `recordid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `phoneid` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userphone`
--

LOCK TABLES `userphone` WRITE;
/*!40000 ALTER TABLE `userphone` DISABLE KEYS */;
INSERT INTO `userphone` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(10,10,1),(11,11,1),(12,12,1),(13,13,1),(14,14,1),(15,15,1),(16,16,1),(17,17,1),(18,18,1),(19,19,1),(20,20,1),(21,21,1),(22,22,1),(23,23,1);
/*!40000 ALTER TABLE `userphone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-17 11:15:45
