package demo1091.disk.dso.service;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;

@Slf4j
@Component
public class LicenseService {

    public void hello(){
        log.debug("Hello javafx! I'm LicenseService");
    }
}
