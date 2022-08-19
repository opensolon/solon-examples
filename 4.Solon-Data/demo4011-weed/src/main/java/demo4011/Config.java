package demo4011;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.weed.WeedConfig;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean(concurrent = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) throws Exception{
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        return ds;
    }

    @Bean
    public void initWeed() {
        if (Solon.cfg().isDebugMode()) {
            //执行后打印下sql
            WeedConfig.onExecuteAft(cmd -> {
                System.out.println(cmd.text + "\r\n" + ONode.stringify(cmd.paramMap()));
            });

            WeedConfig.onException((cmd,err)->{
                System.out.println(cmd.text + "\r\n" + ONode.stringify(cmd.paramMap()));
            });
        }
    }
}

