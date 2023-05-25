package com.example.rabbitMQ.publisher;

import com.example.rabbitMQ.Dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RabbitMqJsonPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${rabbit.routing.json}")
    private String routingKey;


    Logger logger= LoggerFactory.getLogger(RabbitMqJsonPublisher.class);

    public void sendJsonMessage(User user){
        logger.info("Json object send succesfully >>>>>>>>>>"+" "+user.toString());
        rabbitTemplate.convertAndSend(exchange,routingKey,user);
    }


}
