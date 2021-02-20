package com.example.PhonebookService.ContactsDataRepository;

import com.example.PhonebookService.ContactsDataTables.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repo extends JpaRepository<Contact,Integer> {

    //The defined Function to fetch all the contacts with the given name
    public List<Contact> findAllByName(String name);

    //The defined Function to fetch the contacts with email adress
    public List<Contact> findAllByEmailadress(String emailadress);

}
