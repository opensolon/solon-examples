package demo2;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.BeanWrap;
import org.noear.solon.data.datasource.DsUtils;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * @author noear 2022/11/25 created
 */
@Configuration
public class Demo2Config {
    @Inject
    AopContext aopContext;

    @Bean
    public void dsInit(@Inject("${test.datasources}") Properties props) {
        Map<String, DataSource> dsMap = DsUtils.buildDsMap(props, HikariDataSource.class);

        for (Map.Entry<String, DataSource> kv : dsMap.entrySet()) {
            BeanWrap dsWrap = aopContext.wrap(kv.getKey(), kv.getValue());
            aopContext.putWrap(kv.getKey(), dsWrap);
        }
    }
}
