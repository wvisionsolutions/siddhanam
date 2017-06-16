--Create user
GRANT ALL PRIVILEGES ON *.* TO 'momentum'@'localhost' IDENTIFIED BY PASSWORD '*FFF977AE8E7AD6660FE5D54197DD9F34B0A2E154' WITH GRANT OPTION;

CREATE DATABASE  IF NOT EXISTS `momentum`;
USE `momentum`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
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
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `SSN_UNIQUE` (`SSN`),
  KEY `role_id_idx` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hhs_commission`;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `momentum_unemployment_benefits`;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `texasuser`;
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `services`;
CREATE TABLE `services` (
  `service_id` int(11) NOT NULL,
  `service_name` varchar(45) NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `language_id` int(11) NOT NULL,
  `language_name` varchar(45) NOT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `assessment`;
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