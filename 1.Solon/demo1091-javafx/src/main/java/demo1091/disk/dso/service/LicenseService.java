package demo1091.disk.dso.service;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Managed;

@Slf4j
@Managed
public class LicenseService {

    public void hello(){
        log.debug("Hello javafx! I'm LicenseService");
    }
}
