```sql
CREATE TABLE `appx` (
  `app_id` int NOT NULL AUTO_INCREMENT COMMENT '应用ID',
  `app_key` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '应用访问KEY',
  `akey` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '（用于取代app id 形成的唯一key） //一般用于推广注册之类',
  `ugroup_id` int DEFAULT '0' COMMENT '加入的用户组ID',
  `agroup_id` int DEFAULT NULL COMMENT '加入的应用组ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '应用名称',
  `note` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '应用备注',
  `ar_is_setting` int NOT NULL DEFAULT '0' COMMENT '是否开放设置',
  `ar_is_examine` int NOT NULL DEFAULT '0' COMMENT '是否审核中(0: 没审核 ；1：审核中)',
  `ar_examine_ver` int NOT NULL DEFAULT '0' COMMENT '审核 中的版本号',
  `log_fulltime` datetime DEFAULT NULL,
  PRIMARY KEY (`app_id`) USING BTREE,
  UNIQUE KEY `IX_akey` (`akey`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='应用表';
```

```sql
CREATE TABLE `test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `v1` int DEFAULT NULL,
  `v2` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```