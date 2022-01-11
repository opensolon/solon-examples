## 本示例演示内容包括：

* rpc基础架构
* rpc使用注册与发现服务
* 使用配置服务
* 使用配置服务的注入@CloudConfig
* 订阅配置
* 使用了Solon cloud技术


#### 演示配置初始化

* 增加配置：demo/water_cache_header
```
ddd
```

* 增加配置：demo/test.properties
```
db1.url=jdbc
db1.username=noear
db1.password=xxx
db1.jdbcUrl=${db1.url}
```
  