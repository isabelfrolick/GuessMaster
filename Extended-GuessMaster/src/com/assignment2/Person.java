package com.assignment2;

import java.util.Arrays;
/**
 * 
 * @author  Isabel Frolick, 20155540
 *
 */
public abstract class Person {

	private String name; //modifier changed to allow access in derived classes
	private Date birthday;
	private double difficulty;


	Person(){
		this.difficulty = 0.0;
	}


	//constructor
	Person(String name, Date birthday, double difficulty){
		this.name = name; //string is immutable, can't be changed
		this.birthday = new Date(birthday); //creates new object with value, not address for reference type object
		this.difficulty = difficulty; //immutable type
	}



	//copy constructor
	Person(Person newPerson){
		this.name = newPerson.name;
		this.birthday = new Date(newPerson.birthday);
		this.difficulty = newPerson.difficulty;
	}


	//Accessor methods
	public String getName() {
		return this.name;
	}

	public Date getBirthday() {
		return new Date(this.birthday); // new object with same parameters is returned
	}

	//add accessor method for difficulty (just in case)
	public double getDifficultyLevel() {
		return this.difficulty;
	}

	//Mutator methods
	public void setName(String name) {
		this.name = name; 
	}

	public void setBirthday(Date birthday) {
		this.birthday = new Date(birthday);
		//create new calling object with same value as object (but not same address) to parameter 
	}

	//add mutator method for difficulty level
	//used to prevent privacy leaks when using the difficulty outside class
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}


	//toString method
	public String toString() {
		return this.name + ", was born on" + this.birthday.getDay() + this.birthday.getMonth() + this.birthday.getYear();
	}

	//awarded points method
	public int getAwardedPointsNumber(double userDifficulty) { //takes in a double of the difficulty of the Person type object
		if(userDifficulty > 1 || userDifficulty < 0) { //if the difficulty level is outside of scope, return -1 as error
			return -1;
		}
		else {
			double hardFactor = userDifficulty*100; //needed to ensure arithmetic is correct
			int userPoints = (int)hardFactor;//recast the double that provides difficulty as an integer
			return userPoints;	//return the calculated points 	
		}
	}

	//abstract methods
	//abstract methods only have header, no body

	public abstract String personType(); //returns a description of the entity type in concrete classes
	public abstract Person clone() throws CloneNotSupportedException; 

	//method to return starting message
	public String startMessage() {
		return "Guess the birthday of the " + this.personType() + ", " + this.name;
	}

	public String closingMessage() {
		return "Congratulations! You were correct, " + this.toString();

	}



}

