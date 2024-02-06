package com.app;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class ContactManagerTests {

    @Nested
    @DisplayName("com.app.ContactManager adds contact to com.app.Contact")

    class ContactManagerAddsToContact {
        @Test
         void testAddContact(){
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact contact = new Contact.Builder()
                    .withName("Harry Potter")
                    .withEmail( "harrypotter@hogwarts.co.uk")
                    .withPhone("1234567890")
                    .build();
            // Act
            contactManager.addContact(contact);
            // Assert
            assertTrue(contactManager.getContacts().contains(contact));

        }

        }
    @Nested
    @DisplayName("Test 2 Added contact information is correctly stored in the address book")

    class ContactInfoCorrectlyStoredInAddressBook {
        @Test
        void ContactInfoInAddressBook(){
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact contact = new Contact.Builder()
                    .withName("Harry Potter")
                    .withEmail( "harrypotter@hogwarts.co.uk")
                    .withPhone("1234567890")
                    .build();;
            // Act
            contactManager.addContact(contact);
            // Assert
            assertEquals(1, contactManager.getContacts().size(), "Contact should be added to the address book");
            assertEquals(contact, contactManager.getContacts().get(0), "Contact details should match the added contact");
        }
        }
    @Nested
    @DisplayName("Test 3: Verify how the system behaves when trying to add a contact without any information")

    class SystemBehaviourWhenNoInfoAdded {

        @Test
        void TestSystemBehaviorWhenNoInfoAdded(){
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact.Builder builder = new Contact.Builder();

            // Act & Assert
            assertThrows(IllegalArgumentException.class, () -> contactManager.addContact(builder.build()));

        }

    }

    @Nested
    @DisplayName("Test 4: Verify how the system behaves when trying to add a contact with only partial information")

    class SystemBehaviorWithPartialInfoAdded{

        @Test
        void TestSystemBehaviorWithPartialInfoAdded(){
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact.Builder builder = new Contact.Builder();
            builder.withName("Harry");
            // Assert and Act
            assertThrows(IllegalArgumentException.class, () -> contactManager.addContact(builder.build()));

        }
    }

        }



