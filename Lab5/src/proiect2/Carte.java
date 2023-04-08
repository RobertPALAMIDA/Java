package proiect2;

public class Carte {
	private String titlu;
	private String autor;
	private int an_aparitie;

	@Override
	public String toString() {
		return "Carte [titlu=" + titlu + ", autor=" + autor + ", an_aparitie=" + an_aparitie + "]";
	}
	public Carte(String titlu, String autor, int an_aparitie) {
		super();
		this.titlu = titlu;
		this.autor = autor;
		this.an_aparitie = an_aparitie;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAn_aparitie() {
		return an_aparitie;
	}
	public void setAn_aparitie(int an_aparitie) {
		this.an_aparitie = an_aparitie;
	}
}
