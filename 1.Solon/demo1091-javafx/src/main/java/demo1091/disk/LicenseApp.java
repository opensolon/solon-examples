package demo1091.disk;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.noear.solon.core.event.AppBeanLoadEndEvent;
import org.noear.solon.core.event.EventListener;
import org.noear.solon.core.util.ResourceUtil;

@Component
public class LicenseApp extends Application implements EventListener<AppBeanLoadEndEvent> {

    @Override
    public void onEvent(AppBeanLoadEndEvent appBeanLoadEndEvent) throws Throwable {
        //在 bean 扫描完成后执行
        launch(LicenseApp.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //这个函数是在 launch 里 new 后指行的，没法注入 controllerFactory
        ControllerFactory controllerFactory = Solon.context().getBeanOrNew(ControllerFactory.class);

        FXMLLoader loader = new FXMLLoader(ResourceUtil.getResource("javafx/license.fxml"));
        loader.setControllerFactory(controllerFactory);

        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("License UI v1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
