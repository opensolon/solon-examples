package demo4023.dso.mapper;

import demo4023.model.AppxModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppxMapper {
    AppxModel appx_get();
    List<AppxModel> appx_get_page();
}

