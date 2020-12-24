/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : milktea_sql

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 25/12/2020 03:36:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comselectinfo
-- ----------------------------
DROP TABLE IF EXISTS `comselectinfo`;
CREATE TABLE `comselectinfo`  (
  `OrderID` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Number` int(11) NULL DEFAULT 1,
  `Description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Price` decimal(6, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`OrderID`, `id`) USING BTREE,
  INDEX `Fk_id`(`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comselectinfo
-- ----------------------------
INSERT INTO `comselectinfo` VALUES ('1', '0012', 1, '标准糖,正常冰', 23.00);
INSERT INTO `comselectinfo` VALUES ('1', '0003', 1, '标准糖,正常冰', 20.00);
INSERT INTO `comselectinfo` VALUES ('2', '0010', 1, '标准糖,正常冰', 32.00);
INSERT INTO `comselectinfo` VALUES ('3', '0010', 1, '标准糖,正常冰', 32.00);
INSERT INTO `comselectinfo` VALUES ('3', '0002', 1, '标准糖,正常冰', 27.00);
INSERT INTO `comselectinfo` VALUES ('4', '0011', 2, '无糖,正常', 56.00);
INSERT INTO `comselectinfo` VALUES ('4', '0002', 1, '标准糖,正常冰', 27.00);
INSERT INTO `comselectinfo` VALUES ('5', '0007', 1, '标准糖,正常冰', 25.00);
INSERT INTO `comselectinfo` VALUES ('6', '0010', 1, '标准糖,正常冰', 32.00);
INSERT INTO `comselectinfo` VALUES ('7', '0010', 3, '微糖,正常', 96.00);
INSERT INTO `comselectinfo` VALUES ('9', '0013', 1, '标准糖,正常冰', 30.00);
INSERT INTO `comselectinfo` VALUES ('9', '0002', 1, '标准糖,正常冰', 27.00);
INSERT INTO `comselectinfo` VALUES ('9', '0012', 1, '标准糖,正常冰', 23.00);
INSERT INTO `comselectinfo` VALUES ('8', '0012', 1, '标准糖,正常冰', 23.00);
INSERT INTO `comselectinfo` VALUES ('9', '0008', 1, '标准糖,正常冰', 26.00);

-- ----------------------------
-- Table structure for cusaccinfo
-- ----------------------------
DROP TABLE IF EXISTS `cusaccinfo`;
CREATE TABLE `cusaccinfo`  (
  `OpenID` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Name` char(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `PhoneNum` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `NickName` char(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`OpenID`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cusaccinfo
-- ----------------------------
INSERT INTO `cusaccinfo` VALUES ('oJSWT4t6a9pS2v5TAY2oJZFltKY4', '李华铧', '13602348194', '狛枝', '广东省,东莞市,松山湖,东莞理工学院');

-- ----------------------------
-- Table structure for milktea
-- ----------------------------
DROP TABLE IF EXISTS `milktea`;
CREATE TABLE `milktea`  (
  `id` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Type` int(11) NULL DEFAULT NULL,
  `Price` decimal(6, 2) NOT NULL,
  `Type_Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of milktea
-- ----------------------------
INSERT INTO `milktea` VALUES ('0002', 1, 27.00, '果茶家族', '/images/id0002.jpg', '多肉芒芒甘露');
INSERT INTO `milktea` VALUES ('0003', 1, 20.00, '果茶家族', '/images/id0003.jpg', '芝芝桃桃');
INSERT INTO `milktea` VALUES ('0004', 2, 19.00, '茗茶/牛乳', '/images/id0004.jpg', '芝芝绿妍');
INSERT INTO `milktea` VALUES ('0005', 2, 22.00, '茗茶/牛乳', '/images/id0005.jpg', '芝芝金玉');
INSERT INTO `milktea` VALUES ('0006', 3, 27.00, '波波家族', '/images/id0006.jpg', '豆豆波波茶');
INSERT INTO `milktea` VALUES ('0007', 3, 25.00, '波波家族', '/images/id0007.jpg', '芋泥波波牛乳');
INSERT INTO `milktea` VALUES ('0008', 4, 26.00, '醇香咖啡', '/images/id0008.jpg', '芝芝咖啡');
INSERT INTO `milktea` VALUES ('0009', 4, 29.00, '醇香咖啡', '/images/id0009.jpg', '雪山香草拿铁');
INSERT INTO `milktea` VALUES ('0010', 1, 32.00, '果茶家族', '/images/id0010.jpg', '芝芝莓莓');
INSERT INTO `milktea` VALUES ('0011', 1, 28.00, '果茶家族', '/images/id0011.jpg', '芝芝莓莓桃');
INSERT INTO `milktea` VALUES ('0012', 1, 23.00, '果茶家族', '/images/id0012.jpg', '满杯红柚');
INSERT INTO `milktea` VALUES ('0013', 2, 30.00, '茗茶/牛乳', '/images/id0013.jpg', '芝芝金凤茶王');
INSERT INTO `milktea` VALUES ('0001', 3, 31.00, '波波家族', '/images/id0001.jpg', '葡萄波波奶盖');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `OrderID` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `OpenID` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Time` datetime(0) NOT NULL,
  `Total` decimal(6, 2) NOT NULL,
  `Status` int(11) NOT NULL,
  `Address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `PhoneNum` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Name` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`OrderID`) USING BTREE,
  INDEX `Fk_penID`(`OpenID`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('0', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-09-05 10:28:17', 1.00, 1, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES ('1', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-24 23:55:12', 43.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES ('2', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:05:25', 32.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES ('3', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:06:33', 59.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES ('4', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:45:36', 83.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES ('5', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:49:05', 25.00, 0, '广东省,东莞市,松山湖,东莞理工学院', NULL, '李华铧');
INSERT INTO `orderinfo` VALUES ('6', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:50:35', 32.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES ('7', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 02:35:43', 96.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES ('8', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 03:21:15', 23.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES ('9', 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 03:21:45', 106.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');

SET FOREIGN_KEY_CHECKS = 1;
