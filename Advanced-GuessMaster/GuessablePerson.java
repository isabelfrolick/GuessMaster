package com.assignment3;

import java.util.HashSet;

public class GuessablePerson<T extends Person> implements Guessable, Cloneable {
	private T person;
	private double difficulty;


	//constructor
	GuessablePerson(T person, double difficulty){
		this.person = person;
		this.difficulty = difficulty;

	}
	//to avoid privacy leak
	public T getPerson() {
		return this.person;
	}

	public int compareTo(Person otherPerson) {
		int val = 0;
		try {
			//Date has compareTo() can just call the Date comparison
			val = getPerson().getBirthday().compareTo(otherPerson.getBirthday());

			if(val == 0) {
				//if the returned value is 0
				//the calling/ parameter have the same birthday
				//find their names- sort alphabetically
				//person class also has compareTo method
				getPerson().getName().compareTo(otherPerson.getName());

			}//if they have the same name and birthday, same object
			return val;

		}catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	public Date getBirthday() throws CloneNotSupportedException {
		return person.getBirthday();
	}



	//methods for the Guessable extended classes 

	//startMessage() method
	public String startMessage() {
		return "Guess the birthday of the " + person.personType() + " " + person.getName();
	}

	//closingMessage() method
	public String closingMessage() {
		return "Congratulations! You were correct " + person.toString();
	}

	//getAwardedPointNumber method
	public int getAwardedPointNumber() {
		double points = this.difficulty*100;
		return (int)points;
	}


//clone method 
	public Person clone() throws CloneNotSupportedException {
		try {
			Person newGuessablePerson = (Person) super.clone();
			return newGuessablePerson;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}



}
