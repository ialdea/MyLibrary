package myLibrary;

public class LibraryApp {
	
	public static void main(String[] args) {
		
		Author eliade = new Author("Eliade", "Mircea");
		Genre romantic = new Genre("romantic");
		PublishingHouse teora = new PublishingHouse("teora");
		Book b1 = new Book("Nunta in cer", eliade, romantic, teora);
		Book b2 = new Book("Maitreyi", eliade, romantic, teora);
		
		Student s1 = new Student("Grigorescu Razvan", 14, false, "Petre Ghelmez School", "Morarilor nr. 7", "0765234988");
		Student s2 = new Student("Serban Ana", 12, true, "95 School", "Brandusei nr. 24", "0743221365");
		
		System.out.println("------list books------");
		
		Library library = Library.getInstance();
		library.addBook(b1);
		library.addBook(b2);
		library.listAllBooks();
		
//		System.out.println("----stud methods-----");
//		s1.addToMyLoanList(b1);
//		s1.addToMyLoanList(b2);
//		s1.listMyLoanList();
//		s1.removeFromLoanList("Nunta in cer");
//		s1.listMyLoanList();
	}

}
