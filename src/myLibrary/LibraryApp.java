package myLibrary;


public class LibraryApp {
	
	public static void main(String[] args) {
		
		Author eliade = new Author("Eliade", "Mircea");
		Author sadoveanu = new Author("Sadoveanu", "Mihail");
		Genre romantic = new Genre("romantic");
		Genre sf = new Genre("scienced fiction");
		PublishingHouse teora = new PublishingHouse("teora");
		PublishingHouse hum = new PublishingHouse("humanitas");
		Book b1 = new Book("Nunta in cer", eliade, romantic, teora);
		Book b2 = new Book("Maitreyi", eliade, romantic, teora);
		
		Student s1 = new Student("Grigorescu Razvan", 14, false, "Petre Ghelmez School", "Morarilor nr. 7", "0765234988");
		Student s2 = new Student("Serban Ana", 12, true, "95 School", "Brandusei nr. 24", "0743221365");
		
		System.out.println("------list books------");
		
		Library library = Library.getInstance();
		library.addBook(b1);
		library.addBook(b2);
		library.listAllBooks();
		
		System.out.println("-----test for authors----");
		library.addAuthor(eliade);
		library.addAuthor(sadoveanu);
	
		//library.removeAuthor("Eliade");
		//library.listAllAuthors();
		try {
			Author a = library.searchAuthorByName("Eminescu");
			System.out.println(a.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		library.listAllAuthors();
		
		System.out.println("-----test for students-----");
		library.addStudent(s1);
		library.addStudent(s2);
		library.listAllStudents();
//		library.removeStudent("Grigorescu Razvan");
//		library.listAllStudents();
		Student s = library.searchStudentByName("Serban Ana");
		System.out.println(s.toString());
		
		System.out.println("----stud methods-----");
		s1.addToMyLoanList(b1);
		s1.addToMyLoanList(b2);
		s1.listMyLoanList();
//		library.listAllBooks();
//		s1.removeFromLoanList("Nunta in cer");
//		s1.listMyLoanList();
		
//		System.out.println("------list publishing houses---------");
//		library.addPublishingHouse(hum);
//		library.addPublishingHouse(teora);
//		library.listAllPublishingHouse();
		
//		System.out.println("-------list genres------");
//		library.addGenre(romantic);
//		library.addGenre(sf);
//		library.listAllGenres();
		
		System.out.println("-----test for xml----");
//		Book.bookToXML(b1);
//		Book.bookToXML(b2);
		
		//library.booksListToXml();
		//library.authorsListToXml();
//		library.genresListToXml();
//		library.pubHousesListToXml();
//		library.studentsListToXml();
//		Author.authorToXml(eliade);
//		Student.studentToXml(s1);
//		PublishingHouse.pubHouseToXml(ph);
//		Genre.genreToXml(romantic);
		
//		b2.xmlToBook();
//		library.xmlToBooks();
//		library.xmlToAuthors();
//		eliade.xmlToAuthor();
//		hum.xmlToPubHouse();
//		library.xmlToPubHouses();
//		romantic.xmlToGenre();
//		library.xmlToGenres();
//		s1.xmlToStudent();
		library.xmlToStudents();
	}
}
