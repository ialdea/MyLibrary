package myLibrary;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Library {
	
	private static Library instance;
	
	public static Library getInstance() {
		if(instance == null) {
			instance = new Library();
		}
		return instance;
	}

	
	private Map<String, Book> books;
	private Map<String, Student> students;
	private Set<Author> authors;
	private Set<PublishingHouse> pubHouses;
	private Set<Genre> genres;
	
	public Map<String, Book> getBooks() {return this.books;}
	public Map<String, Student> getStudents(){return this.students;}
	public Set<Author> getAuthors() {return this.authors;}
	public Set<PublishingHouse> getPupHouses() {return this.pubHouses;}
	public Set<Genre> getGenres(){return this.genres;}
	
	
	public ArrayList<Book> getBooksList(){
		ArrayList<Book> ar = new ArrayList<Book>();
		for(Book b : books.values()) {
			ar.add(b);
		}
		return ar;
	}
	
	public List<Author> getAuthorsList(){
		ArrayList<Author> aut = new ArrayList<>(authors);
		return aut;
	}
	
	public List<Genre> getGenresList(){
		ArrayList<Genre> gen = new ArrayList<Genre>(genres);
		return gen;
	}
	
	public List<PublishingHouse> getPubHousesList(){
		ArrayList<PublishingHouse> ph = new ArrayList<PublishingHouse>(pubHouses);
		return ph;
	}
	
	public List<Student> getStudentsList(){
		ArrayList<Student> stud = new ArrayList<Student>();
		for(Student s : students.values()) {
			stud.add(s);
		}
		return stud;
	}
	
	private Library() {
		this.books = new HashMap<>();
		this.students = new HashMap<>();
		this.authors = new HashSet<>();
		this.pubHouses = new HashSet<>();
		this.genres = new HashSet<>();
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
		students.put(s.getNameAndSurname(), s);
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
	
	public void addGenre(Genre gen) {
		Genre g = new Genre(gen.getGenreName());
		genres.add(g);
	}
	
	public void listAllGenres() {
		for(Genre g : genres) {
			System.out.println(g);
		}
	}
	
	public void booksListToXml() {
		try {
//			JAXBContext context = JAXBContext.newInstance(Book.class);
//			Marshaller marshaller = context.createMarshaller();
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("booksList.xml");
//			
//			ArrayList<Book> ar = new ArrayList<Book>();
//			
//			String booksXml = "";
//			for(Book b : books.values()) {
//				StringWriter sw = new StringWriter();
//				marshaller.marshal(b, sw);
//				if(ar.size() > 0) {
//					booksXml += sw.toString().substring(sw.toString().indexOf("\n"));
//				}else {
//					booksXml += sw.toString();
//				}
//				ar.add(b);
//			}
//			booksXml = booksXml.split("\n")[0] + "\n<library>"+ booksXml.substring(booksXml.indexOf("\n"))+"</library>";
//			
//			System.out.println(booksXml);
			
			
			
			JAXBContext context = JAXBContext.newInstance(BooksWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			BooksWrapper bw = new BooksWrapper(getBooksList());
			System.out.println("---------------------------");
			marshaller.marshal(bw, System.out);
			marshaller.marshal(bw, file);
			System.out.println("---------------------------");
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void authorsListToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(AuthorsWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("authors.xml");
			AuthorsWrapper aw = new AuthorsWrapper(getAuthorsList());
			marshaller.marshal(aw, file);
			marshaller.marshal(aw, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void genresListToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(GenresWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("genres.xml");
			GenresWrapper gw = new GenresWrapper(this.getGenresList());
			marshaller.marshal(gw, file);
			marshaller.marshal(gw, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void pubHousesListToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(PubHousesWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("publishingHouses.xml");
			PubHousesWrapper phw = new PubHousesWrapper(getPubHousesList());
			marshaller.marshal(phw, file);
			marshaller.marshal(phw, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void studentsListToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(StudentsWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File file = new File("students.xml");
			StudentsWrapper sw = new StudentsWrapper(getStudentsList());
			marshaller.marshal(sw, file);
			marshaller.marshal(sw, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
