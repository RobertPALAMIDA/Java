package proiect41;

import proiect41.MainApp.Mod;
import proiect41.MainApp.Stare;

public class Imprimanta extends Echipament {
	private int ppm;
	private String rezolutie;
	private int p_car;
	Mod mod;

	public Imprimanta(String denumire,int nr_inventar,float pret,String zona_mag,Stare stare,String nume_echipament,int ppm,String rezolutie,int p_car,Mod mod)
	{
		super(denumire,nr_inventar,pret,zona_mag,stare,nume_echipament);
		this.ppm=ppm;
		this.rezolutie=rezolutie;
		this.p_car=p_car;
		this.mod=mod;
	}

	@Override
	public String toString()
	{
		return getDenumire()+" "+getNr_inventar()+" "+getPret()+" "+getZona_mag()+" "+getStare()+" "+getNume_echipament()+" "+this.ppm+" "+this.rezolutie+" "+this.p_car+" "+this.mod;
	}
	public void setMod(Mod mod) {
		this.mod = mod;
	}



}
