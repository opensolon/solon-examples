package demo4035.dso.mapper;

import com.mybatisflex.core.BaseMapper;
import demo4035.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author noear 2022/4/5 created
 */
@Mapper
public interface UserMapper extends BaseMapper<UserModel> {
}
