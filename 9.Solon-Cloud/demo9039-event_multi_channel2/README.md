
### 1、配置示例

```yaml
# 没有配置 event.channel ，则默主为："" 
solon.cloud.mqtt:
  server: "tcp://localhost:41883"   #mqtt服务地址

solon.cloud.rabbitmq:
  server: localhost:5672   #rabbitmq 服务地址
  username: root           #rabbitmq 链接账号
  password: 123456         #rabbitmq 链接密码
  event:
    channel: "biz"
```

### 2、代码示例

订阅消息

```java
//订阅 biz 通道的消息
@CloudEvent(value = "hello.biz", channel = "biz")
public class EVENT_hello_demo2 implements CloudEventHandler {
    @Override
    public boolean handle(Event event) throws Throwable {
        System.out.println(LocalDateTime.now() + ONode.serialize(event));

        return event.times() > 2;
    }
}

//订阅 默认 通道的消息（不指定通道，即为默认）
@CloudEvent("hello.mtt")
public class EVENT_hello_demo2 implements CloudEventHandler {
    @Override
    public boolean handle(Event event) throws Throwable {
        System.out.println(LocalDateTime.now() + ONode.serialize(event));

        return event.times() > 2;
    }
}
```

发送消息

```java
//发送 biz 通道的消息
Event event = new Event("hello.biz", msg).channel("biz");
return CloudClient.event().publish(event);

//发送 默认 通道的消息（不指定通道，即为默认）
Event event = new Event("hello.mtt", msg).qos(1).retained(true);
return CloudClient.event().publish(event);
```
