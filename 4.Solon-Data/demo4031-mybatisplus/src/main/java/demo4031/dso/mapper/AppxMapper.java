package demo4031.dso.mapper;

import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import demo4031.model.AppxModel;
import demo4031.model.DbTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppxMapper {
    AppxModel appx_get();
    List<AppxModel> appx_get_page(Page<AppxModel> page);
    AppxModel appx_get2(int app_id);
    void appx_add();
    Integer appx_add2(int v1);

    @Select("SELECT * FROM INFORMATION_SCHEMA.TABLES")
    List<DbTable> listTables();
}

