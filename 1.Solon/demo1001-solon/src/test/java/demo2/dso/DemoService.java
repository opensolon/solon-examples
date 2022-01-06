package demo2.dso;

import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;
import org.noear.solon.extend.aspect.annotation.Service;

/**
 * 如何注入Bean？
 *
 * @author noear 2021/12/28 created
 */
@Service
public class DemoService {

    //通过bean type注入（注入是异步的，不能在构造函数里使用）
    @Inject
    private TrackService trackService;

    //通过bean name注入
    @Inject("userService")
    private UserService userService;

    public DemoService(){
        //注入的Bean，不能在构造函数里使用。在生命周期时，构建先于注入
    }

    @Init
    public void init(){
        //注入的Bean，需要进一步做初始化，请在处理
    }
}
