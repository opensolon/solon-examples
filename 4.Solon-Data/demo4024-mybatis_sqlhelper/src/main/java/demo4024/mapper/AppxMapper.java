package demo4024.mapper;

import demo4024.model.AppxModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppxMapper {
    List<AppxModel> appx_get_page();
}

