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

 Date: 07/01/2021 20:27:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(15) NOT NULL,
  `password` char(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `username` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '123', 'root');

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
INSERT INTO `comselectinfo` VALUES ('10', '0012', 1, '标准糖,正常冰', 23.00);
INSERT INTO `comselectinfo` VALUES ('10', '0003', 2, '标准糖,正常冰', 40.00);
INSERT INTO `comselectinfo` VALUES ('10', '0011', 1, '标准糖,正常冰', 28.00);
INSERT INTO `comselectinfo` VALUES ('13', '0007', 1, '标准糖,正常冰', 25.00);
INSERT INTO `comselectinfo` VALUES ('14', '0008', 1, '标准糖,正常冰', 26.00);
INSERT INTO `comselectinfo` VALUES ('14', '0013', 1, '标准糖,正常冰', 30.00);
INSERT INTO `comselectinfo` VALUES ('14', '0011', 1, '标准糖,正常冰', 28.00);
INSERT INTO `comselectinfo` VALUES ('15', '0013', 1, '标准糖,正常冰', 30.00);
INSERT INTO `comselectinfo` VALUES ('16', '0004', 1, '标准糖,正常冰', 19.00);
INSERT INTO `comselectinfo` VALUES ('16', '0002', 1, '标准糖,正常冰', 27.00);
INSERT INTO `comselectinfo` VALUES ('16', '0008', 1, '标准糖,正常冰', 26.00);
INSERT INTO `comselectinfo` VALUES ('17', '0001', 1, '标准糖,正常冰', 31.00);
INSERT INTO `comselectinfo` VALUES ('17', '0009', 1, '标准糖,正常冰', 29.00);

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
  `TypeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of milktea
-- ----------------------------
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0001', 3, 31.00, '波波家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0001.jpg', '葡萄波波奶盖');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0002', 1, 27.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0002.jpg', '多肉芒芒甘露');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0003', 1, 20.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0003.jpg', '芝芝桃桃');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0004', 2, 19.00, '茗茶/牛乳', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0004.jpg', '芝芝绿妍');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0005', 2, 22.00, '茗茶/牛乳', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0005.jpg', '芝芝金玉');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0006', 3, 27.00, '波波家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0006.jpg', '豆豆波波茶');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0007', 3, 25.00, '波波家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0007.jpg', '芋泥波波牛乳');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0008', 4, 26.00, '醇香咖啡', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0008.jpg', '芝芝咖啡');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0009', 4, 29.00, '醇香咖啡', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0009.jpg', '雪山香草拿铁');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0010', 1, 32.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0010.jpg', '芝芝莓莓');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0011', 1, 28.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0011.jpg', '芝芝莓莓桃');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES ('0012', 1, 23.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/id0012.jpg', '满杯红柚');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `OpenID` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Time` datetime(0) NOT NULL,
  `Total` decimal(6, 2) NOT NULL,
  `Status` int(11) NOT NULL,
  `Address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `PhoneNum` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Name` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`OrderID`) USING BTREE,
  INDEX `Fk_penID`(`OpenID`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES (1, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-24 23:55:12', 43.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES (2, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:05:25', 32.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES (3, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:06:33', 59.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES (4, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:45:36', 83.00, 0, NULL, NULL, NULL);
INSERT INTO `orderinfo` VALUES (5, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:49:05', 25.00, 0, '广东省,东莞市,松山湖,东莞理工学院', NULL, '李华铧');
INSERT INTO `orderinfo` VALUES (6, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 00:50:35', 32.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (7, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 02:35:43', 96.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (8, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 03:21:15', 23.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (9, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-25 03:21:45', 106.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (10, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-26 17:45:16', 28.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (14, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-26 18:15:29', 84.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (13, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-26 18:14:29', 25.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (15, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-26 18:55:33', 30.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (16, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-26 18:58:29', 72.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');
INSERT INTO `orderinfo` VALUES (17, 'oJSWT4t6a9pS2v5TAY2oJZFltKY4', '2020-12-26 19:00:26', 60.00, 0, '广东省,东莞市,松山湖,东莞理工学院', '13602348194', '李华铧');

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for bannerimg
-- ----------------------------
create table bannerImg
(
    id int not null,
    imgUrl varchar(255) null,
    constraint bannerImg_pk
        primary key (id)
);

-- ----------------------------
-- Records of bannerimg
-- ----------------------------
INSERT INTO milktea_sql.bannerimg (id, imgUrl) VALUES (1, 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/banner/bnr1.jpg');
INSERT INTO milktea_sql.bannerimg (id, imgUrl) VALUES (2, 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/banner/bnr2.jpg');
INSERT INTO milktea_sql.bannerimg (id, imgUrl) VALUES (3, 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/banner/bnr3.jpg');
