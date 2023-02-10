
mybatis 配置示例：

```yaml
mybatis.db1:
    typeAliases:    #支持包名 或 类名（.class 结尾）
        - "demo4031.model"
#        - "demo4031.*.AppxModel.class"
    mappers:        #支持包名 或 类名（.class 结尾）或 xml（.xml结尾）
        - "demo4031.dso.mapper"
#        - "demo4031.**.mapper"
#        - "demo4031/dso/mapper/*.xml"
    configuration:
        cacheEnabled: false
        mapUnderscoreToCamelCase: true
        logImpl: org.apache.ibatis.logging.nologging.NoLoggingImpl
    globalConfig:
        banner: false
        metaObjectHandler: "demo4031.dso.MetaObjectHandlerImpl"
        dbConfig:
            logicDeleteField: "deleted"
            logicDeleteValue: "2"

```