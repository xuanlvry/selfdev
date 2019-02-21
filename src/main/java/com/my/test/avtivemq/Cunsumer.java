package com.my.test.avtivemq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * @author Chengfei.Sun on 2015/8/19.
 */
@Service
public class Cunsumer implements MessageListener {
    public void onMessage(Message message) {
        System.out.println(message.toString());
    }
}
