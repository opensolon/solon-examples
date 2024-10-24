package demo4031.dso.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import demo4031.model.AppxModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppxMapper {
    AppxModel appx_get();

    Page<AppxModel> appx_get_page(Page<AppxModel> page);

    AppxModel appx_get2(int app_id);

    void appx_add();

    Long appx_add2(int v1);

    @Select("SELECT * FROM appx")
    List<Map<String, Object>> listTables();
}

