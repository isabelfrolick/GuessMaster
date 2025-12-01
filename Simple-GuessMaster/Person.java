package com.assignment1;
/**
 * class to develop Person reference type objects
 * @author Isabel Frolick, 20155540
 *
 */
public class Person {

	private String name;
	private Date birthday;
	
	//constructor
	Person(String name, Date birthday){
		this.name = name; //string is immutable, can't be changed
		this.birthday = new Date(birthday); //creates new object with value, not address for reference type object
	}
	
	//copy constructor
	Person(Person newPerson){
		this.name = newPerson.name;
		this.birthday = new Date(newPerson.birthday);
	}
	
	
	//Accessor methods
	public String getName() {
		return this.name;
	}
	
	public Date getBirthday() {
		return new Date(this.birthday); // new object with same parameters is returned
	}
	
	//Mutator methods
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = new Date(birthday);
		//create new calling object with same value as object (but not same address) to parameter 
	}
	

	
	//toString method
	public String toString() {
		return this.name + ", born on" + this.birthday.getDay() + this.birthday.getMonth() + this.birthday.getYear();
	}
	
	
	
}
