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

 Date: 29/11/2018 01:14:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for measurement
-- ----------------------------
DROP TABLE IF EXISTS `measurement`;
CREATE TABLE `measurement`  (
  `mobile` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `item` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `measurement` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of measurement
-- ----------------------------
INSERT INTO `measurement` VALUES ('8524569512', 'kamiz', 'l=5m  b=2m');
INSERT INTO `measurement` VALUES ('7539514862', 'pant', 'l=5m  b=2m h=6ft');
INSERT INTO `measurement` VALUES ('9632587415', 'kurta', 'l=5m  b=2m h=9ft');
INSERT INTO `measurement` VALUES ('9632587415', 'pajama', 'l=5m, h=9ft');
INSERT INTO `measurement` VALUES ('84672569465', 'lehanga', '79 m');

SET FOREIGN_KEY_CHECKS = 1;
