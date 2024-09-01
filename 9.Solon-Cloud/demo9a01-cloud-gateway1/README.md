

* 示例1

功能模块，无 server.contextPath （不方便 service 识别）；请求时要加个前缀，转发时去掉这个前缀


* 示例2

功能模块，有 server.contextPath （已经方便 service 识别）

---

# 示例1（本示例）

###  模块服务（没有 server.contextPath）

* 运行 src/min/...App
* 文档地址：http://localhost:8080/doc.html
  * 打开接口 demo/hello ，可调试
* 测试接口地址：http://localhost:8080/hello?name=ddd

### 网关服务

配置时，会加 contextPath; 用于识别 service

* 运行 src/test/labs/...GatewayApp
* 文档地址：http://localhost:8090/doc.html
  * 打开接口 demo/hello ，可调试
* 测试接口地址：http://localhost:8090/demo-app/hello?name=ddd

