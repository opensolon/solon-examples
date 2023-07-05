### 1、在maven增加JavaFX依赖

```xml
<dependencies>
    <!-- 这个版本号，可以与编译的 java 版本号相同 -->
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>11</version>
    </dependency>
    
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>11</version>
    </dependency>
</dependencies>
```
 
### 2、solon与JavaFX启动顺序
Solon优先于JavaFX启动。相当于Solon启动完成后，所有的Bean都已经被Solon管理了，接着JavaFX再来启动时，就可以通过依赖注入的方式往Controller里注入Bean了。

例子： LicenseApp.java

```java
@Component
public class LicenseApp extends Application implements EventListener<AppBeanLoadEndEvent> {

    @Override
    public void onEvent(AppBeanLoadEndEvent appBeanLoadEndEvent) throws Throwable {
        launch(LicenseApp.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(ResourceUtil.getResource("javafx/license.fxml"));
        loader.setControllerFactory(new ControllerFactory());

        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("License UI v1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
```

### 3、solon管理JavaFX的Controller

JavaFX的Controller相当于MVC模式中的C，而V可以理解为UI部分，此处指FXML文件。一般情况下，我们会在FXML中的里指定：fx:controller，例如：

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import java.lang.*?>
<?import java.util.*?>
<?import javafx.scene.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox prefHeight="400.0" prefWidth="600.0"
            xmlns="http://javafx.com/javafx/8"
            xmlns:fx="http://javafx.com/fxml/1"
            fx:controller="demo1091.disk.controller.LicenseController">

</VBox>
```

而JavaFx对Controller的默认加载，是根据类路径+反射的方式。但也提供了配置ControllerFactory的工厂模式开放给用户自定义Controller的加载方式。

为了让Solon对Controller代为托管，我们可以创建一个SolonControllerFactory来实现Callback接口。如下所示：

```java
public class ControllerFactory implements Callback<Class<?>, Object> {
    @Override
    public Object call(Class<?> aClass) {
        return Solon.context().getBeanOrNew(aClass);
    }
}
```

使用方法：

```java
FXMLLoader loader = new FXMLLoader(ResourceUtil.getResource("javafx/license.fxml"));
loader.setControllerFactory(new ControllerFactory());
```