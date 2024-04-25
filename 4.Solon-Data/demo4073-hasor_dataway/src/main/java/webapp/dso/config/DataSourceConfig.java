package webapp.dso.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {
    @Bean("metadataDs")
    public DataSource metadataStore() throws SQLException {
        // 如果库里面没有事先创建，可通过下面代码创建数据库，这里元数据，我之前操作过了，所以这里就不创建了
        //  String dbType = JdbcUtils.getDbType(jdbcUrl, driver);
        //
//        if (JdbcUtils.MYSQL.equalsIgnoreCase(dbType)) {
//            InputStream infoStream = ResourcesUtils.getResourceAsStream("/META-INF/hasor-framework/mysql/interface_info.sql");
//            InputStream releaseStream = ResourcesUtils.getResourceAsStream("/META-INF/hasor-framework/mysql/interface_release.sql");
//            new JdbcTemplate(dataSource).execute(IOUtils.toString(infoStream, Charsets.UTF_8));
//            new JdbcTemplate(dataSource).execute(IOUtils.toString(releaseStream, Charsets.UTF_8));
//        }
        //
        return this.buildDataSource(new DbConfig(Solon.cfg().get("metadata.jdbcUrl"), Solon.cfg().get("metadata.driverClassName"), Solon.cfg().get("metadata.username"), Solon.cfg().get("metadata.password")));
    }
    @Bean("dataDs1")
    public DataSource data1Store() throws SQLException {
        return this.buildDataSource(new DbConfig(Solon.cfg().get("db1.jdbcUrl"), Solon.cfg().get("db1.driverClassName"), Solon.cfg().get("db1.username"), Solon.cfg().get("db1.password")));
    }

    @Bean(value = "dataDs2", typed = true)
    public DataSource data2Store() throws SQLException {
        return this.buildDataSource(new DbConfig(Solon.cfg().get("db2.jdbcUrl"), Solon.cfg().get("db2.driverClassName"), Solon.cfg().get("db2.username"), Solon.cfg().get("db2.password")));
    }

    private DataSource buildDataSource(DbConfig dbConfig) throws SQLException {
        DruidDataSource druid = new DruidDataSource();
        druid.setUrl(dbConfig.jdbcUrl);
        druid.setDriverClassName(dbConfig.driver);
        druid.setUsername(dbConfig.username);
        druid.setPassword(dbConfig.password);
        druid.setMaxActive(50);
        druid.setMaxWait(3 * 1000);
        druid.setInitialSize(1);
        druid.setConnectionErrorRetryAttempts(1);
        druid.setBreakAfterAcquireFailure(true);
        druid.setTestOnBorrow(true);
        druid.setTestWhileIdle(true);
        druid.setFailFast(true);
        druid.init();
        return druid;
    }

    public static class DbConfig {
        public String jdbcUrl;
        public String driver;
        public String username;
        public String password;

        // 带参数的构造函数
        public DbConfig(String jdbcUrl, String driver, String username, String password) {
            this.jdbcUrl = jdbcUrl;
            this.driver = driver;
            this.username = username;
            this.password = password;
        }

    }
}
