
SQLink 配置示例：

```yaml
# solon数据源配置
solon.dataSources:
  main!: # 数据源名称
    class: "com.zaxxer.hikari.HikariDataSource"
    jdbcUrl: "jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL;DATABASE_TO_LOWER=TRUE;IGNORECASE=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE"
    driverClassName: "org.h2.Driver"
  sub: # 数据源名称
    class: "com.zaxxer.hikari.HikariDataSource"
    jdbcUrl: "jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL;DATABASE_TO_LOWER=TRUE;IGNORECASE=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE"
    driverClassName: "org.h2.Driver"
    
# sqlink配置
solon.data.sqlink:
  # 用到几个就配几个
  # 使用@inject注入，不填名称的情况下默认为第一个
  main: # 名称与数据源名称一致
    printSql: true # 是否打印sql
  sub:
    printSql: true
```