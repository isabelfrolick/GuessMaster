package com.assignment3;



public class Singer extends Person {

	private String debutAlbum;
	private Date debutAlbumReleaseDate;

	//constructor
	Singer(String name, Date birthday, String debutAlbum, Date debutAlbumReleaseDate) throws CloneNotSupportedException{
		super(name, birthday); //these parameters are from base class, Person
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = debutAlbumReleaseDate;
	}



	//clone constructor
	public Singer clone(Singer other) throws CloneNotSupportedException {
		try {
			Singer anotherSinger = (Singer) super.clone();
			//to avoid privacy leaks for the ref. type object
			anotherSinger.debutAlbumReleaseDate = other.debutAlbumReleaseDate.clone();
			return anotherSinger;
		}catch(CloneNotSupportedException e) {
			e.getMessage();
			return null;
		}

	}
	//toString method, note: change in grammar for clarity
	public String toString() {
		try {

			return this.getName() + ", was born on " + this.getBirthday().getDay() +"/" + this.getBirthday().getMonth() + "/" + this.getBirthday().getYear() + ". Their debut album was " + this.debutAlbum + ", which was released on " + this.debutAlbumReleaseDate.getDay() + this.debutAlbumReleaseDate.getMonth() + this.debutAlbumReleaseDate.getYear();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	//personType() method, overloads politician when invoked
	public String personType() {
		return "Singer";
	}
}
