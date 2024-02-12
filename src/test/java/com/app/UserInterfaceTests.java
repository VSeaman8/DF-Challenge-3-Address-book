package com.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(MockitoExtension.class)
public class UserInterfaceTests {

    @Mock
    AddressBook mockAddressBook;


    @Test
    @DisplayName("Test 21:  check that add is accessible through the interface.")
    void UserInterfaceAdd() {
        // Arrange
        String input = "1\nHarry Potter\nharrypotter@hogwarts.co.uk\n1234567890\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        System.setIn(in);
        UserInterface userInterface = new UserInterface(System.in);

        // Act & Assert
        assertDoesNotThrow(() -> userInterface.start());

        // Restore original System.in
        System.setIn(originalIn);
    }
}