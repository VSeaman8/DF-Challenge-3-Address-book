package com.app;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager(){
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (contact.getName().isEmpty()){
            throw new IllegalArgumentException("Contact information is incomplete");
        }
        contacts.add(contact);
    }

    // Remove Contacts
    public void removeContact(Contact contact){
        if (!contacts.contains(contact)){
            throw new IllegalArgumentException("Contact not found in address book");
        }
        contacts.remove(contact);
    }

    // Getters and Setters
    public List<Contact> getContacts(){
        return contacts;
    }
}
