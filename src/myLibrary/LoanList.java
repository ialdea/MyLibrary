package myLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoanList {
	
	private List<Book> booksToLoan;
	
	public List<Book> getBooksToLoan() {return this.booksToLoan;}
	
	public LoanList() {
		this.booksToLoan = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		Book b = new Book(book.getTitle(), book.getAuthor(), book.getGenre(), book.getPubH());
		booksToLoan.add(b);
	}
	
	public void removeBook(String title) {
		Iterator<Book> itr = booksToLoan.iterator();
		while(itr.hasNext()) {
			Book b = itr.next();
			if(b.getTitle().equals(title)) {
				booksToLoan.remove(b);
			}
		}
	}
}
