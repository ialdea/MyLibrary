package myLibrary;

public class Genre {
	
	private String name;
	
	public String getGenreName() {return this.name;}
	public void setGenreName(String name) {this.name = name;}
	
	public Genre(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
