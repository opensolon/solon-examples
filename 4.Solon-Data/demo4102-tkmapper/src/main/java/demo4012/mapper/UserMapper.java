package demo4012.mapper;

import demo4012.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @ResultMap("demo4012.mapper.UserMapper.BaseResultMap")
    @Select("SELECT * FROM user WHERE is_del = 0 AND age > #{age}")
    List<User> findByGTAge(@Param("age") Integer age);

    List<User> findByName(@Param("name") String name);
}