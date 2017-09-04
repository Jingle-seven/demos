-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.12-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 butler 的数据库结构
CREATE DATABASE IF NOT EXISTS `butler` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `butler`;

-- 导出  表 butler.asset 结构
CREATE TABLE IF NOT EXISTS `asset` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `sn` varchar(255) NOT NULL DEFAULT '',
  `number` varchar(255) NOT NULL DEFAULT '0',
  `type_id` bigint(20) NOT NULL DEFAULT '0',
  `asset_type_id` bigint(20) NOT NULL DEFAULT '0',
  `brand_id` bigint(20) NOT NULL DEFAULT '0',
  `model` varchar(255) NOT NULL DEFAULT '',
  `info` varchar(255) NOT NULL DEFAULT '',
  `power` bigint(20) NOT NULL DEFAULT '0',
  `manage_info` varchar(255) NOT NULL DEFAULT '',
  `remark` varchar(255) NOT NULL DEFAULT '',
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `owner_id` bigint(20) NOT NULL DEFAULT '0',
  `cabinet_id` bigint(20) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL DEFAULT '0',
  `is_expired` tinyint(4) DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sn` (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.asset 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` (`id`, `sn`, `number`, `type_id`, `asset_type_id`, `brand_id`, `model`, `info`, `power`, `manage_info`, `remark`, `user_id`, `owner_id`, `cabinet_id`, `create_time`, `update_time`, `start_time`, `expired_time`, `is_expired`, `status`) VALUES
	(1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 250, 'root/z', 'fine', 1, 2, 1, 0, 1502433796029, 140, 150, 0, '0'),
	(2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 500, 'root/z', '很好', 1, 2, 1, 1498632796099, 1502433815915, 146, 154, 0, '0'),
	(3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 2400, 'root/z', '很好', 3, 2, 1, 1498632897210, 1498634408529, 148, 166, 0, '0'),
	(1502766785400711, '592', '234234', 3, 1, 2, 'MS-86', '八天线', 2000, 'root/z', '很好', 2, 2, 2, 1502766785400, 1502766785400, 151, 173, 0, '0');
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;

-- 导出  表 butler.asset_history 结构
CREATE TABLE IF NOT EXISTS `asset_history` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `asset_id` bigint(20) NOT NULL DEFAULT '0',
  `sn` varchar(255) NOT NULL DEFAULT '',
  `number` varchar(255) NOT NULL DEFAULT '0',
  `type_id` bigint(20) NOT NULL DEFAULT '0',
  `asset_type_id` bigint(20) NOT NULL DEFAULT '0',
  `brand_id` bigint(20) NOT NULL DEFAULT '0',
  `model` varchar(255) NOT NULL DEFAULT '',
  `info` varchar(255) NOT NULL DEFAULT '',
  `power` bigint(20) NOT NULL DEFAULT '0',
  `manage_info` varchar(255) NOT NULL DEFAULT '',
  `remark` varchar(255) NOT NULL DEFAULT '',
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `owner_id` bigint(20) NOT NULL DEFAULT '0',
  `cabinet_id` bigint(20) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL DEFAULT '0',
  `status` varchar(255) NOT NULL DEFAULT '0',
  `operation` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.asset_history 的数据：~84 rows (大约)
