package myLibrary;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Author {
	
	@XmlElement
	private String name;
	@XmlElement
	private String surname;
	
	public String getName() {return this.name;}
	public String getSurname() {return this.surname;}
	
//	public void setName(String name) {this.name = name;}
//	public void setSurname(String sn) {this.surname = sn;}
	
	public Author() {}
	
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
	
	public static void authorToXml(Author a) {
		try {
			JAXBContext context = JAXBContext.newInstance(Author.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("author.xml");
			marshaller.marshal(a, file);
			marshaller.marshal(a, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void xmlToAuthor() {
		try {
			JAXBContext context = JAXBContext.newInstance(Author.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("author.xml");
			Author a = (Author) unmarshaller.unmarshal(file);
			System.out.println(a);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
