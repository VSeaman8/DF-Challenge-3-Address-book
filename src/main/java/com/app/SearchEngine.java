package com.app;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    public List<Contact> searchName(String name, List<Contact> contacts){
        List<Contact> searchResults = new ArrayList<>();

        for (Contact contact : contacts){
            if (contact.getName().equalsIgnoreCase(name)){
                searchResults.add(contact);
            }
        }

        if (searchResults.isEmpty()){
            throw new IllegalArgumentException("No contacts have been found with the name: " + name);
        }
        return searchResults;
    }
}
