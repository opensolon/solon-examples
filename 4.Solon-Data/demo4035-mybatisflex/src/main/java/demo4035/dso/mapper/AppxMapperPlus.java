package demo4035.dso.mapper;

import demo4035.dso.mybatisflex_ext.MyBaseMapper;
import demo4035.model.AppxModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author noear 2022/3/28 created
 */
@Mapper
public interface AppxMapperPlus extends MyBaseMapper<AppxModel> {
}
