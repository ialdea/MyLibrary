package myLibrary;

public class Student {
	
	private String nameAndSurname;
	private int age;
	private boolean gender;
	private String school;
	private String adress;
	private String phone;
	private int registerId;
	LoanList loanList;
	//fiecare student are un LoanList si aici fac functia addToMyLoanList, apelez loanList.addBook
	
	private static int nextId = 1;
	
	public String getNameAndSurname() {return this.nameAndSurname;}
	public int getAge() {return this.age;}
	public boolean getGender() {return this.gender;}
	public String getSchool() {return this.school;}
	public String getAdress() {return this.adress;}
	public String getPhone() {return this.phone;}
	
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
}
