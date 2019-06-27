/*
 Navicat Premium Data Transfer

 Source Server         : BCE
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost:3306
 Source Schema         : javatailorproject

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : 65001

 Date: 29/11/2018 01:14:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customerprofile
-- ----------------------------
DROP TABLE IF EXISTS `customerprofile`;
CREATE TABLE `customerprofile`  (
  `mobile` varchar(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mobile`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customerprofile
-- ----------------------------
INSERT INTO `customerprofile` VALUES ('6874591235', 'honey', 'mac street', 'chandigarh', 'female');
INSERT INTO `customerprofile` VALUES ('7009287725', 'tinku', 'pbi', 'patiala', 'male');
INSERT INTO `customerprofile` VALUES ('7837608697', 'harjass', 'jassi chowk', 'jassi', 'female');
INSERT INTO `customerprofile` VALUES ('8146184801', 'jashandeep singh', 'thana road', 'maur mandi', 'male');
INSERT INTO `customerprofile` VALUES ('9872285829', 'zyn', 'back street', 'london', 'male');

SET FOREIGN_KEY_CHECKS = 1;
