package jgsu.clong.main;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JMSException {
        // 创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 创建 会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建消息对象
        Queue queue = session.createQueue("clong-message");

        // 接收端
        MessageConsumer consumer = session.createConsumer(queue);

        // 接收消息
        consumer.setMessageListener(new MessageListener() {// 消息监听器，监听mq服务器的变化
            @Override
            public void onMessage(Message message) {
                // 打印结果
                TextMessage textMessage = (TextMessage) message;
                String text = "";
                try {
                    text = textMessage.getText();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                System.err.println("朱古沛老师，听到了" + text + ",积极的响应了要求。。。");
            }
        });
        // 等待接收消息
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
