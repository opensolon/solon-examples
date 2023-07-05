package demo1091.disk;

import javafx.util.Callback;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.AopContext;

@Component
public class ControllerFactory implements Callback<Class<?>, Object> {

    @Inject
    AopContext aopContext;

    @Override
    public Object call(Class<?> aClass) {
        return aopContext.getBeanOrNew(aClass);
    }
}
