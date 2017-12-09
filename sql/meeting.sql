/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : meeting

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2017-11-28 13:17:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for counter
-- ----------------------------
DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `visitcount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of counter
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentid` int(255) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '后勤保障部');
INSERT INTO `department` VALUES ('2', 'IT支持部');
INSERT INTO `department` VALUES ('3', '财务部');
INSERT INTO `department` VALUES ('4', '教研部');
INSERT INTO `department` VALUES ('5', '人力资源部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `employeename` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `departmentid` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'admin', 'administrator', '13598111647', 'admin@buu.edu.cn', '1', '1', '123456', '1');
INSERT INTO `employee` VALUES ('2', 'jerry', 'jerryzhang', '14725892358', 'jerry@buu.edu.cn', '1', '2', '123456', '2');
INSERT INTO `employee` VALUES ('3', 'tommy', 'tommyhe', '13559591464', 'tommy@mail.com', '1', '2', '123456', '2');
INSERT INTO `employee` VALUES ('4', 'rose', 'rose', '13261978888', 'rose@mail.com', '0', '1', 'rose', '2');
INSERT INTO `employee` VALUES ('5', 'zhang', 'zhang', '16515155454', 'zhang@mail.com', '0', '1', 'zhang', '2');
INSERT INTO `employee` VALUES ('6', 'wang', 'wang', '15912311321', 'wang@qq.com', '0', '1', 'wang', '2');
INSERT INTO `employee` VALUES ('7', 'xiao', 'xiao', '15112341234', 'xiao@qq.com', '0', '4', 'xiao', '2');
INSERT INTO `employee` VALUES ('8', 'zheng', 'zheng', '15815146346', 'zheng@qq.com', '2', '4', 'zheng', '2');
INSERT INTO `employee` VALUES ('9', 'yang', 'yang', '15112341234', 'yang@qq.com', '1', '3', 'yang', '2');
INSERT INTO `employee` VALUES ('10', 'huhu', 'huhu', '15149491616', 'huhu@qq.com', '2', '2', 'huhu', '2');
INSERT INTO `employee` VALUES ('111', 'tete', 'tete', '15959595959', 'tete@qq.com', '1', '3', 'tete', '2');

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meetingid` int(11) NOT NULL AUTO_INCREMENT,
  `meetingname` varchar(255) DEFAULT NULL,
  `roomid` int(11) DEFAULT NULL,
  `reservationistid` int(11) DEFAULT NULL,
  `numberofparticipants` int(11) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `reservationtime` datetime DEFAULT NULL,
  `canceledtime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES ('1', '人事部门例会', '1', '1', '14', '2017-11-14 16:25:24', '2017-11-14 19:25:29', '2017-11-01 12:44:37', null, '本会议将邀请专家参加。', '0');
INSERT INTO `meeting` VALUES ('2', '技术部部门会议', '1', '2', '15', '2017-11-21 12:24:00', '2017-11-21 12:58:00', '2017-11-03 12:44:40', null, '1', '0');
INSERT INTO `meeting` VALUES ('3', '后勤部门会议', '2', '2', '10', '2017-11-22 08:09:51', '2017-11-22 18:29:55', '2017-11-04 12:44:44', null, null, '0');
INSERT INTO `meeting` VALUES ('4', '111', '1', '1', '344', '2017-11-29 16:28:39', '2017-12-01 16:28:41', '2017-11-22 12:44:47', null, '333', '0');
INSERT INTO `meeting` VALUES ('5', '2222', '6', '1', '2222', '2017-11-30 09:38:31', '2017-11-30 09:38:33', '2017-11-15 12:44:50', '2017-11-28 11:34:15', '222', '1');
INSERT INTO `meeting` VALUES ('6', '111222', '2', '2', '111222', '2017-11-30 10:22:20', '2017-11-30 10:22:22', '2017-11-14 12:44:53', null, '111222111222111222111222', '0');
INSERT INTO `meeting` VALUES ('7', '中软国际会议', '6', '1', '100', '2017-11-30 09:43:24', '2017-11-30 20:43:29', '2017-11-19 12:44:57', null, '全天会议全部人员参加', '0');
INSERT INTO `meeting` VALUES ('8', '测试跳转', '3', '1', '111', '2017-11-30 11:53:20', '2017-11-30 11:53:21', '2017-11-06 12:45:01', null, 'ddd', '0');
INSERT INTO `meeting` VALUES ('9', '测试跳转12', '3', '1', '222', '2017-11-30 11:54:07', '2017-11-30 11:54:08', '2017-11-23 12:45:04', null, '测试跳转12测试跳转12测试跳转12', '00');
INSERT INTO `meeting` VALUES ('10', '1125测试', '3', '1', '111', '2017-12-02 22:54:25', '2017-12-02 22:54:27', '2017-11-17 12:45:07', '2017-11-28 11:27:39', '1125测试', '1');
INSERT INTO `meeting` VALUES ('11', '测试取消会议测', '3', '1', '22', '2017-11-30 12:56:46', '2017-12-02 12:56:49', '2017-11-28 12:57:00', '2017-11-28 12:57:11', '测试取消会议测', '1');
INSERT INTO `meeting` VALUES ('12', '普通员工预定的会议', '2', '2', '111', '2017-12-08 13:16:36', '2017-12-09 13:16:39', '2017-11-28 13:16:48', null, '普通员工预定的会议', '0');

-- ----------------------------
-- Table structure for meetingparticipants
-- ----------------------------
DROP TABLE IF EXISTS `meetingparticipants`;
CREATE TABLE `meetingparticipants` (
  `meetingid` int(11) NOT NULL,
  `employeeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingparticipants
-- ----------------------------
INSERT INTO `meetingparticipants` VALUES ('1', '1');
INSERT INTO `meetingparticipants` VALUES ('3', '2');
INSERT INTO `meetingparticipants` VALUES ('2', '1');
INSERT INTO `meetingparticipants` VALUES ('1', '2');
INSERT INTO `meetingparticipants` VALUES ('6', '1');
INSERT INTO `meetingparticipants` VALUES ('6', '5');
INSERT INTO `meetingparticipants` VALUES ('6', '4');
INSERT INTO `meetingparticipants` VALUES ('6', '6');
INSERT INTO `meetingparticipants` VALUES ('7', '1');
INSERT INTO `meetingparticipants` VALUES ('7', '5');
INSERT INTO `meetingparticipants` VALUES ('7', '4');
INSERT INTO `meetingparticipants` VALUES ('7', '6');
INSERT INTO `meetingparticipants` VALUES ('7', '2');
INSERT INTO `meetingparticipants` VALUES ('7', '10');
INSERT INTO `meetingparticipants` VALUES ('7', '3');
INSERT INTO `meetingparticipants` VALUES ('7', '9');
INSERT INTO `meetingparticipants` VALUES ('7', '111');
INSERT INTO `meetingparticipants` VALUES ('7', '7');
INSERT INTO `meetingparticipants` VALUES ('7', '8');
INSERT INTO `meetingparticipants` VALUES ('8', '1');
INSERT INTO `meetingparticipants` VALUES ('9', '2');
INSERT INTO `meetingparticipants` VALUES ('10', '1');
INSERT INTO `meetingparticipants` VALUES ('11', '1');
INSERT INTO `meetingparticipants` VALUES ('11', '2');
INSERT INTO `meetingparticipants` VALUES ('12', '3');
INSERT INTO `meetingparticipants` VALUES ('12', '2');
INSERT INTO `meetingparticipants` VALUES ('12', '10');

-- ----------------------------
-- Table structure for meetingroom
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom` (
  `roomid` int(11) NOT NULL AUTO_INCREMENT,
  `roomnum` int(11) DEFAULT NULL,
  `roomname` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------
INSERT INTO `meetingroom` VALUES ('1', '102', '会议室A', '30', '1', '维修设备');
INSERT INTO `meetingroom` VALUES ('2', '202', '会议室B', '60', '0', '位于办公室一楼右侧');
INSERT INTO `meetingroom` VALUES ('3', '203', '会议室C', '45', '0', '203');
INSERT INTO `meetingroom` VALUES ('4', '204', '会议室D', '100', '0', '修改测试');
INSERT INTO `meetingroom` VALUES ('5', '301', '会议室E', '100', '0', '设备维护完成-1122');
INSERT INTO `meetingroom` VALUES ('6', '201', '201会议室', '2022', '0', '222');
