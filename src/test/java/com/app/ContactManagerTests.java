package com.app;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ContactManagerTests {

    @Nested
    @DisplayName("com.app.ContactManager adds contact to com.app.Contact")

    class ContactManagerAddsToContact {
        @Test
         void testAddContact(){
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact contact = new Contact("Harry Potter", "harrypotter@hogwarts.co.uk", "1234567890");
            // Act
            contactManager.addContact(contact);
            // Assert
            assertTrue(contactManager.getContacts().contains(contact));

        }

        }

    }