/*!40000 ALTER TABLE `asset_history` DISABLE KEYS */;
INSERT INTO `asset_history` (`id`, `asset_id`, `sn`, `number`, `type_id`, `asset_type_id`, `brand_id`, `model`, `info`, `power`, `manage_info`, `remark`, `user_id`, `owner_id`, `cabinet_id`, `create_time`, `update_time`, `start_time`, `expired_time`, `status`, `operation`) VALUES
	(15036500311730, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 1, 1498632897210, 1498634408529, 147, 166, '0', 'update'),
	(150165725266824, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 3, 2, 2, 0, 1501657252000, 0, 145, '0', 'update'),
	(150243381541984, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1498632796099, 1502433815000, 140, 150, '0', 'update'),
	(150276683895847, 1500017618179772, '34564', '23423', 1, 1, 0, 'MS-86', '64核128G内存20T硬盘', 0, '', '很好', 3, 2, 0, 1500017618179, 1502766838000, 0, 151, '0', 'delete'),
	(150276708642172, 1502766785400836, '975', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1502766785400, 1502767086000, 140, 150, '0', 'delete'),
	(150278140954810, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 0, 0, 1502781409000, 140, 150, '0', 'update'),
	(150364165633181, 1502766785400711, '592', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 2, 2, 2, 1502766785400, 1502766785400, 151, 173, '0', 'update'),
	(1501211300439269, 1500017618179772, '34564', '23423', 1, 1, 0, 'MS-86', '64核128G内存20T硬盘', 0, '', '很好', 3, 2, 0, 1500017618179, 1501211300000, 0, 151, '0', 'update'),
	(1501211300630636, 1500017618179772, '34564', '23423', 1, 1, 0, 'MS-86', '64核128G内存20T硬盘', 0, '', '很好', 3, 2, 0, 1500017618179, 1501211300000, 0, 151, '0', 'super update'),
	(1501226871551344, 1501226871098158, '311', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1501226871098, 1501226871000, 0, 145, '0', 'insert'),
	(1501226871572022, 1501226871098648, '351', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 1, 0, 1501226871099, 1501226871000, 0, 146, '1', 'insert'),
	(1501230190835376, 1501226871098158, '311', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1501226871098, 1501230190000, 0, 145, '0', 'delete'),
	(1501230191284971, 1501226871098648, '351', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 1, 0, 1501226871099, 1501230191000, 0, 146, '1', 'delete'),
	(1501485050243607, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1501485050000, 0, 145, '0', 'update'),
	(1501485351764943, 1501485351459585, '350', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1501485351459, 1501485351000, 0, 145, '0', 'insert'),
	(1501485351788786, 1501485351459190, '468', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 1, 0, 1501485351459, 1501485351000, 0, 146, '1', 'insert'),
	(1501485500325435, 1501485351459190, '468', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 1, 0, 1501485351459, 1501485500000, 0, 146, '1', 'delete'),
	(1501485500896356, 1501485351459585, '350', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1501485351459, 1501485500000, 0, 145, '0', 'delete'),
	(1501485819274854, 1501485819557055, '93', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1501485819557, 1501485819000, 0, 145, '0', 'insert'),
	(1501485819458022, 1501485819557936, '570', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 1, 0, 1501485819557, 1501485819000, 0, 146, '1', 'insert'),
	(1501488334505475, 1501485819557936, '570', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 1, 0, 1501485819557, 1501488334000, 0, 146, '1', 'update'),
	(1501488382675102, 1501485819557936, '570', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 1, 0, 1501485819557, 1501488382000, 0, 146, '1', 'delete'),
	(1501488382838305, 1501485819557055, '93', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1501485819557, 1501488382000, 0, 145, '0', 'delete'),
	(1501488389860596, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501488389000, 0, 146, '1', 'update'),
	(1501488468277674, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501488468000, 0, 146, '1', 'update'),
	(1501657252287950, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 3, 2, 0, 1498632796099, 1501657252000, 0, 146, '5', 'update'),
	(1501657252365508, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 3, 2, 2, 0, 1501657252000, 0, 145, '5', 'update'),
	(1501657252513196, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 3, 2, 0, 1498632796099, 1501657252000, 0, 146, '1', 'update'),
	(1501657300157105, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501657300000, 140, 150, '0', 'update'),
	(1501657300231772, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1501657300000, 0, 145, '0', 'update'),
	(1501657300314612, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1501657300000, 140, 145, '0', 'update'),
	(1501657300343228, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1501657300000, 0, 145, '5', 'update'),
	(1501657300601985, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501657300000, 0, 146, '0', 'update'),
	(1501657300767104, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501657300000, 140, 146, '0', 'update'),
	(1501657300852291, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501657300000, 0, 146, '5', 'update'),
	(1501657300891683, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1501657300000, 140, 150, '0', 'update'),
	(1501663522155728, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501663522000, 140, 150, '0', 'update'),
	(1501663522394025, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1501663522000, 140, 150, '0', 'update'),
	(1501664000515656, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1501664000000, 140, 150, '0', 'update'),
	(1501664000596568, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1501664000000, 140, 150, '0', 'update'),
	(1502347855617377, 1502347842987921, 'sn码2', '资产号', 0, 0, 0, '型号', '硬件配置', 0, '', '备注', 0, 0, 0, 1502347842988, 1502347855000, 0, 9701666828495, '0', 'insert'),
	(1502433796239535, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 0, 1502433796000, 140, 150, '0', 'update'),
	(1502760657267771, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 3, 1498632897210, 1502760657000, 0, 153, '0', 'update'),
	(1502760657280161, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 3, 0, 1502760657000, 140, 150, '0', 'update'),
	(1502760657421651, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 3, 1498632796099, 1502760657000, 140, 150, '0', 'update'),
	(1502761026197329, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 0, 1502761026000, 140, 150, '0', 'update'),
	(1502761026819403, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 2, 1498632796099, 1502761026000, 140, 150, '0', 'update'),
	(1502766691239449, 1502766691385244, '709', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 2, 1502766691385, 1502766691000, 140, 150, '0', 'insert'),
	(1502766691884399, 1502766691385461, '103', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1502766691385, 1502766691000, 140, 150, '0', 'insert'),
	(1502766762530993, 1502766691385244, '709', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 2, 1502766691385, 1502766762000, 140, 150, '0', 'delete'),
	(1502766762737765, 1502766691385461, '103', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1502766691385, 1502766762000, 140, 150, '0', 'delete'),
	(1502766785107750, 1502766785400836, '975', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 2, 1502766785400, 1502766785000, 140, 150, '0', 'insert'),
	(1502766785938693, 1502766785400711, '592', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 2, 1502766785400, 1502766785000, 140, 150, '0', 'insert'),
	(1502766838265943, 1502347842987921, 'sn码2', '资产号', 0, 0, 0, '型号', '硬件配置', 0, '', '备注', 0, 0, 0, 1502347842988, 1502766838000, 0, 9701666828495, '0', 'delete'),
	(1502767041492004, 1502767041118676, '919', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1502767041118, 1502767041000, 140, 150, '0', 'insert'),
	(1502767041504060, 1502767041118276, '304', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1502767041118, 1502767041000, 140, 150, '0', 'insert'),
	(1502767041651986, 1502767041118047, '938', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 1502767041118, 1502767041000, 140, 150, '0', 'insert'),
	(1502767041922643, 1502767041115649, '687', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 1502767041115, 1502767041000, 140, 150, '0', 'insert'),
	(1502767086413034, 1502767041115649, '687', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 1502767041115, 1502767086000, 140, 150, '0', 'delete'),
	(1502767086454169, 1502767041118276, '304', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1502767041118, 1502767086000, 140, 150, '0', 'delete'),
	(1502767086454884, 1502767041118676, '919', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1502767041118, 1502767086000, 140, 150, '0', 'delete'),
	(1502767086938654, 1502767041118047, '938', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 1502767041118, 1502767086000, 140, 150, '0', 'delete'),
	(1502767107790881, 1502767107725012, '109', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 1502767107725, 1502767107000, 140, 150, '0', 'insert'),
	(1502767107837343, 1502767107727190, '187', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1502767107727, 1502767107000, 140, 150, '0', 'insert'),
	(1502767107841997, 1502767107727553, '142', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1502767107727, 1502767107000, 140, 150, '0', 'insert'),
	(1502781229312229, 1502767107727190, '187', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1502767107727, 1502781229000, 140, 150, '0', 'update'),
	(1502781229572980, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1498632796099, 1502781229000, 140, 150, '0', 'update'),
	(1502781229591043, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 1, 1498632897210, 1502781229000, 0, 153, '0', 'update'),
	(1502781229607406, 1502767107725012, '109', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 0, 1502767107725, 1502781229000, 140, 150, '0', 'update'),
	(1502781229738928, 1502767107727553, '142', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1502767107727, 1502781229000, 140, 150, '0', 'update'),
	(1502781229757953, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 0, 1502781229000, 140, 150, '0', 'update'),
	(1502781245189319, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1498632796099, 1502781245000, 140, 150, '0', 'update'),
	(1502781245236275, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 0, 0, 1502781245000, 140, 150, '0', 'update'),
	(1502781245332410, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 0, 1498632897210, 1502781245000, 0, 153, '0', 'update'),
	(1502781245408247, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1502781245000, 140, 150, '0', 'update'),
	(1502781245437310, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 0, 1502781245000, 140, 150, '0', 'update'),
	(1502781333655773, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 0, 0, 1502781333000, 140, 150, '0', 'update'),
	(1502781333767791, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1498632796099, 1502781333000, 140, 150, '0', 'update'),
	(1502781333871637, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 0, 1502781333000, 140, 150, '0', 'update'),
	(1502781409131272, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1498632796099, 1502781409000, 140, 150, '0', 'update'),
	(1502781409659140, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 1, 0, 1502781409000, 140, 150, '0', 'update'),
	(1502781409678938, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 1, 1498632897210, 1502781409000, 0, 153, '0', 'update'),
	(1502850756437916, 1502767107727190, '187', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1502767107727, 1502850756000, 140, 150, '0', 'delete'),
	(1502850756519263, 1502767107725012, '109', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', '', 1, 2, 0, 1502767107725, 1502850756000, 140, 150, '0', 'delete'),
	(1502850756631791, 1502767107727553, '142', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 0, 1502767107727, 1502850756000, 140, 150, '0', 'delete'),
	(1502850765845207, 1502766785400711, '592', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 2, 2, 2, 1502766785400, 1502850765000, 140, 150, '0', 'update'),
	(1503641619544442, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1498632796099, 1502433815915, 146, 150, '0', 'update'),
	(1503641626790218, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 1, 1498632897210, 1498634408529, 147, 153, '0', 'update'),
	(1503641633317763, 1502766785400711, '592', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 2, 2, 2, 1502766785400, 1502766785400, 151, 150, '0', 'update'),
	(1503641647218165, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1498632796099, 1502433815915, 146, 154, '0', 'update'),
	(1503641651137535, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 1, 1498632897210, 1498634408529, 147, 165, '0', 'update'),
	(1503650036979566, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 0, '', '很好', 3, 2, 1, 1498632897210, 1498634408529, 148, 166, '0', 'update'),
	(1504173572629710, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', 'fine', 1, 2, 1, 0, 1502433796029, 140, 150, '0', 'update'),
	(1504173685420078, 1504173685536045, '537', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', 'fine', 1, 2, 1, 1504173685536, 1504173685536, 140, 150, '0', 'insert'),
	(1504173685745737, 1504173685540769, '787', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1504173685540, 1504173685540, 146, 154, '0', 'insert'),
	(1504173697173522, 1504173685540769, '787', '234234', 3, 1, 2, 'MS-86', '八天线', 0, '', '很好', 1, 2, 1, 1504173685540, 1504173685540, 146, 154, '0', 'delete'),
	(1504173697212530, 1504173685536045, '537', '1', 1, 1, 0, 'MS-5289', '三核CPU', 0, '', 'fine', 1, 2, 1, 1504173685536, 1504173685536, 140, 150, '0', 'delete'),
	(1504229018875555, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 250, '', 'fine', 1, 2, 1, 0, 1502433796029, 140, 150, '0', 'update'),
	(1504229021257372, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 500, '', '很好', 1, 2, 1, 1498632796099, 1502433815915, 146, 154, '0', 'update'),
	(1504229027660198, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 2400, '', '很好', 3, 2, 1, 1498632897210, 1498634408529, 148, 166, '0', 'update'),
	(1504229033528873, 1502766785400711, '592', '234234', 3, 1, 2, 'MS-86', '八天线', 2000, '', '很好', 2, 2, 2, 1502766785400, 1502766785400, 151, 173, '0', 'update'),
	(1504229046663771, 1, '234', '1', 1, 1, 0, 'MS-5289', '三核CPU', 250, 'root/z', 'fine', 1, 2, 1, 0, 1502433796029, 140, 150, '0', 'update'),
	(1504229052732237, 2, '4325', '234234', 3, 1, 2, 'MS-86', '八天线', 500, 'root/z', '很好', 1, 2, 1, 1498632796099, 1502433815915, 146, 154, '0', 'update'),
	(1504229057669874, 3, '23452', '542', 1, 0, 0, 'MS-86', '双核CPU', 2400, 'root/z', '很好', 3, 2, 1, 1498632897210, 1498634408529, 148, 166, '0', 'update'),
	(1504229063152660, 1502766785400711, '592', '234234', 3, 1, 2, 'MS-86', '八天线', 2000, 'root/z', '很好', 2, 2, 2, 1502766785400, 1502766785400, 151, 173, '0', 'update');
/*!40000 ALTER TABLE `asset_history` ENABLE KEYS */;

-- 导出  表 butler.asset_user 结构
CREATE TABLE IF NOT EXISTS `asset_user` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(10) NOT NULL DEFAULT '',
  `account` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `authority` tinyint(3) NOT NULL DEFAULT '0',
  `department` varchar(50) NOT NULL DEFAULT '',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.asset_user 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `asset_user` DISABLE KEYS */;
INSERT INTO `asset_user` (`id`, `name`, `account`, `password`, `authority`, `department`, `create_time`, `update_time`, `status`) VALUES
	(1, 'tom', 'tom', 'tom', 1, 'IT部', 0, 0, ''),
	(2, 'nancy', 'nancy', 'nancy', 0, '董事会', 0, 0, ''),
	(3, 'Jim', 'Jim', 'jim', 0, '财务部', 1499390959550, 1499390959550, ''),
	(1502074854107018, 'Alice', 'Alice@qq.com', '***', 0, 'IT部', 1502074854107, 1502074854107, ''),
	(1502074854107565, 'Bob', 'Bob@qq.com', '***', 1, 'IT部', 1502074854107, 1502074854107, '');
/*!40000 ALTER TABLE `asset_user` ENABLE KEYS */;

-- 导出  表 butler.ip_history 结构
CREATE TABLE IF NOT EXISTS `ip_history` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `ip_id` bigint(20) NOT NULL DEFAULT '0',
  `ip` varchar(255) NOT NULL DEFAULT '',
  `asset_id` bigint(20) NOT NULL DEFAULT '0',
  `vm_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL DEFAULT '0',
  `is_expired` tinyint(4) DEFAULT '0',
  `status` varchar(255) NOT NULL DEFAULT '0',
  `operation` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.ip_history 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `ip_history` DISABLE KEYS */;
INSERT INTO `ip_history` (`id`, `ip_id`, `ip`, `asset_id`, `vm_id`, `user_id`, `create_time`, `update_time`, `start_time`, `expired_time`, `is_expired`, `status`, `operation`) VALUES
	(15036429869695, 1497259305957377, '127.0.0.2', 1, 0, 1, 161, 1497259305957, 145, 151, 0, '1', 'update'),
	(150339076121258, 12334123452315345, '127.0.0.10', 1, 1, 0, 0, 0, 0, 0, 0, '0', 'update'),
	(150339077014855, 1497259305957377, '127.0.0.2', 1, 3, 1, 1497259305949, 1497259305957, 0, 151, 1, '1', 'update'),
	(150339078866884, 12334123452315345, '127.0.0.10', 1, 1, 0, 0, 0, 0, 0, 0, '0', 'delete'),
	(150339403541116, 1498188174351325, '127.0.1.9', 1498632897210454, 3, 3, 1498188174351, 1498188174351, 0, 1234123423, 0, '0', 'update'),
	(150339425062425, 1498188174351325, '127.0.1.9', 1498632897210454, 0, 3, 1498188174351, 1498188174351, 0, 1234123423, 0, '0', 'update'),
	(150364262974902, 1497259305957377, '127.0.0.2', 1, 0, 1, 161, 1497259305957, 0, 151, 1, '1', 'update'),
	(1503390741616420, 12334123452315345, '127.0.0.10', 1, NULL, 0, 0, 0, 0, 0, 0, '0', 'insert'),
	(1503390765257030, 1, '127.0.0.3', 1, 1, 3, 1455, 14666, 0, 150, 0, '1', 'update'),
	(1503390767221377, 3, '192.168.0.3', 1, 2, 3, 142, 143, 0, 145, 0, '1', 'update'),
	(1503390769335797, 1497259305949759, '127.0.0.1', 1502347842987921, 2, 3, 1497259305949, 1497259305949, 140, 150, 0, '1', 'update'),
	(1503393821234271, 1497259305957377, '127.0.0.2', 1, 0, 1, 1497259305949, 1497259305957, 0, 151, 1, '1', 'update'),
	(1503394035720502, 1498188174349098, '127.0.1.8', 1498632897210454, 3, 0, 1498188174349, 1498188174349, 0, 1234123423, 0, '0', 'update'),
	(1503394250137281, 1498188174349098, '127.0.1.8', 1498632897210454, 0, 0, 1498188174349, 1498188174349, 0, 1234123423, 0, '0', 'update'),
	(1503394250900285, 1498188174349098, '127.0.1.8', 1498632897210454, 3, 0, 1498188174349, 1498188174349, 0, 1234123423, 0, '0', 'update'),
	(1503394285629238, 1498188174349098, '127.0.1.8', 1498632897210454, 0, 0, 1498188174349, 1498188174349, 0, 1234123423, 0, '0', 'update'),
	(1503394285903242, 1498188174347497, '127.0.1.6', 1498632796099286, 3, 0, 1498188174347, 1498188174347, 0, 1234123423, 0, '0', 'update'),
	(1503394681102415, 3, '192.168.0.3', 1, 0, 3, 142, 143, 0, 145, 0, '1', 'update'),
	(1503394681165143, 1497259305949759, '127.0.0.1', 1502347842987921, 0, 3, 1497259305949, 1497259305949, 140, 150, 0, '1', 'update'),
	(1503457803581924, 1498188174351325, '127.0.1.9', 1498632897210454, 1503457803621371, 3, 1498188174351, 1498188174351, 0, 1234123423, 0, '0', 'update'),
	(1503457879238366, 1498188174351325, '127.0.1.9', 1498632897210454, 1503457879169528, 3, 1498188174351, 1498188174351, 0, 1234123423, 0, '0', 'update'),
	(1503457879519506, 1498188174349098, '127.0.1.8', 1498632897210454, 1503457879169528, 0, 1498188174349, 1498188174349, 0, 1234123423, 0, '0', 'update'),
	(1503642620753301, 3, '192.168.0.3', 1, 0, 3, 150, 143, 0, 145, 0, '1', 'update'),
	(1503642625666961, 1497259305949759, '127.0.0.1', 1502347842987921, 0, 3, 160, 1497259305949, 140, 150, 0, '1', 'update'),
	(1503642702551221, 3, '192.168.0.3', 1, 0, 3, 150, 143, 140, 145, 0, '1', 'update'),
	(1503642707467182, 1497259305957377, '127.0.0.2', 1, 0, 1, 161, 1497259305957, 145, 151, 1, '1', 'update'),
	(1503642712682248, 1498188174311629, '127.0.1.0', 1498632897210454, NULL, 1, 1498188174311, 1498188174311, 146, 152, 0, '0', 'update');
/*!40000 ALTER TABLE `ip_history` ENABLE KEYS */;

-- 导出  表 butler.ip_section 结构
CREATE TABLE IF NOT EXISTS `ip_section` (
  `id` bigint(20) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `user` bigint(20) NOT NULL,
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL,
  `remark` varchar(255) NOT NULL DEFAULT '',
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.ip_section 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `ip_section` DISABLE KEYS */;
INSERT INTO `ip_section` (`id`, `ip`, `user`, `start_time`, `expired_time`, `remark`, `status`) VALUES
	(1, '192.168.0.1-192.168.0.128', 1, 140, 148, ' ', '-1'),
	(2, '192.168.0.128-192.168.0.192', 1, 140, 149, '', ' '),
	(3, '192.168.0.192-192.168.0.200', 2, 140, 150, '', ''),
	(1500522528438001, '1.1.1.1', 2, 140, 147, 'QWE', '');
/*!40000 ALTER TABLE `ip_section` ENABLE KEYS */;

-- 导出  表 butler.item_type 结构
CREATE TABLE IF NOT EXISTS `item_type` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `number` bigint(20) NOT NULL DEFAULT '0',
  `table_name` varchar(255) NOT NULL DEFAULT '',
  `item_name` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `comment` varchar(255) NOT NULL DEFAULT '',
  `status` varchar(255) NOT NULL DEFAULT '',
  `deletable` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.item_type 的数据：~28 rows (大约)
/*!40000 ALTER TABLE `item_type` DISABLE KEYS */;
INSERT INTO `item_type` (`id`, `number`, `table_name`, `item_name`, `title`, `comment`, `status`, `deletable`) VALUES
	(234, 0, 'asset', 'type', 'asset_type', '', '交换机', 0),
	(1451, 1, 'asset', 'type', 'asset_type', '', '服务器', 0),
	(4134, 2, 'asset', 'type', 'asset_type', '', '磁盘阵列', 0),
	(31234, 3, 'asset', 'type', 'asset_type', '', '路由器', 0),
	(42516, 0, 'asset', 'asset_type', 'asset_asset_type', '', '借用设备', 0),
	(45252, 0, 'asset', 'brand', 'asset_brand', '', '联想', 0),
	(233411, 1, 'asset', 'asset_type', 'asset_asset_type', '', '测试设备', 0),
	(327564, 2, 'asset', 'asset_type', 'asset_asset_type', '', '租用设备', 0),
	(1124234, 3, 'asset', 'asset_type', 'asset_asset_type', '', '自有设备', 0),
	(1562567, 2, 'asset', 'brand', 'asset_brand', '', '华为', 0),
	(2256513, 1, 'asset', 'brand', 'asset_brand', '', '中兴', 0),
	(3456764, 3, 'asset', 'brand', 'asset_brand', '', '英特尔', 0),
	(4573425631, 1, 'virtual_machine', 'status', 'virtual_machine_status', '', 'unavailable', 1),
	(4573456231, 2, 'virtual_machine', 'status', 'virtual_machine_status', '', 'protected', 1),
	(4573458231, 0, 'virtual_machine', 'status', 'virtual_machine_status', '', 'available', 1),
	(1500949010591, 0, 'asset', 'status', 'asset_status', '设备状态', 'available', 1),
	(1500949024836, 1, 'asset', 'status', 'asset_status', '', 'unavailable', 1),
	(1500950019018, 2, 'asset', 'status', 'asset_status', '', 'broken', 1),
	(1500950019365, 3, 'asset', 'status', 'asset_status', '', 'repairing', 1),
	(1500950019568, 4, 'asset', 'status', 'asset_status', '', 'scrapped', 1),
	(1500972561013, 0, 'pool_cabinet', 'status', 'pool_cabinet_status', '机柜状态', 'available', 1),
	(1500972561120, 1, 'pool_cabinet', 'status', 'pool_cabinet_status', '', 'unavailable', 1),
	(1500972561174, 2, 'pool_cabinet', 'status', 'pool_cabinet_status', '', 'protected', 1),
	(1500972561234, 0, 'pool_network', 'status', 'pool_network_status', 'ip状态', 'available', 1),
	(1500972561245, 1, 'pool_network', 'status', 'pool_network_status', '', 'unavailable', 1),
	(1500972561317, 2, 'pool_network', 'status', 'pool_network_status', '', 'protected', 1),
	(1500972561353, 0, 'workbench', 'status', 'workbench_status', '工作间状态', 'available', 1),
	(1500972561418, 1, 'workbench', 'status', 'workbench_status', '', 'unavailable', 1),
	(1502075395806216, 1, 'asset', 'xxx', 'asset_xxx', '', '测试', 0),
	(1502075422425437, 2, 'asset', 'xxx', 'asset_xxx', '', '测试', 0),
	(1502076033770000, 3, 'asset', 'xxx', 'asset_xxx', '', '测试', 0),
	(1502695950837135, 7, 'asset', 'brand', 'asset_brand', '', '中兴', 0);
/*!40000 ALTER TABLE `item_type` ENABLE KEYS */;

-- 导出  表 butler.operation_log 结构
CREATE TABLE IF NOT EXISTS `operation_log` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `datetime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user` varchar(255) NOT NULL DEFAULT '',
  `operation` text NOT NULL,
  `operation_sql` varchar(255) NOT NULL DEFAULT '',
  `status` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.operation_log 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `operation_log` DISABLE KEYS */;
INSERT INTO `operation_log` (`id`, `datetime`, `user`, `operation`, `operation_sql`, `status`) VALUES
	(1497251794297514, '2017-06-12 15:16:34', 'butler', 'org.springframework.dao.DuplicateKeyException: \r\n### Error updating database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 127.0.0.1 for key ip\r\n### The error may involve io.cloudins.idao.mapper.PoolNetworkMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into pool_network (id, ip, owner,  purpose, asset_id,  cabinet_id, expire_time,  create_time, update_time,  status) values (?, ?, ?,  ?, ?,  ?, ?,  ?, ?,  ?)\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 127.0.0.1 for key ip\n; SQL []; Duplicate entry 127.0.0.1 for key ip; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 127.0.0.1 for key ip', '', ''),
	(1497252773901496, '2017-06-12 15:32:54', 'butler', 'org.springframework.dao.DuplicateKeyException: \r\n### Error updating database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 127.0.0.1 for key ip\r\n### The error may involve io.cloudins.idao.mapper.PoolNetworkMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into pool_network (id, ip, owner,  purpose, asset_id,  cabinet_id, expire_time,  create_time, update_time,  status) values (?, ?, ?,  ?, ?,  ?, ?,  ?, ?,  ?)\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 127.0.0.1 for key ip\n; SQL []; Duplicate entry 127.0.0.1 for key ip; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 127.0.0.1 for key ip', '', '');
/*!40000 ALTER TABLE `operation_log` ENABLE KEYS */;

-- 导出  表 butler.pool_cabinet 结构
CREATE TABLE IF NOT EXISTS `pool_cabinet` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `create_time` bigint(20) NOT NULL,
  `update_time` bigint(20) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.pool_cabinet 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `pool_cabinet` DISABLE KEYS */;
INSERT INTO `pool_cabinet` (`id`, `number`, `location`, `create_time`, `update_time`, `status`) VALUES
	(1, '6-6-6', '研究院', 0, 1499226550641, 'avalaible'),
	(2, '6-6-4', '研究院', 0, 0, 'avalaible'),
	(3, '6-6-2', '研究院', 0, 0, '1');
/*!40000 ALTER TABLE `pool_cabinet` ENABLE KEYS */;

-- 导出  表 butler.pool_network 结构
CREATE TABLE IF NOT EXISTS `pool_network` (
  `id` bigint(20) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `asset_id` bigint(20) NOT NULL,
  `vm_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL,
  `create_time` bigint(20) NOT NULL,
  `update_time` bigint(20) NOT NULL,
  `is_expired` tinyint(4) DEFAULT '0',
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ip` (`ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.pool_network 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `pool_network` DISABLE KEYS */;
INSERT INTO `pool_network` (`id`, `ip`, `asset_id`, `vm_id`, `user_id`, `start_time`, `expired_time`, `create_time`, `update_time`, `is_expired`, `status`) VALUES
	(1, '127.0.0.3', 1, 1, 3, 0, 150, 1455, 14666, 0, '1'),
	(3, '192.168.0.3', 1, 0, 3, 140, 145, 150, 143, 0, '1'),
	(1497259305949759, '127.0.0.1', 1502347842987921, 0, 3, 140, 150, 160, 1497259305949, 0, '1'),
	(1497259305957377, '127.0.0.2', 1, 0, 1, 145, 151, 161, 1497259305957, 0, '1'),
	(1498188174311629, '127.0.1.0', 1498632897210454, NULL, 1, 146, 152, 1498188174311, 1498188174311, 0, '0'),
	(1498188174329457, '127.0.1.2', 1498632796099286, NULL, 3, 0, 1234123423, 1498188174329, 1498188174329, 0, '0'),
	(1498188174341960, '127.0.1.3', 1498632796099286, NULL, 3, 0, 1234123423, 1498188174341, 1498188174341, 0, '0'),
	(1498188174345896, '127.0.1.4', 1498632796099286, NULL, 3, 0, 1234123423, 1498188174345, 1498188174345, 0, '1'),
	(1498188174346783, '127.0.1.5', 1498632796099286, NULL, 0, 0, 1234123423, 1498188174346, 1498188174346, 0, '0'),
	(1498188174347497, '127.0.1.6', 1498632796099286, 3, 0, 0, 1234123423, 1498188174347, 1498188174347, 0, '0'),
	(1498188174349098, '127.0.1.8', 1498632897210454, 1503457879169528, 0, 0, 1234123423, 1498188174349, 1498188174349, 0, '0'),
	(1498188174351325, '127.0.1.9', 1498632897210454, 1503457879169528, 3, 0, 1234123423, 1498188174351, 1498188174351, 0, '0');
/*!40000 ALTER TABLE `pool_network` ENABLE KEYS */;

-- 导出  表 butler.virtual_machine 结构
CREATE TABLE IF NOT EXISTS `virtual_machine` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT '',
  `asset_id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `info` varchar(255) NOT NULL DEFAULT '',
  `remark` varchar(255) NOT NULL DEFAULT '',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL DEFAULT '0',
  `is_expired` tinyint(4) DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.virtual_machine 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `virtual_machine` DISABLE KEYS */;
INSERT INTO `virtual_machine` (`id`, `name`, `asset_id`, `user_id`, `info`, `remark`, `create_time`, `update_time`, `start_time`, `expired_time`, `is_expired`, `status`) VALUES
	(1, '第一虚机', 2, 2, '单核4G内存', '无', 140, 140, 140, 160, 0, '1'),
	(2, '虚机第二', 1, 1, '8G内存', '', 1503027898271, 1503395101316, 145, 155, 0, '0'),
	(3, '第三虚拟机', 2, 1, '16G内存', '', 1503027951277, 1503394285836, 146, 157, 0, '0'),
	(1503457879169528, '虚机第五', 1, 1, '图形处理', '', 1503457879169, 1503457879169, 156, 178, 0, '0'),
	(1503457976461033, '虚机第五', 1, 1, '图形处理', '', 1503457976461, 1503457976461, 0, 170, 0, '0'),
	(1503458003011363, '虚机第五', 1, 1, '图形处理', '', 1503458003011, 1503458003011, 0, 170, 0, '0'),
	(1503458023183090, '虚机第五', 1, 1, '图形处理', '', 1503458023183, 1503458023183, 0, 170, 0, '0');
/*!40000 ALTER TABLE `virtual_machine` ENABLE KEYS */;

-- 导出  表 butler.vm_history 结构
CREATE TABLE IF NOT EXISTS `vm_history` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `vm_id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT '',
  `asset_id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `info` varchar(255) NOT NULL DEFAULT '',
  `remark` varchar(255) NOT NULL DEFAULT '',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL DEFAULT '0',
  `is_expired` tinyint(4) DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '0',
  `operation` varchar(50) NOT NULL DEFAULT 'butler',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.vm_history 的数据：~49 rows (大约)
/*!40000 ALTER TABLE `vm_history` DISABLE KEYS */;
INSERT INTO `vm_history` (`id`, `vm_id`, `name`, `asset_id`, `user_id`, `info`, `remark`, `create_time`, `update_time`, `start_time`, `expired_time`, `is_expired`, `status`, `operation`) VALUES
	(15033732986576, 1, '第一虚机', 1, 6, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(150337341055322, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 1, '1', 'update'),
	(150337341059514, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 1, '1', 'update'),
	(150339403544076, 3, '第三虚拟机', 2, 1, '16G内存', '', 1503027951277, 1503394035441, 0, 150, 0, '0', 'update'),
	(150345802161023, 1503458003011363, '虚机第五', 1, 1, '图形处理', '', 1503458003011, 1503458003011, 0, 170, 0, '0', 'insert'),
	(150364265996307, 1503457879169528, '虚机第五', 1, 1, '图形处理', '', 1503457879169, 1503457879169, 156, 178, 0, '0', 'update'),
	(1503282285516977, 1503282285335402, '第四虚拟机', 2, 1, '32G内存', '', 1503282285335, 140, 0, 150, 0, '0', 'insert'),
	(1503284299893386, 1503282285335402, '第四虚机改', 2, 1, '八核32G内存', '', 1503282285335, 142, 0, 150, 0, '0', 'update'),
	(1503284375831406, 1503284375401576, '第五虚机', 2, 1, '八核32G内存', '', 1503284375401, 146, 0, 150, 0, '0', 'insert'),
	(1503284408476873, 1503282285335402, '第四虚机改', 2, 1, '八核32G内存', '', 1503282285335, 147, 0, 150, 0, '0', 'delete'),
	(1503284408890145, 1503284375401576, '第五虚机', 2, 1, '八核32G内存', '', 1503284375401, 156, 0, 150, 0, '0', 'delete'),
	(1503373159457034, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 0, '0', 'update'),
	(1503373161423966, 3, '第三虚拟机', 2, 1, '16G内存', '', 1503027951277, 1503027951277, 0, 150, 0, '0', 'update'),
	(1503373298252449, 1, '第一虚机', 1, 6, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373298374529, 2, '第二虚拟机', 2, 6, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 0, '1', 'update'),
	(1503373298552784, 2, '第二虚拟机', 2, 6, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 0, '0', 'update'),
	(1503373348140991, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 0, '1', 'update'),
	(1503373348146209, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373348308073, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 1, '1', 'update'),
	(1503373348852915, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373386101739, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373386332400, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 1, '1', 'update'),
	(1503373386584477, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 0, 160, 1, '1', 'update'),
	(1503373386617166, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373410488869, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 140, 160, 1, '1', 'update'),
	(1503373410632868, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 140, 160, 1, '1', 'update'),
	(1503373410762282, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373410810504, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373410845096, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 156, 1, '1', 'update'),
	(1503373410877494, 1, '第一虚机', 1, 2, '单核4G内存', '无', 140, 140, 140, 160, 1, '1', 'update'),
	(1503373766638997, 1, '第一虚机', 2, 2, '单核4G内存', '无', 140, 140, 140, 160, 1, '1', 'update'),
	(1503373766695614, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 140, 160, 1, '1', 'update'),
	(1503387588400125, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 140, 160, 0, '1', 'update'),
	(1503387590557940, 1, '第一虚机', 2, 2, '单核4G内存', '无', 140, 140, 140, 160, 0, '1', 'update'),
	(1503387597589323, 2, '第二虚拟机', 2, 2, '8G内存', '', 1503027898271, 1503027898271, 140, 154, 0, '1', 'update'),
	(1503393950296536, 3, '第三虚拟机', 2, 1, '16G内存', '', 1503027951277, 1503393950893, 0, 150, 0, '0', 'update'),
	(1503394251314149, 3, '第三虚拟机', 2, 1, '16G内存', '', 1503027951277, 1503394251085, 0, 150, 0, '0', 'update'),
	(1503394285628498, 3, '第三虚拟机', 2, 1, '16G内存', '', 1503027951277, 1503394285836, 0, 150, 0, '0', 'update'),
	(1503394793382778, 2, '虚机第二', 1, 1, '图形处理', '', 1503027898271, 1503394793898, 0, 170, 0, '0', 'update'),
	(1503394941856686, 2, '虚机第二', 1, 1, '图形处理', '', 1503027898271, 1503394941029, 0, 170, 0, '0', 'update'),
	(1503395101374446, 2, '虚机第二', 1, 1, '图形处理', '', 1503027898271, 1503395101316, 0, 170, 0, '0', 'update'),
	(1503457803453055, 1503457803621371, '虚机第五', 1, 1, '图形处理', '', 1503457803621, 1503457803621, 0, 170, 0, '0', 'insert'),
	(1503457876481507, 1503457803621371, '虚机第五', 1, 1, '图形处理', '', 1503457803621, 1503457803621, 0, 170, 0, '0', 'delete'),
	(1503457879633311, 1503457879169528, '虚机第五', 1, 1, '图形处理', '', 1503457879169, 1503457879169, 0, 170, 0, '0', 'insert'),
	(1503457896777980, 2, '虚机第二', 1, 1, '8G内存', '', 1503027898271, 1503395101316, 0, 170, 0, '0', 'update'),
	(1503457986451457, 1503457976461033, '虚机第五', 1, 1, '图形处理', '', 1503457976461, 1503457976461, 0, 170, 0, '0', 'insert'),
	(1503458051489228, 1503458023183090, '虚机第五', 1, 1, '图形处理', '', 1503458023183, 1503458023183, 0, 170, 0, '0', 'insert'),
	(1503642640373629, 2, '虚机第二', 1, 1, '8G内存', '', 1503027898271, 1503395101316, 145, 155, 0, '0', 'update'),
	(1503642647643439, 3, '第三虚拟机', 2, 1, '16G内存', '', 1503027951277, 1503394285836, 146, 157, 0, '0', 'update');
/*!40000 ALTER TABLE `vm_history` ENABLE KEYS */;

-- 导出  表 butler.workbench 结构
CREATE TABLE IF NOT EXISTS `workbench` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.workbench 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `workbench` DISABLE KEYS */;
INSERT INTO `workbench` (`id`, `number`, `description`, `status`) VALUES
	(23423, '23413', '最大的桌子', '0'),
	(34234, '334ifp', '进门第一张桌子', '0'),
	(234534, '334', '最小的桌子', '1');
/*!40000 ALTER TABLE `workbench` ENABLE KEYS */;

-- 导出  表 butler.workbench_assignment 结构
CREATE TABLE IF NOT EXISTS `workbench_assignment` (
  `id` bigint(20) NOT NULL,
  `table_id` bigint(20) DEFAULT NULL,
  `user` bigint(20) NOT NULL,
  `start_time` bigint(20) NOT NULL DEFAULT '0',
  `expired_time` bigint(20) NOT NULL,
  `remark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  butler.workbench_assignment 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `workbench_assignment` DISABLE KEYS */;
INSERT INTO `workbench_assignment` (`id`, `table_id`, `user`, `start_time`, `expired_time`, `remark`) VALUES
	(1, 23423, 3, 140, 149, '临时用'),
	(2, 34234, 2, 140, 148, '用两周'),
	(3, 34234, 2, 140, 150, '预定三周后过来');
/*!40000 ALTER TABLE `workbench_assignment` ENABLE KEYS */;

-- 导出  触发器 butler.copy_asset_before_delete 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_asset_before_delete` BEFORE DELETE ON `asset` FOR EACH ROW BEGIN
  INSERT INTO asset_history(id,asset_id,sn,number,type_id,asset_type_id,brand_id,model,info,remark,user_id,owner_id,cabinet_id,
                            create_time,update_time,start_time,expired_time,`status`,`power`,manage_info,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    old.id,
    old.sn,
    old.number,
    old.`type_id`,
    old.asset_type_id,
    old.brand_id,
    old.model,
    old.info,
    old.remark,
    old.`user_id`,
    old.owner_id,
    old.cabinet_id,
    old.create_time,
    old.update_time,
    old.start_time,
    old.expired_time,
    old.`status`,
    old.`power`,
    old.`manage_info`,
    'delete');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_asset_before_insert 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_asset_before_insert` BEFORE INSERT ON `asset` FOR EACH ROW BEGIN
  INSERT INTO asset_history(id,asset_id,sn,number,type_id,asset_type_id,brand_id,model,info,remark,user_id,owner_id,cabinet_id,
                            create_time,update_time,start_time,expired_time,`status`,`power`,manage_info,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    new.id,
    new.sn,
    new.number,
    new.`type_id`,
    new.asset_type_id,
    new.brand_id,
    new.model,
    new.info,
    new.remark,
    new.`user_id`,
    new.owner_id,
    new.cabinet_id,
    new.create_time,
    new.update_time,
    new.start_time,
    new.expired_time,
    new.`status`,
    new.`power`,
    new.`manage_info`,
    'insert');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_asset_before_update 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_asset_before_update` BEFORE UPDATE ON `asset` FOR EACH ROW BEGIN
  INSERT INTO asset_history(id,asset_id,sn,number,type_id,asset_type_id,brand_id,model,info,remark,user_id,owner_id,cabinet_id,
                            create_time,update_time,start_time,expired_time,`status`,`power`,manage_info,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    new.id,
    new.sn,
    new.number,
    new.`type_id`,
    new.asset_type_id,
    new.brand_id,
    new.model,
    new.info,
    new.remark,
    new.`user_id`,
    new.owner_id,
    new.cabinet_id,
    new.create_time,
    new.update_time,
    new.start_time,
    new.expired_time,
    new.`status`,
    new.`power`,
    new.`manage_info`,
    'update');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_ip_before_delete 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_ip_before_delete` BEFORE DELETE ON `pool_network` FOR EACH ROW BEGIN
  INSERT INTO ip_history(id,ip_id,ip,asset_id,vm_id,user_id,create_time,update_time,start_time,expired_time ,
                         is_expired,`status`,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    old.id,
    old.ip,
    old.asset_id,
    old.vm_id,
    old.user_id,
    old.create_time,
    old.update_time,
    old.start_time,
    old.expired_time,
    old.is_expired,
    old.`status`,
    'delete');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_ip_before_insert 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_ip_before_insert` BEFORE INSERT ON `pool_network` FOR EACH ROW BEGIN
  INSERT INTO ip_history(id,ip_id,ip,asset_id,vm_id,user_id,create_time,update_time,start_time,expired_time ,
                         is_expired,`status`,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    new.id,
    new.ip,
    new.asset_id,
    new.vm_id,
    new.user_id,
    new.create_time,
    new.update_time,
    new.start_time,
    new.expired_time,
    new.is_expired,
    new.`status`,
    'insert');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_ip_before_update 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_ip_before_update` BEFORE UPDATE ON `pool_network` FOR EACH ROW BEGIN
  INSERT INTO ip_history(id,ip_id,ip,asset_id,vm_id,user_id,create_time,update_time,start_time,expired_time ,
                         is_expired,`status`,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    new.id,
    new.ip,
    new.asset_id,
    new.vm_id,
    new.user_id,
    new.create_time,
    new.update_time,
    new.start_time,
    new.expired_time,
    new.is_expired,
    new.`status`,
    'update');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_vm_before_delete 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_vm_before_delete` BEFORE DELETE ON `virtual_machine` FOR EACH ROW BEGIN
  INSERT INTO vm_history(id,vm_id,name,asset_id,user_id,info,remark,
  			create_time,update_time,start_time,expired_time,is_expired,status,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    old.id,
    old.name,
    old.asset_id,
    old.user_id,
    old.info,
    old.remark,
    old.create_time,
    old.update_time,
    old.start_time,
    old.expired_time,
    old.is_expired,
    old.`status`,
    'delete');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_vm_before_insert 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_vm_before_insert` BEFORE INSERT ON `virtual_machine` FOR EACH ROW BEGIN
  INSERT INTO vm_history(id,vm_id,name,asset_id,user_id,info,remark,
  			create_time,update_time,start_time,expired_time,is_expired,status,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    new.id,
    new.name,
    new.asset_id,
    new.user_id,
    new.info,
    new.remark,
    new.create_time,
    new.update_time,
    new.start_time,
    new.expired_time,
    new.is_expired,
    new.`status`,
    'insert');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 导出  触发器 butler.copy_vm_before_update 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_vm_before_update` BEFORE UPDATE ON `virtual_machine` FOR EACH ROW BEGIN
  INSERT INTO vm_history(id,vm_id,name,asset_id,user_id,info,remark,
  			create_time,update_time,start_time,expired_time,is_expired,status,operation)
  VALUES(
    concat(unix_timestamp(),floor(rand()*1000000)),
    new.id,
    new.name,
    new.asset_id,
    new.user_id,
    new.info,
    new.remark,
    new.create_time,
    new.update_time,
    new.start_time,
    new.expired_time,
    new.is_expired,
    new.`status`,
    'update');
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
