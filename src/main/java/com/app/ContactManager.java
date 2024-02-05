package com.app;

import java.util.ArrayList;
import java.util.List;


public class ContactManager {
    private List<Contact> contacts;

    public ContactManager(){
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    // Getters and Setters
    public List<Contact> getContacts(){
        return contacts;
    }

}
