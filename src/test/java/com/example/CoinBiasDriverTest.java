package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CoinBiasDriverTest {
@Test
    public void testCoinBiasDriverOutput() {
        // Redirect system output to capture it
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Simulate user input for the second coin's bias
        String simulatedInput = "0.7\n"; // Example bias for the second coin
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        // Run the main method of CoinBiasDriver
        CoinBiasDriver.main(new String[]{});

        // Restore original System.out
        System.setOut(originalOut);

        String output = outputStream.toString();
        String[] outputLines = output.split("\\r?\\n");
        // Extract the number of heads for Coin 1 and Coin 2
        String coin1ResultLine = null;
        String coin2ResultLine = null;

        for (String line : outputLines) {
            if (line.startsWith("Coin 1 with bias")) {
                coin1ResultLine = line;
        }          
        else if (line.startsWith("Coin 2 with bias")) {
            coin2ResultLine = line;
        }
}



    // Parse the number of heads from the output lines
    int heads1 = Integer.parseInt(coin1ResultLine.replaceAll(".*came up heads (\\d+) times\\.", "$1"));
    int heads2 = Integer.parseInt(coin2ResultLine.replaceAll(".*came up heads (\\d+) times\\.", "$1"));

    // Validate the results are within a reasonable range
    assertTrue(heads1 >= 40 && heads1 <= 70, "Heads count for Coin 1 should be within a reasonable range");
    assertTrue(heads2 >= 40 && heads2 <= 80, "Heads count for Coin 2 should be within a reasonable range");
}
}