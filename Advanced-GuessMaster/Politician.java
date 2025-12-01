package com.assignment3;



public class Politician extends Person{

	private String party;


	//constructor
	Politician(String name, Date birthday, String party) throws CloneNotSupportedException{
		super(name, birthday);
		this.party = party; //string is immutable in this instance
	}


	//clone method
	public Politician clone() throws CloneNotSupportedException{
		try {
			Politician newPolitician = (Politician) super.clone(); //create a new Politician type object to clone, there are no ref type variables within derived class
			return newPolitician;
		}catch(CloneNotSupportedException e) {
			e.getMessage();
			return null;
		}


	}


	//toString method
	public String toString() {
		try {
			return this.getName() + " was born on " + this.getBirthday().getDay() + "/" + this.getBirthday().getMonth() + "/" + this.getBirthday().getYear() + ". They are a member of the " + this.party + " party.";
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	//personType, overloads Singer when invoked
	public  String personType() {
		return "politician";
	}
}
