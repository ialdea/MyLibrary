package myLibrary;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	
	@XmlElement
	private String title;
	@XmlElement
	private Author author;
	@XmlElement
	private Genre genre;
	@XmlElement(name = "publishing house")
	private PublishingHouse pubH;
	
	@XmlAttribute
	private int ibsn; 	//international standard book number
	public static int nextIBSN = 100;
	
	public String getTitle() {return this.title;}
	public Author getAuthor() {return this.author;}
	public int getIbsn() {return this.ibsn;}
	public Genre getGenre() {return this.genre;}
	public PublishingHouse getPubH() {return this.pubH;}
	
	public Book() {}
	
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
	
	public static void bookToXML(Book book) {
		try {
			//create an instance of JAXBContext;
			JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
			
			//create an instance of Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			//create XML file
			File file = new File("book.xml");
			
			//convert object to XML file
			jaxbMarshaller.marshal(book, file);
			
			//printeaza continutul XML ului in consola
			OutputStream os = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(book, os);
			String xmlStr = new String(((ByteArrayOutputStream)os).toByteArray());
			System.out.println(xmlStr);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}