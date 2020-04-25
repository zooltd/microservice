/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 25/04/2020 21:22:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'user111', '张三', '123456', 'mybatis');
INSERT INTO `tb_user` VALUES (2, 'user113', '王丽丽', '123456', 'mybatis');
INSERT INTO `tb_user` VALUES (3, 'zhang999', '张山三', '123456', 'mybatis');
INSERT INTO `tb_user` VALUES (5, 'user888', '李四', '111111', 'mybatis');
INSERT INTO `tb_user` VALUES (7, 'lily', '丽丽', '111111', 'mybatis');
INSERT INTO `tb_user` VALUES (11, 'tom123', 'tom', '111111', 'mybatis');
INSERT INTO `tb_user` VALUES (12, 'zhang3', '张山三', '111111', 'mybatis');
INSERT INTO `tb_user` VALUES (13, 'tom111', 'tomtom', '123456', 'mybatis');

SET FOREIGN_KEY_CHECKS = 1;
