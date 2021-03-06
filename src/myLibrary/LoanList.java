package myLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoanList {
	
	@XmlElement
	private List<Book> booksToLoan;
	
	public List<Book> getBooksToLoan() {return this.booksToLoan;}
	//public void setBooksToLoan(List<Book> ls) {this.booksToLoan = ls;}
	
	public LoanList() {
		this.booksToLoan = new ArrayList<>();
	}
	
	public void addBook(Book book) {
//		Book b = new Book(book.getTitle(), book.getAuthor(), book.getGenre(), book.getPubH());
		booksToLoan.add(book);
		Library.getInstance().removeBook(book.getTitle());
	}
	
	public void removeBook(String title) {
		Iterator<Book> itr = booksToLoan.iterator();
		while(itr.hasNext()) {
			Book b = itr.next();
			if(b.getTitle().equals(title)) {
				booksToLoan.remove(b);
				Library.getInstance().getBooks().put(b.getTitle(), b);
			}
		}
	}
	
	public void listTheLoanList() {
		for(Book b : booksToLoan) {
			System.out.println(b.toString());
		}
	}
	
	
}
