package myLibrary;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
public class StudentsWrapper {
	
	@XmlElement(name = "student")
	public List<Student> list;
	
	public StudentsWrapper() {}
	
	public StudentsWrapper(List<Student> ls) {
		list = ls;
	}

}
