package com.app;

import java.util.ArrayList;
import java.util.List;


public class ContactManager {
    private List<Contact> contacts;

    public ContactManager(){
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        try {
            if (contact.getName().isEmpty() || contact.getEmail().isEmpty() || contact.getPhone().isEmpty()){
                throw new IllegalArgumentException("Contact information is incomplete");
            }
            contacts.add(contact);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Contact information is incomplete");
        }


    }
    // Getters and Setters
    public List<Contact> getContacts(){
        return contacts;
    }

}
