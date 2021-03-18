/*
SQLyog Ultimate v12.2.6 (64 bit)
MySQL - 5.5.53 : Database - jia-zheng
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jia-zheng` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `jia-zheng`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminid` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `realname` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addtime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `admin` */

insert  into `admin`(`adminid`,`username`,`password`,`realname`,`contact`,`role`,`addtime`) values 
('1','admin','123456','超级管理员','15888888888','超级管理员','2020-07-12'),
('A20200718173312352','admin1','123456','管理员1','15211111111','超级管理员','2020-07-18'),
('A20200718173602557','admin2','123456','超级管理员2','15222222222','超级管理员','2020-07-18'),
('A20200718173748497','admin3','123456','超级管理员3','15233333333','超级管理员','2020-07-18'),
('A20200718173848637','guanliyuan1','123456','管理员1','15211111111','管理员','2020-07-18');

/*Table structure for table `allot` */

DROP TABLE IF EXISTS `allot`;

CREATE TABLE `allot` (
  `allotid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ordersid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addtime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`allotid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `allot` */

insert  into `allot`(`allotid`,`ordersid`,`employid`,`addtime`,`status`) values 
('Allot20200722223233808','Orders20200722173928460','Employ20200722210235840','2020-07-22','完成'),
('Allot20200724161514773','Orders20200724161443386','Employ20200722210150845','2020-07-24','完成'),
('Allot20200724161941348','Orders20200724161919266','Employ20200722210235840','2020-07-24','完成');

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `articleid` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contents` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addtime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hits` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`articleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `article` */

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `cartid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `usersid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodsid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addtime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `cart` */

/*Table structure for table `cate` */

DROP TABLE IF EXISTS `cate`;

CREATE TABLE `cate` (
  `cateid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `catename` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `memo` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `cate` */

insert  into `cate`(`cateid`,`catename`,`memo`) values 
('Cate20200719161834116','类型A','类型A类型A类型A类型A'),
('Cate20200719161846722','类型B','类型B类型B类型B类型B类型B');

/*Table structure for table `employ` */

DROP TABLE IF EXISTS `employ`;

CREATE TABLE `employ` (
  `employid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `realname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idcard` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jiguan` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `minzu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `workdate` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `memo` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`employid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `employ` */

insert  into `employ`(`employid`,`realname`,`sex`,`birthday`,`idcard`,`jiguan`,`minzu`,`workdate`,`contact`,`memo`) values 
('Employ20200722210150845','工人11','女','2020-07-05','1231231','江苏1','汉1','2020-07-31','152111111112','11111111111112'),
('Employ20200722210235840','工人2','男','2020-07-22','123123','江苏','汉','2020-07-31','15211111111','22222');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `goodsid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `goodsname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cateid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addtime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hits` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sellnum` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contents` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `goods` */

insert  into `goods`(`goodsid`,`goodsname`,`image`,`cateid`,`price`,`addtime`,`hits`,`sellnum`,`contents`) values 
('Goods20200719225459286','项目-打扫','upfiles/20200724200630.jpg','Cate20200719161846722','100','2020-07-19','6','2','<p>项目-打扫-类型A-100</p>\r\n'),
('Goods20200719225524331','项目-做饭','upfiles/20200724200621.jpg','Cate20200719161846722','200','2020-07-19','24','1','<p>项目-做饭-200</p>\r\n'),
('Goods20200720163940888','擦墙','upfiles/20200724200603.jpg','Cate20200719161834116','99','2020-07-20','3','1','<p>擦墙-99-类型A</p>\r\n');

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `itemsid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ordercode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodsid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`itemsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `items` */

insert  into `items`(`itemsid`,`ordercode`,`goodsid`,`price`) values 
('Items20200722173849147','PD20200722173839','Goods20200719225524331','200'),
('Items20200724161443455','PD20200724161443','Goods20200719225459286','100'),
('Items20200724161919688','PD20200724161919','Goods20200720163940888','99'),
('Items20200724161919719','PD20200724161919','Goods20200719225459286','100');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `ordersid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ordercode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usersid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addtime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `workdate` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `worktime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enddate` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ordersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `orders` */

insert  into `orders`(`ordersid`,`ordercode`,`usersid`,`total`,`addtime`,`status`,`address`,`contact`,`workdate`,`worktime`,`enddate`) values 
('Orders20200722173928460','PD20200722173839','Users20200721164327800','200.0','2020-07-22','已评价','南京雨花台','15211111111','2020-07-22','8-10','2020-07-23'),
('Orders20200724161443386','PD20200724161443','Users20200721164327800','100.0','2020-07-24','已评价','11','11','2020-07-24','8-10','2020-07-25'),
('Orders20200724161919266','PD20200724161919','Users20200721164327800','199.0','2020-07-24','已评价','11','11','2020-07-24','8-10','2020-07-25');

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `topicid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `usersid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ordersid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodsid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `num` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contents` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addtime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reps` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`topicid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `topic` */

insert  into `topic`(`topicid`,`usersid`,`ordersid`,`goodsid`,`num`,`contents`,`addtime`,`status`,`reps`) values 
('Topic20200723203009208','Users20200721164327800','Orders20200722173928460','Goods20200719225524331','5','五星好评','2020-07-23','已回复','谢谢您的五星好评,我们会再接再厉'),
('Topic20200724161551927','Users20200721164327800','Orders20200724161443386','Goods20200719225459286','3','111111','2020-07-24','未回复',NULL),
('Topic20200724162012220','Users20200721164327800','Orders20200724161919266','Goods20200720163940888','5','11','2020-07-24','未回复',NULL),
('Topic20200724162012285','Users20200721164327800','Orders20200724161919266','Goods20200719225459286','5','11','2020-07-24','未回复',NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `usersid` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `realname` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `regdate` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`usersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`usersid`,`username`,`password`,`realname`,`sex`,`birthday`,`contact`,`regdate`) values 
('Users20200721164327800','user1','123','用户','男','2020-07-22','15211111111',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
