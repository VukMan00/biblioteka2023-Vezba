package biblioteka;

import java.util.List;
import java.util.Objects;
/**
 * Predstavlja knjigu koja se nalazi u Biblioteci
 * 
 * Knjiga sadrzi naslov, isbn broj, listu autora, izdavaca kao i broj izdanja.
 * 
 * @author Vuk Manojlovic
 *
 */
public class Knjiga {

	/**
	 * Naslov knjige kao String
	 */
	private String naslov;
	/**
	 * ISBN knjige kao Long
	 */
	private Long isbn;
	/**
	 * Lista autora knjige
	 * 
	 * Lista moze biti prazna ukoliko autori nisu poznati(npr. napodne pesme)
	 */
	private List<Autor> autori;
	/**
	 * Izdavac knjige kao String
	 */
	private String izdavac;
	/**
	 * Izdanje knjige kao broj(integer)
	 */
	private int izdanje;
	
	/**
	 * Vraca naslov knjige
	 * 
	 * @return naslov knjige kao String.
	 */
	public String getNaslov() {
		return naslov;
	}
	/**
	 * Postavlja vrednost atributa naslov
	 * 
	 * @param naslov nova vrednost za naslov knjige
	 * 
	 * @throws NullPointerException ako je uneta vrednost null za naslov
	 * @throws IllegalArgumentException ako je uneta vrednost prazan String za naslov
	 */
	public void setNaslov(String naslov) {
		if(naslov==null) {
			throw new NullPointerException("Naslov ne sme biti null");
		}
		if(naslov.isEmpty()) {
			throw new IllegalArgumentException("Naslov ne sme biti prazan String");
		}
		this.naslov = naslov;
	}
	
	/**
	 * Vraca ISBN knjige
	 * 
	 * @return isbn knjige kao broj(Long)
	 */
	public Long getIsbn() {
		return isbn;
	}
	/**
	 * Postavlja vrednost atributa isbn.
	 * 
	 * ISBN broj mora biti veci od 0
	 * 
	 * @param isbn nova vrednost za isbn knjige
	 * 
	 * @throws IllegalArgumentException ako je uneta vrednost manja ili jednaka 0 za isbn
	 */
	public void setIsbn(Long isbn) {
		if (isbn <= 0)
			throw new IllegalArgumentException("ISBN ne sme biti nula niti manji");
		this.isbn = isbn;
	}
	/**
	 * Vraca listu autora knjige.
	 * 
	 * @return list autora sa autorima knjige ili null ukoliko knjiga nema autora.
	 */
	public List<Autor> getAutori() {
		return autori;
	}
	/**
	 * Postavlja vrednost atributa liste autora.
	 * 
	 * Lista autora moze biti null ili prazna ukoliko nisu poznati autori knjige.
	 * 
	 * @param autori nova vrednost liste sa autorima knjige
	 */
	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}
	/**
	 * Vraca naziv izdavaca knjige
	 * 
	 * @return izdavac knjige kao String
	 */
	public String getIzdavac() {
		return izdavac;
	}
	/**
	 * Postavlja vrednost atributa izdavac
	 * 
	 * @param izdavac nova vrednost za naziv izdavaca knjige
	 * 
	 * @throws NullPointerException ako je uneta vrednost null za naziva izdavaca
	 * @throws IllegalArgumentException ako je uneta vrednost prazan String za naziva izdavaca
	 */
	public void setIzdavac(String izdavac) {
		if (izdavac == null)
			throw new NullPointerException("Izdavac ne sme biti null");
		
		if (izdavac.isEmpty())
			throw new IllegalArgumentException("Izdavac ne sme biti prazan");
		this.izdavac = izdavac;
	}
	/**
	 * Vraca izdanje knjige
	 * 
	 * @return izdanje knjige kao ceo broj(integer)
	 */
	public int getIzdanje() {
		return izdanje;
	}
	/**
	 * Postavlja vrednost atributa izdanje.
	 * 
	 * Izdanje knjige ne moze biti manje od 1
	 * 
	 * @param izdanje nova vrednost za izdanje knjige
	 * 
	 * @throws IllegalArgumentException ako je uneta vrednost izdanja manja od 1
	 */
	public void setIzdanje(int izdanje) {
		if (izdanje < 1)
			throw new IllegalArgumentException("Izdanje mora biti 1 ili vece");
		this.izdanje = izdanje;
	}
	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}
	
	/**
	 *Racuna hash code na osnovu atributa autora, isbn broja, izdanja, izdavaca i naslova
	 *
	 * @return hash code na osnovu izracunatih atributa
	 */
	@Override
	public int hashCode() {
		return Objects.hash(autori, isbn, izdanje, izdavac, naslov);
	}
	
	/**
	 * Poredi dve knjige preko ISBN broja
	 * 
	 * @param obj objekat klase Autor sa kojom se poredjuje 
	 * 
	 * @return
	 * <ul>
	 * <li>true-ako su objekti isti i isbn brojevi</li>
	 * <li>false-ako objekat nije klase Knjiga, je null i isbn brojevi nisu isti</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return Objects.equals(isbn, other.isbn);
				
	}
	
	
	
	
}
