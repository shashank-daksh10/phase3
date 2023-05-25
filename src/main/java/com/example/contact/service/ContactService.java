package com.example.contact.service;

import com.example.contact.entities.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    List<Contact>list=List.of(new Contact(5,"998872","shashank@gmail",1),
            new Contact(6,"998872","Daksh@gmail",2),
            new Contact(7,"998872","mohit@gmail",2),
            new Contact(8,"998872","abhinav@gmail",3));

    public List<Contact>getList(Integer Id){
        return list.stream().filter(contact -> contact.getUserId().equals(Id)).collect(Collectors.toList());
    }
}
