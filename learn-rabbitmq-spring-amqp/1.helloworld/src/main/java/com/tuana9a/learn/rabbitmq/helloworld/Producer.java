package com.tuana9a.learn.rabbitmq.helloworld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Scheduled(fixedDelay = 3000)
    public void sayHello() {
        amqpTemplate.send("receiver", new Message(("Hello " + System.currentTimeMillis()).getBytes()));
    }
}
