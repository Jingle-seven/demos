CREATE DATABASE IF NOT EXISTS `test` /*!40100 COLLATE 'utf8_general_ci' */;
USE `test`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(10) NOT NULL DEFAULT '',
  `account` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `authority` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `t_user` VALUES (0,'tom','tom','tom',1),(1495852626527,'nancysss','nancy','nancy',0),(1496215868322,'jim','jim','jim',0);

create table `t_dept`(
	`id` bigint(20) primary key not null default 0,
	`name` varchar(50) not null default ''
);
alter table t_user add column dept_id bigint(20)  after id;
