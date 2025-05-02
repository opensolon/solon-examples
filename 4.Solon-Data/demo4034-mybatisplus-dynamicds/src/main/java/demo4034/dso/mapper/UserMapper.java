package demo4034.dso.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import demo4034.model.UserModel;
import org.apache.ibatis.annotations.Mapper;




@Mapper
public interface UserMapper  extends BaseMapper<UserModel> {
}
