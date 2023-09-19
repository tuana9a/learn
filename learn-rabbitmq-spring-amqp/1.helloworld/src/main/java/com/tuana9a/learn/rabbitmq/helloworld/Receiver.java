package com.tuana9a.learn.rabbitmq.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitListener(queuesToDeclare = {@Queue(name = "receiver", durable = "false")})
    public void onMessage(String message) {
        logger.info(message);
    }
}
