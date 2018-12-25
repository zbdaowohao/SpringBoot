/*
Navicat MySQL Data Transfer

Source Server         : houbber_resume
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : houbber_resume

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-03 14:28:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zbdaowohao', 'winkill', 'Houbber`van', '137608422@qq.com', '18302966364', '', '');
