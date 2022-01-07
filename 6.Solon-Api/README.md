基于 Gateway 构建协议性质的接口（一般给第三方，或者客户端调用）

#### 示例说明

* step1 : 展示一个 "基于轻网关的接口开发" 最基本开发结构，含单测。
* step2 : 在 step1 基础上，增加 1)接口基类、2)异常处理、3)过滤器处
* step3 : 在 step2 基础上，增加 1)接口状态码规范化管理、2)接口返回改为直接类型、3)缓存与数据处理 //不能启动；因为数据库之类的是错的配置
* step4 : 在 step3 基础上，增加 1)换成JWT session、2)采用xx.xx命名接口名、3)增加锁、防重复提交


轻网关的高级定制可以参考：[https://gitee.com/noear/srww/tree/main/srww.uapi](https://gitee.com/noear/srww/tree/main/srww.uapi)
