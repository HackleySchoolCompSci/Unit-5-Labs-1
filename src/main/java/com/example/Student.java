package com.example;

import java.util.Scanner;


public class Student
{
    private String name;
    private double test1;
    private double test2;

    public Student(String studentName)
    {
        name = studentName;
        test1 = 0;
        test2 = 0;
    }

    public void inputGrades()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter " + name + "'s score for test 1: ");
        while (!scan.hasNextDouble()) { // Validate input for test 1
            System.out.println("Invalid input. Please enter a valid number.");
            scan.next(); // Consume invalid input
        }
        test1 = scan.nextDouble();
    
        System.out.print("Enter " + name + "'s score for test 2: ");
        while (!scan.hasNextDouble()) { // Validate input for test 2
            System.out.println("Invalid input. Please enter a valid number.");
            scan.next(); // Consume invalid input
        }
        test2 = scan.nextDouble();
    }

    public double getAverage()
    {
	    return (test1  + test2)/2;
    }

    public String getName()
    {
	    return name;
    }

    public String toString()
    {
        //I DIDN’T DEDUCT PTS IF FORMAT OF OUTPUT WAS DIFFERENT BUT PRODUCED SAME RESULT
        return "Name: " + name + "| Test 1: " + test1 + "| Test 2: " + test2;
    }
}
