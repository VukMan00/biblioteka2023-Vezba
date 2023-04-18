package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfejsTest {

	protected BibliotekaInterfejs bibliotekaInterfejs;
	
	@Test
	void testDodajKnjiguSveOK() {
		Knjiga k = new Knjiga();
		k.setIsbn(12345l);
		
		bibliotekaInterfejs.dodajKnjigu(k);
		List<Knjiga> knjige = bibliotekaInterfejs.VratiSveKnjige();
		
		assertEquals(1,knjige.size());
		assertTrue(knjige.contains(k));
	}
	
	@Test
	void testDodajKnjiguNull() {
		assertThrows(NullPointerException.class, ()->bibliotekaInterfejs.dodajKnjigu(null));
	}

	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn(12345l);
		
		bibliotekaInterfejs.dodajKnjigu(k);
		assertThrows(IllegalArgumentException.class, ()->bibliotekaInterfejs.dodajKnjigu(k));
	}
	
	@Test
	void testDodajKnjiguSveOk2() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435l);
		
		bibliotekaInterfejs.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321l);
		
		bibliotekaInterfejs.dodajKnjigu(k2);

		
		List<Knjiga> knjige = bibliotekaInterfejs.VratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue( knjige.contains(k) );
		assertTrue( knjige.contains(k2) );
	}
	
	@Test
	void testObrisiKnjiguSveOK() {
		Knjiga k = new Knjiga();
		k.setIsbn(12435l);
		bibliotekaInterfejs.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(54321l);
		bibliotekaInterfejs.dodajKnjigu(k2);
		
		bibliotekaInterfejs.obrisiKnjigu(k);
		
		List<Knjiga> knjige = bibliotekaInterfejs.VratiSveKnjige();
		assertEquals(1, knjige.size());
		assertFalse(knjige.contains(k));
		assertTrue(knjige.contains(k2));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435l);
		
		bibliotekaInterfejs.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321l);
		
		bibliotekaInterfejs.dodajKnjigu(k2);
		
		Knjiga k3 = new Knjiga();
		
		k3.setIsbn(999l);
	

		bibliotekaInterfejs.obrisiKnjigu(k3);
		
		List<Knjiga> knjige = bibliotekaInterfejs.VratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue( knjige.contains(k) );
		assertTrue( knjige.contains(k2) );
	}
	
	@Test
	void testPronadjiKnjiguSveNull() {
		assertThrows(IllegalArgumentException.class, ()->bibliotekaInterfejs.pronadjiKnjigu(null, -1, null, null));
	}
	
	@Test
	void testPronadjiKnjiguNaslovNull() {
		List<Knjiga> rezultat = 
				bibliotekaInterfejs.pronadjiKnjigu(null, 0, null, "Laguna");
		
		assertTrue( rezultat.isEmpty() );
	}
	
	
	@Test
	@Timeout(value = 3, unit = TimeUnit.MILLISECONDS)
	void testPronadjiKnjiguNaslov() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435l);
		k.setNaslov("Prohujalo sa vihorom");
		
		bibliotekaInterfejs.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321l);
		k2.setNaslov("Gospodar prstenova");
		
		bibliotekaInterfejs.dodajKnjigu(k2);
		
		List<Knjiga> rezultat = 
				bibliotekaInterfejs.pronadjiKnjigu(null, -1, "PRST", null);
		
		assertEquals(1, rezultat.size());
		assertTrue( rezultat.contains(k2) );
	}
	
	@Test
	@Timeout(3)
	void testPronadjiViseKnjigaNaslov() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435l);
		k.setNaslov("Prohujalo sa vihorom");
		
		bibliotekaInterfejs.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321l);
		k2.setNaslov("Gospodar prstenova");
		
		bibliotekaInterfejs.dodajKnjigu(k2);
		
		List<Knjiga> rezultat = 
				bibliotekaInterfejs.pronadjiKnjigu(null, -1, "PR", null);
		
		assertEquals(2, rezultat.size());
		assertTrue( rezultat.contains(k) );
		assertTrue( rezultat.contains(k2) );
	}
}
