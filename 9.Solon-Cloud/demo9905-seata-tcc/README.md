## 本示例演示内容包括：

* seata tcc 模式使用

#### 演示配置初始化

1. Seata Server

2. 准备数据库

```sql
drop table if exists tcc_fence_log;
CREATE TABLE IF NOT EXISTS `tcc_fence_log`
(
    `xid`
    VARCHAR
(
    128
) NOT NULL COMMENT 'global id',
    `branch_id` BIGINT NOT NULL COMMENT 'branch id',
    `action_name` VARCHAR
(
    64
) NOT NULL COMMENT 'action name',
    `status` TINYINT NOT NULL COMMENT 'status(tried:1;committed:2;rollbacked:3;suspended:4)',
    `gmt_create` DATETIME
(
    3
) NOT NULL COMMENT 'create time',
    `gmt_modified` DATETIME
(
    3
) NOT NULL COMMENT 'update time',
    PRIMARY KEY
(
    `xid`,
    `branch_id`
),
    KEY `idx_gmt_modified`
(
    `gmt_modified`
),
    KEY `idx_status`
(
    `status`
)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;

drop table if exists demo;
CREATE TABLE `demo`
(
    `code` varchar(50) NOT NULL,
    PRIMARY KEY (`code`)
);
```

3. 启动`demo9905.server.ServarApp`remote
4. 启动`client.ClientApp`client
5. 请求地址

- `http://127.0.0.1:8080/insert?code=remote` remote报错应该全回滚(此处有问题)
- `http://127.0.0.1:8080/insert?code=local` local报错应该全回滚
- `http://127.0.0.1:8080/insert?code=test` 全回滚
- `http://127.0.0.1:8080/insert?code=xxx` 正常插入

亦或直接运行单测`test.ClientTest`
