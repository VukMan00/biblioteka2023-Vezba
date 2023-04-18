package biblioteka;

import java.util.Objects;
/**
 * Predstavlja autora knjige
 * 
 * Autor ima samo ime i prezime.
 * 
 * @author Vuk Manojlovic
 *
 */
public class Autor {

	/**
	 * Ime autora kao String
	 */
	private String ime;
	/**
	 * Prezime autora kao String
	 */
	private String prezime;
	
	public Autor() {
		// TODO Auto-generated constructor stub
	}
	
	public Autor(String ime,String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
	/**
	 * Vraca ime autora
	 * 
	 * @return ime autora kao String
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja vrednost atributa ime.
	 * 
	 * @param ime nova vrednost za ime autora.
	 * 
	 * @throws NullPointerException ako se unese null vrednost za ime
	 * @throws IllegalArgumentException ako se unese prazan String za ime
	 */
	public void setIme(String ime) {
		if(ime==null) {
			throw new NullPointerException("Ime ne sme biti null");
		}
		if(ime.isEmpty()) {
			throw new IllegalArgumentException("Ime ne sme biti prazan String");
		}
		this.ime = ime;
	}
	/**
	 * Vraca prezime autora
	 * @return prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Postavlja vrednost atributa prezime
	 * 
	 * @param prezime nova vrednost za prezime autora
	 * 
	 * @throws NullPointerException ako se unese null vrednost za prezime
	 * @throws IllegalArgumentException ako se unese prazan String za prezime
	 */
	public void setPrezime(String prezime) {
		if(prezime==null) {
			throw new NullPointerException("Prezime ne sme biti null");
		}
		if(prezime.isEmpty()) {
			throw new IllegalArgumentException("Prezime ne sme biti prazan String");
		}
		this.prezime = prezime;
	}
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}
	/**
	 * Racuna hashCode na osnovu imena i prezimena autora
	 * 
	 * @return hash code izracunat na osnovu imena i prezimena
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}
	/**
	 * Poredi dva autora prema imenu i prezimenu kao i prema objektima
	 * 
	 * @param obj objekat klase Autor sa kojom se poredjuje.
	 * @return
	 * <ul>
	 * <li>true-Ako je unet isti objekat ili ako su ime i prezime isti</li>
	 * <li>false-Ako je unet null objekat, objekat razlicite instance i ako su ime i prezime objekata razliciti
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
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}
	
	
}
