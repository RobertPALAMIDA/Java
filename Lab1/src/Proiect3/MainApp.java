package Proiect3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {

		Scanner input=new Scanner(new File("intrare.txt"));
		PrintWriter writer=new PrintWriter("iesire.txt","UTF-8");

		String vers;
		Vers v;

		System.out.println("Introduceti o grupare de litere: ");
		BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
		String linie = flux_in.readLine(); 
		String grupare=linie;

		Random rand=new Random();

		while (input.hasNext())
		{
			vers=input.nextLine();
			v=new Vers(vers);
			String steluta="";
			
			if(v.Steluta(grupare))
			{
				steluta="*";
			}
			
			float random=rand.nextFloat(1);
			
			writer.println(v.Split()+" "+v.Vocale()+" "+v.Upper(random)+""+steluta);
		}

		input.close();
		writer.close();
	}
}
