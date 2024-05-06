/*
 Navicat MySQL Data Transfer

 Source Server         : 11923020325
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : robot

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 20/02/2023 21:46:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alertmessage
-- ----------------------------
DROP TABLE IF EXISTS r_alertmessage;
CREATE TABLE `alertmessage`  (
  `id` int(0) NOT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `detectItem` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detectResult` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(0) NULL DEFAULT NULL,
  `opreation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alertmessage
-- ----------------------------
INSERT INTO r_alertmessage VALUES (1, '2023-02-20 15:48:48', '巡检项1', '正常', 1, '操作1');
INSERT INTO r_alertmessage VALUES (2, '2023-02-16 15:48:48', '巡检项2', '正常', 3, '操作2');
INSERT INTO r_alertmessage VALUES (3, '2023-02-24 15:48:48', '巡检项3', '正常', 5, '操作3');

-- ----------------------------
-- Table structure for checkresult
-- ----------------------------
DROP TABLE IF EXISTS `checkresult`;
CREATE TABLE `checkresult`  (
  `id` int(0) NOT NULL,
  `robotId` int(0) NULL DEFAULT NULL,
  `taskId` int(0) NULL DEFAULT NULL,
  `temDetect` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `noiseDetect` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `abnormGasDetect` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `instruDetect` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checkresult
-- ----------------------------
INSERT INTO `checkresult` VALUES (1, 1, 1, '36.3', '2', 'h2o', '正常');
INSERT INTO `checkresult` VALUES (2, 1, 2, '36.5', '5', 'h2o', '正常');
INSERT INTO `checkresult` VALUES (3, 2, 2, '36.4', '4', 'h2o', '正常');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int(0) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '四点零分公司', '重庆是渝北区');
INSERT INTO `company` VALUES (2, '森林防火公司', '广东省深圳市');
INSERT INTO `company` VALUES (3, '顶上功夫公司', '四川省成都市');

-- ----------------------------
-- Table structure for environmentmes
-- ----------------------------
DROP TABLE IF EXISTS `environmentmes`;
CREATE TABLE `environmentmes`  (
  `id` int(0) NOT NULL,
  `field` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `temperature` decimal(10, 0) NULL DEFAULT NULL,
  `moisture` decimal(10, 0) NULL DEFAULT NULL,
  `smoke` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `noise` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gas` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of environmentmes
-- ----------------------------
INSERT INTO `environmentmes` VALUES (1, '试验区', 36, 3, '0', '3', 'h2o');
INSERT INTO `environmentmes` VALUES (2, '实验区', 25, 5, '0', '4', 'h2o');
INSERT INTO `environmentmes` VALUES (3, '工作区', 37, 4, '0', '5', 'h2o');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(0) NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1001, '123123');
INSERT INTO `manager` VALUES (1002, '123123');
INSERT INTO `manager` VALUES (1003, '123123');

-- ----------------------------
-- Table structure for robot
-- ----------------------------
DROP TABLE IF EXISTS `robot`;
CREATE TABLE `robot`  (
  `id` int(0) NOT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `battery` int(0) NULL DEFAULT NULL,
  `speed` int(0) NULL DEFAULT NULL,
  `navicateState` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `runtime` decimal(10, 0) NULL DEFAULT NULL,
  `preTaskId` int(0) NULL DEFAULT NULL,
  `currentTaskId` int(0) NULL DEFAULT NULL,
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of robot
-- ----------------------------
INSERT INTO `robot` VALUES (1, '工作中', 45, 10, '导航中', 30, 1, 2, '工作区');
INSERT INTO `robot` VALUES (2, '充电中', 23, 7, '未导航', 25, 1, 0, '试验区');
INSERT INTO `robot` VALUES (3, '工作中', 35, 10, '导航中', 45, 2, 3, '工作区');

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`  (
  `id` int(0) NOT NULL,
  `route` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES (1, '路线1');
INSERT INTO `route` VALUES (2, '路线2');
INSERT INTO `route` VALUES (3, '路线3');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(0) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` time(0) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `detectPlace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detectItem` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startTime` date NULL DEFAULT NULL,
  `satete` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `routeId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, '巡检任务1', '21:41:50', '2023-02-20', '工作区', '器具安全', '2023-02-20', '已完成', 1);
INSERT INTO `task` VALUES (2, '巡检任务2', '02:41:50', '2023-02-09', '实验区', '气体安全', '2023-02-23', '已完成', 2);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(0) NOT NULL,
  `robotId` int(0) NULL DEFAULT NULL,
  `taskId` int(0) NULL DEFAULT NULL,
  `video` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, 2, 2, 'http：');
INSERT INTO `video` VALUES (2, 1, 1, 'http：');
INSERT INTO `video` VALUES (3, 2, 2, 'http:');

SET FOREIGN_KEY_CHECKS = 1;
