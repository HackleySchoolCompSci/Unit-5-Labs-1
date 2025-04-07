package com.example;

import java.util.Scanner;

public class NameDriver {
    public static void main(String[] args)
    {
        String first, middle, last;
        Name name1;
        Name name2;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nName Program\n");
        System.out.println ("Name of first person...");
        System.out.print ("Enter the first name: ");
        first = scan.nextLine();
        System.out.print ("Enter the middle name: ");
        middle = scan.nextLine();
        System.out.print ("Enter the last name: ");
        last = scan.nextLine();

        name1 = new Name (first, middle, last);

        System.out.println ("Name of second person...");
        System.out.print ("Enter the first name: ");
        first = scan.nextLine();
        System.out.print ("Enter the middle name: ");
        middle = scan.nextLine();
        System.out.print ("Enter the last name: ");
        last = scan.nextLine();

        name2 = new Name (first, middle, last);

        System.out.println ("\nInformation about the first person:");

        System.out.println ("Full Name: " + name1.firstMiddleLast());
        System.out.println ("Last name first: " + name1.lastFirstMiddle());
        System.out.println ("Initials: " + name1.initials());
        System.out.println ("Name length: " + name1.length());

        System.out.println ("\nInformation about the second person:");

        System.out.println ("Full Name: " + name2.firstMiddleLast());
        System.out.println ("Last name first: " + name2.lastFirstMiddle());
        System.out.println ("Initials: " + name2.initials());
        System.out.println ("Name length: " + name2.length());

        System.out.println();

        if (name1.equals(name2))
            System.out.println ("The names are the same!");
        else
            System.out.println ("The names are not the same.");
    }

}

