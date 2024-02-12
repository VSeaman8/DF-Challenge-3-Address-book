package com.app;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private ContactManager contactManager;
    private SearchEngine searchEngine;
    private Display display;

    public AddressBook() {
        this.contactManager = new ContactManager();
        this.searchEngine = new SearchEngine();
        this.display = new Display();
    }

    // Adding Contacts
    public void addContactToAddressBook(String name, String email, String phone){
        Contact contact = new Contact.Builder()
                .withName(name)
                .withEmail(email)
                .withPhone(phone)
                .build();
        contactManager.addContact(contact);

    }

    // Searching for Contacts
    public void searchName(String name) {
        List<Contact> contacts = searchEngine.searchName(name, contactManager.getContacts());
        display.displaySearchResults(contacts);
    }

    // Removing Contacts
    public boolean removeContactByName(String name) {
        SearchEngine searchEngine = new SearchEngine();
        try {
            List<Contact> contacts = searchEngine.searchName(name, getAllContacts());
            Contact contact = contacts.get(0);
            display.displaySearchResults(contacts);
            removeContactFromAddressBook(contact);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    public void removeContactFromAddressBook(Contact contact){
        contactManager.removeContact(contact);

    }

    // Viewing All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contacts = contactManager.getAllContacts();
        display.displaySearchResults(contacts);
        return contacts;
    }
    // Editing a contact
    public void editContact(String oldName, String newName, String newEmail, String newPhone) {
        contactManager.editContactName(oldName, newName);
        contactManager.editContactEmail(newName, newEmail);
        contactManager.editContactPhone(newName, newPhone);
    }

}

