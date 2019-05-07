package jgsu.clong.listener;

import jgsu.clong.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyLogListener implements MessageListener {

    @Autowired
    LogService logService;
    @Override
    public void onMessage(Message message) {
        // 消息内容
        TextMessage textMessage = (TextMessage) message;
        String text = null;
        try {
            text = textMessage.getText();
            String[] split = text.split("-");
            String id = split[0];
            logService.insertLog(text,id);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
