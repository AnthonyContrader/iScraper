-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sampledb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `injuries`
--

DROP TABLE IF EXISTS `injuries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `injuries` (
  `ID` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `duration` tinyint DEFAULT NULL,
  `severity` smallint DEFAULT NULL,
  `season` smallint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `injuries`
--

LOCK TABLES `injuries` WRITE;
/*!40000 ALTER TABLE `injuries` DISABLE KEYS */;
/*!40000 ALTER TABLE `injuries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `injury`
--

DROP TABLE IF EXISTS `injury`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `injury` (
  `ID` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `duration` tinyint DEFAULT NULL,
  `severity` smallint DEFAULT NULL,
  `season` smallint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `injury`
--

LOCK TABLES `injury` WRITE;
/*!40000 ALTER TABLE `injury` DISABLE KEYS */;
/*!40000 ALTER TABLE `injury` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_players`
--

DROP TABLE IF EXISTS `tb_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_players` (
  `player_id` smallint DEFAULT NULL,
  `player_name` varchar(25) DEFAULT NULL,
  `player_surname` varchar(25) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `actualMarketValue` int DEFAULT NULL,
  `previousMarketValue` int DEFAULT NULL,
  `position` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_players`
--

LOCK TABLES `tb_players` WRITE;
/*!40000 ALTER TABLE `tb_players` DISABLE KEYS */;
INSERT INTO `tb_players` VALUES (1,'wew','wrrrw',233,2323,322,'dfs'),(1,'sfssf','wwr',121,2322,3535,'dgg'),(1,'wrwr','rwrw',32,22322,32,'fsf'),(2,'fasfas','asfas',32,22432,23,'fs');
/*!40000 ALTER TABLE `tb_players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_searches`
--

DROP TABLE IF EXISTS `tb_searches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_searches` (
  `id` bigint NOT NULL,
  `search_date` date NOT NULL,
  `player_value` bigint NOT NULL,
  `player_index` int NOT NULL,
  `user` int NOT NULL,
  `playerId` smallint NOT NULL,
  PRIMARY KEY (`id`)
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
  `player_id` int NOT NULL DEFAULT '0',
  `season` varchar(9) NOT NULL DEFAULT '0',
  `team` varchar(32) NOT NULL DEFAULT '0',
  `caps` int NOT NULL DEFAULT '0',
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
  PRIMARY KEY (`player_id`,`season`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stats`
--

LOCK TABLES `tb_stats` WRITE;
/*!40000 ALTER TABLE `tb_stats` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_stats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(16) NOT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','ADMIN','admin',1),('user','USER','user',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-31 14:15:40
