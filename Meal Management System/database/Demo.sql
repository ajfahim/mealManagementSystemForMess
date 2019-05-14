-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: Demo
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

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
-- Table structure for table `Bazar`
--

DROP TABLE IF EXISTS `Bazar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bazar` (
  `BazarId` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Cost` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`BazarId`),
  KEY `Bazar_User_User_Id_fk` (`User_id`),
  CONSTRAINT `Bazar_User_User_Id_fk` FOREIGN KEY (`User_id`) REFERENCES `User` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bazar`
--

LOCK TABLES `Bazar` WRITE;
/*!40000 ALTER TABLE `Bazar` DISABLE KEYS */;
INSERT INTO `Bazar` VALUES (1,2,'2019-03-31',500),(2,2,'2019-04-01',456),(3,3,'2019-04-01',345),(4,2,'2019-04-04',18000);
/*!40000 ALTER TABLE `Bazar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Deposite`
--

DROP TABLE IF EXISTS `Deposite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Deposite` (
  `Deposite_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Amount` double DEFAULT '0',
  `Date` date DEFAULT NULL,
  `User` int(11) NOT NULL,
  PRIMARY KEY (`Deposite_Id`),
  KEY `Deposite_User_User_Id_fk` (`User`),
  CONSTRAINT `Deposite_User_User_Id_fk` FOREIGN KEY (`User`) REFERENCES `User` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Deposite`
--

LOCK TABLES `Deposite` WRITE;
/*!40000 ALTER TABLE `Deposite` DISABLE KEYS */;
INSERT INTO `Deposite` VALUES (1,490,'2019-03-31',2),(2,0,'2019-03-31',3),(3,500,'2019-03-31',4),(4,670,'2019-03-31',5),(5,0,'2019-04-01',3),(6,6545,'2019-04-24',5),(7,23456,'2019-04-01',2),(8,564,'2019-04-02',6),(9,564,'2019-04-02',7),(10,12,'2019-04-24',1),(11,12,'2019-04-24',1),(12,12,'2019-04-24',1),(13,500,'2019-04-04',4),(14,500,'2019-04-04',4);
/*!40000 ALTER TABLE `Deposite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Meal`
--

DROP TABLE IF EXISTS `Meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Meal` (
  `Meal_Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Id` int(11) NOT NULL,
  `Date` date NOT NULL,
  `BreakFast` int(11) DEFAULT '0',
  `Lunch` int(11) DEFAULT '0',
  `Dinner` int(11) DEFAULT '0',
  PRIMARY KEY (`Meal_Id`),
  KEY `Meal_User_User_Id_fk` (`User_Id`),
  CONSTRAINT `Meal_User_User_Id_fk` FOREIGN KEY (`User_Id`) REFERENCES `User` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Meal`
--

LOCK TABLES `Meal` WRITE;
/*!40000 ALTER TABLE `Meal` DISABLE KEYS */;
INSERT INTO `Meal` VALUES (1,3,'2019-03-27',1,0,0),(2,2,'2019-03-27',1,0,0),(3,3,'2019-03-31',0,1,1),(4,5,'2019-04-01',1,1,2),(5,4,'2019-04-01',0,3,0),(6,3,'2019-04-03',1,1,1),(7,1,'2019-04-09',2,6,8);
/*!40000 ALTER TABLE `Meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `User_Id` int(10) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(255) DEFAULT NULL,
  `Pass` varchar(255) DEFAULT NULL,
  `ContactNum` varchar(25) DEFAULT NULL,
  `Type` enum('manager','border') DEFAULT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Fahim','123',NULL,'manager'),(2,'Baker','234',NULL,'border'),(3,'Selim','123','01781748034','border'),(4,'Istiak',NULL,NULL,NULL),(5,'Biplob','123','123421','border'),(6,'Momen','123','q23e412313','manager'),(7,'shanta','234',NULL,'manager'),(8,'Jion','123','123423123','border'),(9,'Xyz','123','122321234231','manager'),(10,'Sabiul','123','0186834553','border');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-08  9:44:46
