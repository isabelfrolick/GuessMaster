package com.assignment3;


public abstract class Person implements Cloneable{

	private String name; //modifier changed to allow access in derived classes
	private Date birthday;



	//constructor
	Person(String name, Date birthday) throws CloneNotSupportedException{
		this.name = name; //string is immutable, can't be changed
		this.birthday = birthday.clone(); //creates new object with value, not address for reference type object

	}


	public Date getBirthday() throws CloneNotSupportedException {
		return birthday.clone(); // new object with same parameters is returned
	}


	//Mutator methods
	public void setName(String name) {
		this.name = name; 
	}

	public void setBirthday(Date birthday) throws CloneNotSupportedException {
		this.birthday = birthday.clone();
		//create new calling object with same value as object (but not same address) to parameter 
	}




	//toString method
	public String toString() {
		return this.name + ", was born on" + this.birthday.getDay() + this.birthday.getMonth() + this.birthday.getYear();
	}


	//clone method to avoid privacy leaks
	public Person clone(Person other) {
		try {
			Person newPerson = (Person) super.clone();
			newPerson.birthday = other.getBirthday().clone();
			return newPerson;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}

	//abstract methods
	//abstract methods only have header, no body

	public abstract String personType(); //returns a description of the entity type in concrete classes


	//Accessor methods
	public String getName() {
		return this.name;
	} 


}
