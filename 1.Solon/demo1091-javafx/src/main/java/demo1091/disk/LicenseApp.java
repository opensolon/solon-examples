package demo1091.disk;

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
        new Thread(() -> {
            launch(LicenseApp.class);
        }).start();
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
