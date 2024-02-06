package com.app;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DisplayTest {


    @DisplayName("Test 9: search results are displayed to user.")
    @Test
    void searchResultsDisplayed(){
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

    }

}
