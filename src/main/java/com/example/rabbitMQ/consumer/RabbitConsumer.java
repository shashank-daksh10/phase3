package com.example.rabbitMQ.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {

    Logger logger= LoggerFactory.getLogger(RabbitConsumer.class);

    @RabbitListener(queues = {"${rabbit.queue}"})
    public void consume(String message){
        logger.info("Message received>>>>>>>>>>>>>>>>>>>>>"+" "+message);
    }
}
