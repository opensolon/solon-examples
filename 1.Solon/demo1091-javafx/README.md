### 1、在 maven 增加 JavaFX 依赖

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
 
### 2、定义 JavaFX 应用启动组件，并对接 Solon 容器

通过 solon 的生命周期事件，在 bean 扫描完成后，启动 JavaFX Application。启动时，按需要加载 fxml

* 定义 JavaFX 应用： LicenseApp.java

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
        loader.setControllerFactory(new ControllerFactoryImpl());

        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("License UI v1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
```

* 与 Solon 容器的对接工厂：ControllerFactoryImpl.java

JavaFx 对 Controller 的默认加载，是根据类路径 + 反射的方式。但也提供了配置 ControllerFactory 的工厂模式开放给用户自定义 Controller 的加载方式。 为了让 Solon 代为托管 Controller 类，我们可以创建一个 ControllerFactoryImpl 来实现 Callback 接口。如下所示：

```java
public class ControllerFactory implements Callback<Class<?>, Object> {
    @Override
    public Object call(Class<?> aClass) {
        //从 solon 容器获取
        return Solon.context().getBeanOrNew(aClass);
    }
}
```

### 3、用 Solon 管理 JavaFX 控制器

* 控制器：LicenseController.java

```java
@Component
public class LicenseController implements Initializable {
    @FXML
    private TextArea license;

    @Inject
    private LicenseService licenseService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //测试 service 是否正常
        licenseService.hello();
    }
}
```

* 视图： fxml文件（通过 fx:controller 关联 java 控制器）

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

### 4、说见示例源码
