package biblioteka.interfejs;

import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;
/**
 * Predstavlja Biblioteku u kojoj se mogu dodati knjige,
 * brisati knjige kao i pronalaziti.
 * 
 * 
 * @author Vuk Manojlovic
 *
 */
public interface BibliotekaInterfejs {

	/**
	 * Dodaje knjigu u listu knjiga.
	 * 
	 * Knjiga ne sme biti null ili duplikat u listi knjiga.
	 * 
	 * @param knjiga nova knjiga koja se dodaje
	 * 
	 * @throws NullPointerException ako je uneta vrednost null za knjigu
	 * @throws IllegalArgumentException ako je uneta knjiga duplikat
	 */
	public void dodajKnjigu(Knjiga knjiga);
	
	/**
	 * Izbacuje knjigu iz liste knjiga.
	 * 
	 * Ukoliko se knjiga ne nalazi u listi ili je null, ne desava se nista.
	 * 
	 * @param knjiga knjiga koja treba biti izbacena iz biblioteke.
	 * 
	 */
	public void obrisiKnjigu(Knjiga knjiga);
	/**
	 * Vraca sve knjige koje se nalaze u biblioteci.
	 * 
	 * @return lista svih knjiga koje se nalaze u biblioteci.
	 */
	public List<Knjiga> VratiSveKnjige();
	
	/**
	 * Pronalazi Knjigu po odredjenom kriterijumu.
	 * 
	 * Pretraga se moze vrsiti preko autora, ISBN broja,dela naslova ili celog naslova kao i preko izdavaca.
	 * Pretraga preko autora i ISBN broja je onako kako je uneto, mora biti tacna vrednost, dok se pretrazuje preko dela naslova 
	 * ili preko dela naziva izdavaca.
	 * 
	 * Ukoliko se unese null ili -1 za neki od paramatera, ne pretrazuje se preko tog kriterijuma.
	 * 
	 * @param autor Autor knjige ili null ako se ne pretrazuje preko autora
	 * @param ISBN ISBN knjige ili -1 ukoliko se ne pretrazuje preko ISBn
	 * @param naslov Naslov knjige,deo naslova ili null ukoliko se ne pretrazuje preko naslova
	 * @param izdavac Izdavac knjige, deo naziva izdavaca ili null ako se ne pretrazuje preko izdavaca
	 * 
	 * @return lista knjiga koje zadovoljavaju postavljeni kriterijum
	 * 
	 * @throws IllegalArgumentException ako nijedan parametar nije unet
	 */
	public List<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac);
}
