package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KnjigaTest {

	Knjiga k;
	@BeforeEach
	void setUp() throws Exception {
		k=new Knjiga();
	}

	@AfterEach
	void tearDown() throws Exception {
		k=null;
	}

	@Test
	void testSetNaslovSveOK() {
		k.setNaslov("Babaroga");
		assertEquals("Babaroga",k.getNaslov());
	}
	
	@Test
	void testSetNaslovNull() {
		assertThrows(NullPointerException.class, ()->k.setNaslov(null));
	}
	
	@Test
	void testSetNaslovPrazanString() {
		assertThrows(IllegalArgumentException.class, ()->k.setNaslov(""));
	}
	
	@Test
	void testSetISBNSveOk() {
		k.setIsbn(100L);
		assertEquals(100L, k.getIsbn());
	}
	
	@ParameterizedTest
	@CsvSource({
		"0",
		"-55",
		"-1000"
	})
	void testSetIsbnManjeOdNula(Long isbn) {
		assertThrows(IllegalArgumentException.class, ()->k.setIsbn(isbn));
	}
	
	@Test
	void testSetIzdavacSveOK() {
		k.setIzdavac("Vuk");
		assertEquals("Vuk",k.getIzdavac());
	}
	
	@Test
	void testSetIzdavacNull() {
		assertThrows(NullPointerException.class, ()->k.setIzdavac(null));
	}
	
	@Test
	void testSetIzdavacPrazanString() {
		assertThrows(IllegalArgumentException.class, ()->k.setIzdavac(""));
	}
	
	@Test
	void testSetIzdanjeSveOk() {
		k.setIzdanje(1);
		assertEquals(1, k.getIzdanje());
	}
	
	@ParameterizedTest
	@CsvSource({
		"0",
		"-55",
		"-1000"
	})
	void testSetIzdanjeManjeOdJedan(int izdanje) {
		assertThrows(IllegalArgumentException.class, ()->k.setIzdanje(izdanje));
	}

	@Test
	void testToString() {
		k.setNaslov("Tihi don");
		k.setIzdavac("Vulkan");
		k.setIzdanje(3);
		k.setIsbn(999l);
		
		Autor a = new Autor();
		a.setIme("Pera");
		a.setPrezime("Peric");
		
		List<Autor> autori = new ArrayList<Autor>();
		autori.add(a);
		
		k.setAutori(autori);
		
		String s = k.toString();

		assertTrue( s.contains("999") );
		assertTrue( s.contains("Tihi don") );
		assertTrue( s.contains("3") );
		assertTrue( s.contains("Vulkan") );
		assertTrue( s.contains("Pera") );
		assertTrue( s.contains("Peric") );
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,4,2,4,true",
		"2,4,1,4,false",
		"2,4,2,3,false",
		"2,4,1,6,false"
	})
	void testEquals(Long isbn1,int izdanje1,Long isbn2,int izdanje2,boolean isti) {
		k.setIsbn(isbn1);
		k.setIzdanje(izdanje1);
		
		Knjiga k1 = new Knjiga();
		k1.setIsbn(isbn2);
		k1.setIzdanje(izdanje2);
		
		assertEquals(isti, k.equals(k1));
	}
}
