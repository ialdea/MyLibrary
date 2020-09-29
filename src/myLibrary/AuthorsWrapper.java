package myLibrary;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authors")
public class AuthorsWrapper {
	
	@XmlElement(name = "author")
	public List<Author> list;
	
	public AuthorsWrapper() {}
	
	public AuthorsWrapper(List<Author> ls) {		// POJO - plain old java object -  is an ordinary Java object, not bound by any special restriction
		list = ls;
	}
}
