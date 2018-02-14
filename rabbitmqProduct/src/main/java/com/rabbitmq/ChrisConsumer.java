package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author yakungao
 * @date 2018/2/5
 **/
public class ChrisConsumer implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(ChrisConsumer.class);

    public void onMessage(Message message) {
        logger.info("chris receive message------->:{}", message);
    }

}
