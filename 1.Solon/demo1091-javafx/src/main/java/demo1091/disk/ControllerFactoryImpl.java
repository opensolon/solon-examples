package demo1091.disk;

import javafx.util.Callback;
import org.noear.solon.Solon;

public class ControllerFactoryImpl implements Callback<Class<?>, Object> {
    @Override
    public Object call(Class<?> aClass) {
        return Solon.context().getBeanOrNew(aClass);
    }
}
