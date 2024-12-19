package demoB004;

import javax.jms.*;

/**
 * @author noear 2024/12/19 created
 */
public class IProducer {
    private Connection connection;

    public IProducer(Connection connection) {
        this.connection = connection;
    }

    public void send(String topic, MessageBuilder messageBuilder) throws JMSException {
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        Destination destination = session.createTopic(topic);
        MessageProducer producer = session.createProducer(destination);

        producer.send(destination, messageBuilder.build(session));
    }

    @FunctionalInterface
    public static interface MessageBuilder {
        Message build(Session session) throws JMSException;
    }
}