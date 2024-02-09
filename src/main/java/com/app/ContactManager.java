package com.app;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager(){
        this.contacts = new ArrayList<>();
    }
    // Add Contact
    public void addContact(Contact contact) {
        if (contact.getName().isEmpty()){
            throw new IllegalArgumentException("Contact information is incomplete");
        }
        for (Contact existingContact : contacts) {
            if (existingContact.getPhone().equals(contact.getPhone())) {
                throw new IllegalArgumentException("A contact with this phone number already exists");
            }

        }
        for (Contact existingContact : contacts){
            if ( existingContact.getEmail().equals(contact.getEmail())){
                throw new IllegalArgumentException("A contact with this email address number already exists");
            }
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
    // Edit Contacts
    public void editContactName(String oldName, String newName){
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equals(oldName)){
                contact.setName(newName);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Contact with name " + oldName + " not found");
        }
    }

    public void editContactEmail(String name, String newEmail){
        for (Contact contact : contacts){
            if (contact.getName().equals(name)){
                contact.setEmail(newEmail);
                break;
            }
        }
    }

    public void editContactPhone(String name, String newPhone){
        for (Contact contact : contacts){
            if (contact.getName().equals(name)){
                contact.setPhone(newPhone);
                break;
            }
        }
    }
    // Viewing all contacts
    public List<Contact> getAllContacts(){
        return new ArrayList<>(contacts);

    }



    // Getters and Setters
    public List<Contact> getContacts(){
        return contacts;
    }

    public Contact findContact(String name){
        for (Contact contact : contacts){
            if (contact.getName().equals(name)){
                return contact;
            }
        } return null;
    }
}
