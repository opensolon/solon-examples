CREATE TABLE `appx` (
                        `app_id` int NOT NULL AUTO_INCREMENT COMMENT '应用ID',
                        `app_key` varchar(40) DEFAULT NULL COMMENT '应用访问KEY',
                        `akey` varchar(40) DEFAULT NULL COMMENT '（用于取代app id 形成的唯一key） //一般用于推广注册之类',
                        `ugroup_id` int DEFAULT '0' COMMENT '加入的用户组ID',
                        `agroup_id` int DEFAULT NULL COMMENT '加入的应用组ID',
                        `name` varchar(50) DEFAULT NULL COMMENT '应用名称',
                        `note` varchar(50) DEFAULT NULL COMMENT '应用备注',
                        `ar_is_setting` int NOT NULL DEFAULT '0' COMMENT '是否开放设置',
                        `ar_is_examine` int NOT NULL DEFAULT '0' COMMENT '是否审核中(0: 没审核 ；1：审核中)',
                        `ar_examine_ver` int NOT NULL DEFAULT '0' COMMENT '审核 中的版本号',
                        `log_fulltime` datetime DEFAULT NULL,
                        PRIMARY KEY (`app_id`)
);

CREATE TABLE `test` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `v1` int DEFAULT NULL,
                        `v2` int DEFAULT NULL,
                        PRIMARY KEY (`id`)
);

INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (1, '1', 'a', 1, 1, 'iOS-0', '', 1, 0, 0, '2017-08-25 10:59:44');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (2, '2', 'b', 1, 1, 'Android-0', '', 0, 0, 0, '2017-08-11 18:05:27');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (3, '3', 'c', 1, 1, 'Android-yyb', '000', 1, 0, 0, '2017-08-25 10:59:44');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (4, '4', 'd', 1, 1, 'Android-bd', '', 0, 0, 0, '2017-08-04 17:19:41');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (5, '5', 'e', 1, 1, 'Android-91', '', 0, 0, 0, '2017-08-04 17:16:18');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (6, '6', 'f', 1, 1, 'Android-92', '', 0, 0, 0, '2017-08-04 17:23:45');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (7, '7', 'g', 1, 1, 'Android-93', '', 0, 0, 0, '2017-08-25 10:47:44');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (8, '8', 'h', 1, 1, 'HarmonyOS-hw', NULL, 1, 0, 0, '2017-08-25 10:59:44');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (9, '9', 'i', 1, 1, 'Android-op', '', 0, 0, 0, '2017-08-25 10:47:44');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (10, '10', 'j', 1, 1, 'Android-pp', '', 0, 0, 0, '2017-08-04 17:36:20');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (11, '11', 'k', 1, 1, 'Android-1', '', 0, 0, 0, '2017-08-04 17:36:32');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (12, '12', 'n', 1, 1, 'Android-2', '', 0, 0, 0, '2017-08-04 17:36:46');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (13, '13', 'm', 1, 1, 'Android-3', '', 0, 0, 0, '2017-08-04 17:37:00');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (14, '14', 'o', 1, 1, 'Android-4', '', 0, 0, 0, '2017-08-25 10:55:37');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (15, '15', 'x', 1, 1, 'Android-5', '', 0, 0, 0, '2017-08-25 10:55:37');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (16, '16', 'y', 1, 1, 'iOS-Pro', NULL, 0, 0, 0, '2017-08-04 17:38:15');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (17, '17', 'z', 1, 1, 'iOS-2', NULL, 0, 0, 0, '2017-08-04 17:38:26');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (18, '18', 'u', 1, 1, 'iOS-3', NULL, 0, 0, 0, '2017-08-04 17:38:40');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (19, '19', 'w', 1, 1, 'Android-a', NULL, 0, 0, 0, '2017-08-04 17:38:57');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (20, '20', 'a1', 1, 1, 'Android-b', NULL, 0, 0, 0, '2017-08-04 17:39:09');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (21, '21', 'b1', 1, 1, 'Android-c', NULL, 0, 0, 0, '2017-08-04 17:39:23');
INSERT INTO `appx` (`app_id`, `app_key`, `akey`, `ugroup_id`, `agroup_id`, `name`, `note`, `ar_is_setting`, `ar_is_examine`, `ar_examine_ver`, `log_fulltime`) VALUES (22, '22', 'c1', 1, 1, 'Android-d', NULL, 1, 0, 0, '2017-08-04 17:39:39');


CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(50) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
);