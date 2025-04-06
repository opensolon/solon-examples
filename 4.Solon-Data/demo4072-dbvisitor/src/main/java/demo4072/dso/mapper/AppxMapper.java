package demo4072.dso.mapper;

import demo4072.model.Appx;
import demo4072.model.DbTable;
import net.hasor.dbvisitor.dialect.Page;
import net.hasor.dbvisitor.mapper.Query;
import net.hasor.dbvisitor.mapper.RefMapper;

import java.util.List;

@RefMapper("/demo4072/dso/mapper/AppxMapper.xml")
public interface AppxMapper {
    Appx appx_get();
    List<Appx> appx_get_page(Page pageInfo);
    Appx appx_get2(int app_id);
    void appx_add();
    Integer appx_add2(int v1);

    @Query("SELECT * FROM INFORMATION_SCHEMA.TABLES")
    List<DbTable> listTables();
}

