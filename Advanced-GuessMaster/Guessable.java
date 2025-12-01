package com.assignment3;

public interface Guessable extends Comparable<Person>{
	//just need method headers in interface 
	public String startMessage();
	public String closingMessage();
	public int getAwardedPointNumber();
	
}
