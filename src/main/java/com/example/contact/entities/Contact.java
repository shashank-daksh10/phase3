package com.example.contact.entities;

import lombok.*;

@Getter
@Setter
@ToString
public class Contact {

    private Integer cId;
    private String contactNumber;
    private String email;
    private Integer userId;

    public Contact(Integer cId, String contactNumber, String email, Integer userId) {
        this.cId = cId;
        this.contactNumber = contactNumber;
        this.email = email;
        this.userId = userId;
    }
}
