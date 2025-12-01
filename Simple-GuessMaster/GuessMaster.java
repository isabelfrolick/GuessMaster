
package com.assignment1;
import java.util.Scanner;
import java.util.Random;
/**
 * Class to start the GuessMaster game with main method
 * @author Isabel Frolick, 20155540
 * @version 1
 *
 */
public class GuessMaster {
	
	private int currentPerson = 1; //which person is being used (like array)
	private Person person1;
	private Person person2;
	private Person person3;
	

	//constructor
	public GuessMaster(Person person1, Person person2, Person person3) {
		this.person1 = new Person(person1); //initialize the ref type objects by making a new person type object for instance variables
		this.person2 = new Person(person2);
		this.person3 = new Person(person3);
		this.currentPerson = 1;
	}
	
	//start game method
	
	public void startGame() {
	

		//get date from the user
		Scanner keyboard = new Scanner(System.in);

		
		System.out.println("Please enter your birthday guess in the format \"DD/MM/YYYY\"\nIf you would like to exit the game at any time, enter \"quit\"");
	for(int i=0; i < 100; i ++) {	//use for loop to restart the game after the third person guesses

		//code for the first person
		while(currentPerson == 1) { 
	
			System.out.println( "You are trying to guess " + person1.getName() + "'s birthday."); //output name of person to be guessed
			

			String user = keyboard.nextLine(); //get the guess from the user
		
			if(user.matches("quit")) { //if user enters quit, end game
				System.out.println("Thank you for playing!");
				System.exit(0);
			}
			
			Date dateTypeInput = new Date(user); //convert String type to a Date type using 
		
			
			if(person1.getBirthday().equals(dateTypeInput)){ //if the birthday of the user is equal to the date type object the user inputed
				System.out.println("Correct! You got it!");
				currentPerson++; //iterate value to next person
			}else 
				if(person1.getBirthday().getYear() == dateTypeInput.getYear()) { //if the person's year of birth is the same as guess
					if(person1.getBirthday().getMonth() > dateTypeInput.getMonth()) { //if the month is different, guess again
						System.out.println("Same year! Try a later date!\n");
				}else if(person1.getBirthday().getMonth() < dateTypeInput.getMonth()) {
					System.out.println("Same year! Try an earlier date!\n");
				}
				else if(person1.getBirthday().getMonth() == dateTypeInput.getMonth()) { //if the month and year are same
				
					if(person1.getBirthday().getDay() > dateTypeInput.getDay()) { //if day of birth is different, guess again 
						System.out.println("So close! Try a later day!!\n");
					}else if(person1.getBirthday().getDay() < dateTypeInput.getDay()) {
						System.out.println("So close! Try an earlier day!"); //inserted hints to make the game easier for the user
					}
				}
				
			}
			else if(person1.getBirthday().getYear() < dateTypeInput.getYear()) { //if the year of birth is different than guess, guess again
				System.out.println("Try an earlier date!\n");
			}else if(person1.getBirthday().getYear() > dateTypeInput.getYear()) {
				System.out.println("Try a later date!\n");
			}
}
			
//person 2, guessing code (same as person 1)
	while(currentPerson == 2) {
		
		System.out.println("You are trying to guess " + person2.getName() + "'s birthday.");
		

		String user = keyboard.nextLine();
		
		if(user.matches("quit")) {
			System.out.println("Thank you for playing!");
			System.exit(0);
		}
		Date dateTypeInput = new Date(user);
		
		
		if(person2.getBirthday().equals(dateTypeInput)){
			System.out.println("Correct! You got it!");
			currentPerson++; //iterate loop to person 3
		}else 
			if(person2.getBirthday().getYear() == dateTypeInput.getYear()) {
				if(person1.getBirthday().getMonth() > dateTypeInput.getMonth()) {
					System.out.println("Same year! Try a later date!\n");
			}else if(person2.getBirthday().getMonth() < dateTypeInput.getMonth()) {
				System.out.println("Same year! Try an earlier date!\n");
			}else if(person2.getBirthday().getMonth() == dateTypeInput.getMonth()) {
				
				if(person2.getBirthday().getDay() > dateTypeInput.getDay()) {
					System.out.println("So close! Try a later day!\n");
				}else if(person2.getBirthday().getDay() < dateTypeInput.getDay()) {
					System.out.println("SO close! Try an earlier day");
				}
			}
		}else if(person2.getBirthday().getYear() < dateTypeInput.getYear()) {
			System.out.println("Try an earlier date!\n");
		}else if(person2.getBirthday().getYear() > dateTypeInput.getYear()) {
			System.out.println("Try a later date!\n");
		}
}
	
//guessing for person 3
while(currentPerson == 3) {
		System.out.println("You are trying to guess " + person3.getName() + "'s birthday.");
	

		String user = keyboard.nextLine();
		if(user.matches("quit")) {
			System.out.println("Thank you for playing!");
			System.exit(0);
		}
		Date dateTypeInput = new Date(user);
		
		if(person3.getBirthday().equals(dateTypeInput)){
			System.out.println("Correct! You got it!");
			currentPerson = 1;
			i++; //update the for loop to restart the game, can replay up to 100 times
		}else 
			if(person3.getBirthday().getYear() == dateTypeInput.getYear()) {
				if(person3.getBirthday().getMonth() > dateTypeInput.getMonth()) {
					System.out.println("Same year! Try a later date!\n");
			}else if(person3.getBirthday().getMonth() < dateTypeInput.getMonth()) {
				System.out.println("Same year! Try an earlier date!\n");
			}
			else if(person3.getBirthday().getMonth() == dateTypeInput.getMonth()) {
				if(person3.getBirthday().getDay() > dateTypeInput.getDay()) {
					System.out.println("So close! Try a later day!\n");
				}else if(person3.getBirthday().getDay() < dateTypeInput.getDay()) {
					System.out.println("SO close! Try an earlier day");
				}
			}
			
		}
		else if(person3.getBirthday().getYear() < dateTypeInput.getYear()) {
			System.out.println("Try an earlier date!\n");
		}else if(person3.getBirthday().getYear() > dateTypeInput.getYear()) {
			System.out.println("Try a later date!\n");
		}
}	
	}
	}
	
	

	


	public static void main(String[] args) {
		
		Person gates = new Person("Bill Gates" , new Date(28, 10, 1955));
		Person musk = new Person(" Elon Musk" , new Date(30, 3, 1968));
		Person bolt = new Person("Usain Bolt" , new Date(21, 8, 1986));

		GuessMaster gm = new GuessMaster(gates, musk, bolt);
		

		
		gm.startGame();
	
	


	}

}

