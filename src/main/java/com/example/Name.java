package com.example;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name (String first, String middle, String last)
    {
        firstName = first;
        middleName = middle;
        lastName = last;
    }

    public String getFirst()
    {
	    return firstName;
    }

    public String getMiddle()
    {
	    return middleName;
    }

    public String getLast()
    {
	    return lastName;
    }

    public String firstMiddleLast()
    {
	    return firstName + " " + middleName + " " + lastName;
    }

    public String lastFirstMiddle()
    {
	    return lastName + ", " + firstName + " " + middleName;
    }

    public boolean equals (Name otherName)
    {
	    return (this.firstMiddleLast()).equalsIgnoreCase(otherName.firstMiddleLast());
    }

    public String initials()
    {
	    String firstLetters;
	    firstLetters = firstName.substring(0,1) + middleName.substring(0,1) +
	    lastName.substring(0,1);
	    return firstLetters.toUpperCase();
    }

    public int length()
    {
	    return firstName.length() + middleName.length() + lastName.length();
    }
}

