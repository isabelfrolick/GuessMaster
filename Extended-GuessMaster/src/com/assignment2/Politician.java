package com.assignment2;

/**
 * 
 * @author  Isabel Frolick, 20155540
 *
 */
public class Politician extends Person implements Cloneable{

	private String party;


	//constructor
	Politician(String name, Date birthday, double difficulty, String party){
		super(name, birthday, difficulty);
		this.party = party; //string is immutable in this instance
	}


	//copy constructor
	Politician(Politician newPolitician){
		super(newPolitician.getName(), newPolitician.getBirthday(), newPolitician.getDifficultyLevel());
		this.party = newPolitician.party;
	}


	//clone method
	public Politician clone() throws CloneNotSupportedException{
		Politician newPolitician = (Politician)clone(); //create a new Politician type object to clone, there are no ref type variables within derived class
		return newPolitician; //return the clone of Politician type
	}


	//toString method
	public String toString() {
		return this.getName() + " was born on " + this.getBirthday().getDay() + "/" + this.getBirthday().getMonth() + "/" + this.getBirthday().getYear() + ". They are a member of the " + this.party + " party.";
	}

	//personType, overloads Singer when invoked
	public  String personType() {
		return "politician";
	}
}
