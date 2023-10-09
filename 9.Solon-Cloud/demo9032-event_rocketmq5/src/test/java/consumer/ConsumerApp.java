package consumer;

import org.noear.solon.Solon;

/**
 * @author noear 2021/1/27 created
 */
public class ConsumerApp {
    public static void main(String[] args) {
        Solon.start(ConsumerApp.class, args);
    }
}