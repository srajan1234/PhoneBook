package com.example.PhonebookService.Controllers;

import com.example.PhonebookService.ContactsDataTables.Contact;
import com.example.PhonebookService.ContactsDataRepository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//For REST Requests(Api Calls)
@RestController
public class ContactsController {

    //Getting bean of Repository
    @Autowired
    Repo contactsrepo;


    //1.Adding a new contact
    @PostMapping("/addcontact")
    public void addContact(Contact c){
        contactsrepo.save(c);
    }

    //2.Getting all contacts but setting default as only 10 contacts per page
    @GetMapping("/getall")
    Page<Contact> give(@RequestParam Optional<Integer> page,@RequestParam Optional<String> sortBy ){
        return contactsrepo.findAll(PageRequest.of(page.orElse(0),10,Sort.Direction.ASC,sortBy.orElse("id")));
    }

    //3.Fetching all the Contacts by name
    @GetMapping("/getallcontacts/{name}")
    public List<Contact> giveContactsbyname(@PathVariable String name){
        return contactsrepo.findAllByName(name);
    }

    //4.Fetching all the contacts by email
    @GetMapping("/getallcontacts2/{emailadress}")
    public List<Contact> giveContactsbyemail(@PathVariable String emailadress){
        return contactsrepo.findAllByEmailadress(emailadress);
    }

    //5.Deleting A contact

    @DeleteMapping("/deletecontacts/{id}")
    public void deleteContact(@PathVariable int id){

        contactsrepo.deleteById(id);
    }

    //6.Updating a Contact
    @PutMapping("/addcontact")
    public void updateContact(Contact c){
        contactsrepo.save(c);
    }
}
