package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {
    private AddressBook addressBook;

    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    @DisplayName("Test 22: Adding a contact to the address book.")
    public void testAddContactToAddressBook() {
        // Arrange
        addressBook.addContactToAddressBook("Harry Potter", "harrypotter@hogwarts.co.uk", "1234567890");
        List<Contact> contacts = addressBook.getAllContacts();
        // Act
        Contact contact = contacts.get(0);
        //Assert
        assertEquals(1, contacts.size());
        assertEquals("Harry Potter", contact.getName());
        assertEquals("harrypotter@hogwarts.co.uk", contact.getEmail());
        assertEquals("1234567890", contact.getPhone());
    }


    @Test
    @DisplayName("Test 23: Removing contact by name through address book class.")
    public void testRemoveContactByName() {
        // Arrange
        addressBook.addContactToAddressBook("Harry Potter", "harrypotter@hogwarts.co.uk", "1234567890");
        // Act
        List<Contact> contacts = addressBook.getAllContacts();
        // Assert
        assertTrue(addressBook.removeContactByName("Harry Potter"));
        assertTrue(contacts.isEmpty());
    }

    @Test
    @DisplayName("Test 24: Getting all contacts through address book class.")
    public void testGetAllContacts() {
        // Arrange
        addressBook.addContactToAddressBook("Harry Potter", "harrypotter@hogwarts.co.uk", "1234567890");
        // Act
        List<Contact> contacts = addressBook.getAllContacts();
        Contact contact = contacts.get(0);
        // Assert
        assertEquals(1, contacts.size());
        assertEquals("Harry Potter", contact.getName());
        assertEquals("harrypotter@hogwarts.co.uk", contact.getEmail());
        assertEquals("1234567890", contact.getPhone());
    }
}