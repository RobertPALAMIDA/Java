package proiect41;
import java.io.Serializable;

import proiect41.MainApp.Stare;


public class Echipament implements Serializable{
	private String denumire;
	private int nr_inventar;
	private float pret;
	private String zona_mag;
	Stare stare;
	private String nume_echipament;
	public Echipament(String denumire,int nr_inventar,float pret,String zona_mag,Stare stare,String nume_echipament)
	{
		this.denumire=denumire;
		this.nr_inventar=nr_inventar;
		this.pret=pret;
		this.zona_mag=zona_mag;
		this.stare=stare;
		this.nume_echipament=nume_echipament;
	}

	public String getNume_echipament() {
		return nume_echipament;
	}

	public String getDenumire() {
		return denumire;
	}

	public int getNr_inventar() {
		return nr_inventar;
	}

	public float getPret() {
		return pret;
	}

	public String getZona_mag() {
		return zona_mag;
	}

	public Stare getStare() {
		return stare;
	}

	public void setStare(Stare stare) {
		this.stare = stare;
	}
}
