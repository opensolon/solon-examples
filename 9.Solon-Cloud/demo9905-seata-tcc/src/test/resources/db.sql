drop table if exists tcc_fence_log;
CREATE TABLE IF NOT EXISTS `tcc_fence_log`
(
`xid`           VARCHAR(128)  NOT NULL COMMENT 'global id',
`branch_id`     BIGINT        NOT NULL COMMENT 'branch id',
`action_name`   VARCHAR(64)   NOT NULL COMMENT 'action name',
`status`        TINYINT       NOT NULL COMMENT 'status',
`gmt_create`    DATETIME(3)   NOT NULL COMMENT 'create time',
`gmt_modified`  DATETIME(3)   NOT NULL COMMENT 'update time',
PRIMARY KEY (`xid`, `branch_id`),
KEY `idx_gmt_modified` (`gmt_modified`),
KEY `idx_status` (`status`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4;

drop table if exists demo;
CREATE TABLE `demo`
(
    `code` varchar(50) NOT NULL,
    PRIMARY KEY (`code`)
);