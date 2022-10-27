/*
 Navicat Premium Data Transfer

 Source Server         : MySQL 8.0
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 127.0.0.1:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 27/10/2022 22:51:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for testM
-- ----------------------------
DROP TABLE IF EXISTS `testM`;
CREATE TABLE `testM` (
  `team_name` char(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '团队名字',
  `personal_bib` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选手号码',
  `personal_name` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选手名字',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别',
  `record_time` time DEFAULT NULL COMMENT '计时时间',
  `net_time` time DEFAULT NULL COMMENT '净时间',
  `video_rank` int DEFAULT NULL COMMENT '视频排名',
  `gender_rank` int DEFAULT NULL COMMENT '性别排名',
  `overall_rank` int DEFAULT NULL COMMENT '全体排名',
  `avg_pace` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '平均配速',
  PRIMARY KEY (`personal_bib`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
