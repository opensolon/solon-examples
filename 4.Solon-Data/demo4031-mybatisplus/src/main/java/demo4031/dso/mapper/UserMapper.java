package demo4031.dso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import demo4031.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author noear 2022/4/5 created
 */
@Mapper
public interface UserMapper extends BaseMapper<UserModel> {
}
