package com.example;

public class Account
{
    // Properties of account object 
    private double balance;
    private String name;
    private int acctNum;
    
    // Data of Account class
    private static int numAccounts = 0;
    private static int numDeposits = 0;
    private static int depositTotal = 0;
    private static int numWithdrawals = 0;
    private static int withdrawalTotal = 0;
    
    //----------------------------------------------
    //Constructor -- initializes balance, owner, and account number
    //----------------------------------------------
    public Account(double initBal, String owner)
    {
        balance = initBal;
        name = owner;
        acctNum = (int)(Math.random() * Integer.MAX_VALUE);
        numAccounts++;
    }
    
    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    //----------------------------------------------
    public void withdraw(double amount)
    {
        if (balance >= amount)
        {
            balance -= amount;
            numWithdrawals++;
            withdrawalTotal += amount;
        }   
        else
            System.out.println("Insufficient funds");
    }
    
    //----------------------------------------------
    // Adds deposit amount to balance.
    //----------------------------------------------
    public void deposit(double amount)
    {
        balance += amount;
        numDeposits++;
        depositTotal += amount;
    }

    // Transfer funds from one account to the other
    public void transfer(Account acct1, double amount)
    {
        if (balance >= amount)
        {
            withdraw(amount);
            acct1.deposit(amount);
        }
        else
            System.out.println("Insufficient funds");
    }

    // Static transfer method
    public static void transfer(Account acct1, Account acct2, double amount)
    {
        if (acct1.getBalance() >= amount)
        {
            acct1.withdraw(amount);
            acct2.deposit(amount);
        }
        else
            System.out.println("Insufficient funds");
    }
    
    //----------------------------------------------
    // Returns balance.
    //----------------------------------------------
    public double getBalance()
    {
        return balance;
    }
    
    // Returns numAccounts
    public static int getNumAccounts()
    {
        return numAccounts;
    }
    
    // Close the account
    public void close()
    {
        name = "CLOSED";
        balance = 0;
        numAccounts--;
    }
    
    // Create a new account which adds the balance of both accounts and keeps the name
    public static Account consolidate(Account acct1, Account acct2)
    {
        if (acct1.name.equals(acct2.name) && acct1.acctNum !=acct2.acctNum)
        {
            double initBalance = acct1.getBalance() + acct2.getBalance();
            String tempName = acct1.name;
            Account tempAccount = new Account (initBalance, tempName);
            acct1.close();
            acct2.close();
            return tempAccount;
        }
        else
        {
            System.out.println("Accounts cannot be consolidated.");
            return null;
        }
    }
    
    // Getters to return static data for deposits and withdrawals
    public static int getNumDeposits()
    {
        return numDeposits;
    }
    
    public static int getDepositTotal()
    {
        return depositTotal;
    }
    
    public static int getNumWithdrawals()
    {
        return numWithdrawals;
    }
    
    public static int getWithdrawalTotal()
    {
        return withdrawalTotal;
    }

    // Setters to reset static data for deposits and withdrawals
    public static void setNumDeposits(int num)
    {
        numDeposits = num;
    }
    
    public static void setDepositTotal(int amount)
    {
        depositTotal = amount;
    }
    
    public static void setNumWithdrawals(int num)
    {
        numWithdrawals = num;
    }
    
    public static void setWithdrawalTotal(int amount)
    {
        withdrawalTotal = amount;
    }
    
    //----------------------------------------------
    // Returns a string containing the name, account number, and balance.
    //----------------------------------------------
    public String toString()
    {
        return "Name: " + name + 
        " Account Number: " + acctNum +
        " Balance: " +  balance; 
    }
}