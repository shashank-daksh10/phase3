package com.example.User.entities;

import lombok.*;


@Getter
@Setter
@ToString
public class Contact {

    private Long cId;
    private String contactNumber;
    private String email;
    private Integer userId;

    public Contact(Long cId, String contactNumber, String email, Integer userId) {
        this.cId = cId;
        this.contactNumber = contactNumber;
        this.email = email;
        this.userId = userId;
    }
}
