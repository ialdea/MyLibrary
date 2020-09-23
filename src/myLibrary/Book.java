package myLibrary;

public class Book {
	
	private String title;
	private Author author;
	private Genre genre;
	private PublishingHouse pubH;
	
	private int ibsn; 	//international standard book number
	public static int nextIBSN = 100;
	
	public String getTitle() {return this.title;}
	public Author getAuthor() {return this.author;}
	public int getIbsn() {return this.ibsn;}
	public Genre getGenre() {return this.genre;}
	public PublishingHouse getPubH() {return this.pubH;}
	
	public Book(String title, Author a, Genre genre, PublishingHouse ph) {
		this.ibsn = nextIBSN;
		nextIBSN++;
		this.title = title;
		this.author = a;
		this.genre = genre;
		this.pubH = ph;
	}
	
	public String toString() {
		return ibsn+", "+title+", "+author.toString()+", "+genre.toString()+", "+pubH.toString();
	}
}