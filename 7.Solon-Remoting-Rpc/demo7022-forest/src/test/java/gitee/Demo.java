package gitee;

import org.junit.jupiter.api.Test;

import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonTest;


@SolonTest
public class Demo {
    @Inject
    TestGiteeApi api;

    @Test
    public void test() {
        String ret = api.search("solon");
        System.out.println(ret);
        assert ret.contains("html");
    }
}
