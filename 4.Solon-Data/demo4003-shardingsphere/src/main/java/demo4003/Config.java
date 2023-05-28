package demo4003;

import org.apache.shardingsphere.solon.ShardingSphereSupplier;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

/**
 * @author noear 2023/5/28 created
 */
@Configuration
public class Config {
    @Bean(name = "db1",typed = true)
    public DataSource db1(@Inject("${test.db1}") ShardingSphereSupplier supplier) {
        return supplier.get();
    }
}
