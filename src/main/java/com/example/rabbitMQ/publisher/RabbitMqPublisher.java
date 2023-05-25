package com.example.rabbitMQ.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqPublisher {
    @Autowired
    RabbitTemplate rabbitTemplate;

    Logger logger= LoggerFactory.getLogger(RabbitMqPublisher.class);

    @Value("${rabbit.exchange}")
    private String topicExchange;

    @Value("${rabbit.routing}")
    private String routingKey;


    public void sendMessage(String message){
        logger.info("Message sent >>>>>>>>>>>>>>>>>>>>>"+" "+message);
        rabbitTemplate.convertAndSend(topicExchange,routingKey,message);
    }

}
