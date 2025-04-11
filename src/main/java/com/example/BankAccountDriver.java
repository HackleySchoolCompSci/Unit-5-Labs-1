package com.example;

public class BankAccountDriver {

    public static void main(String[] args)
    {
        BankAccount acct1, acct2, acct3;
      
     	acct1 = new BankAccount(1000, "Nora", 98765);
	    acct2 = new BankAccount(500, "Carina");
	    acct3 = new BankAccount("Jayna");

	    acct3.deposit(100);
	    System.out.println(acct3.getBalance());

	    acct1.withdraw(50);
	    System.out.println(acct1.getBalance());
      
        acct2.withdraw(100, 50);
        System.out.println(acct2.getBalance());
      
        acct3.changeName("Jay");
      
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct3);
    }  
}
