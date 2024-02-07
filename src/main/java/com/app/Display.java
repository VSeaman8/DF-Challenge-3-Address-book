package com.app;

import java.util.List;

public class Display {

    public void displaySearchResults(List<Contact> searchResults){
        if (searchResults.isEmpty()){
            System.out.println("No Contacts Found.");
            return;
        }
        System.out.println("Search Results:");
        for (Contact contact: searchResults){
            System.out.println("Name: " + contact.getName());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone: " + contact.getPhone());
        }
    }
}
