CREATE DATABASE  IF NOT EXISTS `animal_world` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `animal_world`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: animal_world
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `family_animal`
--

DROP TABLE IF EXISTS `family_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `family_animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(4096) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8dy5pneg4cb0j9kqs5wys6y74` (`order_id`),
  CONSTRAINT `FK8dy5pneg4cb0j9kqs5wys6y74` FOREIGN KEY (`order_id`) REFERENCES `order_animal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_animal`
--

LOCK TABLES `family_animal` WRITE;
/*!40000 ALTER TABLE `family_animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_animal`
--

DROP TABLE IF EXISTS `order_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(4096) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_animal`
--

LOCK TABLES `order_animal` WRITE;
/*!40000 ALTER TABLE `order_animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species_animal`
--

DROP TABLE IF EXISTS `species_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `species_animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Identify_character` longtext,
  `name` varchar(255) DEFAULT NULL,
  `family_id` int DEFAULT NULL,
  `distribution` longtext,
  `Raiting` varchar(45) DEFAULT NULL,
  `value` longtext,
  `biology_ecology` longtext,
  `status` longtext,
  `protective` longtext,
  `document` longtext,
  `image` longtext,
  PRIMARY KEY (`id`),
  KEY `FKh2sskfe8ps6ueuq3go0w695io` (`family_id`),
  CONSTRAINT `FKh2sskfe8ps6ueuq3go0w695io` FOREIGN KEY (`family_id`) REFERENCES `family_animal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species_animal`
--

LOCK TABLES `species_animal` WRITE;
/*!40000 ALTER TABLE `species_animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `species_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'animal_world'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-23 14:07:40
