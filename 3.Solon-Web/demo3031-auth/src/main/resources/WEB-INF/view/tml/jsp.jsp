<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="auth" uri="http://solon.noear.org/auth" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
jsp::${message}


<table>
    <tr>
        <td>权限（user:add）</td>
        <td>
            <auth:permissions name="user:add">
            有
            </auth:permissions>
        </td>
    </tr>
    <tr>
        <td>权限（user:del）</td><td>
        <auth:permissions name="user:del">
            有
        </auth:permissions>
        </td>
    </tr>
    <tr>
        <td>权限（user:clear）</td><td>
        <auth:permissions name="user:clear">
            有
        </auth:permissions>
        </td>
    </tr>
    <tr>
        <td>角色（admin1）</td><td>
        <auth:roles name="admin1">
            有
        </auth:roles>
        </td>
    </tr>
    <tr>
        <td>角色（admin2）</td><td>
        <auth:roles name="admin2">
            有
        </auth:roles>
        </td>
    </tr>
    <tr>
        <td>角色（admin3）</td><td>
        <auth:roles name="admin3">
            有
        </auth:roles>
        </td>
    </tr>
</table>
</body>
</html>