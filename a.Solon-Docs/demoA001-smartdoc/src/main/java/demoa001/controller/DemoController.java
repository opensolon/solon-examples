package demoa001.controller;


import demoa001.model.Model;
import demoa001.model.Msg;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制器测试
 *
 * @author noear
 */
@Controller
@Mapping("/demo")
public class DemoController {

    /**
     * hello
     *
     * @param username 用户
     * @return
     */
    @Get
    @Mapping("/hello/{username}")
    public Result<Msg> hello(@Path String username) {
        Map m = new HashMap();

        m.put("uu", username);
        Msg msg = new Msg();
        msg.setData(m);

        return Result.succeed(msg);
    }

    /**
     * addapp
     *
     * @param appname app名称
     * @param nick    昵称
     * @return
     */
    @Post
    @Mapping(value = "/add")
    public Msg add(String appname, String nick) {
        Map m = new HashMap();
        m.put("appname", appname);
        m.put("nick", nick);

        Msg msg = new Msg();
        msg.setData(m);
        return msg;
    }

    /**
     * add by model
     *
     * @param model
     * @return
     */
    @Post
    @Mapping(value = "/add2", produces = "text/json")
    public Msg add2(@Body Model model) {
        Msg m = new Msg();
        return m;
    }

    /**
     * update app
     *
     * @param id      id
     * @param appname app名称
     * @param nick    昵称
     * @return
     */
    @Put
    @Mapping("/update")
    public Msg update(Long id, String appname, String nick) {
        Msg m = new Msg();
        return m;
    }

    /**
     * get by appname
     *
     * @param appname
     * @return
     */
    @Mapping("/get/{appname}")
    public Msg get(@Path String appname) {
        Msg m = new Msg();
        return m;
    }

    /*
    //for web socket （需添加：solon.boot.websocket 插件）
    @Mapping(value="/hallo/{u_u}", method = MethodType.WEBSOCKET)
    public ModelAndView hallo_ws(String u_u){
        return new ModelAndView("hallo");
    }
    */
}