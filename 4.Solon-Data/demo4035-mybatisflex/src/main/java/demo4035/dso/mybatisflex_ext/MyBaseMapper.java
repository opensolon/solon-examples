package demo4035.dso.mybatisflex_ext;

import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyBaseMapper<T> extends BaseMapper<T> {
}
