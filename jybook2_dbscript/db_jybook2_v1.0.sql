/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.31-77.0-log : Database - jy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `jy`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1);

/*Table structure for table `jy_book` */

DROP TABLE IF EXISTS `jy_book`;

CREATE TABLE `jy_book` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `s_profile` varchar(500) DEFAULT NULL COMMENT '封面',
  `n_type` int(11) DEFAULT NULL COMMENT '类型',
  `s_remark` varchar(1000) DEFAULT NULL COMMENT '描述',
  `n_chapternum` int(11) DEFAULT NULL COMMENT '章节数',
  `s_url` varchar(500) DEFAULT NULL COMMENT '下载地址',
  `n_size` int(11) DEFAULT NULL COMMENT '文件大小',
  `n_sort` int(11) DEFAULT NULL COMMENT '排序',
  `d_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`n_id`),
  KEY `n_id` (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `jy_book` */

insert  into `jy_book`(`n_id`,`s_name`,`s_profile`,`n_type`,`s_remark`,`n_chapternum`,`s_url`,`n_size`,`n_sort`,`d_create_time`) values (2,'人工智能',NULL,1,'李开复老师的书',23,'http://www.jdd.com/books/rengong.epub',234,1,'2018-06-23 16:27:15'),(3,'亿级流量网站架构核心技术',NULL,1,'跟开涛学搭建高可用高并发系统',34,'http://www.jdd.com/books/yiji.epub',254,2,NULL),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `jy_booktype` */

DROP TABLE IF EXISTS `jy_booktype`;

CREATE TABLE `jy_booktype` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_type` varchar(50) DEFAULT NULL,
  `n_sort` int(11) DEFAULT NULL,
  `s_remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`n_id`),
  KEY `n_id` (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `jy_booktype` */

insert  into `jy_booktype`(`n_id`,`s_type`,`n_sort`,`s_remark`) values (1,'类别1',1,NULL),(2,'类别2',2,NULL),(3,'类别3',3,NULL),(4,'类别4',4,NULL);

/*Table structure for table `jy_image` */

DROP TABLE IF EXISTS `jy_image`;

CREATE TABLE `jy_image` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_path` varchar(500) DEFAULT NULL COMMENT '路径',
  `s_url` varchar(500) DEFAULT NULL COMMENT '链接地址',
  `s_place` varchar(10) DEFAULT NULL COMMENT '显示的位置',
  `n_sort` int(11) DEFAULT NULL COMMENT '排序',
  `d_createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `n_status` int(11) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `jy_image` */

insert  into `jy_image`(`n_id`,`s_path`,`s_url`,`s_place`,`n_sort`,`d_createtime`,`n_status`) values (1,'/images/index.png',NULL,'index',1,'2018-06-25 17:28:24',1),(2,'/images/ad/1.jpg',NULL,'ad',1,'2018-06-25 17:31:52',1),(3,'/images/ad/2.jpg',NULL,'ad',2,'2018-06-25 17:32:12',1),(4,'/images/ad/3.jpg',NULL,'ad',3,'2018-06-25 17:32:26',1);

/*Table structure for table `jy_version` */

DROP TABLE IF EXISTS `jy_version`;

CREATE TABLE `jy_version` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_client_type` int(11) DEFAULT NULL COMMENT '1:android;2:ios;3:wap',
  `n_version` int(11) DEFAULT NULL COMMENT '版本号',
  `d_create_time` datetime DEFAULT NULL,
  `n_status` int(11) DEFAULT NULL COMMENT '状态 1:启用;0:禁用',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `jy_version` */

insert  into `jy_version`(`n_id`,`n_client_type`,`n_version`,`d_create_time`,`n_status`) values (1,1,11,'2018-05-10 13:36:24',1),(2,2,100,'2018-05-10 13:36:33',1),(3,1,100,'2018-05-10 13:37:26',1);

/*Table structure for table `Person` */

DROP TABLE IF EXISTS `Person`;

CREATE TABLE `Person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created` bigint(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Person` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
