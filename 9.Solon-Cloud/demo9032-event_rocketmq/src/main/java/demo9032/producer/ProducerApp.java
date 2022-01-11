package demo9032.producer;

import org.noear.solon.Solon;

/**
 * @author noear 2021/1/27 created
 */
public class ProducerApp {
    public static void main(String[] args) {
        Solon.start(ProducerApp.class, args).onError(e->e.printStackTrace());
    }
}
