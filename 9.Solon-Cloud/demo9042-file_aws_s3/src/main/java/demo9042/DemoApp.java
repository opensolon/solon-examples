package demo9042;

import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.Utils;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Media;
import org.noear.solon.core.handle.Result;
import org.noear.solon.core.util.ResourceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

/**
 * @author noear 2021/4/8 created
 */
public class DemoApp {
    public static void main(String[] args) throws Exception {
        Solon.start(DemoApp.class, args);

        test();

        System.out.println("------------");

        test2();
    }

    public static void test() {
        if (CloudClient.file() == null) {
            System.err.println("This file service is not available");
            return;
        }

        String key = "test/" + Utils.guid();
        String val = "Hello world!";

        //上传字符串内容
        Result result = CloudClient.file().put(key, new Media(val));
        System.out.println(ONode.stringify(result));
        assert result.getCode() == Result.SUCCEED_CODE;


        //获取字符串内容
        String tmp = CloudClient.file().get(key).bodyAsString();
        System.out.println(tmp);
        assert val.equals(tmp);


        String url = CloudClient.file().getTempUrl(key, Duration.ofSeconds(2L));
        System.out.println(url);
        assert url.contains("://");
    }


    public static void test2() throws Exception {
        if (CloudClient.file() == null) {
            System.err.println("This file service is not available");
            return;
        }

        // test_id/xxx.png
        String key = "test/" + Utils.guid() + ".png";
        File val = new File(ResourceUtil.getResource("test.png").getFile());

        //file url like : http://xx.xx.xx/test/xxx.png

        //上传文件
        Result result = CloudClient.file().put(key, new Media(new FileInputStream(val), Utils.mime(val.getName())));
        System.out.println(ONode.stringify(result));
        assert result.getCode() == Result.SUCCEED_CODE;
    }
}
