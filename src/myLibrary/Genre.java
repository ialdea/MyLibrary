package myLibrary;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Genre {
	
	@XmlElement
	private String name;
	
	public String getGenreName() {return this.name;}
	public void setGenreName(String name) {this.name = name;}
	
	public Genre() {}
	
	public Genre(String name) {
		this.name = name;
	}
	
	@Override
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
	
	public static void genreToXml(Genre g) {
		try {
			JAXBContext context = JAXBContext.newInstance(Genre.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("genre.xml");
			marshaller.marshal(g, file);
			marshaller.marshal(g, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void xmlToGenre() {
		try {
			JAXBContext context = JAXBContext.newInstance(Genre.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("genre.xml");
			Genre g = (Genre) unmarshaller.unmarshal(file);
			System.out.println(g);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
