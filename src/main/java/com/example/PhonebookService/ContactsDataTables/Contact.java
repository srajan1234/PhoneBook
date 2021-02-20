package com.example.PhonebookService.ContactsDataTables;



import com.sun.istack.NotNull;
import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

//To make a table in database
@Entity
//giving Name Of Table
@Table(name = "Contacts")
//Providing Validations
@Validated
public class Contact {
    //Making it PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //Making Name field as required
    @NotNull
    private String name;

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //making phone number as optional
    //and fixing length of phone number to 10
    @Column(length = 10,unique = true)
    @Basic(optional = true)
    private long phonenumber;

    @Column(unique = true)
    @NotNull
    private String emailadress;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", emailadress='" + emailadress + '\'' +
                '}';
    }
}
