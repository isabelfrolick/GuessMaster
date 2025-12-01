package com.assignment2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Isabel Frolick, 20155540
 *
 */

public class GuessMaster2 {


	private Person[] people = new Person[0]; //array of People type objects
	private int numPoints = 0; //number of points the user has scored
	private int numPeople = 0; //number of people to be used in the game
	private int numRound = 0; //tracks the round so that the starting message does not repeat after the first round
	private int[] totalPointsArray = new int[0]; //an array of integers containing the points won per round to track the total points


	//default constructor
	GuessMaster2(){
		this(new Person[0], 0, 0, 1, new int[0]);
	}


	//constructor to initialize instance variables
	GuessMaster2(Person[] people, int numPoints, int numPeople, int numRound, int[] totalPointsArray){
		this.people = people;
		this.numPoints = numPoints;
		this.numPeople = numPeople;
		this.numRound = numRound;
		this.totalPointsArray = totalPointsArray;

	}

	//add person method
	public void addPerson(Person somePerson) {
		int personArrayLength = people.length; //find current length of array

		people = Arrays.copyOf(people, personArrayLength + 1); //expand array by one spot
		people[people.length -1] = somePerson; //add the person to the end of the array
		numPeople++; //iterate number of people in array, could also do numPeople = people.length + 1 
	}

	
	//use override to create 2 methods by same name, one randomly generates
	//the index, other takes in a person type produced by the Random array
	public void startGame() {

		int indexPerson = randomGenerator(); //call the random genertor method to get a random index
		startGame(people[indexPerson]); //start the game at the index of the randomly generated person in array

	}


	//override method that takes in a person type object

