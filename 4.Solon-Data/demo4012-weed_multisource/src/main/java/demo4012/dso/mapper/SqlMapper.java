package demo4012.dso.mapper;

import demo4012.model.AppxModel;
import org.noear.weed.annotation.Db;
import org.noear.weed.xml.Namespace;

import java.util.List;

@Db("db1")
@Namespace("webapp.dso.mapper")
public interface SqlMapper{
    //随便取条数据的ID
    int appx_get() throws Exception;

    //根据id取条数据
    AppxModel appx_get2(int app_id) throws Exception;

    List<AppxModel> appx_getlist(int app_id) throws Exception;

    List<Integer> appx_getids() throws Exception;

    void appx_add();
}
