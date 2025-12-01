package com.assignment3;




public class Date implements Comparable<Date>, Cloneable {
	private int day;
	private int month;
	private int year;

	//inside class can be static with non-static outside class
	private static class Months{
		//must have static methods
		private static int getDays(int month) {
			int numDays;
			switch(month) { //use switch to ease functionality
			case 2: //febrary
				numDays = 28;
			case 4: //april
				numDays = 30;
			case 6: //june
				numDays = 30;
			case 9: //september
				numDays = 30;
			case 11: //november
				numDays = 30;
			default: //the majority of months have 31 days
				numDays = 31;
				break;
			}
			return numDays;
		}
	}

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

	//string constructor
	Date(String userFeedback) throws IncorrectDateException{
		if(userFeedback instanceof String) {
			String param = (String)userFeedback;
			try { //if the string is not the right length, if the days are incorrect for the month, or the day, month, year is 0 or negative
				if(param.length() != 10 || Integer.parseInt(param.substring(0,2)) > Months.getDays(Integer.parseInt(param.substring(3,5))) || Integer.parseInt(param.substring(0,2)) <= 0 || Integer.parseInt(param.substring(3,5)) <= 0 || Integer.parseInt(param.substring(6)) <= 0){
					throw new IncorrectDateException(param); //throw exception
				}

				//split the string type into day, month, year
				//cast string type as an integer
				int inputDay = Integer.parseInt(param.substring(0,2)); 
				int inputMonth = Integer.parseInt(param.substring(3,5));
				int inputYear = Integer.parseInt(param.substring(6));

				//cast integer type as a Date type , create new Date object
				Date newDate = new Date(inputDay, inputMonth, inputYear);{
					this.day = inputDay;
					this.month = inputMonth;
					this.year = inputYear;

				}
			}catch(IncorrectDateException e) {
				System.out.println(e.getMessage());
				return; 

			}
		}





	}

	//cloneable method, no mutable variables
	public Date clone() throws CloneNotSupportedException {

		try {
			Date newDate = (Date) super.clone();
			return newDate; //no ref type instance variables- can just call super
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}	
	}

	//comparable interface method definition
	public int compareTo(Date otherDate) {
		int val;
//compare the years first
		if(this.getYear() > otherDate.getYear()) {
			val = -1;
		}else if(this.getYear() < otherDate.getYear()) {
			val = 1;
			//if the year is the same, check months
		}else if(this.getMonth() > otherDate.getMonth()) {
			val = -1;
		}else if(this.getMonth() < otherDate.getMonth()) {
			val = 1;
			//if months is also the same, check days
		}else if(this.getDay() > otherDate.getDay()) {
			val = -1;
		}else if(this.getDay() < otherDate.getDay()) {
			val = 1;
		}else 
			val = 0;
		return val;
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
