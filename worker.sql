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

 Date: 29/11/2018 01:17:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `workername` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `address` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `experience` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `specialist` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `specializedfor` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`workername`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('chaman', 'gol market', 'mansa', '7946762649', '3 yr', 'Ladies', 'kamiz,top,lehanga,', 'working', 'C:\\Users\\Vostro 15-5568\\Pictures\\Camera Roll\\WIN_20180520_17_01_50_Pro.jpg');
INSERT INTO `worker` VALUES ('harpreet', 'gujjar nagar', 'jassi', '7953461346', '2 yr', 'Ladies', 'salwar,', 'working', 'C:\\Users\\Vostro 15-5568\\Pictures\\Camera Roll\\WIN_20180520_17_01_50_Pro.jpg');
INSERT INTO `worker` VALUES ('jashan', 'golli marker', 'maur', '7946811465', '5 yr', 'Gents', 'pant,shirt,jeans,', 'working', 'C:\\Users\\Vostro 15-5568\\Pictures\\Camera Roll\\WIN_20180524_19_53_04_Pro.jpg');
INSERT INTO `worker` VALUES ('john', 'ac market', 'bti', '7946811496', '4 yr', 'Gents', 'pant,', 'working', 'C:\\Users\\Vostro 15-5568\\Pictures\\Camera Roll\\WIN_20180524_19_52_37_Pro.jpg');
INSERT INTO `worker` VALUES ('johnny', 'johal market', 'talwandi', '7946811496', '4 yr', 'Gents', 'kurta,pajama,', 'working', 'C:\\Users\\Vostro 15-5568\\Pictures\\Camera Roll\\WIN_20180524_19_51_48_Pro.jpg');
INSERT INTO `worker` VALUES ('raman', 'kela road', 'rampura', '7896811496', '7 yr', 'Gents', 'kurta,pajama,jeans,', 'working', 'C:\\Users\\Vostro 15-5568\\Pictures\\Camera Roll\\WIN_20180524_19_51_48_Pro.jpg');
INSERT INTO `worker` VALUES ('yoy', 'hala road', 'patiala', '85496811496', '10 yr', 'Ladies', 'kurta,shirt,kamiz,top,', 'left', 'C:\\Users\\Vostro 15-5568\\Pictures\\Camera Roll\\WIN_20180524_19_51_54_Pro.jpg');

SET FOREIGN_KEY_CHECKS = 1;