	public void startGame(Person newPerson) {

		//if this is the first round, play the startMessage to welcome the user
		if(numRound ==1) {
			//starting message, invoke startMessage() method using the index randomly generated
			System.out.println("Welcome! Let's start the game! " + newPerson.startMessage());
			System.out.println("If you you like to exit the game at any time enter \"quit\"");
		}else

			System.out.println("In this round, " + newPerson.startMessage());

		while(true) {

			//create scanner object to get user input, same as Assignment 1
			Scanner keyboard = new Scanner(System.in); 

			String user = keyboard.nextLine(); //get the guess from the user
			if(user.matches("quit")) { //if user enters quit, end game
				System.out.println("Thank you for playing!");
				System.exit(0);
			}

			Date dateTypeInput = new Date(user); //convert String type to a Date type using string constructor


			if(newPerson.getBirthday().equals(dateTypeInput)) {
				//tell user their guess was correct using a closing message
				System.out.println("Correct! " + newPerson.closingMessage());	

				//indicate how many points were won this round, call the method to calculate the awarded points at the Person object difficulty level
				System.out.println("This round you won: " + newPerson.getAwardedPointsNumber(newPerson.getDifficultyLevel()) + " points");

				int numPoints = newPerson.getAwardedPointsNumber(newPerson.getDifficultyLevel()); //set the number of points of the round to the instance variable, numPoints

				System.out.println("In total, you have won: " + totalPoints(numPoints) + " points"); //call the totalPoints() method to add the round's points to the array and calculate sum
				numRound++; //iterate the rounds so that the welcome message doesn't play again
				startGame(); //start another round



			}else //if the user inputted date is not the date of the object
				if(newPerson.getBirthday().getYear() == dateTypeInput.getYear()) { //if the person's year of birth is the same as guess

					if(newPerson.getBirthday().getMonth() > dateTypeInput.getMonth()) { //if the month is different, guess again
						int programMonth = (Integer)newPerson.getBirthday().getMonth(); //get the integer value of the Person object birthday month
						int userMonth = (Integer)dateTypeInput.getMonth(); //get the integer value of the user inputed birthday month
						int monthDifference = programMonth - userMonth; //find the difference between the actual birth month and the guessed birthday month
						monthDifference = Math.abs(programMonth - userMonth); //make an absolute value
						if(monthDifference > 12) { //if the difference is greater than 12, the guessed birth month was invalid, not foolproof but provides some limitations
							System.out.println("Please re-enter a valid month");

						}else if(monthDifference <= 12 && monthDifference >= 9) { //largest difference, 12-9 months difference
							System.out.println("You're in the right year but you're pretty much as far away as possible from the right month! Try a later date.");
						}else if(monthDifference < 9 && monthDifference >= 6) { //between 9 and 6 month difference, half a year approximately
							System.out.println("You're about half a year away! Try a later date");
						}else if(monthDifference < 6 && monthDifference >= 3) { //about 1 season difference (3 months)
							System.out.println("You're a season away! Try a later date");
						}else if(monthDifference < 3) { //within the correct season, within 3 months of the correct date
							System.out.println("You're in the right season! Try a later date");
						}
					}
					//same code as above, instead of "later date" suggests selecting an earlier month"
					else if(newPerson.getBirthday().getMonth() < dateTypeInput.getMonth()) {
						int programMonth = (Integer)newPerson.getBirthday().getMonth();
						int userMonth = (Integer)dateTypeInput.getMonth();
						int monthDifference = programMonth - userMonth;
						monthDifference = Math.abs(programMonth - userMonth);
						if(monthDifference > 12) {
							System.out.println("Please re-enter a valid month");

						}else if(monthDifference <= 12 && monthDifference >= 9) {
							System.out.println("You're in the right year but you're pretty much as far away as possible from the right month! Try an earlier date.");
						}else if(monthDifference < 9 && monthDifference >= 6) {
							System.out.println("Right year! You're about half a year away! Try an earlier date");
						}else if(monthDifference < 6 && monthDifference >= 3) {
							System.out.println("Right year! You're a season away! Try an earlier date");
						}else if(monthDifference < 3) {
							System.out.println("Right year! You're in the right season! Try an earlier date");
						}
					}


					else if(newPerson.getBirthday().getMonth() == dateTypeInput.getMonth()) { //if the month and year are same

						if(newPerson.getBirthday().getDay() > dateTypeInput.getDay()) { //if day of birth is different, guess again 
							//same code used to find the difference in days as the months above
							int programDay = (Integer)newPerson.getBirthday().getDay();
							int userDay = (Integer)dateTypeInput.getDay();
							int dayDifference = programDay - userDay;
							dayDifference = Math.abs(programDay - userDay);
							if(dayDifference > 30) { //invalid if the difference is greater than 30 days, not foolproof but provides some limitations
								System.out.println("Please enter a valid day");
							}else if(dayDifference <= 30 && dayDifference > 21) { // guessed answer is within correct month but still on the wrong side
								System.out.println("Right month! Still 4 weeks off! Try a later day!");
							}else if(dayDifference <= 21 && dayDifference > 14) { //still more than 2 weeks off but within correct month
								System.out.println("Right month! About 3 weeks off! Try a later day!");
							}else if(dayDifference <= 14 && dayDifference > 7) { //1-2 weeks off the correct date
								System.out.println("Right month! About 2 weeks off! Try a later day!");
							}else if(dayDifference <= 7) { //within the correct week
								System.out.println("SO close, you're within a week! Try a later day!");
							}

							//same code as for the day code above
						}else if(newPerson.getBirthday().getDay() < dateTypeInput.getDay()) {
							int programDay = (Integer)newPerson.getBirthday().getDay();
							int userDay = (Integer)dateTypeInput.getDay();
							int dayDifference = programDay - userDay;
							dayDifference = Math.abs(programDay - userDay);
							if(dayDifference > 30) {
								System.out.println("Please enter a valid day");

							}else if(dayDifference <= 30 && dayDifference > 21) {
								System.out.println("Right month! Still 4 weeks off! Try an earlier day!");
							}else if(dayDifference <= 21 && dayDifference > 14) {
								System.out.println("Right month! About 3 weeks off! Try an earlier day!");
							}else if(dayDifference <= 14 && dayDifference > 7) {
								System.out.println("Right month! About 2 weeks off! Try an earlier day!");
							}else if(dayDifference <= 7) {
								System.out.println("SO close, you're within a week! Try an earlier day!");
							}
						}
					}

				}//if the year is different
				else if(newPerson.getBirthday().getYear() < dateTypeInput.getYear()) { //if the year of birth is different than guess, guess again
					int programInt = (Integer)newPerson.getBirthday().getYear();
					int userInt = (Integer)dateTypeInput.getYear();

					int difference = programInt - userInt;
					difference = Math.abs(difference);
					if(difference >= 25) {
						System.out.println("Woah! That's not even the right generation! Try an earlier date!");
					}else if(difference < 25 && difference >= 10) {
						System.out.println("Wrong decade! Try an earlier date!");
					}else if(difference < 10 && difference >= 5) {
						System.out.println("With 10 years, but not quite! Try an earlier date");
					}else if(difference < 5 && difference >= 3) {
						System.out.println("You're so close, within 5 years! Pick an earlier date.");
					}else if(difference < 3) {
						System.out.println("You're so close, within 3 years! Pick an earlier date.");
					}
				}else if(newPerson.getBirthday().getYear() > dateTypeInput.getYear()) {
					int programInt = (Integer)newPerson.getBirthday().getYear();
					int userInt = (Integer)dateTypeInput.getYear();
					int difference = programInt - userInt;
					difference = Math.abs(difference);

					if(difference >= 50) {
						System.out.println("Woah! That's not even the right generation! Try a later date!");
					}else if(difference < 50 && difference >= 25) {
						System.out.println("Maybe their parents are that age, but you're a little off. Try a later date!");
					}else if(difference < 25 && difference >= 10) {
						System.out.println("Wrong decade! Try a later date!");
					}else if(difference < 10 && difference >= 5) {
						System.out.println("Within 10 years, but not quite! Try a later date");
					}else if(difference < 5 && difference >= 3) {
						System.out.println("You're so close, within 5 years! Pick a later date.");
					}else if(difference < 3) {
						System.out.println("You're so close, within 3 years! Pick a later date.");
					}

				}
		}
	}

