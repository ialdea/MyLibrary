package myLibrary;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	@XmlElement
	private String nameAndSurname;
	@XmlElement
	private int age;
	@XmlElement
	private boolean gender;
	@XmlElement
	private String school;
	@XmlElement
	private String adress;
	@XmlElement
	private String phone;
	@XmlElement
	private int registerId;
	@XmlElement
	LoanList loanList;
	
	private static int nextId = 1;
	
	public String getNameAndSurname() {return this.nameAndSurname;}
	public int getAge() {return this.age;}
	public boolean getGender() {return this.gender;}
	public String getSchool() {return this.school;}
	public String getAdress() {return this.adress;}
	public String getPhone() {return this.phone;}
	
	public Student() {}
	
	public Student(String nameAndSurn, int age, boolean gender, String school, String adress, String phone) {
		this.registerId = nextId;
		nextId++;
		this.nameAndSurname = nameAndSurn;
		this.age = age;
		this.gender = gender;
		this.school = school;
		this.adress = adress;
		this.phone = phone;
		
		this.loanList = new LoanList();
	}
	
	public String toString() {
		return registerId+", "+nameAndSurname+", "+age+", "+gender+", "+school+", "+adress+", "+phone;
	}
	
	public void addToMyLoanList(Book b) {
		this.loanList.addBook(b);
	}
	
	public void removeFromLoanList(String t) {
		this.loanList.removeBook(t);
	}
	
	public void listMyLoanList() {
		for(Book b : loanList.getBooksToLoan()) {
			System.out.println(b.toString());
		}
	}
	
	public static void studentToXml(Student s) {
		try {
			JAXBContext context = JAXBContext.newInstance(Student.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("student.xml");
			marshaller.marshal(s, file);
			marshaller.marshal(s, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void xmlToStudent() {
		try {
			JAXBContext context = JAXBContext.newInstance(Student.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("student.xml");
			Student s = (Student) unmarshaller.unmarshal(file);
			System.out.println(s);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
