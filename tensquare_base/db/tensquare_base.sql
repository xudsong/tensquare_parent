/*
Navicat MySQL Data Transfer

Source Server         : mysql-192.168.64.128
Source Server Version : 50721
Source Host           : 192.168.64.128:3306
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-01-14 17:18:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `tb_enterprise`;
CREATE TABLE `tb_enterprise` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '企业名称',
  `summary` varchar(255) DEFAULT NULL COMMENT '企业简介',
  `address` varchar(128) DEFAULT NULL COMMENT '企业地址',
  `labels` varchar(255) DEFAULT NULL COMMENT '标签列表(用逗号分隔)',
  `coordinate` varchar(64) DEFAULT NULL COMMENT '企业位置坐标(经度，纬度)',
  `ishot` varchar(12) DEFAULT NULL COMMENT '是否热门 0：非热门 1：热门',
  `logo` varchar(255) DEFAULT NULL COMMENT 'LOGO',
  `jobcount` int(11) DEFAULT NULL COMMENT '职位数',
  `url` varchar(128) DEFAULT NULL COMMENT 'URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='企业表';

-- ----------------------------
-- Table structure for tb_label
-- ----------------------------
DROP TABLE IF EXISTS `tb_label`;
CREATE TABLE `tb_label` (
  `id` varchar(64) NOT NULL,
  `labelname` varchar(64) DEFAULT NULL COMMENT '标签名称',
  `state` varchar(12) DEFAULT NULL COMMENT '状态 0：无效 1：有效',
  `count` int(11) DEFAULT NULL COMMENT '使用数量',
  `fans` int(11) DEFAULT NULL COMMENT '关注数',
  `recommend` varchar(12) DEFAULT NULL COMMENT '是否推荐 0：不推荐 1:推荐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签管理';

-- ----------------------------
-- Table structure for tb_recruit
-- ----------------------------
DROP TABLE IF EXISTS `tb_recruit`;
CREATE TABLE `tb_recruit` (
  `id` varchar(64) NOT NULL,
  `jobname` varchar(64) DEFAULT NULL COMMENT '招聘职位',
  `salary` varchar(64) DEFAULT NULL COMMENT '薪资范围',
  `condition` varchar(255) DEFAULT NULL COMMENT '经验要求',
  `education` varchar(255) DEFAULT NULL COMMENT '学历要求',
  `type` varchar(64) DEFAULT NULL COMMENT '任职方式',
  `address` varchar(128) DEFAULT NULL COMMENT '办公地址',
  `eid` varchar(64) DEFAULT NULL COMMENT '企业ID',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  `state` varchar(12) DEFAULT NULL COMMENT '状态 0：关闭 1:开启 2：推荐',
  `url` varchar(200) DEFAULT NULL COMMENT '原网址',
  `label` varchar(64) DEFAULT NULL COMMENT '标签',
  `content1` varchar(255) DEFAULT NULL COMMENT '职位描述',
  `content2` varchar(255) DEFAULT NULL COMMENT '职位要求',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='招聘信息表';
