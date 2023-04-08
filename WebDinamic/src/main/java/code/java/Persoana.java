package code.java;

public class Persoana {
private String nume;
private String prenume;
private String cod;

public Persoana(String nume, String prenume, String cod) {
	this.nume = nume;
	this.prenume = prenume;
	this.cod = cod;
}
public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}
public String getPrenume() {
	return prenume;
}
public void setPrenume(String prenume) {
	this.prenume = prenume;
}
public String getCod() {
	return cod;
}
public void setCod(String cod) {
	this.cod = cod;
}

}
