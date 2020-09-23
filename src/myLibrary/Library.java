package myLibrary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Library {
	
	private static Library instance;
	
	public static Library getInstance() {
		if(instance == null) {
			return new Library();
		}else {
			return instance;
		}
	}
	
	private Map<String, Book> books;
	private Set<Author> authors;
	private Set<PublishingHouse> pupHouses;
	
	public Map<String, Book> getBooks() {return this.books;}
	public Set<Author> getAuthors() {return this.authors;}
	public Set<PublishingHouse> getPupHouses() {return this.pupHouses;}
	
	private Library() {
		this.books = new HashMap<>();
		this.authors = new HashSet<>();
		this.pupHouses = new HashSet<>();
	}
	
	public void addBook(String title, Author a, Genre g, PublishingHouse p) {
		Book b = new Book(title, a, g, p);
		books.put(b.getTitle(), b);
	}
	
	public void addBook(Book book) {
		books.put(book.getTitle(), book);
	}
	
	public void removeBook(String title) {
		books.remove(title);
	}
	
	public void listAllBooks() {
		for(Map.Entry<String, Book> entry : books.entrySet()) {
			System.out.println(entry.getKey() +", "+ entry.getValue().toString());
		}
	}
	
	public Book searchBookByTitle(String title) {
		return books.get(title);
	}
	
	public void addAuthor(Author author) {
		Author a = new Author(author.getName(), author.getSurname());
		this.authors.add(a);
	}
	
	public void removeAuthor(String name) {
		for(Author a : authors) {
			if(a.getName().equals(name)) {
				authors.remove(a);
			}
		}
	}
	
	public void listAllAuthors() {
		for(Author a : authors) {
			System.out.println(a.toString());
		}
	}
	
	public Author searchAuthorByName(String name) throws Exception{
		for(Author a : authors) {
			if(a.getName().equals(name)) {
				return a;
			}
		}
		throw new Exception("This author does not exist in this library!");
	}

}
