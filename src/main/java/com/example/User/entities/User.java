package com.example.User.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class User {
    private Integer userId;
    private String name;
    private String phone;

    List<Contact>contactList=new ArrayList<>();

    public User() {
    }

    public User(Integer userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    public User(Integer userId, String name, String phone, List<Contact> contactList) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.contactList = contactList;
    }
}
