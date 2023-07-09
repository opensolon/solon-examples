
配置

```yaml
solon.cloud.rabbitmq:
  server: localhost:5672   #rabbitmq 服务地址
  username: root           #rabbitmq 链接账号
  password: 123456         #rabbitmq 链接密码

solon.cloud.rabbitmq_biz:
  server: localhost:5672   #rabbitmq 服务地址
  username: root           #rabbitmq 链接账号
  password: 123456         #rabbitmq 链接密码
  event:
    channel: "biz"
```