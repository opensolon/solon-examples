package demo3011.controller.more;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;



//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 * 需要使用 solon.boot.jetty 或者 solon.boot.undertow 插件
 *
 * @author noear 2021/3/30 created
 */
@Mapping("/demo2/servlet")
@Controller
public class ServletController {
//    @Mapping("hello")
//    public String hello(HttpServletRequest request, HttpServletResponse response){
//        if(request == null){
//            return "Err";
//        }else{
//            return "Ok";
//        }
//    }
}
