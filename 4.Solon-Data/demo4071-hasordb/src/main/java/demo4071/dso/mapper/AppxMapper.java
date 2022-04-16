package demo4071.dso.mapper;

import demo4071.model.Appx;
import demo4071.model.DbTable;
import net.hasor.db.dal.repository.Param;
import net.hasor.db.dal.repository.Query;
import net.hasor.db.dal.repository.RefMapper;
import net.hasor.db.page.Page;

import java.util.List;

@RefMapper("/demo4071/dso/mapper/AppxMapper.xml")
public interface AppxMapper {
    Appx appx_get();
    List<Appx> appx_get_page(Page pageInfo);
    Appx appx_get2(int app_id);
    void appx_add();
    Integer appx_add2(int v1);

    @Query("SELECT * FROM INFORMATION_SCHEMA.TABLES")
    List<DbTable> listTables();
}

