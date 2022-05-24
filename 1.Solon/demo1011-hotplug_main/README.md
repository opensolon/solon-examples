注意事项：

* 插件包名需独立性（避免描扫时扫到别人）
    * 例主程为：xxx 或 xxx.main
    * 插件1为：xxx.add1
    * 插件2为：xxx.add2


演示：

* 打包 demo1011-hotplug_plugin1 (找到 demo1011-hotplug_plugin1.jar 的地址，去做第2步；目前只有7k)
* 替换掉 app.yml 里的 solon.hotplug.add1 的地址
* 启动主程序的 demo1011.App
* 控制台会打印定时任务的执行信息（也可能启动不成，插件里有数据库连接）

> 演示的插件里提供了：web 服务 和 job 服务