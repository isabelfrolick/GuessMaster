package com.assignment1;

/**
 * class to develop Date type reference objects
 * @author Isabel Frolick, 20155540
 *
 */
public class Date {

	private int day;
	private int month;
	private int year;
	
	//default constructor
	Date(){
		this.day = 1;
		this.month = 1;
		this.year = 1;
	}
	
	//constructor with arguments
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		

		
	}
	
//	copy constructor, creates a new Date object from existing Date objects
	Date(Date newDate){
		if(newDate instanceof Date) {
			Date parameter = (Date)newDate;
		this.day = parameter.day;
		this.month = parameter.month;
		this.year = parameter.year;
	}
	}
	
	//string constructor
 Date(String userInput){
	
	
	// take in string in DD/MM/YYYY, output is a Date type object
if(userInput instanceof String) {
		String param = (String)userInput;
	//split the string type into day, month, year
	//cast string type as an integer
	int inputDay = Integer.parseInt(param.substring(0,2)); 
	int inputMonth = Integer.parseInt(param.substring(3,5));
	int inputYear = Integer.parseInt(param.substring(6,10));

	
	//cast integer type as a Date type , create new Date object
	Date newDate = new Date(inputDay, inputMonth, inputYear);{
		this.day = inputDay;
		this.month = inputMonth;
		this.year = inputYear;
	}

}

	}
	
	//accessor methods
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public Date getBirthday() {
		return new Date(this.day, this.month, this.year);
	}
		
	//equals method, using instanceof method
	public boolean equals(Date date) {
		if(date == null) {
			return false;
		}else if(!(date instanceof Date)) {
			return false;
		}else {
			Date checkDateEquality = (Date)date;
			return(this.day == date.day && this.month == date.month && this.year == date.year);
		}
	}
		

}

