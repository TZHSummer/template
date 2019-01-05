DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `manager` (
  `id` int(6) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 NOT NULL,
  `enable` int(1) NOT NULL DEFAULT '0',
  `level` int(2) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`),
  UNIQUE KEY `manager_id_uindex` (`id`),
  UNIQUE KEY `manager_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (123456,'hello','fsfzcxgs651',1,2),(230109,'AreYouOk','123456',1,2),(236581,'enenen','fssdfds',1,2),(265401,'helloworld','hello123',1,2),(282506,'welcome','123456',0,2),(406720,'hoareyou','imokhh',1,2),(456789,'world','fssdfsdf',1,2),(483219,'root','root',1,1),(594592,'nihaoya','nihaoya123',1,2),(896516,'6456546','123456',1,2),(932707,'我是你的小天使','123456',1,2);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-20 23:09:30
