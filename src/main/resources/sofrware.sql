/*
 Navicat Premium Data Transfer

 Source Server         : localDB
 Source Server Type    : MySQL
 Source Server Version : 100414
 Source Host           : localhost:3306
 Source Schema         : projectdb

 Target Server Type    : MySQL
 Target Server Version : 100414
 File Encoding         : 65001

 Date: 23/04/2021 08:18:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
                          `admin_id` int(11) NOT NULL AUTO_INCREMENT,
                          `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `knowledge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `gender_id` int(11) NULL DEFAULT NULL,
                          `admin_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                          `admin_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `admin_age` int(11) NULL DEFAULT NULL,
                          `admin_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `admin_country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `employees_group` int(11) NULL DEFAULT NULL,
                          `admin_role_id` int(11) NULL DEFAULT NULL,
                          `admin_salary` int(11) NULL DEFAULT NULL,
                          PRIMARY KEY (`admin_id`) USING BTREE,
                          INDEX `fk_employees_employees_2`(`admin_role_id`) USING BTREE,
                          INDEX `fk_employees_employees_6`(`gender_id`) USING BTREE,
                          CONSTRAINT `fk_admin_gender` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                          CONSTRAINT `fk_admin_role` FOREIGN KEY (`admin_role_id`) REFERENCES `admin_role` (`admin_role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for admin_news
-- ----------------------------
DROP TABLE IF EXISTS `admin_news`;
CREATE TABLE `admin_news`  (
                               `admin_news_id` int(11) NOT NULL,
                               `admin_id` int(11) NULL DEFAULT NULL,
                               `news_id` int(11) NULL DEFAULT NULL,
                               PRIMARY KEY (`admin_news_id`) USING BTREE,
                               INDEX `fk_admin_news1`(`admin_id`) USING BTREE,
                               INDEX `fk_admin_news2`(`news_id`) USING BTREE,
                               CONSTRAINT `fk_admin_news1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                               CONSTRAINT `fk_admin_news2` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
                               `admin_role_id` int(11) NOT NULL AUTO_INCREMENT,
                               `admin_role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               PRIMARY KEY (`admin_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
                            `comment_id` int(11) NOT NULL AUTO_INCREMENT,
                            `news_id` int(11) NULL DEFAULT NULL,
                            `user_id` int(11) NULL DEFAULT NULL,
                            `comment_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                            `level` int(11) NULL DEFAULT 1,
                            `parent_id` int(11) NULL DEFAULT NULL,
                            PRIMARY KEY (`comment_id`) USING BTREE,
                            INDEX `fk_comment_comment_2`(`news_id`) USING BTREE,
                            INDEX `fk_comment_comment_3`(`user_id`) USING BTREE,
                            CONSTRAINT `fk_comment_comment_2` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            CONSTRAINT `fk_comment_comment_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for gender
-- ----------------------------
DROP TABLE IF EXISTS `gender`;
CREATE TABLE `gender`  (
                           `gender_id` int(11) NOT NULL AUTO_INCREMENT,
                           `gender_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           PRIMARY KEY (`gender_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
                            `history_id` int(255) NOT NULL,
                            `user_id` int(11) NULL DEFAULT NULL,
                            `news_id` int(11) NULL DEFAULT NULL,
                            `like` tinyint(1) NULL DEFAULT NULL COMMENT '0 là ko like,1 là like',
                            PRIMARY KEY (`history_id`) USING BTREE,
                            INDEX `fk_history_user`(`user_id`) USING BTREE,
                            INDEX `fk_history_news`(`news_id`) USING BTREE,
                            CONSTRAINT `fk_history_news` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            CONSTRAINT `fk_history_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
                         `news_id` int(11) NOT NULL AUTO_INCREMENT,
                         `tittle` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                         `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                         `news_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                         `news_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `news_date` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
                         `news_kind_id` int(11) NULL DEFAULT NULL,
                         `view_count` int(11) NULL DEFAULT NULL,
                         `like_count` int(11) NULL DEFAULT NULL,
                         `title_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`news_id`) USING BTREE,
                         INDEX `fk_news_news_2`(`news_kind_id`) USING BTREE,
                         CONSTRAINT `fk_news_news_2` FOREIGN KEY (`news_kind_id`) REFERENCES `news_kind` (`news_kind_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for news_kind
-- ----------------------------
DROP TABLE IF EXISTS `news_kind`;
CREATE TABLE `news_kind`  (
                              `news_kind_id` int(11) NOT NULL AUTO_INCREMENT,
                              `news_kind_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                              PRIMARY KEY (`news_kind_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `user_id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `user_phone` int(11) NULL DEFAULT NULL,
                         `user_pass` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `user_birth` date NULL DEFAULT NULL,
                         `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `gender_id` int(11) NULL DEFAULT NULL,
                         PRIMARY KEY (`user_id`) USING BTREE,
                         INDEX `fk_user_user_1`(`gender_id`) USING BTREE,
                         CONSTRAINT `fk_user_user_1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;