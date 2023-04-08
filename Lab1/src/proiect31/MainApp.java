package proiect31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {


	public static void main(String[] args) throws IOException, CNPeronat {
		System.out.println("Introduceti o numele persoanei: ");
		BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
		String linie = flux_in.readLine(); 
		String nume=linie;

		System.out.println("Introduceti cnp-ul persoanei: ");
		flux_in = new BufferedReader(new InputStreamReader (System.in)); 
		linie = flux_in.readLine(); 
		String cnp=linie;

		Persoana pers=new Persoana(nume,cnp);
		System.out.print(pers.GetVarsta(pers));
	}
}
