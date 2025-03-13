package gitee;

import com.dtflys.forest.annotation.*;

/**
 * @BaseRequest（baseURL ="https://www.gitee.com"）  直接使用值
 * @BaseRequest（baseURL ="#{test.gitee}"）  使用配置文件中的参数
 */
@ForestClient
@BaseRequest(baseURL = "https://gitee.com")
public interface TestGiteeApi {
    @Get
    String search(@Query("q") String q);
}
