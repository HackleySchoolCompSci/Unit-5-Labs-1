package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDriverTest {

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
        String userInput = "85.5\n90.0\n78.3\n88.7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // Call the main method
        StudentDriver.main(new String[]{});
    

        // Capture the output
        String output = outContent.toString().trim();

         // Verify the output contains expected results
         assertTrue(output.contains("Mary's current average is 87.75%"), "Mary's average is incorrect.");
         assertTrue(output.contains("The average for Mike is 83.5%"), "Mike's average is incorrect.");
         assertTrue(output.contains("Student 1: Name: Mary| Test 1: 85.5| Test 2: 90.0"), "Student 1 details are incorrect.");
         assertTrue(output.contains("Student 2: Name: Mike| Test 1: 78.3| Test 2: 88.7"), "Student 2 details are incorrect.");
        
    }


    
}
