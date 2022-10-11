package demo4041.dso.mapper;

import demo4041.model.AppxModel;
import org.noear.solon.extend.activerecord.annotation.Namespace;
import org.noear.solon.extend.activerecord.annotation.Sql;

/**
 * @author noear 2022/10/11 created
 */
@Namespace("SqlMapper")
public interface SqlMapper {
    @Sql("appx_get")
    AppxModel appx_get();

    @Sql("appx_get2")
    AppxModel appx_get2(int app_id);
}
