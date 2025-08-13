package demo1091.disk.controller;

import java.net.URL;
import java.util.ResourceBundle;

import demo1091.disk.dso.service.LicenseService;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


@Managed
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