package com.assignment3;

public class IncorrectDateException extends Exception{

	public IncorrectDateException(String dateString) {
		super("The date you have entered, " + dateString + " is not a valid input.");

	}

}
