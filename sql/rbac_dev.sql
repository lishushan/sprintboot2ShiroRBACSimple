/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.26-0ubuntu0.16.04.1 : Database - rbac_dev
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rbac_dev` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rbac_dev`;

/*Table structure for table `system_group` */

DROP TABLE IF EXISTS `system_group`;

CREATE TABLE `system_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) NOT NULL COMMENT '组名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `udpate_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `system_group` */

insert  into `system_group`(`id`,`name`,`create_time`,`udpate_time`) values 
(1,'超管组','2019-05-28 16:12:33','2019-05-28 16:12:35');

/*Table structure for table `system_group_permission` */

DROP TABLE IF EXISTS `system_group_permission`;

CREATE TABLE `system_group_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_id` bigint(20) NOT NULL COMMENT '组id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `system_group_permission` */

insert  into `system_group_permission`(`id`,`group_id`,`permission_id`,`create_time`,`update_time`) values 
(1,1,1,'2019-05-28 16:12:48','2019-05-28 16:12:50');

/*Table structure for table `system_permission` */

DROP TABLE IF EXISTS `system_permission`;

CREATE TABLE `system_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id，无实际业务意义',
  `name` varchar(128) NOT NULL COMMENT '权限名称',
  `code` varchar(10) NOT NULL COMMENT '权限代码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `system_permission` */

insert  into `system_permission`(`id`,`name`,`code`,`create_time`,`update_time`) values 
(1,'权限01','0001','2019-05-28 16:13:16','2019-05-28 16:13:18');

/*Table structure for table `system_user` */

DROP TABLE IF EXISTS `system_user`;

CREATE TABLE `system_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `enabled` int(11) NOT NULL COMMENT '使能状态：1-启用；0-禁用；',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密文密码',
  `group_id` bigint(20) NOT NULL COMMENT '用户组id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `system_user` */

insert  into `system_user`(`id`,`enabled`,`username`,`password`,`group_id`,`create_time`,`update_time`) values 
(1,1,'admin','123456',1,'2019-05-28 16:11:46','2019-05-28 16:11:48');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
