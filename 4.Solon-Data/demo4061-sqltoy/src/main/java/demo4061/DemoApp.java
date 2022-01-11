package demo4061;

import demo4061.model.Dictionary;
import demo4061.model.User;
import org.noear.solon.Solon;
import org.noear.solon.core.Aop;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author noear 2022/1/10 created
 */
public class DemoApp {
    public static void main(String[] args) {
        //先删除测试数据
        File f=new File("./test.db.mv.db");
        if(f.exists()){
            f.delete();
            new File("./test.db.trace.db").delete();
        }
        Solon.start(DemoApp.class,args);
    }
}
