/*
Navicat MySQL Data Transfer

Source Server         : Demo1
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ssh_employee

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-17 18:01:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `DeptId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `DDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DeptId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', 'HR', 'DeptOfHumanResource');
INSERT INTO `t_department` VALUES ('2', 'IT', 'InformationTechnology');
INSERT INTO `t_department` VALUES ('3', 'OP', 'Operation');
INSERT INTO `t_department` VALUES ('4', 'Canteen', 'Food');
INSERT INTO `t_department` VALUES ('5', 'Security', 'Security');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `Eid` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `ENo` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Birthday` datetime DEFAULT NULL,
  `DayOfHired` datetime DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `DeptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Eid`),
  KEY `FKeb0axav9pjbg5lbxxdcupj7r0` (`DeptId`),
  CONSTRAINT `FKeb0axav9pjbg5lbxxdcupj7r0` FOREIGN KEY (`DeptId`) REFERENCES `t_department` (`DeptId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', 'Tony', '1', 'Male', '2017-12-15 00:00:00', '2017-12-15 00:00:00', 'Tony', '123', '2');
INSERT INTO `t_employee` VALUES ('3', 'Jenny', '2', 'Female', '2017-12-15 00:00:00', '2017-12-15 00:00:00', 'Jenny', '111', '1');
INSERT INTO `t_employee` VALUES ('4', 'Yoon', '3', 'Female', '2017-11-15 00:00:00', '2017-12-20 00:00:00', 'Yoon', '111', '4');
INSERT INTO `t_employee` VALUES ('6', 'Yuen', '6', 'Male', '1995-02-03 00:00:00', '2017-03-04 00:00:00', 'Yuen', '111', '2');
