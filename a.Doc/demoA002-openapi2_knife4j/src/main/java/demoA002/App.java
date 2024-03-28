package demoA002;


import org.noear.solon.Solon;

public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, app -> {
            //演示方便，把打开根页时跳到文档页
            app.get("/", ctx -> ctx.redirect("/doc.html"));
        });
    }
}
