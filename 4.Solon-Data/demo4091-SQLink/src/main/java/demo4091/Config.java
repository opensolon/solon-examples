package demo4091;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Configuration
public class Config
{
    @Bean
    public void db1_cfg(@Inject("h2ds") HikariDataSource dataSource) throws Exception
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
