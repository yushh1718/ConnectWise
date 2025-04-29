package com.ConnectWise.services;

import com.ConnectWise.entities.Contact;
import com.ConnectWise.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {
    // save contacts
    Contact save(Contact contact);

    // update contact
    Contact update(Contact contact);

    // get contact
    List<Contact> getAll();

    // get contact by id
    Contact getById(String id);

    // delete contact
    void delete(String id);

    // search contact
    Page<Contact> searchByName(String nameKeyword, int size, int page, String sortBy, String order,User user);
    Page<Contact> searchByEmail(String emailKeyword, int size, int page, String sortBy, String order,User user);
    Page<Contact> searchByPhoneNumber(String phoneNumberKeyword,
                                      int size, int page, String sortBy, String order,User user);

    // get contacts by userId
    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(User user, int page, int size, String sortField, String sortDirection);
}
