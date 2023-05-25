package com.example.User.service;

import com.example.User.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    List<User>list=List.of(new User(1,"Shashank","REDMI"),
            new User(2,"Abhinav","IPHONE"),
            new User(3,"Mohit","Samsung"),
            new User(4,"ram","Lava")
    );

    public User getUserDetails(Integer userId){
        User ans=list.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
        return ans;
    }
}
