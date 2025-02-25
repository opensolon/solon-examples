package demoB004;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.Props;

import javax.jms.*;

/**
 * @author noear 2024/12/6 created
 */
@Configuration
public class ActivemqConfig {
    @Bean(destroyMethod = "stop")
    public Connection client(@Inject("${solon.activemq.properties}") Props common) throws Exception {
        String brokerURL = (String) common.remove("brokerURL");
        String userName = (String) common.remove("userName");
        String password = (String) common.remove("password");

        ActiveMQConnectionFactory factory;
        if (Utils.isEmpty(userName)) {
            factory = new ActiveMQConnectionFactory(brokerURL);
        } else {
            factory = new ActiveMQConnectionFactory(brokerURL, userName, password);
        }

        //绑定额外的配置并创建连接
        Connection connection = common.bindTo(factory).createConnection();
        connection.start();
        return connection;
    }

    @Bean
    public IProducer producer(Connection connection) throws Exception {
        return new IProducer(connection);
    }

    @Bean
    public void consumer(Connection connection,
                         MessageListener messageListener) throws Exception {
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        Destination destination = session.createTopic("topic.test");
        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(messageListener);
    }
}
