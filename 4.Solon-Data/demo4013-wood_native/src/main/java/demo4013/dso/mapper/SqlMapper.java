package demo4013.dso.mapper;

import java.util.*;

import org.noear.wood.annotation.Sql;
import org.noear.wood.xml.Namespace;
import demo4013.model.*;

@Namespace("demo4013.dso.mapper.SqlMapper")
public interface SqlMapper{
    //随便取条数据的ID
    @Sql("select app_id from appx limit 1")
    int appx_get();

    //随便取条数据的ID
    @Sql("select app_id from appx where app_id < 1 limit 1")
    Integer appx_get0() ;

    //根据id取条数据
    @Sql("select * from appx where app_id = @{app_id:int} limit 1")
    AppxModel appx_get2(int app_id) ;

    @Sql("select * from appx where app_id > @{app_id:int} order by app_id asc limit 4")
    List<AppxModel> appx_getlist(int app_id) ;

    @Sql("select app_id from appx limit 4")
    List<Integer> appx_getids() ;

    @Sql("select app_id from appx limit 4")
    Set<Integer> appx_getids2() ;

    @Sql("insert into test (v1) values (1024)")
    void appx_add() ;
}
