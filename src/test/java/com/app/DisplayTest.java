package com.app;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayTest {


    @DisplayName("Test 9: search results are displayed to user.")
    @Test
    void searchResultsDisplayed() {
        // Arrange
        // Arrange
        Contact contact = new Contact.Builder()
                .withName("Harry Potter")
                .withEmail("harrypotter@hogwarts.co.uk")
                .withPhone("1234567890")
                .build();

        List<Contact> searchResults = Arrays.asList(contact);

        SearchEngine searchEngine = mock(SearchEngine.class);
        when(searchEngine.searchName(eq("Harry Potter"), anyList())).thenReturn(searchResults);

        Display display = new Display();

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        display.displaySearchResults(searchResults);

        // Assert
        String expectedOutput = "Search Results:\n" +
                "Name: " + contact.getName() + "\n" +
                "Email: " + contact.getEmail() + "\n" +
                "Phone: " + contact.getPhone() + "\n" + "\n";

        String actualOutput = outputStreamCaptor.toString().trim();

        // Normalize line endings and trim spaces from each line
        expectedOutput = Arrays.stream(expectedOutput.split("\n"))
                .map(String::trim)
                .collect(Collectors.joining("\n"));

        actualOutput = Arrays.stream(actualOutput.split("\n"))
                .map(String::trim)
                .collect(Collectors.joining("\n"));

        assertEquals(expectedOutput, actualOutput);
    }
}
