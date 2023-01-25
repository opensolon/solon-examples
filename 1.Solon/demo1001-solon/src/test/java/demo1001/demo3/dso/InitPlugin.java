package demo1001.demo3.dso;

import demo1001.demo3.dso.service.UserService;
import demo1001.demo3.dso.service.impl.UserServiceImpl;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;

/**
 * 手动
 *
 * @author noear 2021/12/28 created
 */
public class InitPlugin implements Plugin {
    @Override
    public void start(AopContext context) {
        //生成普通的Bean
        context.wrapAndPut(UserService.class, new UserServiceImpl());

        //生成带注解的Bean（比如：@Controller）
        context.beanMake(UserServiceImpl.class);

        //获取Bean（如果不确定是否存在，可改用异步订阅获取）
        context.getBean(UserService.class);
    }
}
