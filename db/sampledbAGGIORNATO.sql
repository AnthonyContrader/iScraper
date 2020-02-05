-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: sampledb
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `tb_injuries`
--

DROP TABLE IF EXISTS `tb_injuries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_injuries` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `severity` tinyint(4) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `duration` tinyint(4) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `player_id` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_id` (`player_id`),
  CONSTRAINT `tb_injuries_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `tb_players` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_injuries`
--

LOCK TABLES `tb_injuries` WRITE;
/*!40000 ALTER TABLE `tb_injuries` DISABLE KEYS */;
INSERT INTO `tb_injuries` VALUES (8,2,'lesione parziale',3,'9/12/1997',1),(9,4,'rottura perone',5,'01/02/1998',2);
/*!40000 ALTER TABLE `tb_injuries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_players`
--

DROP TABLE IF EXISTS `tb_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_players` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `player_name` varchar(25) DEFAULT NULL,
  `player_surname` varchar(25) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `actual_value` int(11) DEFAULT NULL,
  `previous_value` int(11) DEFAULT NULL,
  `position` varchar(15) DEFAULT NULL,
  `team` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_players`
--

LOCK TABLES `tb_players` WRITE;
/*!40000 ALTER TABLE `tb_players` DISABLE KEYS */;
INSERT INTO `tb_players` VALUES (1,'Cristiano','Ronaldo',34,100,120,'forward',NULL),(2,'Lionel','Messi',32,200,210,'forward',NULL);
/*!40000 ALTER TABLE `tb_players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_results`
--

DROP TABLE IF EXISTS `tb_results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_results` (
  `team1` varchar(40) DEFAULT NULL,
  `team2` varchar(40) DEFAULT NULL,
  `result` varchar(5) DEFAULT NULL,
  `season` varchar(20) DEFAULT NULL,
  KEY `team1` (`team1`),
  KEY `team2` (`team2`),
  CONSTRAINT `tb_results_ibfk_1` FOREIGN KEY (`team1`) REFERENCES `tb_teams` (`name`),
  CONSTRAINT `tb_results_ibfk_2` FOREIGN KEY (`team2`) REFERENCES `tb_teams` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_results`
--

LOCK TABLES `tb_results` WRITE;
/*!40000 ALTER TABLE `tb_results` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_searches`
--

DROP TABLE IF EXISTS `tb_searches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_searches` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `search_date` date NOT NULL,
  `player_value` bigint(20) NOT NULL,
  `player_index` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `player_id` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_id` (`player_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tb_searches_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `tb_players` (`id`),
  CONSTRAINT `tb_searches_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `tb_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_searches`
--

LOCK TABLES `tb_searches` WRITE;
/*!40000 ALTER TABLE `tb_searches` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_searches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stats`
--

DROP TABLE IF EXISTS `tb_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_stats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_id` smallint(6) NOT NULL DEFAULT '0',
  `season` int(11) NOT NULL DEFAULT '0',
  `caps` int(11) NOT NULL DEFAULT '0',
  `contributions` decimal(5,2) NOT NULL DEFAULT '0.00',
  `shotsper` decimal(5,2) NOT NULL DEFAULT '0.00',
  `keypass` decimal(5,2) NOT NULL DEFAULT '0.00',
  `passprec` decimal(5,2) NOT NULL DEFAULT '0.00',
  `dribbling` decimal(5,2) NOT NULL DEFAULT '0.00',
  `foulssub` decimal(5,2) NOT NULL DEFAULT '0.00',
  `foulscomm` decimal(5,2) NOT NULL DEFAULT '0.00',
  `tackles` decimal(5,2) NOT NULL DEFAULT '0.00',
  `tacklesper` decimal(5,2) NOT NULL DEFAULT '0.00',
  `breaks` decimal(5,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `player_id` (`player_id`),
  CONSTRAINT `tb_stats_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `tb_players` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stats`
--

LOCK TABLES `tb_stats` WRITE;
/*!40000 ALTER TABLE `tb_stats` DISABLE KEYS */;
INSERT INTO `tb_stats` VALUES (1,1,1,4,3.00,4.00,3.00,4.00,3.00,4.00,3.00,4.00,3.00,4.00);
/*!40000 ALTER TABLE `tb_stats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_teams`
--

DROP TABLE IF EXISTS `tb_teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_teams` (
  `name` varchar(40) NOT NULL,
  `market_value` int(11) DEFAULT NULL,
  `teamIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_teams`
--

LOCK TABLES `tb_teams` WRITE;
/*!40000 ALTER TABLE `tb_teams` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_users`
--

DROP TABLE IF EXISTS `tb_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_users` (
  `username` varchar(16) DEFAULT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES ('user','USER','user',1,'user@email.com',NULL),('admin','ADMIN','admin',2,'admin@email.com',NULL);
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-05 19:59:49
