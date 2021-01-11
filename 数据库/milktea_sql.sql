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

create table admin
(
    id       int(15)  not null
        primary key,
    password char(20) not null,
    username char(15) not null
);

create table bannerimg
(
    id     int          not null
        primary key,
    imgUrl varchar(255) null
);

create table comselectinfo
(
    OrderID     char(15)      not null,
    id          char(15)      not null,
    Number      int default 1 null,
    Description varchar(255)  null,
    Price       decimal(6, 2) null,
    primary key (OrderID, id)
);

create index Fk_id
    on comselectinfo (id);

create table cusaccinfo
(
    OpenID   varchar(255) not null
        primary key,
    Name     char(20)     null,
    PhoneNum char(15)     null,
    NickName char(20)     null,
    Address  varchar(255) null
);

create table milktea
(
    id       int auto_increment,
    Type     int           null,
    Price    decimal(6, 2) not null,
    TypeName varchar(255)  null,
    image    varchar(255)  null,
    Name     varchar(30)   not null,
    constraint milktea_id_uindex
        unique (id)
);

alter table milktea
    add primary key (id);

create table orderinfo
(
    OrderID  int auto_increment
        primary key,
    OpenID   varchar(255)  not null,
    Time     datetime      not null,
    Total    decimal(6, 2) not null,
    Status   int           not null,
    Address  varchar(255)  null,
    PhoneNum char(15)      null,
    Name     char(15)      null
);

create index Fk_penID
    on orderinfo (OpenID);

create table revenue
(
    date        date   not null
        primary key,
    orderNumber int    null,
    revenue     double null
)
    comment '收入表，记录某天订单数和当天收入';

INSERT INTO milktea_sql.admin (id, password, username) VALUES (1, '123', 'root');

INSERT INTO milktea_sql.bannerimg (id, imgUrl) VALUES (1, 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/banner/bnr1.jpg');
INSERT INTO milktea_sql.bannerimg (id, imgUrl) VALUES (2, 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/banner/bnr2.jpg');
INSERT INTO milktea_sql.bannerimg (id, imgUrl) VALUES (3, 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/banner/bnr3.jpg');

INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('26', '3', 1, '标准糖,正常冰', 20.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('27', '11', 1, '标准糖,正常冰', 28.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('27', '6', 1, '标准糖,正常冰', 27.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('28', '34', 1, '标准糖,正常冰', 21.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('28', '11', 1, '标准糖,正常冰', 28.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('28', '3', 1, '标准糖,正常冰', 20.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('28', '2', 1, '标准糖,正常冰', 27.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('29', '8', 1, '标准糖,正常冰', 26.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('29', '11', 2, '标准糖,正常冰', 56.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('30', '10', 1, '标准糖,正常冰', 32.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('31', '5', 1, '半糖,少冰', 22.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('31', '12', 1, '微糖,少少冰', 23.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('32', '3', 1, '标准糖,正常冰', 20.00);
INSERT INTO milktea_sql.comselectinfo (OrderID, id, Number, Description, Price) VALUES ('33', '37', 2, '半糖,少冰', 244.00);

INSERT INTO milktea_sql.cusaccinfo (OpenID, Name, PhoneNum, NickName, Address) VALUES ('oJSWT4t6a9pS2v5TAY2oJZFltKY4', '李华铧', '13602348194', '狛枝', '广东省,东莞市,松山湖,东莞理工学院');
INSERT INTO milktea_sql.cusaccinfo (OpenID, Name, PhoneNum, NickName, Address) VALUES ('oJSWT4gRMK8MJg6myGJdA_4MZaaY', '宁龙辉', '18925422863', 'ZER0N-1', '广东省,东莞市,松山湖,东莞理工学院');

INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (2, 1, 27.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0002.jpg', '多肉芒芒甘露');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (3, 1, 20.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0003.jpg', '芝芝桃桃');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (4, 2, 19.00, '茗茶/牛乳', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0004.jpg', '芝芝绿妍');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (5, 2, 22.00, '茗茶/牛乳', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0005.jpg', '芝芝金玉');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (6, 3, 27.00, '波波家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0006.jpg', '豆豆波波茶');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (7, 3, 25.00, '波波家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0007.jpg', '芋泥波波牛乳');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (8, 4, 26.00, '醇香咖啡', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0008.jpg', '芝芝咖啡');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (9, 4, 29.00, '醇香咖啡', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0009.jpg', '雪山香草拿铁');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (10, 1, 32.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0010.jpg', '芝芝莓莓');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (11, 1, 28.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0011.jpg', '芝芝莓莓桃');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (12, 1, 23.00, '果茶家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0012.jpg', '满杯红柚');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (1, 3, 31.00, '波波家族', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0001.jpg', '葡萄波波奶盖');
INSERT INTO milktea_sql.milktea (id, Type, Price, TypeName, image, Name) VALUES (37, 2, 122.00, '茗茶/牛乳', 'https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/milktea/id0006.jpg', '测试牛乳');

INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (32, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-11 21:25:09', 20.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');
INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (33, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-11 21:29:09', 244.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');
INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (26, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-10 20:58:01', 20.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');
INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (27, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-11 18:09:41', 55.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');
INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (28, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-11 18:12:20', 96.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');
INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (29, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-11 20:51:59', 82.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');
INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (30, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-11 21:16:30', 32.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');
INSERT INTO milktea_sql.orderinfo (OrderID, OpenID, Time, Total, Status, Address, PhoneNum, Name) VALUES (31, 'oJSWT4gRMK8MJg6myGJdA_4MZaaY', '2021-01-11 21:23:25', 45.00, 1, '广东省,东莞市,松山湖,东莞理工学院', '18925422863', '宁龙辉');

INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-03', 23, 598);
INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-04', 42, 1092);
INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-05', 21, 778);
INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-06', 32, 889);
INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-07', 32, 889);
INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-08', 42, 1092);
INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-09', 123, 3198);
INSERT INTO milktea_sql.revenue (date, orderNumber, revenue) VALUES ('2021-01-10', 52, 1292);