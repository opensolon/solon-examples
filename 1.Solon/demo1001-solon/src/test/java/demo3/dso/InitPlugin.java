package demo3.dso;

import demo3.dso.service.UserService;
import demo3.dso.service.impl.UserServiceImpl;
import org.noear.solon.SolonApp;
import org.noear.solon.core.Aop;
import org.noear.solon.core.Plugin;

/**
 * 手动
 *
 * @author noear 2021/12/28 created
 */
public class InitPlugin implements Plugin {
    @Override
    public void start(SolonApp app) {
        //生成普通的Bean
        Aop.wrapAndPut(UserService.class, new UserServiceImpl());

        //生成带注解的Bean（比如：@Controller）
        Aop.context().beanMake(UserServiceImpl.class);

        //获取Bean（如果不确定是否存在，可改用异步订阅获取）
        Aop.get(UserService.class);
    }
}
