package proiect41;

import proiect41.MainApp.SO;
import proiect41.MainApp.Stare;


public class SistemCalcul extends Echipament {
	private String tip_mon;
	private float vit_proc;
	private int c_hdd;
	SO sist;

	public SistemCalcul(String denumire,int nr_inventar,float pret,String zona_mag,Stare stare,String nume_echipament,String tip_mon,float vit_proc,int c_hdd,SO sist)
	{
		super(denumire,nr_inventar,pret,zona_mag,stare,nume_echipament);
		this.tip_mon=tip_mon;
		this.vit_proc=vit_proc;
		this.c_hdd=c_hdd;
		this.sist=sist;
	}

	@Override
	public String toString()
	{
		return getDenumire()+" "+getNr_inventar()+" "+getPret()+" "+getZona_mag()+" "+getStare()+" "+getNume_echipament()+" "+this.tip_mon+" "+this.vit_proc+" "+this.c_hdd+" "+this.sist;
	}
	public void setSist(SO sist) {
		this.sist = sist;
	}
}
