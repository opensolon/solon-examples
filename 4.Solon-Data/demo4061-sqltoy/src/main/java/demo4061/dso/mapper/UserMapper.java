package demo4061.dso.mapper;

import demo4061.model.UserVo;
import org.noear.solon.extend.sqltoy.annotation.Mapper;
import org.noear.solon.extend.sqltoy.annotation.Param;
import org.noear.solon.extend.sqltoy.annotation.Sql;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * Mapper 为sqltoy-solon 中新增功能，原sqltoy不带此扩展
 * mapper 优势：
 *        1。可直接通过@Param指定少量参数,省去封装查询参数和返回类型的过程
 *        2。可以自动识别单值，单个Entity,List,Page等,单值获取时sqltoy本身接口需要一次手动解开的操作,
 *           查询参数和结果类型不一致的时候需要手动设定
 *
 *       劣势：
 *          需要多出来一个Mapper层，部分接口不如sqltoy自带
 */
@Mapper
public interface UserMapper {
    // 查询单个User,getByUserName这个名字不重要，以@sql注解中内容为准
    @Sql("userList")
    UserVo getByUserName(@Param String username);

    // 也可直接写sql
    @Sql("  SELECT * FROM T_USER WHERE WHERE USER_NAME=:username #[and GENDER=:gender]")
    UserVo getByUserName2(@Param String username,@Param Integer gender);

    // 可查list,可以直接用Map或entity 做查询参数,这种情况下不支持 @Param指定多个参数
    @Sql("userList")
    List<UserVo> allUser(UserVo query);

    // 也可分页
    @Sql("userList")
    Page<UserVo> pageUser(UserVo query,Page page);

    //可查询单值，这里要注意返回值，需要和数据库中值类型对应
    @Sql("select count(*) from t_user")
    Long count();

    //default 方法不处理，直接调用，可在default方法中调用本接口方法处理一些业务
    default long doSomeThingElse(){
        // Aop.get(XX.class) 获取其他bean来处理业务
        return count()+1;
    }
}
