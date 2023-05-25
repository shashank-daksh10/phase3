package com.example.rabbitMQ.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String firstname;
    private String lastName;
    private Integer age;
}
