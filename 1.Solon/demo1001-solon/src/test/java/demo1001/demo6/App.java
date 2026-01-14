package demo1001.demo6;

import org.noear.solon.Solon;


public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            app.context().beanExtractorAdd(Job.class, new JobExtractor());
        });
    }
}
