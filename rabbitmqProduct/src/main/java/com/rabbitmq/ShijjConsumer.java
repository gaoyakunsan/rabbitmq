package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author yakungao
 * @date 2018/2/5
 **/
public class ShijjConsumer implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(ShijjConsumer.class);

    public void onMessage(Message message) {

        String str = new String(message.getBody());
        logger.info("shijj receive message------->:{}", str);

    }
}
