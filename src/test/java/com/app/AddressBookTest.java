package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

    // Note that all tests below are AI generated see documentaion in the domain model test plan
    @Test
    @DisplayName("Test 25: A contact can be searched by phone number.")
    public void testSearchByPhoneNumber() {
        // Arrange
        addressBook.addContactToAddressBook("Harry Potter", "harry@hogwarts.co.uk", "1234567890");
        String phoneNumber = "1234567890";

        // Act
        List<Contact> contacts = addressBook.searchByPhoneNumber(phoneNumber);

        // Assert
        assertFalse(contacts.isEmpty(), "No contacts found with the given phone number.");
    }

    @Test
    @DisplayName("Test 26: The correct contact is returned when searched by phone number.")
    public void testCorrectContactReturnedWhenSearchedByPhoneNumber() {
        // Arrange
        addressBook.addContactToAddressBook("Hermione Granger", "hermione@hogwarts.co.uk", "0987654321");
        String phoneNumber = "0987654321";

        // Act
        List<Contact> contacts = addressBook.searchByPhoneNumber(phoneNumber);

        // Assert
        assertEquals(1, contacts.size(), "More than one contact found with the given phone number.");
        assertEquals("Hermione Granger", contacts.get(0).getName(), "Incorrect contact returned.");
    }

    @Test
    @DisplayName("Test 27: The system behaves as expected when searching for a phone number that does not exist in the address book.")
    public void testSearchPhoneNumberNotInAddressBook() {
        // Arrange
        String phoneNumber = "1111111111";

        // Act
        List<Contact> contacts = addressBook.searchByPhoneNumber(phoneNumber);

        // Assert
        assertTrue(contacts.isEmpty(), "Contacts found with a phone number that doesn't exist in the address book.");
    }

    @Test
    @DisplayName("Test 28: The system throws an exception when trying to add a contact with a duplicate phone number.")
    public void testAddContactWithDuplicatePhoneNumber() {
        // Arrange
        addressBook.addContactToAddressBook("Harry Potter", "harry@hogwarts.co.uk", "1234567890");
        Exception exception = null;

        // Act
        try {
            addressBook.addContactToAddressBook("Ron Weasley", "ron@hogwarts.co.uk", "1234567890");
        } catch (Exception e) {
            exception = e;
        }

        // Assert
        assertNotNull(exception, "Expected an exception to be thrown.");
        assertEquals("A contact with this phone number already exists", exception.getMessage(), "Incorrect exception message.");
    }
    }
