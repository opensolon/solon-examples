package demo9010.controller.rpcimpl;

import demo9010.dso.Rpc1;
import org.noear.solon.annotation.Managed;

/**
 * @author noear 2024/3/20 created
 */
@Managed
public class Rpc1Impl implements Rpc1 {
    @Override
    public boolean list1() {
        return false;
    }

    @Override
    public String list2() {
        return "local-list2";
    }
}
