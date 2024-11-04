package demo4091;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.sqlink.core.dialect.DefaultDialect;
import org.noear.solon.data.sqlink.core.dialect.H2Dialect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class Config
{
    @Bean
    public void db1_cfg(@Inject("main") HikariDataSource dataSource) throws Exception
    {
        String sql = ResourceUtil.getResourceAsString("db.sql");
        try (Connection connection = dataSource.getConnection())
        {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql))
            {
                int i = preparedStatement.executeUpdate();
            }
        }
        System.out.println("db1_cfg执行完毕");
    }
}
