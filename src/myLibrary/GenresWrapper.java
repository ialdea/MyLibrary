package myLibrary;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenresWrapper {

	@XmlElement
	public List<Genre> list;
	
	public GenresWrapper() {}
	
	public GenresWrapper(List<Genre> ls) {
		list = ls;
	}
}
