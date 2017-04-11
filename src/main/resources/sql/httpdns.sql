/*
Navicat MySQL Data Transfer

Source Server         : myconnection
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : httpdns

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-29 10:25:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_computer_rom
-- ----------------------------
DROP TABLE IF EXISTS `t_computer_rom`;
CREATE TABLE `t_computer_rom` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '机房名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '机房备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='机房表';

-- ----------------------------
-- Records of t_computer_rom
-- ----------------------------
INSERT INTO `t_computer_rom` VALUES ('1', '广州机房', '测试测试');
INSERT INTO `t_computer_rom` VALUES ('2', '北京机房', '测试测试');

-- ----------------------------
-- Table structure for t_constant
-- ----------------------------
DROP TABLE IF EXISTS `t_constant`;
CREATE TABLE `t_constant` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `key` varchar(30) NOT NULL COMMENT '常量名',
  `value` varchar(40) NOT NULL COMMENT '常量值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='常量表';

-- ----------------------------
-- Records of t_constant
-- ----------------------------
INSERT INTO `t_constant` VALUES ('1', 'ipExpire', '1440');
INSERT INTO `t_constant` VALUES ('2', 'cleanDataState', '0');

-- ----------------------------
-- Table structure for t_domain
-- ----------------------------
DROP TABLE IF EXISTS `t_domain`;
CREATE TABLE `t_domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `domain` varchar(50) NOT NULL COMMENT '域名',
  `type` tinyint(4) NOT NULL COMMENT '域名类型（0：预置域名，1普通域名）',
  `remark` varchar(50) DEFAULT NULL COMMENT '域名备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='域名表';

-- ----------------------------
-- Records of t_domain
-- ----------------------------
INSERT INTO `t_domain` VALUES ('1', 'watch.module.okii.com', '1', '');
INSERT INTO `t_domain` VALUES ('2', 'location.module.okii.com', '1', '');
INSERT INTO `t_domain` VALUES ('3', 'points.module.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('4', 'sport.module.watch.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('5', 'acttest.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('6', 'dns1st.watch.okii.com', '0', '预置');
INSERT INTO `t_domain` VALUES ('7', 'dns2nd.watch.okii.com', '0', '预置');
INSERT INTO `t_domain` VALUES ('8', 'account.alpha.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('9', 'static.module.watch.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('10', 'thirdparty.module.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('11', 'store.module.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('12', 'gw.module.im.okii.com', '1', null);
INSERT INTO `t_domain` VALUES ('13', 'game.module.watch.okii.com', '1', null);

-- ----------------------------
-- Table structure for t_domain_ip
-- ----------------------------
DROP TABLE IF EXISTS `t_domain_ip`;



-- ----------------------------
-- Table structure for t_ip
-- ----------------------------
DROP TABLE IF EXISTS `t_ip`;
CREATE TABLE `t_ip` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `domain_id` int(11) NOT NULL COMMENT '域名ID',
  `ip` varchar(15) NOT NULL COMMENT 'IP',
  `computer_rom` int(11) DEFAULT NULL COMMENT '机房',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='Ip表';

-- ----------------------------
-- Records of t_ip
-- ----------------------------
INSERT INTO `t_ip` VALUES ('6', '1', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('7', '2', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('8', '3', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('9', '4', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('10', '8', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('11', '10', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('12', '11', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('13', '13', '106.75.145.63', '1', null);
INSERT INTO `t_ip` VALUES ('14', '12', '113.108.235.176', '1', null);
INSERT INTO `t_ip` VALUES ('15', '12', '183.232.44.235', '1', null);
INSERT INTO `t_ip` VALUES ('16', '12', '122.13.148.176', '1', null);
INSERT INTO `t_ip` VALUES ('17', '9', '113.108.235.163', '1', null);
INSERT INTO `t_ip` VALUES ('18', '9', '122.13.148.163', '1', null);
INSERT INTO `t_ip` VALUES ('19', '9', '183.232.44.222', '1', null);
INSERT INTO `t_ip` VALUES ('20', '5', '113.108.235.135', '1', null);
INSERT INTO `t_ip` VALUES ('21', '5', '122.13.148.135', '1', null);
INSERT INTO `t_ip` VALUES ('22', '5', '183.232.44.197', '1', null);
INSERT INTO `t_ip` VALUES ('23', '6', '106.75.37.182', '1', null);
INSERT INTO `t_ip` VALUES ('24', '7', '106.75.129.159', '1', null);

-- ----------------------------
-- Table structure for t_server_trouble
-- ----------------------------
DROP TABLE IF EXISTS `t_server_trouble`;
CREATE TABLE `t_server_trouble` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL COMMENT '故障名称',
  `content` varchar(200) DEFAULT NULL COMMENT '故障内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '故障创建时间',
  `duration` int(11) NOT NULL COMMENT '故障预计持续时间',
  `resolve_time` datetime DEFAULT NULL COMMENT '故障解除时间',
  `resolve` tinyint(4) NOT NULL COMMENT '故障是否被解除(1:未被解除，0：已经被解除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='服务器故障表';

-- ----------------------------
-- Records of t_server_trouble
-- ----------------------------
INSERT INTO `t_server_trouble` VALUES ('1', 'errorerror', '服务器故障', '2017-03-17 19:12:54', '100', '2017-03-21 16:11:41', '0');

