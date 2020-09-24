package myLibrary;

public class Author {
	
	private String name;
	private String surname;
	
	public String getName() {return this.name;}
	public String getSurname() {return this.surname;}
	
	public void setName(String name) {this.name = name;}
	public void setSurname(String sn) {this.surname = sn;}
	
	public Author(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String toString() {
		return name +" "+ surname;
	}
	
	@Override
	public boolean equals(Object anotherAuthor) {
		if(anotherAuthor instanceof Author) {
			Author a = (Author) anotherAuthor;
			return this.name.equals(a.name) && this.surname.equals(a.surname);
		}
		return false;
	}
}
