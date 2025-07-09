# 1.下载sentinel

https://github.com/alibaba/Sentinel/releases

# 2.使用如下命令启动控制台

```shell
java -Dserver.port=8858 -Dcsp.sentinel.dashboard.server=localhost:8858 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
```

> 注意：sentinel的默认端口为8080，如启动时未修改默认端口则需将app.yml配置文件中的端口修改为8080

```yaml
csp.sentinel.dashboard.server: localhost:8858
# 调整为 csp.sentinel.dashboard.server: localhost:8080
```

>
其中`-Dserver.port=8858` 用于指定 Sentinel 控制台端口为 8858。默认用户名和密码都是 `sentinel`

# 3.启动当前example

# 4.调用http:localhost:8080

# 5.观察sentinel控制台，发现应用注册到dashboard

