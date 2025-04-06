## 本示例演示内容包括：

* seata xa 模式使用

#### 演示配置初始化

1. git clone [seata](https://github.com/fuzi1996/seata) 的 `ft/solon` 分支

编译并本地安装

2. 启动`org.apache.seata.server.ServerApplication`Server

3. 准备数据库

```sql
CREATE TABLE `demo`
(
    `code` varchar(50) DEFAULT NULL
);
```

4. 启动`demo9903.server.ServarApp`remote
5. 启动`client.ClientApp`client
6. 请求地址

- `http://127.0.0.1:8080/insert?code=remote` remote报错应该全回滚(此处有问题)
- `http://127.0.0.1:8080/insert?code=local` local报错应该全回滚
- `http://127.0.0.1:8080/insert?code=test` 全回滚
- `http://127.0.0.1:8080/insert?code=xxx` 正常插入
