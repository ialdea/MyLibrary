package myLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	private Map<String, Student> students;
	private Set<Author> authors;
	private Set<PublishingHouse> pubHouses;
	
	public Map<String, Book> getBooks() {return this.books;}
	public Map<String, Student> getStudents(){return this.students;}
	public Set<Author> getAuthors() {return this.authors;}
	public Set<PublishingHouse> getPupHouses() {return this.pubHouses;}
	
	private Library() {
		this.books = new HashMap<>();
		this.students = new HashMap<>();
		this.authors = new HashSet<>();
		this.pubHouses = new HashSet<>();
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
//		Iterator<Author> itr = authors.iterator();			
//		while(itr.hasNext()) {
//			Author a = itr.next();
//			if(a.getName().equalsIgnoreCase(name)) {
//				itr.remove();
//			}
//		}
		Set<Author> collection = new HashSet<>();		//daca vrei sa stergi dintr un set sau list tre' sa folosesti iterator ca sa stergi
		for(Author a : authors) {						//cu el, nu poti face remove pe setul sau cu lista respectiva;
			if(a.getName().equals(name)) {				//cand faci un for sau un while se creeaza implicit un iterator;
				collection.add(a);
			}
		}
		authors.removeAll(collection);
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
	
	public void addStudent(Student s) {
		Student stud = new Student(s.getNameAndSurname(), s.getAge(), s.getGender(), s.getSchool(), s.getAdress(), s.getPhone());
		students.put(stud.getNameAndSurname(), stud);
	}
	
	public void removeStudent(String nameAndSurname) {
		students.remove(nameAndSurname);
	}
	
	public void listAllStudents() {
		for(Map.Entry<String, Student> entry : students.entrySet()) {
			System.out.println(entry.getKey()+", "+entry.getValue().toString());
		}
	}
	
	public Student searchStudentByName(String nameAndSurname) {
		return students.get(nameAndSurname);
	}
	
	public void addPublishingHouse(PublishingHouse pub) {
		PublishingHouse p = new PublishingHouse(pub.getName());
		pubHouses.add(p);
	}
	
	public void removePublishingHouse(String name) {
		Iterator<PublishingHouse> itr = pubHouses.iterator();
		while(itr.hasNext()) {
			PublishingHouse p = itr.next();
			if(p.getName().equals(name)) {
				itr.remove();
			}
		}
	}
	
	public void listAllPublishingHouse() {
		for(PublishingHouse p : pubHouses) {
			System.out.println(p);
		}
	}
	
	public PublishingHouse searchPublishingHouse(String name) throws Exception{
		for(PublishingHouse p : pubHouses) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		throw new Exception("This Publishing House does not exist in this library!");
	}
	
	public List<Book> getBooksByAuthor(Author aut){
		List<Book> list = new ArrayList<>();
		//in acest for iterez prin entrySet pentru a cauta valoarea;
//		for(Map.Entry<String, Book> entry : books.entrySet()) {
//			if(entry.getValue().getAuthor().equals(aut)) {
//				list.add(entry.getValue());
//				System.out.println(entry.getValue().toString());
//			}
//		}
		
		// aici iterez direct pe valoare;
		for(Book b : books.values()) {
			if(b.getAuthor().equals(aut)) {
				list.add(b);
				System.out.println(b);
			}
		}
		return list;
	}
	
	public List<Book> getBooksByGenre(Genre gen){
		List<Book> list = new ArrayList<>();
		for(Book b : books.values()) {
			if(b.getGenre().equals(gen)) {
				list.add(b);
				System.out.println(b);
			}
		}
		return list;
	}
	
	

}
