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
	
	@Override
	public boolean equals(Object anotherGenre) {
		if(anotherGenre instanceof Genre) {
			Genre g = (Genre) anotherGenre;
			return this.name.equals(g.name);
		}
		return false;
	}
}
