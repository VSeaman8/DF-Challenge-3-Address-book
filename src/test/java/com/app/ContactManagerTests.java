package com.app;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class ContactManagerTests {

    @Nested
    @DisplayName("ContactManager adds contact to Contact")

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
                    .build();
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
            Contact contact = builder.build();
            // Act
            contactManager.addContact(contact);
            //Assert
            assertTrue(contactManager.getContacts().contains(contact));


        }
    }
    @Test
    @DisplayName("Test 10: Check a contact can be removed from the address book")

    void ContactRemovedFromAddressBook(){

        // Arrange
        ContactManager contactManager = new ContactManager();
        Contact contact = new Contact.Builder()
                .withName("Harry Potter")
                .withEmail( "harrypotter@hogwarts.co.uk")
                .withPhone("1234567890")
                .build();
        contactManager.addContact(contact);

        // Act
        contactManager.removeContact(contact);
        // Assert
        assertFalse(contactManager.getContacts().contains(contact));
    }

    @Test
    @DisplayName("Test 11: Verify how the system behaves when trying to remove a contact that does not exist in the address book.")

    void ContactDoesNotExistTryToRemove(){
        // Arrange

        ContactManager contactManager = new ContactManager();
        Contact contact = new Contact.Builder()
                .withName("Harry Potter")
                .withEmail( "harrypotter@hogwarts.co.uk")
                .withPhone("1234567890")
                .build();
        contactManager.addContact(contact);

        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactManager.removeContact(new Contact.Builder()
                    .withName("Ron Weasley")
                    .withEmail("ronweasley@hogwarts.co.uk")
                    .withPhone("9876543210")
                    .build());
        });

        // Assert
        assertEquals("Contact not found in address book", exception.getMessage());
    }

    @Test
    @DisplayName("Test 12: Edited details are correctly updated in the address book.")

    void EditContactDetails(){
        // Arrange
        ContactManager contactManager = new ContactManager();
        Contact contact = new Contact.Builder()
                .withName("Harry Potter")
                .withEmail( "harrypotter@hogwarts.co.uk")
                .withPhone("1234567890")
                .build();
        contactManager.addContact(contact);
        // Act
       contactManager.editContactName("Harry Potter", "Harry James Potter");
       contactManager.editContactEmail("Harry James Potter", "harryjamespotter@hotwarts.co.uk");
       contactManager.editContactPhone("Harry James Potter", "0987654321");

       // Assert
        Contact retrievedContact = contactManager.findContact("Harry James Potter");
        assertEquals("Harry James Potter", retrievedContact.getName());
        assertEquals("harryjamespotter@hotwarts.co.uk", retrievedContact.getEmail());
        assertEquals( "0987654321", retrievedContact.getPhone());
    }

        }



