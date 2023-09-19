package com.tuana9a.learn.rabbitmq.workqueues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class Worker {
    private static final Logger logger = LoggerFactory.getLogger(Worker.class);

    @RabbitListener(queuesToDeclare = {@Queue(name = "receiver", durable = "false")}, containerFactory = "simpleRabbitListenerContainerFactory")
    public void onMessage(String in) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        logger.info(" [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        logger.info(" [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
