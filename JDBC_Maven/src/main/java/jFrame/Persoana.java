package jFrame;

public class Persoana {
	private int index;
	private String nume;
	private int varsta;

	public Persoana(int index, String nume, int varsta) {
		this.index = index;
		this.nume = nume;
		this.varsta = varsta;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

}
