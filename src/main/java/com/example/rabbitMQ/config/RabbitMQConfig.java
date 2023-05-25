package com.example.rabbitMQ.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbit.queue}")
    private String queue;

    @Value("${rabbit.queue.json}")
    private String queueJson;

    @Value("${rabbit.exchange}")
    private String topicExchange ;

    @Value("${rabbit.routing}")
    private String routingKey;

    @Value("${rabbit.routing.json}")
    private String routingKeyJson;



    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public Queue jsonQueue(){
        return new Queue(queueJson);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }

    @Bean
    public Binding bindingJson(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(topicExchange())
                .with(routingKeyJson);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
