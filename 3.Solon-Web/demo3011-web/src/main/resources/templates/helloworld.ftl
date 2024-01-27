<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<div>
    ${m.name} : ${message} （我想<a href="/jinjin.htm">静静</a>）

    <div>
        国际化配置：${i18n.get("login.title")}
    </div>
</div>
<@footer/>

</body>
</html>