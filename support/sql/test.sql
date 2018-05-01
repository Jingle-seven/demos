-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.12-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 test 的数据库结构
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  表 test.courses 结构
DROP TABLE IF EXISTS `courses`;
CREATE TABLE IF NOT EXISTS `courses` (
  `cno` varchar(5) NOT NULL,
  `cname` varchar(10) NOT NULL,
  `tno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.courses 的数据：~4 rows (大约)
DELETE FROM `courses`;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`cno`, `cname`, `tno`) VALUES
	('3-105', '计算机导论', '825'),
	('3-245', '操作系统', '804'),
	('6-166', '数据电路', '856'),
	('9-888', '高等数学', '100');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;

-- 导出  表 test.grade 结构
DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `low` int(3) DEFAULT NULL,
  `upp` int(3) DEFAULT NULL,
  `rank` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.grade 的数据：~5 rows (大约)
DELETE FROM `grade`;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` (`low`, `upp`, `rank`) VALUES
	(90, 100, 'A'),
	(80, 89, 'B'),
	(70, 79, 'C'),
	(60, 69, 'D'),
	(0, 59, 'E');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;

-- 导出  表 test.scores 结构
DROP TABLE IF EXISTS `scores`;
CREATE TABLE IF NOT EXISTS `scores` (
  `sno` varchar(3) NOT NULL,
  `cno` varchar(5) NOT NULL,
  `degree` decimal(10,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.scores 的数据：~12 rows (大约)
DELETE FROM `scores`;
/*!40000 ALTER TABLE `scores` DISABLE KEYS */;
INSERT INTO `scores` (`sno`, `cno`, `degree`) VALUES
	('103', '3-245', 86.0),
	('105', '3-245', 75.0),
	('109', '3-245', 68.0),
	('103', '3-105', 92.0),
	('105', '3-105', 88.0),
	('109', '3-105', 76.0),
	('101', '3-105', 64.0),
	('107', '3-105', 91.0),
	('108', '3-105', 78.0),
	('101', '6-166', 85.0),
	('107', '6-106', 79.0),
	('108', '6-166', 81.0);
/*!40000 ALTER TABLE `scores` ENABLE KEYS */;

-- 导出  表 test.students 结构
DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `sno` varchar(3) NOT NULL,
  `sname` varchar(4) NOT NULL,
  `ssex` varchar(2) NOT NULL,
  `sbirthday` datetime DEFAULT NULL,
  `class` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.students 的数据：~6 rows (大约)
DELETE FROM `students`;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`sno`, `sname`, `ssex`, `sbirthday`, `class`) VALUES
	('108', '曾华', '男', '1977-09-01 00:00:00', '95033'),
	('105', '匡明', '男', '1975-10-02 00:00:00', '95031'),
	('107', '王丽', '女', '1976-01-23 00:00:00', '95033'),
	('101', '李军', '男', '1976-02-20 00:00:00', '95033'),
	('109', '王芳', '女', '1975-02-10 00:00:00', '95031'),
	('103', '陆君', '男', '1974-06-03 00:00:00', '95031');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

-- 导出  表 test.teachers 结构
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE IF NOT EXISTS `teachers` (
  `tno` varchar(3) NOT NULL,
  `tname` varchar(4) NOT NULL,
  `tsex` varchar(2) NOT NULL,
  `tbirthday` datetime NOT NULL,
  `prof` varchar(6) DEFAULT NULL,
  `depart` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.teachers 的数据：~4 rows (大约)
DELETE FROM `teachers`;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` (`tno`, `tname`, `tsex`, `tbirthday`, `prof`, `depart`) VALUES
	('804', '李诚', '男', '1958-12-02 00:00:00', '副教授', '计算机系'),
	('856', '张旭', '男', '1969-03-12 00:00:00', '讲师', '电子工程系'),
	('825', '王萍', '女', '1972-05-05 00:00:00', '助教', '计算机系'),
	('831', '刘冰', '女', '1977-08-14 00:00:00', '助教', '电子工程系');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;

-- 导出  表 test.t_book 结构
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE IF NOT EXISTS `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  test.t_book 的数据：~3 rows (大约)
DELETE FROM `t_book`;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
INSERT INTO `t_book` (`id`, `author`, `name`) VALUES
	(0, 2, '围城'),
	(1, 99, '平凡的世界'),
	(2, 1, '活着');
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;

-- 导出  表 test.t_user 结构
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `ts` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  test.t_user 的数据：~6 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `name`, `ts`) VALUES
	(1, 'Tom', 1),
	(2, 'Nancy', 1),
	(3, 'jack', 2),
	(4, 'rose', 1478519215),
	(11, 'Bob', 1478519662),
	(12, 'Jimmy', 1478519662);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
