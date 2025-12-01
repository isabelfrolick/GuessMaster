package com.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;



public class GuessMaster3{

	//Hashset of GuessablePerson that can accept any type parameter
	private HashSet<GuessablePerson<?>> people = new HashSet<>();
	private int numPoints;
	private int numPeople;

	//default constructor
	GuessMaster3(){
		//this(new HashSet<>(0), 0, 0);
		people = new HashSet<GuessablePerson<?>>();
		numPoints = 0;
		numPeople = 0;
	}


	//addPerson() method that accepts type parameter that extends Person 
	public <M extends Person> void addPerson(M person, double difficulty) {
		//new GuessablePerson type object
		GuessablePerson<M> newPeople = new GuessablePerson<M>(person, difficulty);
		//use hashset method add to add GuessablePerson obj to Hashset (no duplicates)
		people.add(newPeople);
		this.numPeople++;




	}
	//method to return the people hashset
	public HashSet<GuessablePerson<?>> getPeople(){
		return this.people;
	}


	//startGame() to run the game
	public void startGame() throws CloneNotSupportedException, FileNotFoundException, IncorrectDateException {

		System.out.println("Welcome! Let's start the game!");

		boolean quitGame = false;

		//define user input as null initially
		Scanner user = null;

		try {
			//scanner object for getting user input
			File newFile = new File("C:\\Users\\12894\\Downloads\\test.txt");
			//Scanner object defined using FileInputStream
			user = new Scanner(new FileInputStream(newFile));



			//catch exception
		}catch (FileNotFoundException e1) {
			return;

		}	

		//while loop to repeat guesses until the user is correct
		while(!quitGame) {
			//get the guess from the user

			//define Iterator- can take in any GuessablePerson type parameter
			Iterator<GuessablePerson<?>> peopleIterator = people.iterator();
			//accomodate currPerson to be selected using iterator

			//while Scanner input has more info
			while(peopleIterator.hasNext()) {
				//while the iterator has
				while(user.hasNextLine()) {
					//define currentPerson using the iterator's next method
					GuessablePerson<?> currPerson = peopleIterator.next();
					//startMessage() method-  in Guessable interface, implemented in GuessablePerson- works bc currPerson is a GuessablePerson object
					System.out.println(currPerson.startMessage());
					//boolean value for when the user guesses correctly
					boolean correct=false;
					boolean next = false;


					while(!correct) {
						//convert the users guess into a date object

						String userInput = user.nextLine();

						//if string entered is quit- exit game
						if(userInput.equals("quit")) {
							System.out.println("Thank you for playing!");
							quitGame = true;
							user.close();

							System.exit(0);
						}


						try {
							//check if dateGuessed throws exceptions
							Date dateGuessed = new Date(userInput);
							//use compareTo() to ease functionality
							if(dateGuessed.compareTo(currPerson.getPerson().getBirthday()) == -1){

								System.out.println("Incorrect. Try an earlier year.");


							}else if(dateGuessed.compareTo(currPerson.getPerson().getBirthday()) == 1) {
								System.out.println("Incorrect. Try a later year.");


							}else if(dateGuessed.compareTo(currPerson.getPerson().getBirthday()) == 0) {
								System.out.println(currPerson.closingMessage());
								//Add the points won to the total number of points
								numPoints+=currPerson.getAwardedPointNumber();
								//display the number of points gained, and the total number of points
								System.out.println("You won "+currPerson.getAwardedPointNumber()+" points in this round. Your total number of points is "+numPoints);
								correct=true;
								currPerson = peopleIterator.next();
								//iterate Iterator

							}
							//catch exceptions
						}catch(IncorrectDateException e1) {
							e1.getMessage();

						}
						catch(CloneNotSupportedException e2) {
							e2.getMessage();
							correct = true;

						}finally {
							//will output regardless of whether the guess was correct or not
							System.out.println("If you want to quit at any time enter \"quit\"");
							System.out.println("\n"); //for output clarity
							//check if at end of file- set next to true
							if(!(user.hasNextLine())) {
								next = true;
							}
						}




					}
				}
			}


		}




	}

	public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException, IncorrectDateException {
		Politician trudeau = new Politician("Justin Trudeau", new Date(25,12,1971), "Liberal");
		Singer dion = new Singer("Celine Dion", new Date(30,3,1961), "La voix du bon Dieu", new Date(6,11,1992));
		Singer robertson = new Singer("Ed Robertson", new Date(25,10,1970), "Gordon", new Date(6,11,1981));

		GuessMaster3 gm = new GuessMaster3();
		gm.addPerson(trudeau, 0.25);
		gm.addPerson(dion, 0.5);
		gm.addPerson(robertson, 0.75);
		System.out.println("There are " + gm.getPeople().size() + " people in the game");
		GuessablePerson<Politician> guessableTrudeau = new GuessablePerson<>(trudeau, 0.25);

		System.out.println("The next output should be -1");
		System.out.println(guessableTrudeau.compareTo(dion));
		gm.startGame();



	}
}
