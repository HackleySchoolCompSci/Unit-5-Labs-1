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
    public void testPart1() {
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

    @Test
    public void testPart2() {
        // Redirect system output to capture it
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String simulatedInput =
        "Alice\n" +               
        "Bob\n" +                 
        "Bob\n" +            
        "D\n1\n50\nquit\n" +      // Day 1: Deposit $50 into account 1, then quit
        "W\n2\n30\nquit\n" +      // Day 2: Withdraw $30 from account 2, then quit
        "account 1 to account 2\n100\nquit\n";           // Transfer money, then quit
    
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


       // Call the main method
       AccountDriver.main(new String[]{});

       // Restore original System.out
        System.setOut(originalOut);

        // Extract the output
        String output = outputStream.toString();

        // Verify Day 1 Output
        assertTrue(output.contains("Day 1"), "Day 1 should be printed");
        assertTrue(output.contains("Account 1's balance: 150.0"), "Account 1's balance after deposit should be $150.0");
        assertTrue(output.contains("Number of deposits: 1"), "Day 1 should record 1 deposit");
        assertTrue(output.contains("Total deposit amount: 50"), "Day 1 total deposit amount should be $50");

        // Verify Day 2 Output
        assertTrue(output.contains("Day 2"), "Day 2 should be printed");
        assertTrue(output.contains("Account 2's balance: 70.0"), "Account 2's balance after withdrawal should be $70.0");
        assertTrue(output.contains("Number of withdrawals: 1"), "Day 2 should record 1 withdrawal");
        assertTrue(output.contains("Total withdrawal amount: 30"), "Day 2 total withdrawal amount should be $30");
   }

   @Test
   public void testPart3() {
       // Redirect system output to capture it
       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       PrintStream originalOut = System.out;
       System.setOut(new PrintStream(outputStream));

       String simulatedInput =
       "Alice\n" +              
       "Bob\n" +                
       "Bob\n" +             
       "D\n1\n50\nquit\n" +      
       "W\n2\n30\nquit\n" +     
       "account 1 to account 2\n100\nquit\n";          
       System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


      // Call the main method
      AccountDriver.main(new String[]{});

      // Restore original System.out
       System.setOut(originalOut);

       // Extract the output
       String output = outputStream.toString();

        // Verify Transfer Output
        assertTrue(output.contains("Account 1's balance: 400.0"), "Account 1's balance after transferring $100 to Account 2 should be $400.0");
        assertTrue(output.contains("Account 2's balance: 600.0"), "Account 2's balance after receiving $100 from Account 1 should be $600.0");
       
        // Verify Account Summary
        assertTrue(output.contains("Account 1: Name: Hope"), "Account 1 should be initialized with name Hope");
        assertTrue(output.contains("Account 2: Name: Barry"), "Account 2 should be initialized with name Barry");
  }     
 }

