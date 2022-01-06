package demo3031.dso.auth;

import demo3031.dso.Session;
import org.noear.grit.solon.GritAuthProcessor2;

/**
 * @author noear 2021/5/28 created
 * @see demo3031.Config
 */
public class AuthProcessorImpl extends GritAuthProcessor2 {
    @Override
    protected long getSubjectId() {
        return Session.current().getSubjectId();
    }
}
