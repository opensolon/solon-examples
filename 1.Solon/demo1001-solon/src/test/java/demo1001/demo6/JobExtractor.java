package demo1001.demo6;

import org.noear.solon.core.BeanExtractor;
import org.noear.solon.core.BeanWrap;
import org.noear.solon.core.util.RunUtil;

import java.lang.reflect.Method;

public class JobExtractor implements BeanExtractor<Job> {
    @Override
    public void doExtract(BeanWrap bw, Method method, Job anno) throws Throwable {
        //此入，主要是为了收集到：method，而不是为了直接执行

        RunUtil.scheduleAtFixedRate(() -> {
            try {
                method.invoke(bw.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, anno.fixedRate());
    }
}
