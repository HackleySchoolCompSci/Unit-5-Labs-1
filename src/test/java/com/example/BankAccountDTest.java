package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountDTest {
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
        BankAccountDriver.main(new String[]{});

        // Capture the output
        String output = outContent.toString().trim();

        // Verify the output contains expected results
        assertTrue(output.contains("100"), "Account 3 balance is incorrect.");
        assertTrue(output.contains("950"), "Account 1 balance is incorrect.");
        assertTrue(output.contains("350"), "Account 2 balance is incorrect.");
        assertTrue(output.contains("Name: Nora\n" + //
                        "Acct #: 98765\n" + //
                 "Balance: 950.0"), "Account 1 info is incorrect.");
        assertTrue(output.contains("Name: Jay\n"), "Account 3 info is incorrect.");
    }
}
