这个项目，同时支持单体或分布式。**本方案，采用引入需要的所有包，通过 solon.env 配置切换**：

* 好处：一次打包，随时切换
* 坏处：包可能会大一些

#### 1、通过 app.yml 配置

```yaml
solon.env: local
```

#### 2、启动时指定

```
java -Dsolon.env=local -jar xxx.jar
```

solon v2.0 后都支持本方案