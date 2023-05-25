package com.example.rabbitMQ.consumer;

import com.example.rabbitMQ.Dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitJsonConsumer {

    Logger logger= LoggerFactory.getLogger(RabbitJsonConsumer.class);

    @RabbitListener(queues = {"${rabbit.queue.json}"})
    public void consume(User user){
        logger.info("Message received>>>>>>>>>>>>>>>>>>>>>"+" "+user.toString());
    }
}
