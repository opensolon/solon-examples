package demo4051.dso.mapper;

import demo4051.model.AppxModel;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.annotation.Update;

import java.util.List;

@SqlResource("SqlMapper")
public interface SqlMapper {
    //随便取条数据的ID
    int appx_get() throws Exception;

    //根据id取条数据
    AppxModel appx_get2(int app_id) throws Exception;

    List<AppxModel> appx_getlist(int app_id) throws Exception;

    PageResult<AppxModel> appx_getlist_page(PageRequest pageRequest, int app_id) throws Exception;

    List<Integer> appx_getids() throws Exception;

    @Update
    void appx_add(int app_id);
}
