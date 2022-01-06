
## 安例说明

### 一、适配

* 完成 `AuthAdapter` bean 构建
* 完成 `AuthProcessor` 适配

### 二、应用

* 通过 `AuthAdapter` 的`addRule(...)` 用于添加全局的签权规则
 
```java
new AuthAdapter()
    .addRule(r -> r.include("**").verifyIp().failure((c, t) -> c.output("你的IP不在白名单"))) //添加规则
    .addRule(b -> b.exclude("/login**").exclude("/run/**").verifyPath()) //添加规则

``` 

* 使用注解 `@AuthPermissions`、`@AuthRoles` 控制具体的Java函数
  
```java
@AuthPermissions("agroup:edit")
@Mapping("edit/{id}")
public void edit(int id) {
    //...
}

@AuthRoles("admin")
@Mapping("edit/{id}/ajax/save")
public void save(int id) {
    //...
}
```


* 使用模板标签 `<@authPermissions>`、`<@authRoles>` 控制视图块是否显示

```html
<@authPermissions name="user:del">
我有user:del权限
</@authPermissions>

<@authRoles name="admin">
我有admin角色
</@authRoles>
```


> 其它模板的模板标签参考：demo_beetl, demo_enjoy, demo_freemarker, demo_jsp, demo_thymeleaf, demo_velocity