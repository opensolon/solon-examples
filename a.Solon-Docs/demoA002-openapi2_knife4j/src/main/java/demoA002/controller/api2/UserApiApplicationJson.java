package demoA002.controller.api2;

import demoA002.model.bean.RoleReq;
import io.swagger.annotations.*;
import org.noear.solon.annotation.*;

import java.util.Map;

/**
 * @author Sorghum
 * @since 2023/09/22
 */
@Api("用户接口2")
@Component
public class UserApiApplicationJson {
    @ApiOperation(value = "添加用户11")
    @Mapping(value = "user/add111", consumes = "application/json")
    public void userAdd(@ApiParam("用户名") String name) {

    }

    @ApiOperation(value = "添加用户22")
    @Mapping(value = "user/add222")
    public void userAdd(@ApiParam("用户名") String name, @Body Map ignore) {

    }

    @ApiOperation(value = "添加用户33")
    @Mapping(value = "user/${path}/add333")
    @Post
    @Consumes("application/json")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "roleName", value = "角色名称",dataType = "String",required = true, paramType = "body")
    )
    public void userAddPath(@ApiParam("帅气路径") @Path String path,@ApiParam("query用户名") String queryName,@Body RoleReq roleReq){
        //RoleReq 中有 roleId和name
    }
}
