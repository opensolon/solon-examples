package demo4010_rx;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.rx.sql.RxSqlUtils;

/**
 * @author noear 2024/12/25 created
 */
@Configuration
public class Config {
    @Bean
    public void initDb(@Inject RxSqlUtils sqlUtils) throws Exception {
        String sql = ResourceUtil.getResourceAsString("db.sql");

        for (String s1 : sql.split(";")) {
            if (s1.trim().length() > 10) {
                sqlUtils.sql(s1).update().block();
            }
        }
    }
}
