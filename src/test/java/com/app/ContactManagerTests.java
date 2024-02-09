package com.app;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactManagerTests {

    @Test
    @DisplayName("ContactManager adds contact to Contact")

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


    @Test
    @DisplayName("Test 2 Added contact information is correctly stored in the address book")

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

    @Test
    @DisplayName("Test 3: Verify how the system behaves when trying to add a contact without any information")

    void TestSystemBehaviorWhenNoInfoAdded(){
        // Arrange
        ContactManager contactManager = new ContactManager();
        Contact.Builder builder = new Contact.Builder();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> contactManager.addContact(builder.build()));

    }

    @Test
    @DisplayName("Test 4: Verify how the system behaves when trying to add a contact with only partial information")

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

    @Test
    @DisplayName("Test 13:  Verify how the system behaves when trying to edit a contact that does not exist in the address book.")

    void EditContactDetailsWhenContactDoesNotExist() {

        // Arrange
        ContactManager contactManager = new ContactManager();
        Contact contact = new Contact.Builder()
                .withName("Harry Potter")
                .withEmail("harrypotter@hogwarts.co.uk")
                .withPhone("1234567890")
                .build();
        contactManager.addContact(contact);

        // & Act Assert
        assertThrows(IllegalArgumentException.class, () -> contactManager.editContactName("Ronauld Wheezzly", "Ronald Weasley"));

    }

    @Test
    @DisplayName("Test 14: Verify how the system behaves when trying to edit a contact with invalid or incomplete information.")

    void EditContactDetailsWhenContactPartiallyAdded(){

        // Arrange
        ContactManager contactManager = new ContactManager();
        Contact.Builder builder = new Contact.Builder();
        builder.withName("Harry");
        Contact contact = builder.build();
        contactManager.addContact(contact);
        // Act
        contactManager.editContactName("Harry", "Harry James Potter");
        contactManager.editContactEmail("Harry James Potter", "harryjamespotter@hotwarts.co.uk");
        // Assert
        Contact retrievedContact = contactManager.findContact("Harry James Potter");
        assertEquals("Harry James Potter", retrievedContact.getName());
        assertEquals("harryjamespotter@hotwarts.co.uk", retrievedContact.getEmail());
    }
    @Test
    @DisplayName("Test 15: check that the system does not allow duplicate phone numbers for a contact.")
    void NoDuplicatePhoneNumbersAllowed(){
        // Arrange
        ContactManager contactManager = new ContactManager();
        Contact contact1 = new Contact.Builder()
                .withName("Harry Potter")
                .withEmail("harrypotter@hogwarts.co.uk")
                .withPhone("1234567890")
                .build();
        contactManager.addContact(contact1);

        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactManager.addContact(new Contact.Builder()
                    .withName("Luna Lovegood")
                    .withEmail("lunalovegood@hogwarts.co.uk")
                    .withPhone("1234567890")
                    .build());
        });

        // Assert
        assertEquals("A contact with this phone number already exists", exception.getMessage());
    }
    @Test
    @DisplayName("Test 16: Check that the system does not allow duplicate addresses for a contact.")

    void NoDuplicateEmailNumbersAllowed(){
        // Arrange
        ContactManager contactManager = new ContactManager();
        Contact contact1 = new Contact.Builder()
                .withName("Harry Potter")
                .withEmail("harrypotter@hogwarts.co.uk")
                .withPhone("1234567890")
                .build();
        contactManager.addContact(contact1);

        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactManager.addContact(new Contact.Builder()
                    .withName("Luna Lovegood")
                    .withEmail("harrypotter@hogwarts.co.uk")
                    .withPhone("0987654321")
                    .build());
        });

        // Assert
        assertEquals("A contact with this email address number already exists", exception.getMessage());
    }
        }




