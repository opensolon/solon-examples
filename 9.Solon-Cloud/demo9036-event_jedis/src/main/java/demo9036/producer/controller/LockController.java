package demo9036.producer.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;

import java.util.Date;

/**
 * @author noear 2021/1/27 created
 */
@Controller
public class LockController {
    @Mapping("lock")
    public Object lock() {
        if (CloudClient.lock().tryLock("lock", 3)) {
            return new Date();
        } else {
            return "0000";
        }
    }
}
