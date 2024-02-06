package com.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;



public class SearchEngineTests {
    @Nested
    @DisplayName("Test 5: check that a contact can be searched by name.")
    class SearchByName {

        @Test
        void SearchByNameTest() {
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact contact = new Contact.Builder()
                    .withName("Harry Potter")
                    .withEmail("harrypotter@hogwarts.co.uk")
                    .withPhone("1234567890")
                    .build();
            SearchEngine searchEngine = new SearchEngine();

            // Act
            contactManager.addContact(contact);
            List<Contact> searchResults = searchEngine.searchName("Harry Potter", contactManager.getContacts());

            // Assert
            assertTrue(searchResults.contains(contact));
        }
    }

    @Nested
    @DisplayName("Test 6: check that the correct contact is returned when searched by name.")
    class CorrectInfoReturnedSearchByName {
        @Test
        void correctInfoReturnedSearchByNameTest() {
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact contact = new Contact.Builder()
                    .withName("Harry Potter")
                    .withEmail("harrypotter@hogwarts.co.uk")
                    .withPhone("1234567890")
                    .build();
            SearchEngine searchEngine = new SearchEngine();
            // Act
            contactManager.addContact(contact);
            List<Contact> searchResults = searchEngine.searchName("Harry Potter", contactManager.getContacts());

            // Assert
            assertEquals("Harry Potter", searchResults.get(0).getName());
        }

    }

    @Nested
    @DisplayName("Test 7: Verify how the system behaves when searching for a name that does not exist in the address book.")
    class SystemBehaviourWithNameNotExisting {

        @Test
        void systemBehaviourWithNameNotExistingTest(){
            // Arrange
            ContactManager contactManager = new ContactManager();
            Contact contact = new Contact.Builder()
                    .withName("Harry Potter")
                    .withEmail("harrypotter@hogwarts.co.uk")
                    .withPhone("1234567890")
                    .build();
            SearchEngine searchEngine = new SearchEngine();
            // Act
            contactManager.addContact(contact);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                searchEngine.searchName("Ron Weasley", contactManager.getContacts());
            });
            // Assert
            assertEquals("No contacts have been found with the name: Ron Weasley", exception.getMessage());

        }

    }
}
