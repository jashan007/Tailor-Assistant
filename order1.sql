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

 Date: 29/11/2018 01:17:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order1
-- ----------------------------
DROP TABLE IF EXISTS `order1`;
CREATE TABLE `order1`  (
  `orderid` int(255) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `item` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `measurement` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `worker` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `quantity` int(255) NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `total` int(255) NULL DEFAULT NULL,
  `currentdate` date NULL DEFAULT NULL,
  `dod` date NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order1
-- ----------------------------
INSERT INTO `order1` VALUES (12, '8524569512', 'kamiz', 'l=5m  b=2m', 'chaman', 2, 400, 400, '2018-07-15', '2018-07-17', '1');
INSERT INTO `order1` VALUES (13, '7539514862', 'pant', 'l=5m  b=2m h=6ft', 'jashan', 4, 600, 600, '2018-07-19', '2018-07-22', '0');
INSERT INTO `order1` VALUES (14, '9632587415', 'kurta', 'l=5m  b=2m h=9ft', 'raman', 1, 600, 600, '2018-07-19', '2018-07-31', '0');
INSERT INTO `order1` VALUES (15, '9632587415', 'pajama', 'l=5m, h=9ft', 'johnny', 1, 600, 600, '2018-07-21', '2018-07-31', '0');
INSERT INTO `order1` VALUES (16, '84672569465', 'lehanga', '79 m', 'chaman', 1, 900, 900, '2018-07-18', '2018-07-19', '1');

SET FOREIGN_KEY_CHECKS = 1;
