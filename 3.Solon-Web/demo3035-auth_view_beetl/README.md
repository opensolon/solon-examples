
### 适配 AuthProcessor 适配样例

```java
public  class AuthProcessorImpl extends AuthProcessorBase {
    @Override
    public boolean verifyLogined() {
        return true;
    }

    @Override
    protected List<String> getPermissions() {
        List<String> list = new ArrayList<>();

        list.add("user:add");
        list.add("user:demo");

        return list;
    }

    @Override
    protected List<String> getRoles() {
        List<String> list = new ArrayList<>();

        list.add("admin1");
        list.add("admin2");

        return list;
    }
}
```

### 模板标签使用样例

```html
<#authPermissions name="user:del">
我有user:del权限
</#authPermissions>

<#authRoles name="admin">
我有admin角色
</#authRoles>
```