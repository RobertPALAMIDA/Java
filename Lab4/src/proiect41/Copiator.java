package proiect41;


import proiect41.MainApp.Layout;
import proiect41.MainApp.Stare;

public class Copiator extends Echipament{
	private int nr_pag;
	private int p_ton;
	Layout format;

	public Copiator(String denumire,int nr_inventar,float pret,String zona_mag,Stare stare,String nume_echipament,int nr_pag,int p_ton,Layout format2)
	{
		super(denumire,nr_inventar,pret,zona_mag,stare,nume_echipament);
		this.nr_pag=nr_pag;
		this.p_ton=p_ton;
		this.format=format2;
	}

	@Override
	public String toString()
	{
		return getDenumire()+" "+getNr_inventar()+" "+getPret()+" "+getZona_mag()+" "+getStare()+" "+getNume_echipament()+" "+this.nr_pag+" "+this.p_ton+" "+this.format;
	}
	public void setLayout(Layout format) {
		this.format = format;
	}
}
