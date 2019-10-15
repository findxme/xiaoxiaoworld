/*
 Navicat Premium Data Transfer

 Source Server         : 39.106.200.227_3306_root
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 39.106.200.227:3306
 Source Schema         : db_library_project

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/10/2019 10:20:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `b_admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `b_admin_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户编码',
  `b_admin_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名字唯一',
  `b_admin_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `b_admin_email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '不能为空，登陆的邮箱，唯一标识',
  `b_admin_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1，管理员用户  2， 普通用户，',
  `b_admin_create_date` date NULL DEFAULT NULL COMMENT '开户日期',
  `b_admin_stop_date` date NULL DEFAULT NULL COMMENT '销户日期',
  `b_admin_Remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员备注',
  PRIMARY KEY (`b_admin_id`, `b_admin_name`, `b_admin_email`, `b_admin_no`) USING BTREE,
  UNIQUE INDEX `b_admin_name`(`b_admin_name`) USING BTREE,
  INDEX `b_user_no`(`b_admin_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `b_book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `b_book_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号\r\n',
  `b_book_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名\r\n书名',
  `b_book_author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `b_book_number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `b_book_type_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '书的类型id',
  `b_book_createDate` date NOT NULL COMMENT '书的入库时间',
  `b_stop_date` date NULL DEFAULT NULL COMMENT '书销毁时间',
  PRIMARY KEY (`b_book_id`, `b_book_no`) USING BTREE,
  INDEX `b_book_no`(`b_book_no`) USING BTREE,
  INDEX `b_book_type`(`b_book_type_no`) USING BTREE,
  CONSTRAINT `b_book_type_no` FOREIGN KEY (`b_book_type_no`) REFERENCES `t_book_type` (`b_book_type_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_book_reader
-- ----------------------------
DROP TABLE IF EXISTS `t_book_reader`;
CREATE TABLE `t_book_reader`  (
  `b_book_reader_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `b_book_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号外键',
  `b_user_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员编号\r\n',
  `b_reader_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者编号',
  `b_borrow_date` date NOT NULL COMMENT '借书日期',
  `b_return_date` date NULL DEFAULT NULL COMMENT '还书日期',
  `b_over_date` int(11) NOT NULL DEFAULT 0 COMMENT '超过日期',
  `is_return_book` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未还' COMMENT '是否归还',
  `b_renew_frequency` int(11) NOT NULL DEFAULT 3 COMMENT '续借次数',
  `b_renew_time` int(11) NULL DEFAULT NULL COMMENT '续借时间',
  PRIMARY KEY (`b_book_reader_id`, `b_book_no`, `b_reader_no`, `b_user_no`) USING BTREE,
  INDEX `b_book_no`(`b_book_no`) USING BTREE,
  INDEX `b_reader_no`(`b_reader_no`) USING BTREE,
  INDEX `b_user_no`(`b_user_no`) USING BTREE,
  CONSTRAINT `b_book_no` FOREIGN KEY (`b_book_no`) REFERENCES `t_book` (`b_book_no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `b_reader_no` FOREIGN KEY (`b_reader_no`) REFERENCES `t_reader` (`b_reader_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `b_user_no` FOREIGN KEY (`b_user_no`) REFERENCES `t_admin` (`b_admin_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 161 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_book_type
-- ----------------------------
DROP TABLE IF EXISTS `t_book_type`;
CREATE TABLE `t_book_type`  (
  `b_book_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_book_type_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类id',
  `b_book_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图书类型',
  PRIMARY KEY (`b_book_type_id`, `b_book_type_no`) USING BTREE,
  INDEX `b_book_type`(`b_book_type`) USING BTREE,
  INDEX `b_book_type_no`(`b_book_type_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_reader
-- ----------------------------
DROP TABLE IF EXISTS `t_reader`;
CREATE TABLE `t_reader`  (
  `b_reader_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '读者id',
  `b_reader_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者编号',
  `b_reader_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者姓名',
  `b_reader_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `b_reader_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `b_reader_borrow_number` int(11) NOT NULL DEFAULT 5 COMMENT '借阅数量，默认5',
  `b_reader_borrow_already_number` int(11) NOT NULL DEFAULT 0 COMMENT '以及借阅的书的数量',
  `b_reader_borrow_time` double NULL DEFAULT NULL COMMENT '借阅时间',
  `b_reader_mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '读者手机',
  `b_reader_Remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`b_reader_id`, `b_reader_no`, `b_reader_name`, `b_reader_email`) USING BTREE,
  UNIQUE INDEX `b_reader_name`(`b_reader_name`) USING BTREE,
  UNIQUE INDEX `b_reader_no`(`b_reader_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_smtp
-- ----------------------------
DROP TABLE IF EXISTS `t_smtp`;
CREATE TABLE `t_smtp`  (
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统邮箱SMTP账号',
  `smtp` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'SMTP服务器',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发件人昵称',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'SMTP授权码',
  `prot` int(4) NOT NULL COMMENT 'SMTP端口',
  PRIMARY KEY (`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
