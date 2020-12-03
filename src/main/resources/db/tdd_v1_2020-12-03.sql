# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.31)
# Database: tdd_v1
# Generation Time: 2020-12-03 11:32:24 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ums_admin
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ums_admin`;

CREATE TABLE `ums_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `gender` int(1) DEFAULT NULL COMMENT '0->未知；1->男；2->女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '0->禁用；1->启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

LOCK TABLES `ums_admin` WRITE;
/*!40000 ALTER TABLE `ums_admin` DISABLE KEYS */;

INSERT INTO `ums_admin` (`id`, `email`, `username`, `password`, `nick_name`, `phone`, `gender`, `birthday`, `city`, `create_time`, `login_time`, `status`)
VALUES
	(1,'baiyu@xxx.com','baiyu123','$2a$10$fGWlZeoueOuu6VjqyHZMCOXCm2cHv/KGts0oTYskY9iulBKSP.UqO',NULL,NULL,NULL,NULL,NULL,'2020-12-03 01:26:01',NULL,1),
	(2,'lizhiwei@xxx.com','lizhiwei123','$2a$10$natQtaqpHUp/egI4J1y/IuAVboDaAm5SUSizK5mMMZu07XbNKyEBu',NULL,NULL,NULL,NULL,NULL,'2020-12-03 17:26:51',NULL,1);

/*!40000 ALTER TABLE `ums_admin` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ums_admin_role_relation
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ums_admin_role_relation`;

CREATE TABLE `ums_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` int(20) NOT NULL,
  `role_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

LOCK TABLES `ums_admin_role_relation` WRITE;
/*!40000 ALTER TABLE `ums_admin_role_relation` DISABLE KEYS */;

INSERT INTO `ums_admin_role_relation` (`id`, `admin_id`, `role_id`)
VALUES
	(1,1,1),
	(2,2,2);

/*!40000 ALTER TABLE `ums_admin_role_relation` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ums_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ums_permission`;

CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` tinyint(4) DEFAULT '0' COMMENT '0->目录；1->列表',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';

LOCK TABLES `ums_permission` WRITE;
/*!40000 ALTER TABLE `ums_permission` DISABLE KEYS */;

INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`)
VALUES
	(1,0,'管理员',NULL,NULL,0,NULL,1,NULL,0),
	(2,1,'管理员列表','ums:admin:read',NULL,1,'/ums/admin/list',1,'2020-01-01 00:00:00',1),
	(3,1,'添加管理员','ums:admin:create',NULL,1,'/ums/admin/create',1,'2020-01-01 00:00:00',2),
	(4,1,'修改管理员','ums:admin:update',NULL,1,'/ums/admin/update',1,'2020-01-01 00:00:00',3),
	(5,1,'删除管理员','ums:admin:delete',NULL,1,'/ums/admin/delete',1,'2020-01-01 00:00:00',4),
	(6,0,'用户',NULL,NULL,0,NULL,1,NULL,0),
	(7,6,'用户列表','ums:member:read',NULL,1,'/ums/member/list',1,'2020-01-01 00:00:00',1),
	(8,6,'添加用户','ums:member:create',NULL,1,'/ums/member/create',1,'2020-01-01 00:00:00',2),
	(9,6,'修改用户','ums:member:update',NULL,1,'/ums/member/update',1,'2020-01-01 00:00:00',3),
	(10,6,'删除用户','ums:member:delete',NULL,1,'/ums/member/delete',1,'2020-01-01 00:00:00',4),
	(11,0,'地址',NULL,NULL,0,NULL,1,NULL,0),
	(12,11,'地址列表','ums:memberAddress:read',NULL,1,'/ums/member/address/list',1,'2020-01-01 00:00:00',1),
	(13,11,'添加地址','ums:memberAddress:create',NULL,1,'/ums/member/address/create',1,'2020-01-01 00:00:00',2),
	(14,11,'修改地址','ums:memberAddress:update',NULL,1,'/ums/member/address/update',1,'2020-01-01 00:00:00',3),
	(15,11,'删除地址','ums:memberAddress:delete',NULL,1,'/ums/member/address/delete',1,'2020-01-01 00:00:00',4);

/*!40000 ALTER TABLE `ums_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ums_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ums_role`;

CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `count` int(11) DEFAULT NULL COMMENT '用户数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) DEFAULT '1' COMMENT '0->禁用；1->启用',
  `sort` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

LOCK TABLES `ums_role` WRITE;
/*!40000 ALTER TABLE `ums_role` DISABLE KEYS */;

INSERT INTO `ums_role` (`id`, `name`, `description`, `count`, `create_time`, `status`, `sort`)
VALUES
	(1,'超级管理员','超级管理员',5,'2020-01-01 00:00:00',1,0),
	(2,'普通管理员','普通管理员',10,'2020-01-01 00:00:00',1,0);

/*!40000 ALTER TABLE `ums_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ums_role_permission_relation
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ums_role_permission_relation`;

CREATE TABLE `ums_role_permission_relation` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) NOT NULL,
  `permission_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色和权限关系表';

LOCK TABLES `ums_role_permission_relation` WRITE;
/*!40000 ALTER TABLE `ums_role_permission_relation` DISABLE KEYS */;

INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`)
VALUES
	(1,1,1),
	(2,1,2),
	(3,1,3),
	(4,1,4),
	(5,1,5),
	(6,1,6),
	(7,1,7),
	(8,1,8),
	(9,1,9),
	(10,1,10),
	(11,2,6),
	(12,2,7),
	(13,2,8),
	(14,2,9);

/*!40000 ALTER TABLE `ums_role_permission_relation` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
