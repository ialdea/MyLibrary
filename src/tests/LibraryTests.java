package tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import myLibrary.Book;
import myLibrary.Library;

public class LibraryTests {

	@Test
	public void test1() {
		Library l = Library.getInstance();
		l.listAllBooks();
		assertNotNull(l.getBooks());
	}
}
