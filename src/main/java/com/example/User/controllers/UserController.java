package com.example.User.controllers;

import com.example.User.entities.User;
import com.example.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        User user= userService.getUserDetails(id);
        //http://localhost:9090/contact/2
        List contact=restTemplate.getForObject("http://localhost:9090/contact/"+user.getUserId(), List.class);
        user.setContactList(contact);
        return user;
    }
}
