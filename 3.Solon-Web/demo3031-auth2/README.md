
运行 DemoApp 后，测示效果

http://localhost:8080/          ::显示ok
http://localhost:8080/test      ::显示ok

http://localhost:8080/admin/       ::提示不是ip白名单
http://localhost:8080/admin/login  ::提示不是ip白名单

http://localhost:8080/user/      ::会跳到 /login
http://localhost:8080/user/test  ::会跳到 /login
http://localhost:8080/user/login