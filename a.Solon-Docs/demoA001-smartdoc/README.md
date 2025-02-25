操作说明：

- 1.先用 maven 编译或打包（第2步，需要 target/classes 下的内容）
- 2.再使用 maven 插件 smart-doc 生成 html 文档（会放在 static/doc 下面，这个由 smart-doc.json 配置）
- 3.启动程序
- 4.打开 http://localhost:8089/doc/api.html （端口，由 app.yml 配置）