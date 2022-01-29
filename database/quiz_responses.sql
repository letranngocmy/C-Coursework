-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `responses`
--

DROP TABLE IF EXISTS `responses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student` int DEFAULT NULL,
  `question` int DEFAULT NULL,
  `response` varchar(1) DEFAULT NULL,
  `correct` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responses`
--

LOCK TABLES `responses` WRITE;
/*!40000 ALTER TABLE `responses` DISABLE KEYS */;
INSERT INTO `responses` VALUES (12,1,12,'b','1'),(13,1,13,'b','1'),(14,1,11,'c','1'),(15,1,14,'c','1'),(16,1,10,'b','0'),(17,1,9,'b','1'),(18,2,9,'b','1'),(19,2,10,'a','1'),(20,2,11,'c','1'),(21,2,12,'a','0'),(22,2,13,'b','1'),(23,2,14,'c','1'),(24,3,9,'b','1'),(25,3,10,'b','0'),(26,3,11,'b','0'),(27,3,14,'b','0'),(28,3,13,'b','1'),(29,3,12,'b','1'),(30,4,9,'c','0'),(31,4,10,'c','0'),(32,4,11,'c','1'),(33,4,12,'b','1'),(34,4,13,'b','1'),(35,4,14,'c','1'),(36,5,9,'b','1'),(37,5,10,'a','1'),(38,5,11,'c','1'),(39,5,13,'b','1'),(40,5,12,'a','0'),(41,5,14,'b','0'),(42,6,9,'b','1'),(43,6,10,'a','1'),(44,6,11,'c','1'),(45,6,12,'a','0'),(46,6,13,'b','1'),(47,6,14,'c','1'),(48,7,9,'b','1'),(49,7,11,'c','1'),(50,7,10,'b','0'),(51,7,12,'a','0'),(52,7,14,'c','1'),(53,7,13,'b','1'),(54,8,9,'b','1'),(55,8,10,'a','1'),(56,8,11,'c','1'),(57,8,12,'b','1'),(58,8,13,'b','1'),(59,8,14,'c','1');
/*!40000 ALTER TABLE `responses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-07 18:08:52
