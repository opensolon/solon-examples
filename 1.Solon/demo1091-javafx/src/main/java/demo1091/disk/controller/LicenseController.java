package demo1091.disk.controller;

import java.net.URL;
import java.util.ResourceBundle;

import demo1091.disk.dso.service.LicenseService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


@Component
public class LicenseController implements Initializable {
    @FXML
    private TextField authMacs;

    @FXML
    private TextField cretInfo;

    @FXML
    private DatePicker expirationDate;

    @FXML
    private TextArea license;

    @Inject
    private LicenseService licenseService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        licenseService.hello();
    }
}