package demo9051;

import org.noear.solon.Solon;
import org.noear.solon.cloud.CloudClient;

/**
 * @author noear 2021/4/30 created
 */
public class DemoApp {
    public static void main(String[] args){
        Solon.start(DemoApp.class, args);

        for(int i=0; i<100; i++){
            System.out.println(CloudClient.id().generate());
        }
    }
}
