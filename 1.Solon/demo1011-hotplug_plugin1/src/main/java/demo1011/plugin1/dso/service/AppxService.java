package demo1011.plugin1.dso.service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author noear 2022/10/29 created
 */
public interface AppxService {
    List findAppx() throws SQLException;
}
