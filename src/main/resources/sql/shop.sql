/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-04-11 21:28:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('4', '盛邦推出甲醇专用锅炉', '以甲醇为代表的醇基燃料相比于目前供给紧缺的石油、天然气等石化燃料资源，具备原料分布广、再生快、数量巨大等特点而在我国显出明显优势。在这一点上，我国醇基燃料行业的发展前景是非常广阔的。\r\n      近几十年来，人们对大自然的资源进行不断改造和掠夺，导致了各种各样的环境污染、资源枯竭、气候反常、生态破坏等全球性的危机，传统的“三高”（高投入、高消耗、高回报）工业发展模式根本不能持续。在人们饱受雾霾等环境污染的折磨后，公众对环境保护和节能减排的关注日益升温。人们开始寻找各种方法与大自然和谐相处。醇基燃料应运而生，成为节能燃料的代表，醇基燃料符合国家的政策要求，醇基燃料符合人们的价值观念。\r\n       醇基燃料目前的市场良莠不齐，事实上，真正拥有醇基燃料好技术的企业或团队真的不多，泰安盛邦锅炉设备有限公司，不仅在醇基燃料技术上和他人合作，而且也在醇基燃料的锅炉设计上进行了持续的优化改进。\r\n       欢迎有兴趣的客户直接在商城内搜索“甲醇锅炉”或者直接致电：400-113-8028，我们将竭诚为您服务。', '刘志刚', '2017-04-10 16:42:51');
INSERT INTO `article` VALUES ('5', '西安重污染天气Ⅰ级响应 20蒸吨以下燃煤锅炉全停用', '针对启动的重污染天气一级响应，西安全市已经有多家重点大气污染源企业限产。其中，3户大气类污染源关闭了部分生产线，减排50%以上，另外，五个县区的8家水泥粉磨企业均已停产。\r\n　　西安市重污染天气应急指挥部工作人员孙宇：“全市的20蒸吨以下燃煤锅炉全部停用，20蒸吨以上的燃煤锅炉要求全部燃用优质燃煤，来降低污染负荷，同时减排50%以上，然后扬尘方面是（西安）市1047家建设工地，26个渣土消纳场以及173处商混站也全部都是停工。”', '刘志刚', '2017-04-05 16:43:46');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `num` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('2', '测试', '20', '20', '1', 'hello');
INSERT INTO `commodity` VALUES ('5', 'test', '20', '10', '1', '测试');
INSERT INTO `commodity` VALUES ('6', 'jijie', '1000', '1000', '3', '12345');
INSERT INTO `commodity` VALUES ('7', '3456', '1013', '997', '5', '5677');
INSERT INTO `commodity` VALUES ('8', '全自动温控热风炉用于鸡棚猪圈烘干中药花圃车间供暖燃气热风锅炉 举报', '100000', '100000', '3', '热风炉\n适用于鸡棚、猪圈以及其他畜牧养殖场的室内干燥通风，也适用于烘干金银花等中草药和苗圃花圃以及大面积车间的供暖。\n本公司生产的“金山口”系列热风炉能够实现全自动温控，操作简单，热效率高。\n欢迎致电本公司官方热线400-113-8028进行洽谈交流。\n');

-- ----------------------------
-- Table structure for pictuer
-- ----------------------------
DROP TABLE IF EXISTS `pictuer`;
CREATE TABLE `pictuer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cId` int(11) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pictuer
-- ----------------------------

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
