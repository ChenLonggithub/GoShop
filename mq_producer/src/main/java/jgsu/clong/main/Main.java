package jgsu.clong.main;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Main {
    public static void main(String[] args) throws JMSException {

        // 发送一个队列模式的消息
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 消息对象
        Queue queue = session.createQueue("clong-message");

        // 消息内容
        TextMessage textMessage = session.createTextMessage("我渴了，来杯水...");

        // 发送端
        MessageProducer producer = session.createProducer(queue);

        // 发送消息
        producer.send(textMessage);

        // 关闭连接
        producer.close();
        session.close();
        connection.close();

    }
}
