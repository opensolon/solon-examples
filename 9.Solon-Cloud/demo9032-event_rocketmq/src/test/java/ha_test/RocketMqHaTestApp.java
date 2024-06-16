package ha_test;

import org.noear.solon.Solon;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.EventLevel;
import org.noear.solon.cloud.model.Event;
import org.noear.solon.core.event.AppPluginLoadEndEvent;

import java.util.concurrent.CountDownLatch;

public class RocketMqHaTestApp {
    public static void main(String[] args) throws Exception {
        int count = 10_000;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        Solon.start(RocketMqHaTestApp.class, args, app -> {
            app.onEvent(AppPluginLoadEndEvent.class, e -> {
                //订阅
                CloudClient.event().attention(EventLevel.cluster, "", "", "ha.test", "", 1, new CloudEventHandler() {
                    @Override
                    public boolean handle(Event event) throws Throwable {
                        countDownLatch.countDown();
                        return true;
                    }
                });
            });
        });

        //发布
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            CloudClient.event().publish(new Event("ha.test", "demo"));
        }
        System.out.println("publish timespan:" + (System.currentTimeMillis() - startTime));

        //检测
        countDownLatch.await();
        System.out.println("consumer timespan:" + (System.currentTimeMillis() - startTime));

        System.out.println(countDownLatch.getCount());
    }
}
