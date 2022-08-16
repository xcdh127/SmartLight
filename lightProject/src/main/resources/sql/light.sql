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

insert  into `light`(`id`,`name`,`strength`,`frequency`) values (1,'\"灯箱1号\"',0,40);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `sex` varchar(10) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`password`,`email`,`sex`) values (1,'admin','123456','zhongguo@163.com','男'),(2,'user01','123456','222@qq.com','女');

/*Table structure for table `user_light` */

DROP TABLE IF EXISTS `user_light`;

CREATE TABLE `user_light` (
  `user_light_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `light_id` int(11) NOT NULL,
  PRIMARY KEY (`user_light_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_light` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
