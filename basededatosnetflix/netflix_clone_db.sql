/*
SQLyog Enterprise - MySQL GUI v8.1 
MySQL - 5.5.5-10.4.13-MariaDB : Database - netflix_clone_db
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`netflix_clone_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `netflix_clone_db`;

/*Table structure for table `episodio` */

DROP TABLE IF EXISTS `episodio`;

CREATE TABLE `episodio` (
  `episodioId` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(250) NOT NULL,
  `descripcion` text NOT NULL,
  `youtubeVideoId` varchar(45) NOT NULL,
  `temporadaId` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  PRIMARY KEY (`episodioId`),
  KEY `temporadaId` (`temporadaId`),
  CONSTRAINT `episodio_ibfk_1` FOREIGN KEY (`temporadaId`) REFERENCES `temporada` (`temporadaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `episodio` */

/*Table structure for table `serie` */

DROP TABLE IF EXISTS `serie`;

CREATE TABLE `serie` (
  `serieId` int(11) NOT NULL AUTO_INCREMENT,
  `nombreSerie` varchar(500) NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`serieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `serie` */

/*Table structure for table `temporada` */

DROP TABLE IF EXISTS `temporada`;

CREATE TABLE `temporada` (
  `temporadaId` int(11) NOT NULL AUTO_INCREMENT,
  `serieId` int(11) NOT NULL,
  `nombreTemporada` varchar(500) NOT NULL,
  `orden` int(11) NOT NULL,
  PRIMARY KEY (`temporadaId`),
  KEY `serieId` (`serieId`),
  CONSTRAINT `temporada_ibfk_1` FOREIGN KEY (`serieId`) REFERENCES `serie` (`serieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `temporada` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `usuarioId` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCompleto` varchar(100) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tipoUsuario` varchar(15) NOT NULL DEFAULT 'CLIENTE' COMMENT 'Valores posibles : ''ADM'', ''CLIENTE''',
  PRIMARY KEY (`usuarioId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
