package demoA002.controller.app;


import demoA002.model.bean.Node;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.solon.annotation.ApiRes;
import io.swagger.solon.annotation.ApiResProperty;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lbq
 * @email: 526509994@qq.com
 * @date: 2020/12/21
 */
@Mapping("/demo")
@Api(description = "app管理", tags = "示例")
@Controller
public class DemoController {

    @ApiOperation(value = "简单返回值", notes = "SwaggerConst.COMMON_RES.data中返回值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramA", value = "参数a", defaultValue = "1111"),
            @ApiImplicitParam(name = "paramB", value = "参数b", defaultValue = "222"),
    })
    @ApiRes({
            @ApiResProperty(name = "resA", value = "返回值A", example = "hello word1"),
            @ApiResProperty(name = "resB", value = "返回值b", example = "hello word2"),
    })
    @Mapping("test2")
    public Map test2() {
        return new HashMap();
    }

    @ApiOperation("复杂返回树")
    @Mapping("test3")
    public Node test3(){
        return new Node();
    }
}
