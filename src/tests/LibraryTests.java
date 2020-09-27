package tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myLibrary.Book;
import myLibrary.Library;

public class LibraryTests {
	
//	@Before - creezi o functie a carei implementare se executa inaintea fiecarui @Test;
//	@After - creezi o functie a carei implementare se executa dupa fiecare @Test;
//	@BeforeClass - creezi o functie a carei implementare se executa la run o singura data. cam ca blocurile statice, ex: o conexiune la baza de date;
//	@AfterClass - creezi o functie care se executa la run dupa ce s a executat tot altceva din aceasta clasa. de ex: inchizi conexiunea la baza de date;

	@Test
	public void test1() {
		Library l = Library.getInstance();
		l.listAllBooks();
		assertNotNull(l.getBooks());
	}
}
