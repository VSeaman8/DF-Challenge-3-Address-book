package com.app;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private ContactManager contactManager;
    private SearchEngine searchEngine;

    public AddressBook() {
        this.contactManager = new ContactManager();
        this.searchEngine = new SearchEngine();
    }

    // Adding Contacts
    public void addContact(String name, String email, String phone){
        Contact contact = new Contact.Builder()
                .withName(name)
                .withEmail(email)
                .withPhone(phone)
                .build();
        contactManager.addContact(contact);
    }

    // Searching for Contacts
    public List<Contact> searchName(String name) {
        return searchEngine.searchName(name, contactManager.getContacts());
    }
}

