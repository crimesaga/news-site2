/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2016-11-23 00:27:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `advertise`
-- ----------------------------
DROP TABLE IF EXISTS `advertise`;
CREATE TABLE `advertise` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `description` text COLLATE utf8_vietnamese_ci,
  `url` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `imageUrl` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `position` int(11) unsigned zerofill DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of advertise
-- ----------------------------

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `summary` text COLLATE utf8_vietnamese_ci,
  `content` longtext COLLATE utf8_vietnamese_ci,
  `imageUrl` text COLLATE utf8_vietnamese_ci,
  `featured` tinyint(4) DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  `postedDate` timestamp NULL DEFAULT NULL,
  `categoryID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `primary_index` (`id`) USING BTREE,
  KEY `date_index` (`postedDate`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'Tilte1', 'Summary1', '<p>Content1</p><p><br></p><p><img class=\"fr-dib fr-draggable\" src=\"http://localhost:8080/SpringSecurity/resources/images/161221417/1659338521.jpg\" style=\"width: 300px;\"></p><p><br></p>', 'http://localhost:8080/SpringSecurity/resources/images/1743080055/1179159561.jpg', '0', '1', '2016-11-22 16:39:09', '1', '1');
INSERT INTO `article` VALUES ('2', 'Title2', 'Summary2', null, null, '0', '1', '2016-09-15 21:00:30', '1', '1');
INSERT INTO `article` VALUES ('3', 'Title3', 'Summary3', '<p>Content 3</p>', null, '0', '1', '2016-10-17 17:31:47', '2', '1');
INSERT INTO `article` VALUES ('4', 'Title4', 'Summary4', null, 'http://localhost:8080/SpringSecurity/resources/images/1946331888/1784108352.jpg', '0', '1', '2016-10-08 17:20:04', '3', '1');
INSERT INTO `article` VALUES ('5', 'Title5', 'Summary5', null, null, '0', '1', '2016-09-15 21:02:49', '2', '1');
INSERT INTO `article` VALUES ('6', 'Title6', 'Summary6', null, 'http://localhost:8080/SpringSecurity/resources/images/974709837/770353201.jpg', '0', '1', '2016-10-08 17:20:17', '4', '1');
INSERT INTO `article` VALUES ('7', 'Title7', 'Summary7', null, null, '0', '1', '2016-09-15 21:00:57', '2', '1');
INSERT INTO `article` VALUES ('8', 'Title8', 'Summary8', null, null, '0', '1', '2016-09-15 21:06:30', '3', '1');
INSERT INTO `article` VALUES ('9', 'Tiltle9', 'Summary9', null, null, '1', '1', '2016-09-15 21:06:03', '1', '1');
INSERT INTO `article` VALUES ('10', 'Tiltle10', 'Summary10', null, null, '0', '1', '2016-09-15 20:06:23', '4', '1');
INSERT INTO `article` VALUES ('11', 'Tiltle11', 'Summary11', null, null, '0', '1', '2016-09-15 21:06:54', '2', '1');
INSERT INTO `article` VALUES ('18', 'C?nh hoang tàn bên trong Th??ng xá Tax tr??c gi? tháo d?', 'Sáng 12/10, sau g?n 2 n?m ?óng c?a b?o t?n, Th??ng xá Tax (trung tâm th??ng m?i lâu ??i nh?t Sài Gòn) b?t ??u ???c tháo d? ?? nh??ng ch? cho cao ?c 40 t?ng s?p xây d?ng.', '<p>Thương x&aacute; Tax được x&acirc;y dựng v&agrave;o năm 1880, thời kỳ đầu mang t&ecirc;n Grands Magasins Charner (GMC) - c&ocirc;ng tr&igrave;nh mang t&iacute;nh biểu tượng của khu vực. Trung t&acirc;m thương mại (TTTM) l&acirc;u đời v&agrave; nổi tiếng nhất tại TP.HCM n&agrave;y c&oacute; diện t&iacute;ch 9.200 m2, nằm ngay ở quận 1, tiếp gi&aacute;p 3 đại lộ mua b&aacute;n sầm uất v&agrave; nhộn nhịp nhất th&agrave;nh phố l&agrave; Nguyễn Huệ, L&ecirc; Lợi v&agrave; Pasteur.</p>', 'http://localhost:8080/SpringSecurity/resources/images/847309480/662984207.jpg', '0', '1', '2016-10-23 16:26:24', '1', '1');
INSERT INTO `article` VALUES ('19', 'www', 'www', '<p>wwww</p>', 'http://localhost:8080/SpringSecurity/resources/images/1794863976/1947512098.jpg', '0', '1', '2016-10-08 17:19:47', '4', '1');
INSERT INTO `article` VALUES ('20', 'Khán giả khiêu khích khiếm nhã với Ronaldo', 'Trước và sau lúc thực hiện quả penalty trong trận thắng Alaves, siêu sao Ronaldo bị khán giả đội chủ nhà tấn công tinh thần bằng những hành động khiếm nhã.', '<p>Anh ta c&ograve;n li&ecirc;n tục vẫy tay v&agrave; la h&eacute;t để thu h&uacute;t sự ch&uacute; &yacute; của si&ecirc;u sao 31 tuổi. Nhưng Ronaldo vẫn b&igrave;nh tĩnh thực hiện th&agrave;nh c&ocirc;ng quả 11 m&eacute;t, gỡ h&ograve;a cho đội kh&aacute;ch Real Madrid.</p><p>Sự việc chưa dừng lại ở đ&acirc;y. Trong l&uacute;c CR7 c&ugrave;ng đồng đội Gareth Bale chạy ra đường bi&ecirc;n ăn mừng b&agrave;n thắng n&agrave;y, hai cổ động vi&ecirc;n tụt quần hở nửa m&ocirc;ng rồi ngồi quay lưng lại h&agrave;ng r&agrave;o, hướng về ph&iacute;a hai si&ecirc;u sao. H&agrave;nh động bất lịch sự của c&aacute;c CĐV khiến Alaves đối mặt &aacute;n phạt của Li&ecirc;n đo&agrave;n b&oacute;ng đ&aacute; T&acirc;y Ban Nha.</p>', 'http://localhost:8080/SpringSecurity/resources/images/1171066041/425683983.jpg', '0', '1', '2016-10-31 17:52:18', '6', '1');
INSERT INTO `article` VALUES ('21', null, null, '', 'http://localhost:8080/SpringSecurity/resources/images/1845642862/1994987690.jpg', '0', '0', '2016-11-20 18:24:01', '1', '1');
INSERT INTO `article` VALUES ('22', 'ấdasdasdas', 'đâsdasdasdad', '<p>đ&acirc;sdasdasd</p>', null, '0', '1', '2016-11-22 15:45:56', '1', '1');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `position` tinyint(2) DEFAULT NULL,
  `parentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `primary_index` (`id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Category1', 'Xa Hoi', '1', '1', null);
INSERT INTO `category` VALUES ('2', 'Category2', 'The Thao', '1', '2', null);
INSERT INTO `category` VALUES ('3', 'Category3', 'Giao Duc', '1', '3', null);
INSERT INTO `category` VALUES ('4', 'Category4', 'Kinh te', '1', '4', null);
INSERT INTO `category` VALUES ('6', 'Category12', 'Xa hoi 2', '1', '6', '1');
INSERT INTO `category` VALUES ('7', 'Category121', 'Xahoi 21', '1', '7', '6');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of position
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `description` text COLLATE utf8_vietnamese_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'User', 'Moderator');
INSERT INTO `role` VALUES ('2', 'Admin', 'Administrator');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_index` (`id`) USING HASH,
  KEY `name_index` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'quest', '123', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userID` int(11) NOT NULL DEFAULT '0',
  `roleID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userID`,`roleID`),
  KEY `user_index` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `view_count`
-- ----------------------------
DROP TABLE IF EXISTS `view_count`;
CREATE TABLE `view_count` (
  `articleId` int(11) DEFAULT NULL,
  `viewCount` int(11) unsigned zerofill DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `article_index` (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of view_count
-- ----------------------------
