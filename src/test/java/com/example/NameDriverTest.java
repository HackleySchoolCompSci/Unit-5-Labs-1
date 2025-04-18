package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NameDriverTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent)); // Redirect System.out to capture output
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut); // Restore original System.out
        System.setIn(System.in);
    }

    @Test
    public void testMain() {
        // Simulate user input: one phrase, then quit
        String userInput = "John\nDoe\nSmith\nHannah\nDoe\nSmith\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // Call the main method
        NameDriver.main(new String[]{});

        // Capture the output
        String output = outContent.toString().trim();

        // Verify the output contains expected results
        assertTrue(output.contains("Full Name: John Doe Smith"), "Full name is incorrect.");
        assertTrue(output.contains("Last name first: Smith, John Doe"), "Last name first format is incorrect.");
        assertTrue(output.contains("Initials: JDS"), "Initials are incorrect.");
        assertTrue(output.contains("Name length: 12"), "Name length is incorrect.");
        assertTrue(output.contains("Full Name: Hannah Doe Smith"), "Full name is incorrect.");
        assertTrue(output.contains("Last name first: Smith, Hannah Doe"), "Last name first format is incorrect.");
        assertTrue(output.contains("Initials: HDS"), "Initials are incorrect.");
        assertTrue(output.contains("Name length: 14"), "Name length is incorrect.");
        assertTrue(output.contains("The names are not the same."), "Name comparison result is incorrect.");
    }
}
