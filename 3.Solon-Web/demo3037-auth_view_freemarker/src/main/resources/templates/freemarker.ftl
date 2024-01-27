<html>
<head>
    <title>${title}</title>
</head>
<body>
ftl::
${message}


<table>
    <tr>
        <td>权限（user:add）</td>
        <td>
            <@authPermissions name="user:add">
            有
            </@authPermissions>
        </td>
    </tr>
    <tr>
        <td>权限（user:del）</td><td>
            <@authPermissions name="user:del">
            有
            </@authPermissions>
        </td>
    </tr>
    <tr>
        <td>权限（user:clear）</td><td>
            <@authPermissions name="user:clear">
            有
            </@authPermissions>
        </td>
    </tr>
    <tr>
        <td>角色（admin1）</td><td>
            <@authRoles name="admin1">
            有
            </@authRoles>
        </td>
    </tr>
    <tr>
        <td>角色（admin2）</td><td>
            <@authRoles name="admin2">
            有
            </@authRoles>
        </td>
    </tr>
    <tr>
        <td>角色（admin3）</td><td>
            <@authRoles name="admin3">
            有
            </@authRoles>
        </td>
    </tr>
</table>
</body>
</html>