package biblioteka;

import java.util.Objects;

public class Autor {

	private String ime;
	private String prezime;
	
	public Autor() {
		// TODO Auto-generated constructor stub
	}
	
	public Autor(String ime,String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if(ime==null) {
			throw new NullPointerException("Ime ne sme biti null");
		}
		if(ime.isEmpty()) {
			throw new IllegalArgumentException("Ime ne sme biti prazan String");
		}
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}
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
