package demo1001.demo2_2.dso;

import demo1001.demo2.dso.TrackService;
import demo1001.demo2.dso.UserService;
import org.noear.solon.Solon;

/**
 * 如何手动获取Bean？
 *
 * @author noear 2021/12/28 created
 */
public class DemoService {
    private TrackService trackService;
    private UserService userService;

    public DemoService(){
        //同步方式，根据bean type获取Bean（如果此时不存在，则返回null。需要注意时机）
        trackService = Solon.context().getBean(TrackService.class);

        //同步方式，根据bean type获取Bean（如果此时不存在，自动生成一个Bean并注册+返回）
        trackService = Solon.context().getBeanOrNew(TrackService.class);

        //同步方式，根据bean name获取Bean（如果此时不存在，则返回null）
        userService = Solon.context().getBean("userService");

        //异步订阅方式，根据bean type获取Bean（已存在或产生时，会通知回调；否则，一直不回调）
        Solon.context().getWrapAsyn(TrackService.class, bw-> {
            trackService = bw.get();

            //bean 获取后，可以做些后续处理。。。
        });

        //异步订阅方式，根据bean name获取Bean
        Solon.context().getWrapAsyn("userService", bw-> {
            userService = bw.get();
        });
    }
}
