/*
Navicat MySQL Data Transfer

Source Server         : 192.168.100.136
Source Server Version : 50520
Source Host           : 192.168.100.136:3306
Source Database       : priest_db_test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-09-09 17:09:37
*/

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE if not exists `priest_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use priest_db;

-- ----------------------------
-- Table structure for `P_APPLICATION`
-- ----------------------------
DROP TABLE IF EXISTS `P_APPLICATION`;
CREATE TABLE `P_APPLICATION` (
  `APP_ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '应用ID',
  `APP_NAME` varchar(200) NOT NULL COMMENT '应用名',
  `APP_DESC` varchar(255) DEFAULT NULL COMMENT '应用描述',
  `APP_VARIABLES` varchar(255) DEFAULT NULL COMMENT '应用变量',
  `APP_USER` varchar(50) NOT NULL DEFAULT '' COMMENT '应用对应集群用户',
  `thread_pool_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`APP_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_APPLICATION
-- ----------------------------
INSERT INTO `P_APPLICATION` VALUES ('1', 'default', '', '', 'u_public', '1');

-- ----------------------------
-- Table structure for `P_DATABASE`
-- ----------------------------
DROP TABLE IF EXISTS `P_DATABASE`;
CREATE TABLE `P_DATABASE` (
  `APP_ID` int(20) NOT NULL COMMENT '应用ID',
  `DB_USER` text NOT NULL COMMENT '数据库用户名',
  `DB_PASS` text NOT NULL COMMENT '数据库密码',
  `DB_URL` text NOT NULL COMMENT '数据库连接串',
  `DB_DRIVER` varchar(200) NOT NULL COMMENT '数据库驱动',
  `db_name` varchar(256) NOT NULL DEFAULT '',
  `db_type` char(1) NOT NULL DEFAULT '',
  `ip` varchar(255) DEFAULT NULL,
  `port` varchar(128) DEFAULT NULL,
  `real_db_name` varchar(52) DEFAULT NULL,
  `connect_type` varchar(20) DEFAULT NULL,
  `service_name` varchar(129) DEFAULT NULL,
  `failover` varchar(10) DEFAULT NULL,
  `load_balance` varchar(10) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`APP_ID`,`db_name`,`db_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_DATABASE
-- ----------------------------

-- ----------------------------
-- Table structure for `P_LOCK`
-- ----------------------------
DROP TABLE IF EXISTS `P_LOCK`;
CREATE TABLE `P_LOCK` (
  `lock_id` int(3) NOT NULL COMMENT '锁ID',
  `lock_type` char(1) NOT NULL COMMENT '锁类型,L:进程加载锁;R:进程运行锁;J:失败JOB重新加载锁',
  `lock_time` datetime DEFAULT NULL COMMENT '锁开始时间',
  `memo` varchar(20) DEFAULT NULL COMMENT '该字段用来存放备注:当锁类型为C时,存放本次流程创建日期',
  PRIMARY KEY (`lock_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_LOCK
-- ----------------------------
INSERT INTO `P_LOCK` VALUES ('1', 'C', null, '2016-09-09');
INSERT INTO `P_LOCK` VALUES ('5', 'I', null, '2016-09-02 16:39:16');
INSERT INTO `P_LOCK` VALUES ('4', 'J', null, null);
INSERT INTO `P_LOCK` VALUES ('2', 'L', null, null);
INSERT INTO `P_LOCK` VALUES ('3', 'R', null, null);

-- ----------------------------
-- Table structure for `P_PROCESS_DEF`
-- ----------------------------
DROP TABLE IF EXISTS `P_PROCESS_DEF`;
CREATE TABLE `P_PROCESS_DEF` (
  `process_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '流程ID',
  `process_name` varchar(200) NOT NULL COMMENT '流程名称',
  `process_desc` text COMMENT '流程描述',
  `valid_date` date NOT NULL COMMENT '流程有效期',
  `process_priority` char(1) NOT NULL DEFAULT 'L' COMMENT '流程优先级:L:低优先级N:正常优先级 H:高优先级',
  `process_app` varchar(100) NOT NULL COMMENT '流程所属应用',
  `schedule_type` char(1) NOT NULL COMMENT '调度类型:O:只运行一次D:每日运行W:每周运行M:每月运行Q:每季运行Y:每年运行',
  `schedule_date` date NOT NULL COMMENT '运行日期',
  `schedule_time` time NOT NULL COMMENT '运行时间',
  `latest_schedule_time` time DEFAULT NULL COMMENT '最晚运行时间',
  `alarm_type` char(1) NOT NULL COMMENT '失败告警方式N:不告警E:邮件告警S:短信告警',
  `alarm_target` text NOT NULL COMMENT '告警对象',
  `bpmn_def` text NOT NULL COMMENT '流程的BPMN定义',
  `json_def` text NOT NULL COMMENT '流程的JSON定义,用于页面展现',
  `created_by` varchar(50) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  `process_state` char(1) NOT NULL DEFAULT 'N' COMMENT '流程状态 :N正常,D禁止',
  `process_variables` text COMMENT '流程变量',
  `investigation_result` text COMMENT '流程审核结果',
  PRIMARY KEY (`process_id`),
  UNIQUE KEY `UNI_PROCESS_NAME` (`process_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_PROCESS_DEF
-- ----------------------------

-- ----------------------------
-- Table structure for `P_PROCESS_DEP`
-- ----------------------------
DROP TABLE IF EXISTS `P_PROCESS_DEP`;
CREATE TABLE `P_PROCESS_DEP` (
  `process_id` int(20) NOT NULL COMMENT '流程ID',
  `dependent_process_id` int(20) NOT NULL COMMENT '本流程依赖的流程id',
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  PRIMARY KEY (`id`),
  KEY `IDX_PROC_DEP_PROCESS_ID` (`process_id`),
  KEY `IDX_PROC_DEP_DEPENDENT_PROCESS_ID` (`dependent_process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_PROCESS_DEP
-- ----------------------------

-- ----------------------------
-- Table structure for `P_PROCESS_ID_GEN`
-- ----------------------------
DROP TABLE IF EXISTS `P_PROCESS_ID_GEN`;
CREATE TABLE `P_PROCESS_ID_GEN` (
  `process_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_PROCESS_ID_GEN
-- ----------------------------

-- ----------------------------
-- Table structure for `P_PROCESS_RUN`
-- ----------------------------
DROP TABLE IF EXISTS `P_PROCESS_RUN`;
CREATE TABLE `P_PROCESS_RUN` (
  `PROCESS_ID` int(20) NOT NULL DEFAULT '0' COMMENT '流程ID',
  `EXEC_DATE` date NOT NULL COMMENT '流程执行日期',
  `START_TIME` datetime DEFAULT NULL COMMENT '流程开始执行时间',
  `END_TIME` datetime DEFAULT NULL COMMENT '流程结束执行时间',
  `RUN_TIME` int(11) DEFAULT NULL COMMENT '运行时长',
  `MESSAGE` text COMMENT '流程执行过程中产生的信息,如出错信息',
  `PROCESS_STATUS` char(1) NOT NULL COMMENT '流程执行状态:W:等待执行;Q:内存排队;R:正在执行S:成功执行F:失败执行P:暂停执行C:取消执行',
  `REMEDY_TIMES` int(11) DEFAULT '0' COMMENT '补偿执行次数',
  `LATEST_SCHEDULE_TIME` time DEFAULT NULL COMMENT '最晚调度时间',
  `SCHEDULE_TIME` time NOT NULL COMMENT '调度运行时间',
  `process_priority` char(1) NOT NULL DEFAULT 'N' COMMENT '流程优先级:L:低优先级N:正常优先级 H:高优先级',
  `PROCESS_NAME` varchar(200) DEFAULT NULL COMMENT '流程名称',
  `BPMN_DEF` text NOT NULL COMMENT '流程BPMN2.0定义',
  `PROCESS_VARIABLES` text COMMENT '流程变量',
  `SCHEDULE_DATE` date NOT NULL COMMENT '调度日期',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '记录创建时间',
  `CREATED_BY` varchar(50) DEFAULT NULL COMMENT '创建人',
  `process_type` char(1) NOT NULL DEFAULT 'N' COMMENT '流程类型:H:补跑流程N:正常流程',
  `process_app` varchar(100) NOT NULL COMMENT '流程所属应用',
  PRIMARY KEY (`PROCESS_ID`,`EXEC_DATE`),
  KEY `IDX_PROCESS_RUN_EXEC_DATE` (`EXEC_DATE`),
  KEY `IDX_PROCESS_RUN_PROCESS_ID` (`PROCESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_PROCESS_RUN
-- ----------------------------

-- ----------------------------
-- Table structure for `P_PROCESS_SMS`
-- ----------------------------
DROP TABLE IF EXISTS `P_PROCESS_SMS`;
CREATE TABLE `P_PROCESS_SMS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip_addr` varchar(50) NOT NULL DEFAULT '',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `context` text,
  `p_event_date` varchar(20) NOT NULL DEFAULT '',
  `is_send` tinyint(1) unsigned zerofill NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_PROCESS_SMS
-- ----------------------------

-- ----------------------------
-- Table structure for `P_SYS_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `P_SYS_CONFIG`;
CREATE TABLE `P_SYS_CONFIG` (
  `priority` int(1) NOT NULL,
  `type` char(1) NOT NULL,
  `url` text NOT NULL,
  `user` varchar(255) DEFAULT '',
  `passwd` varchar(255) DEFAULT '',
  `target` varchar(255) DEFAULT '',
  `ip` varchar(50) DEFAULT NULL,
  `port` varchar(10) DEFAULT NULL,
  `db_name` varchar(52) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`priority`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_SYS_CONFIG
-- ----------------------------

-- ----------------------------
-- Table structure for `P_SYS_MAP`
-- ----------------------------
DROP TABLE IF EXISTS `P_SYS_MAP`;
CREATE TABLE `P_SYS_MAP` (
  `key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `P_SYS_MAP` VALUES ('hadoop.security.authentication', 'simple');

-- ----------------------------
-- Records of P_SYS_MAP
-- ----------------------------

-- ----------------------------
-- Table structure for `P_TASK_DEF`
-- ----------------------------
DROP TABLE IF EXISTS `P_TASK_DEF`;
CREATE TABLE `P_TASK_DEF` (
  `TASK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `PROCESS_ID` int(11) NOT NULL COMMENT '所属流程ID',
  `TASK_NAME` varchar(255) NOT NULL COMMENT '任务名',
  `TASK_TYPE` char(2) NOT NULL COMMENT '任务类型: TR:数据迁移 HD:HDFS任务 MR:Map/Reduce任务 HI:HIVE任务 MS:MYSQL任务 SH:SHELL任务 JV:JAVA任务 CC:CACHE任务 KV:key value store任务 DP:依赖任务 ',
  `TASK_PARAM` text COMMENT '参数JSON格式',
  `CREATED_DATE` varchar(50) NOT NULL COMMENT '创建时间',
  `CREATED_BY` datetime NOT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) DEFAULT NULL COMMENT '修改人',
  `UPDATED_DATE` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`TASK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_TASK_DEF
-- ----------------------------

-- ----------------------------
-- Table structure for `P_TASK_ID_GEN`
-- ----------------------------
DROP TABLE IF EXISTS `P_TASK_ID_GEN`;
CREATE TABLE `P_TASK_ID_GEN` (
  `task_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`task_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_TASK_ID_GEN
-- ----------------------------

-- ----------------------------
-- Table structure for `P_TASK_RUN`
-- ----------------------------
DROP TABLE IF EXISTS `P_TASK_RUN`;
CREATE TABLE `P_TASK_RUN` (
  `TASK_ID` int(20) NOT NULL DEFAULT '0' COMMENT '任务ID',
  `PROCESS_ID` int(20) NOT NULL COMMENT '流程ID',
  `TASK_NAME` varchar(255) NOT NULL COMMENT '任务名称',
  `TASK_TYPE` varchar(50) NOT NULL COMMENT '任务类型TRANSFER, HDFS, MAPREDUCE, HIVE, MYSQL, SHELL, JAVA, CACHE, KV, DEP',
  `EXEC_DATE` date NOT NULL DEFAULT '0000-00-00' COMMENT '任务执行日期',
  `START_TIME` datetime DEFAULT NULL COMMENT '任务开始执行时间',
  `END_TIME` datetime DEFAULT NULL COMMENT '任务结束执行时间',
  `RUN_TIME` int(11) DEFAULT NULL COMMENT '运行时长',
  `REMEDY_TIMES` int(11) DEFAULT '0' COMMENT '补偿执行次数',
  `TASK_STATUS` char(1) NOT NULL COMMENT '任务执行状态:W:等待执行;Q:内在排队;R:正在执行S:成功执行F:失败执行P:暂停执行C:取消执行D禁止/失效',
  `MESSAGE` text COMMENT '任务执行过程中产生的信息,如出错信息',
  `SCHEDULE_TIME` time DEFAULT NULL COMMENT '调度运行时间',
  `LATEST_SCHEDULE_TIME` time DEFAULT NULL COMMENT '最晚调度时间',
  PRIMARY KEY (`TASK_ID`,`EXEC_DATE`),
  KEY `IDX_TASK_RUN_PROCESS_ID` (`PROCESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_TASK_RUN
-- ----------------------------

-- ----------------------------
-- Table structure for `P_THREAD_POOL_CONFIG`
-- ----------------------------
DROP TABLE IF EXISTS `P_THREAD_POOL_CONFIG`;
CREATE TABLE `P_THREAD_POOL_CONFIG` (
  `pool_id` int(11) NOT NULL COMMENT '线程池ID',
  `pool_name` varchar(100) NOT NULL COMMENT '资源池名称',
  `core_pool_size` int(11) NOT NULL COMMENT '初始线程数',
  `max_pool_size` int(11) NOT NULL COMMENT '最大线程数',
  PRIMARY KEY (`pool_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of P_THREAD_POOL_CONFIG
-- ----------------------------
INSERT INTO `P_THREAD_POOL_CONFIG` VALUES ('1', 'P_DEFAULT', '50', '50');
