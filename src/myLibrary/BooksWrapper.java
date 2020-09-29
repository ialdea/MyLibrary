package myLibrary;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "books")
public class BooksWrapper {

	@XmlElement(name = "book")
	public List<Book> list;
	
	public BooksWrapper() {}
	
	public BooksWrapper(List<Book> ls) {
		list = ls;
	}
}