	//method to generate a random index for the person to be selected
	public int randomGenerator() {

		Random rnd = new Random(); //create random type object
		int selectedPerson = rnd.nextInt(numPeople); //create a random object that generates the index outputed, between  0 and the max number of people

		return selectedPerson; //return the chosen index 


	}
	
	//method to sum the total points of each round played
	public int totalPoints(int points) {
		//takes in the points won in that round

		int totalPointsLength = totalPointsArray.length; //find the length of the array of points
		totalPointsArray = Arrays.copyOf(totalPointsArray, totalPointsLength + 1); //append to the array to add an index

		totalPointsArray[totalPointsArray.length -1] = points; //add the points of the current round to the last index
		int sum = 0; //initialize the sum

		for(int i = totalPointsLength; i >= 0; i--) { //decrement the loop, starting at the current index, to the first index
			sum = sum + totalPointsArray[i]; //sum each index as a recursive function
		}
		return sum; //return the sum of all points won so far
	}

	//main method
	public static void main(String[] args) {
		Politician trudeau = new Politician("Justin Trudeau", new Date(25,12,1971), 0.25, "Liberal");
		Singer dion = new Singer("Celine Dion", new Date(30,3,1961), 0.5, "La voix du bon Dieu", new Date(6,11,1992));
		Singer robertson = new Singer("Ed Robertson", new Date(25,10,1970), 0.75, "Gordon", new Date(6,11,1981));
		GuessMaster2 gm = new GuessMaster2();
		gm.addPerson(trudeau);
		gm.addPerson(dion);
		gm.addPerson(robertson);
		gm.startGame();


	}

}
