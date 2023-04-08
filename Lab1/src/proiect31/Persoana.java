package proiect31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;

public class Persoana {
	private String nume;
	private String cnp;

	public Persoana(String nume,String cnp)
	{
		this.nume=nume;
		this.cnp=cnp;
	}


	static void VerificareCNP(String cnp) throws CNPeronat
	{
		int ok=1;
		for (int i = 0; i < cnp.length(); i++) 
		{
			if (cnp.charAt(i) != '0' && cnp.charAt(i) != '1' && cnp.charAt(i) != '2' && cnp.charAt(i) != '3' && cnp.charAt(i) != '4'&& cnp.charAt(i) != '5' && cnp.charAt(i) != '6' && cnp.charAt(i) != '7' && cnp.charAt(i) != '8' && cnp.charAt(i) != '9')
			{
				ok=0;
			}
		}
		if(cnp.length()<13 || cnp.length()>13)
		{
			ok=0;
		}

		if(cnp.charAt(0)!='1' && cnp.charAt(0)!='2' && cnp.charAt(0)!='5' && cnp.charAt(0)!='6')
		{
			ok=0;
		}

		int lunaVf=Integer.parseInt(cnp.substring(3,5));
		if(lunaVf>12  || lunaVf<1)
		{
			ok=0;
		}

		int ziVf=Integer.parseInt(cnp.substring(5,7));
		if(ziVf>31 || ziVf<1)
		{
			ok=0;
		}

		if(ok==0)
		{
			throw new CNPeronat(cnp);
		}
	}


	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public int GetVarsta(Persoana pers) throws CNPeronat, IOException
	{
		boolean gata=false;
		do {
			try
			{
				VerificareCNP(cnp);
				gata=true;
			}
			catch(CNPeronat e)
			{
				System.out.println(e);
				System.out.println("Introduceti noul cnp al persoanei: ");
				BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String linie = flux_in.readLine(); 
				String cnp_=linie;
				pers.setCnp(cnp_);
			}
		}while(!gata);

		int p=0;

		if(cnp.charAt(0) == '1' || cnp.charAt(0)=='2')
		{
			p=1900;
		}
		if(cnp.charAt(0) == '5' || cnp.charAt(0)=='6')
		{
			p=2000;
		}

		int an=Integer.parseInt(cnp.substring(1,3))+p;
		int luna=Integer.parseInt(cnp.substring(3,5));
		int zi=Integer.parseInt(cnp.substring(5,7));
		LocalDate birthday=LocalDate.of(an, luna, zi);
		LocalDate today=LocalDate.now();
		int varsta=Period.between(birthday, today).getYears();
		return varsta;
	}
}

