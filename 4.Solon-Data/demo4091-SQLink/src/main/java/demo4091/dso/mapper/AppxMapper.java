package demo4091.dso.mapper;

import demo4091.model.AppxModel;
import demo4091.model.DbTable;

import java.util.List;

public interface AppxMapper {
    AppxModel appx_get();
    List<AppxModel> appx_get_page();
    AppxModel appx_get2(int app_id);
    void appx_add();
    Integer appx_add2(int v1);

    @Select("SELECT * FROM INFORMATION_SCHEMA.TABLES")
    List<DbTable> listTables();
}

