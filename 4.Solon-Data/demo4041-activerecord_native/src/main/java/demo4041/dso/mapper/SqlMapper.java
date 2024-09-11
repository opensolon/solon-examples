package demo4041.dso.mapper;

import com.jfinal.plugin.activerecord.solon.annotation.Sql;
import demo4041.model.AppxModel;

/**
 * @author noear 2022/10/11 created
 */
//@Namespace("SqlMapper")
public interface SqlMapper {
    @Sql("appx_get")
    AppxModel appx_get();

    @Sql("appx_get2")
    AppxModel appx_get2(int app_id);
}
