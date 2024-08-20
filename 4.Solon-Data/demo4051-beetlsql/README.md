
### 配置示例

数据源配置与构建参考：
 * https://solon.noear.org/article/794

```yaml
solon.dataSources.db1!:
  schema: rock
  jdbcUrl: jdbc:mysql://localhost:3306/rock?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=true
  driverClassName: com.mysql.jdbc.Driver
  username: root
  password: 123456

# 配置印射的是 SQLManagerBuilder 字段
beetlsql.db1:
  dialect: "mysql" #快捷配置：方言
  debug: true  #快捷配置：是否调试模式
  slaves: "db2,db3"  #快捷配置：从库配置
  nc: "org.wisecloud.common.db.beetlsql.JPANameConversion" #字段映射
  dbStyle: "org.beetl.sql.core.db.MySqlStyle" #字段映射：与 dialect 效果相同
  inters: #字段映射
    - "org.beetl.sql.ext.DebugInterceptor" #与 debug 效果相同
    - "org.beetl.sql.ext.Slf4JLogInterceptor"
```