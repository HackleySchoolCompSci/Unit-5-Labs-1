package com.example;

public class BankAccount
{
    private double balance;
    private String name;
    private int acctNum;

  public BankAccount(double initBal, String owner, int number)
  {
    balance = initBal;
    name = owner;
    acctNum = number;
  }

  public BankAccount(double initBal, String owner)
  {
    balance = initBal;
    name = owner;
    acctNum = (int) (Math.random() * Integer.MAX_VALUE + 1);
  }

  public BankAccount(String owner)
  {
    balance = 0;
    name = owner;
    acctNum = (int) (Math.random() * Integer.MAX_VALUE + 1);
  }

  public void withdraw(double amount)
  {
    if (balance >= amount)
       balance -= amount;
    else
       System.out.println("Insufficient funds");

  }

  public void withdraw(double amount, double fee)
  {
    	withdraw(amount);
chargeFee(fee);

  }

  public void deposit(double amount)
  {
    balance += amount;
  }

  public double getBalance()
  {
    return balance;
  }

  private void chargeFee(double fee)
  {
    balance = balance - fee;  
  }

  public void changeName(String newName)
  {
    name = newName;
  }

  public String toString()
  {
	return "Name: " + name + 
	    "\nAcct #: " + acctNum + 
	    "\nBalance: " + balance;
  }
}

