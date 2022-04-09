package demo4071.dso.mapper;

import demo4071.model.AppxModel;
import demo4071.model.DbTable;
import net.hasor.db.dal.repository.RefMapper;

import java.util.List;

@RefMapper("demo4071/dso/mapper/AppxMapper.xml")
public interface AppxMapper {
    AppxModel appx_get();
    List<AppxModel> appx_get_page();
    AppxModel appx_get2(int app_id);
    void appx_add();
    Integer appx_add2(int v1);
}

