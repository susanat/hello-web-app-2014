create database if not exists `hibernate_maven_dao`;
USE `hibernate_maven_dao`;
DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;