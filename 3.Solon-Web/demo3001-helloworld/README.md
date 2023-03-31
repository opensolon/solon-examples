# 利用 Solon-web 框架写一个 Hello World

**Solon 项目的开源地址：**

[https://gitee.com/noear/solon](https://gitee.com/noear/solon)

> 最近看了不少别人写的各种框架的 `Hello world` 示例，有些看起来，真的很复杂。
> 
> 今天，我们用号称简单到不能再简单的 `Solon` 框架也写一个 `Hello world`（确实是0配置，除了meven）

### 一、写代码

#### 1. 用 IntelliJ IDEA 新建一个 Meven 空项目 `helloworld`
#### 2. 在 `pom.xml` 文件里添加框架依赖
```xml
<dependencies>
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon-web</artifactId>
        <version>2.2.8</version>
    </dependency>
</dependencies>
```

#### 3. 添加应用启动入口 `/src/main/java/helloworld/App.java`
```
package helloworld;

import org.noear.solon.Solon;

public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}
```

#### 4. 添加控制器 `/src/main/java/helloworld/controller/HelloController.java`
```
package helloworld.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    /**
     * 这是直接返回值
     * */
    @Mapping("/")
    public String hello() {
        return "Hello world!";
    }

    /**
     * 这是返回个对象（以json形式）
     * */
    @Mapping("/json")
    public Map hello_json() {
        Map<String,Object> map = new HashMap<>(); //实体也ok
        map.put("message", "Hello world!");

        return map;
    }

    /**
     * 这是用 FreeMarker 进行渲染（你想用别的引擎？可以随便换，比如：Enjoy）
     * */
    @Mapping("/ftl")
    public ModelAndView hello_ftl() {
        ModelAndView mv = new ModelAndView("hello.ftl");
        mv.put("message", "Hello world!");

        return mv;
    }
}

```

#### 5.再添加个模板文件 `/src/main/resources/WEB-INF/view/hello.ftl`
```html
<html>
    <body>
    ${message!}
    </body>
</html>
```

####  6. 运行 `App.main()`

对着 App.java 文件，右键，选择：`Run 'App.main()'`

####  7. 用浏览器打开：`http://localhost:8080/`

####  8. 再用wrk测试一下qps

测试代码：`wrk -t10 -c200 -d30s --latency "http://127.0.0.1:8080/"` ；大概有 4.5万的qps，不错的

听说切换到嵌入式 `jetty` 有 6.5万左右；切换到嵌入式 `undertow` 有 8万左右。

`solon-mvc` 默认配的是 jlhttp，不过它小巧，只有0.1m

到此，写代码的事儿。搞定了！

### 二、发布服务包

####  1. 再修改下pom.xml文件，添加打包配置

```xml

<dependencies>
    <dependency>
        <groupId>org.noear</groupId>
        <artifactId>solon-web</artifactId>
        <version>2.2.8</version>
    </dependency>
</dependencies>

<build>
<finalName>${project.artifactId}</finalName>
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
            <compilerArgument>-parameters</compilerArgument>
            <source>11</source>
            <target>11</target>
            <encoding>UTF-8</encoding>
        </configuration>
    </plugin>

    <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <configuration>
            <finalName>${project.artifactId}</finalName>
            <appendAssemblyId>false</appendAssemblyId>
            <descriptorRefs>
                <descriptorRef>jar-with-dependencies</descriptorRef>
            </descriptorRefs>
            <archive>
                <manifest>
                    <mainClass>demo3001.WebApp</mainClass>
                </manifest>
            </archive>
        </configuration>
        <executions>
            <execution>
                <id>make-assembly</id>
                <phase>package</phase>
                <goals>
                    <goal>single</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
</plugins>
</build>
```

####  2. 使用meven打包命令，打包成：`helloworld.jar`

OK，传说中的一个微形小服务出来了。

#### 3. 用命令运行 `java -jar helloworld.jar` （不用容器，不用容器，不用容器......）

再用浏览器打开：`http://localhost:8080/`

### 三、DEMO源码

[源码：demo02.solon_helloworld](https://gitee.com/noear/solon_demo/tree/master/demo02.solon_helloworld)
