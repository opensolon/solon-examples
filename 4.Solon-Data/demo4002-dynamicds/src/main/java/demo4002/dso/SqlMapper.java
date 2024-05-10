package demo4002.dso;

import demo4002.model.AppxModel;
import org.noear.wood.xml.Namespace;

import java.util.List;
import java.util.Set;

@Namespace("demo4002.dso.SqlMapper")
public interface SqlMapper{
    //随便取条数据的ID
    int appx_get() ;

    //随便取条数据的ID
    Integer appx_get0() ;

    //根据id取条数据
    AppxModel appx_get2(int app_id) ;

    List<AppxModel> appx_getlist(int app_id) ;

    List<Integer> appx_getids() ;

    Set<Integer> appx_getids2() ;

    void appx_add() ;

    void test_add(int val);
}
