package demo3031.dso.auth;

import demo3031.dso.Session;
import org.noear.grit.solon.GritAuthProcessor2;

/**
 * 如果不借用第三方的框架适配，则需要自己实现：AuthProcessor 接口
 *
 * @author noear 2021/5/28 created
 * @see demo3031.Config
 */
public class AuthProcessorImpl extends GritAuthProcessor2 {
    @Override
    protected long getSubjectId() {
        return Session.current().getSubjectId();
    }
}
