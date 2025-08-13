package demo3011.widget;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.noear.solon.annotation.Managed;

import java.io.IOException;
import java.util.Map;

@Managed("view:footer")
public class FooterTag implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        StringBuffer sb = new StringBuffer();

        sb.append("<footer>");
        sb.append("我是自定义标签，FooterTag");
        sb.append("</footer>");

        env.getOut().write(sb.toString());
    }
}
