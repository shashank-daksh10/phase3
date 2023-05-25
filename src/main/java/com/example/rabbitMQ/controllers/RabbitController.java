package com.example.rabbitMQ.controllers;

import com.example.rabbitMQ.Dto.User;
import com.example.rabbitMQ.publisher.RabbitMqJsonPublisher;
import com.example.rabbitMQ.publisher.RabbitMqPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RabbitController {
    @Autowired
    RabbitMqPublisher rabbitMqPublisher;

    @Autowired
    private RabbitMqJsonPublisher rabbitMqJsonPublisher;

    @GetMapping("getData")
    public ResponseEntity<String>getData(@RequestParam String message){
        rabbitMqPublisher.sendMessage(message);
        return ResponseEntity.ok("Message passed successfully");
    }

    @PostMapping("/postData")
    private ResponseEntity<String>postData(@RequestBody User user){
        rabbitMqJsonPublisher.sendJsonMessage(user);
        return ResponseEntity.ok("Json object stored successfully");
    }
}
