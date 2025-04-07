package com.example;
import java.util.Scanner;

public class StudentDriver {
    public static void main(String[] args)
    {
	Scanner scan = new Scanner(System.in); // Create a single Scanner instance

	Student student1 = new Student("Mary");
	Student student2 = new Student("Mike");

	student1.inputGrades(scan);
	System.out.println (student1.getName() + "'s current average is " 
    + student1.getAverage() + "%.");

	student2.inputGrades(scan);
	System.out.println ("The average for " + student2.getName() +	   " is " + student2.getAverage() + "%.");
	

	System.out.println ("Student 1: " + student1);
	System.out.println ("Student 2: " + student2);
    }

}

