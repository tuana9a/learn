package com.tuana9a.learn.rabbitmq.workqueues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private AmqpTemplate template;

    @Scheduled(fixedDelay = 3000)
    public void sayHello() {
        StringBuilder builder = new StringBuilder("Hello");
        int length = 5 + (int) (Math.random() * 5);
        for (int i = 0; i < length; i++) {
            builder.append('.');
        }
        String message = builder.toString();
        template.convertAndSend("receiver", message);
        logger.info(" [x] Sent '" + message + "'");
    }
}
