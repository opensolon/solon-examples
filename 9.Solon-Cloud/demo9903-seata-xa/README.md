## 本示例演示内容包括：

* seata xa 模式使用

#### 演示配置初始化

1. Seata Server

2. 准备数据库

```sql
drop table if exists demo;
CREATE TABLE `demo`
(
    `code` varchar(50) NOT NULL,
    PRIMARY KEY (`code`)
);
```

3. 启动`demo9903.server.ServarApp`remote
4. 启动`client.ClientApp`client
5. 请求地址

- `http://127.0.0.1:8080/insert?code=remote` remote报错应该全回滚(此处有问题)
- `http://127.0.0.1:8080/insert?code=local` local报错应该全回滚
- `http://127.0.0.1:8080/insert?code=test` 全回滚
- `http://127.0.0.1:8080/insert?code=xxx` 正常插入

亦或直接运行单测`test.ClientTest`
