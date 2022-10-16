package demo4014.dso.mapper;

import demo4014.model.AppxModel;
import org.noear.wood.xml.Namespace;

import java.util.List;

@Namespace("demo4012.dso.mapper")
public interface SqlMapper{
    //随便取条数据的ID
    int appx_get() throws Exception;

    //根据id取条数据
    AppxModel appx_get2(int app_id) throws Exception;

    List<AppxModel> appx_getlist(int app_id) throws Exception;

    List<Integer> appx_getids() throws Exception;

    void appx_add();
}
