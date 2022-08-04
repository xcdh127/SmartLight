/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.38 : Database - light
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`light` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `light`;

/*Table structure for table `light` */

DROP TABLE IF EXISTS `light`;

CREATE TABLE `light` (
  `id` int(11) NOT NULL COMMENT '灯箱id',
  `name` varchar(255) DEFAULT NULL COMMENT '灯箱名字',
  `strength` int(11) DEFAULT NULL COMMENT '强度',
  `frequency` int(11) DEFAULT NULL COMMENT '频率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `light` */

insert  into `light`(`id`,`name`,`strength`,`frequency`) values (1,'\"灯箱1号\"',44,44);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
