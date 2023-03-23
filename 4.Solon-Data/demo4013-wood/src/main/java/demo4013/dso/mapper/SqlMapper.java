package demo4013.dso.mapper;

import java.math.*;
import java.sql.SQLException;
import java.time.*;
import java.util.*;

import org.noear.wood.BaseMapper;
import org.noear.wood.DataItem;
import org.noear.wood.DataList;
import org.noear.wood.annotation.Db;
import org.noear.wood.xml.Namespace;
import demo4013.model.*;

@Db("db1")
@Namespace("demo4013.dso.mapper.SqlMapper")
public interface SqlMapper{
    //随便取条数据的ID
    int appx_get() throws SQLException;

    //随便取条数据的ID
    Integer appx_get0() throws SQLException;

    //根据id取条数据
    AppxModel appx_get2(int app_id) throws SQLException;

    List<AppxModel> appx_getlist(int app_id) throws SQLException;

    List<Integer> appx_getids() throws SQLException;

    Set<Integer> appx_getids2() throws SQLException;

    void appx_add() throws SQLException;
}
