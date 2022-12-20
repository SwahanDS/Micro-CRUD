package com.contact.contact_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.contact_service.entity.Contact;

@Service    
public class ContactServiceImpl implements ContactService{

    List<Contact> list=List.of(
        new Contact(1L,"nunna.bapaji@lntecc.com","Bapaji",20333194L),
        new Contact(2L,"nswahan@gmail.com","Swahan",20333194L),
        new Contact(3L,"nunna.bapaj@lntecc.com","Bapaj",2033319L),
        new Contact(4L,"nswaha@gmail.com","Swaha",203331L)
    );

    @Override
    public List<Contact> getContactsofUser(Long userId) {
        return list.stream().filter(contact->contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
    
}
