package com.rabbitmq;

import javax.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

/**
 * @author yakungao
 * @date 2018/2/5
 **/
@Service
public class Product {

    @Resource(name = "amqpTemplate")
    private AmqpTemplate amqpTemplate;

    @Resource(name = "amqpTemplate2")
    private AmqpTemplate amqpTemplate2;

    public void sendMessage(Object message) {
        amqpTemplate.convertAndSend("queueTestKey", message);
        amqpTemplate.convertAndSend("queueTestChris", message);
        amqpTemplate2.convertAndSend("shijj.xxxx.wsdwd", message);
    }
}
