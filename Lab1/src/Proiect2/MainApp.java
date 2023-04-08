package Proiect2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {
		//1
		/*
		System.out.println("Introduceti valoarea lui a: ");
		BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
		String linie = flux_in.readLine(); 
		int a=Integer.parseInt(linie);

		System.out.println("Introduceti valoarea lui b: ");
		linie = flux_in.readLine();
		int b=Integer.parseInt(linie);


		System.out.println("Introduceti valoarea lui c: ");
		linie = flux_in.readLine();
		int c=Integer.parseInt(linie);


		Parabola p1=new Parabola(a,b,c);
		p1.Afisare();
		p1.Varf();


		Parabola p2=new Parabola(a+4,b+3,c+2);
		Parabola.GetMijloc(p1,p2);
		 */


		//2
		ArrayList<Produs> lista=new ArrayList<Produs>();
		Scanner input=new Scanner(new File("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\in.txt"));
		input.useDelimiter(";");
		String denumire;
		float pret,cantitate;
		while (input.hasNext())
		{
			denumire = input.next();
			pret = Float.valueOf(input.next());
			cantitate = Float.valueOf(input.next());
			Produs p=new Produs(denumire,pret,cantitate);
			lista.add(p);
		}

		float min=999;
		float max=0;

		for(Produs p : lista)
		{
			System.out.print(p);

			if(p.GetPret()>max)
			{
				max=(p.GetPret());
			}

			if(p.GetPret()<min)
			{
				min=(p.GetPret());
			}
		}
		input.close();

		PrintWriter writer=new PrintWriter("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\out.txt","UTF-8");
		for(Produs p : lista)
		{

			if(p.GetPret()==max)
			{
				writer.print("\nProdusul cu pretul maxim este: ");
				writer.print(p);
			}

			if(p.GetPret()==min)
			{
				writer.print("\nProdusul cu pretul minim este: ");
				writer.print(p);
			}	
		}
		writer.close();

		System.out.println("\nIntroduceti valoarea cantitatii pentru comparare: ");
		BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
		String linie = flux_in.readLine(); 
		float comp=Float.parseFloat(linie);
		for(Produs p : lista)
		{
			if(p.GetCantitate()<comp)
			{
				System.out.print(p);
			}
		}
	}
}