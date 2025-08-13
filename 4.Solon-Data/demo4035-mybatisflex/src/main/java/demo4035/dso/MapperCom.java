package demo4035.dso;

import demo4035.dso.mapper.AppxMapper;
import org.noear.solon.annotation.Managed;

/**
 * 测试构建函数注入 Mapper
 *
 * @author noear 2024/12/24 created
 */
@Managed
public class MapperCom {
    private AppxMapper appxMapper;

    public MapperCom(AppxMapper appxMapper) {
        this.appxMapper = appxMapper;
    }
}
