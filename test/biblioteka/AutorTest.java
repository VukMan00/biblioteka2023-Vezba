package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {

	Autor a;
	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testSetImeSveOK() {
		a.setIme("Vuk");
		assertEquals("Vuk",a.getIme());
	}
	
	@Test
	void testSetImeNull() {
		assertThrows(NullPointerException.class, ()->a.setIme(null));
	}
	
	@Test
	void testSetImePrazanString() {
		assertThrows(IllegalArgumentException.class, ()->a.setIme(""));
	}
	
	@Test
	void testSetPrezimeSveOK() {
		a.setPrezime("Manojlovic");
		assertEquals("Manojlovic",a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(NullPointerException.class, ()->a.setPrezime(null));
	}
	
	@Test
	void testSetPrezimePrazanString() {
		assertThrows(IllegalArgumentException.class, ()->a.setPrezime(""));
	}
	
	@Test
	@DisplayName("Test za proveru toString metode")
	void testToString() {
		a.setIme("Vuk");
		a.setPrezime("Manojlovic");
		
		String potpis = a.toString();
		
		assertTrue(potpis.contains("Vuk"));
		assertTrue(potpis.contains("Manojlovic"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"Pera,Peric,Pera,Peric,true",
		"Pera,Peric,Zika,Zikic,false",
		"Pera,Peric,Zika,Peric,false",
		"Pera,Peric,Pera,Zikic,false"
	})
	void testEquals(String ime1,String prezime1,String ime2,String prezime2,boolean isti) {
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor a1 = new Autor();
		a1.setIme(ime2);
		a1.setPrezime(prezime2);
		
		assertEquals(isti, a.equals(a1));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(a.equals(new Exception()));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(a.equals(null));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(a.equals(a));
	}

}
