package demo4091;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.sql.SqlUtils;

@Configuration
public class Config
{
    @Bean
    public void db1_cfg(@Inject SqlUtils sqlUtils) throws Exception {

        String sql = ResourceUtil.getResourceAsString("db.sql");

        for (String s1 : sql.split(";")) {
            if (s1.trim().length() > 10) {
                sqlUtils.sql(s1).update();
            }
        }
    }
}
