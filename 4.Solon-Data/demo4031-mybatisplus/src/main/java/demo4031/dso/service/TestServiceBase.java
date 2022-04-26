package demo4031.dso.service;

import demo4031.dso.mapper.AppxMapper;
import org.apache.ibatis.solon.annotation.Db;

/**
 * @author noear 2022/4/26 created
 */
public abstract class TestServiceBase {
    @Db
    protected AppxMapper sqlMapper1;
}