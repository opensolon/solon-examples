package demo4031.dso;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author noear 2022/4/17 created
 */
public class MetaObjectHandlerImpl implements MetaObjectHandler {
    public MetaObjectHandlerImpl(){
        System.out.println("....MetaObjectHandlerImpl");
    }
    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
