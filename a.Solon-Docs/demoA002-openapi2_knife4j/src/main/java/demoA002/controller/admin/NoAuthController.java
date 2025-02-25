package demoA002.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.solon.annotation.ApiNoAuthorize;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lbq
 * 联系方式: 526509994@qq.com
 * 创建日期: 2020/9/16
 */
@Mapping("/noAuthCtrl")
@Api(tags = "Ctrl部分方法不校验")
@Controller
public class NoAuthController {

    @ApiOperation(value = "test1验证权限", notes = "SwaggerConst.COMMON_RES定义返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramA", value = "参数a", defaultValue = "1111"),
            @ApiImplicitParam(name = "paramB", value = "参数b", defaultValue = "222"),
    })
    @Mapping("test1")
    public Map test1() {
        return new HashMap();
    }

    @ApiNoAuthorize
    @ApiOperation(value = "test2不验证权限", notes = "SwaggerConst.COMMON_RES定义返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramA", value = "参数a", defaultValue = "1111"),
            @ApiImplicitParam(name = "paramB", value = "参数b", defaultValue = "222"),
    })
    @Mapping("test2")
    public Map test2() {
        return new HashMap();
    }
}
