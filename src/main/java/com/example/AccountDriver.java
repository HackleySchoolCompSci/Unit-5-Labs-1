package com.example;
import java.util.Scanner;

public class AccountDriver
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in); // Use a single Scanner instance

        // Test Part 1
        System.out.println("Enter name 1: ");
        String name = scan.nextLine();
        Account account1 = new Account(100, name);
        System.out.println("Enter name 2: ");
        name = scan.nextLine();
        Account account2 = new Account(100, name);
        System.out.println("Enter name 3: ");
        name = scan.nextLine();
        Account account3 = new Account(100, name);
    
        // Print Accounts
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        System.out.println("Account 3: " + account3);
        System.out.println();
    
        account1.close();
        
        // Print Accounts again
        System.out.println("Account 1: " + account1);
        System.out.println("Consolidated Account: " + Account.consolidate(account2, account3));
        System.out.println("Account 2: " + account2);
        System.out.println("Account 3: " + account3);
        System.out.println();
    
        // Test PART 2
        account1 = new Account(100, "Sally");
        account2 = new Account(100, "Dan");

        // Transactions for 2 days
        for (int days=0; days<2; days++)
        {
            System.out.println("Day " + (days+1));
            System.out.println("Account 1: " + account1);
            System.out.println("Account 2: " + account2);

            // Reset the static deposit and withdraw variables to zero 
            Account.setNumDeposits(0);
            Account.setDepositTotal(0);
            Account.setNumWithdrawals(0);
            Account.setWithdrawalTotal(0);

            // Day Transaction
            System.out.println("Would you like to withdraw, deposit money or quit? (W/D/quit)");
            String transaction = scan.nextLine();
            while (!transaction.equals("quit"))
            {
                // Withdraw Money
                if (transaction.equals("W")) {
                    System.out.println("Do you want to withdraw money from account 1 or 2?");
                    int account = scan.nextInt();
                    scan.nextLine(); // Consume leftover newline
                    System.out.println("How much money do you want to withdraw?");
                    int amount = scan.nextInt();
                    scan.nextLine(); // Consume leftover newline
                    if (account == 1) {
                        account1.withdraw(amount);
                        System.out.println("Account 1's balance: " + account1.getBalance());
                    } else {
                        account2.withdraw(amount);
                        System.out.println("Account 2's balance: " + account2.getBalance());
                    }
                }
                // Deposit Money
                else if (transaction.equals("D")) {
                    System.out.println("Do you want to deposit money into account 1 or 2?");
                    int account = scan.nextInt();
                    scan.nextLine(); // Consume leftover newline
                    System.out.println("How much money do you want to deposit?");
                    int amount = scan.nextInt();
                    scan.nextLine(); // Consume leftover newline
                    if (account == 1) {
                        account1.deposit(amount);
                        System.out.println("Account 1's balance: " + account1.getBalance());
                    } else {
                        account2.deposit(amount);
                        System.out.println("Account 2's balance: " + account2.getBalance());
                    }
                }
                System.out.println("Would you like to withdraw, deposit money or quit? (W/D/quit)");
                transaction = scan.nextLine();
            }
            
            // Print Day Summary
            System.out.println();
            System.out.println("Number of deposits: " + Account.getNumDeposits());
            System.out.println("Total deposit amount: " + Account.getDepositTotal());
            System.out.println("Number of withdrawals: " + Account.getNumWithdrawals());
            System.out.println("Total withdrawal amount: " + Account.getWithdrawalTotal());
            System.out.println();
        }

        // Test PART 3
        account1 = new Account(500.0, "Hope");
        account2 = new Account(500.0, "Barry");
        System.out.println("Would you like to transfer from account 1 to account 2, account 2 to account 1 or quit");
        String transfer = scan.nextLine();
        while (!transfer.equals("quit")) {
            System.out.println("How much money would you like to transfer?");
            int amount = scan.nextInt();
            scan.nextLine(); // Consume leftover newline
        
            if (transfer.equals("account 1 to account 2")) {
                Account.transfer(account1, account2, amount);
            } else if (transfer.equals("account 2 to account 1")) {
                Account.transfer(account2, account1, amount);
            }
        
            // Print both accounts' new balances
            System.out.println("Account 1's balance: " + account1.getBalance());
            System.out.println("Account 2's balance: " + account2.getBalance());
            System.out.println();
        
            // Reprompt
            System.out.println("Would you like to transfer from account 1 to account 2, account 2 to account 1 or quit");
            transfer = scan.nextLine();
        }

        // Account Summary
        System.out.println();
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
    }
}
