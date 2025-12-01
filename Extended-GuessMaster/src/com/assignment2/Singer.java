package com.assignment2;

/**
 * 
 * @author  Isabel Frolick, 20155540
 *
 */
public class Singer extends Person implements Cloneable{

	private String debutAlbum;
	private Date debutAlbumReleaseDate;

	//constructor
	Singer(String name, Date birthday, double difficulty, String debutAlbum, Date debutAlbumReleaseDate){
		super(name, birthday, difficulty); //these parameters are from base class, Person
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = debutAlbumReleaseDate;
	}

	//copy constructor 
	Singer(Singer newSinger){
		super(newSinger.getName(), newSinger.getBirthday(), newSinger.getDifficultyLevel());
		this.debutAlbum = newSinger.debutAlbum;
		this.debutAlbumReleaseDate = newSinger.debutAlbumReleaseDate;
	}

	//clone constructor
	public Singer clone() throws CloneNotSupportedException {
		Singer anotherSinger = (Singer)clone();
		return anotherSinger;

	}
	//toString method, note: change in grammar for clarity
	public String toString() {
		return this.getName() + ", was born on " + this.getBirthday().getDay() +"/" + this.getBirthday().getMonth() + "/" + this.getBirthday().getYear() + ". Their debut album was " + this.debutAlbum + ", which was released on " + this.debutAlbumReleaseDate.getDay() + this.debutAlbumReleaseDate.getMonth() + this.debutAlbumReleaseDate.getYear();
	}

	//personType() method, overloads politician when invoked
	public String personType() {
		return "Singer";
	}

}
