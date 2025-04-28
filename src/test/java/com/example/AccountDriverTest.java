package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountDriverTest {

    @BeforeEach
    public void resetStaticVariables() {
        Account.setNumDeposits(0);
        Account.setDepositTotal(0);
        Account.setNumWithdrawals(0);
        Account.setWithdrawalTotal(0);
    }

    @AfterEach
    public void restoreSystemIO() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testMain() {
         // Redirect system output to capture it
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         PrintStream originalOut = System.out;
         System.setOut(new PrintStream(outputStream));
 
         String simulatedInput =
         "Alice\n" +               // Name for account 1
         "Bob\n" +                 // Name for account 2
         "Bob\n" +             // Name for account 3
         "D\n1\n50\nquit\n" +      // Day 1: Deposit $50 into account 1, then quit
         "W\n2\n30\nquit\n" +      // Day 2: Withdraw $30 from account 2, then quit
         "account 1 to account 2\n100\nquit\n";           // Quit the program
         System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


        // Call the main method
        AccountDriver.main(new String[]{});

        // Restore original System.out
         System.setOut(originalOut);

         // Extract the output
         String output = outputStream.toString();
 
         // Verify Part 1 Output
         assertTrue(output.contains("Account 1: Name: Alice"), "Account 1 should be initialized with name Alice");
         assertTrue(output.contains("Account 2: Name: Bob"), "Account 2 should be initialized with name Bob");
         assertTrue(output.contains("Account 3: Name: Bob"), "Account 3 should be initialized with name Charlie");
         assertTrue(output.contains("Account 1: Name: CLOSED"), "Account 1 should be initialized with name Alice");
         assertTrue(output.contains("Account 2: Name: CLOSED"), "Account 2 should be initialized with name Bob");
         assertTrue(output.contains("Consolidated Account: Name: Bob"), "Account 3 should be initialized with name Charlie");
         assertTrue(output.contains("Balance: 0.0"), "Closed account balance should be 0");
         assertTrue(output.contains("Balance: 200.0"), "Consolidated account balance should be 200");
         assertTrue(output.contains("Account 3: Name: CLOSED"), "Account 3 should be initialized with name Charlie");


    }
}
