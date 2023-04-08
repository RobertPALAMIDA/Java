package proiect34;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static List<Melodie> citireDate() throws FileNotFoundException 
	{ 
		Scanner input=new Scanner(new File("in.txt"));

		String nume_melodie;
		String nume_artist;
		int an_lansare;
		int numar_vizualizari_youtube;

		List<Melodie> listaMelodii=new ArrayList<Melodie>();

		input.useDelimiter(";");
		while (input.hasNext())
		{
			nume_melodie = input.next();
			nume_artist = input.next();
			an_lansare = Integer.valueOf(input.next());
			numar_vizualizari_youtube=Integer.valueOf(input.next());
			Melodie mel=new Melodie(nume_melodie,nume_artist,an_lansare,numar_vizualizari_youtube);
			listaMelodii.add(mel);
		}
		return listaMelodii;
	}

	public static void main(String[] args) throws IOException {
		List<Melodie> listaMelodii=new ArrayList<Melodie>();
		listaMelodii=citireDate();
		while(true)
		{
			System.out.println("\nMENIU");
			System.out.println("1.Afisare lista melodii");
			System.out.println("2.Afisare lista dorita in ordinea vizualizarilor");
			System.out.println("3.Afisarea melodiilor unui artist");
			System.out.println("0.Iesire");
			System.out.println("Selectati optiunea dorita");
			BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
			String linie = flux_in.readLine(); 
			int opt=Integer.parseInt(linie);

			switch(opt)
			{
			case 1:
				for(Melodie m : listaMelodii)
				{
					System.out.print(m);
				}
				break;
			case 2:
				List<Melodie> listaMelodiiSort=new ArrayList<Melodie>();
				listaMelodiiSort=listaMelodii;
				listaMelodiiSort.sort(Comparator.comparing(Melodie::getNumar_vizualizari_youtube).reversed());
				for(Melodie m : listaMelodiiSort)
				{
					System.out.print(m);
				}
				break;
			case 3:
				System.out.println("Introduceti numele artistului:");
				flux_in = new BufferedReader(new InputStreamReader (System.in));
				linie = flux_in.readLine(); 
				String nume=linie;
				for(Melodie m : listaMelodii)
				{
					if(m.getNume_artist().compareTo(nume)==0)
					{
						System.out.print(m);
					}
				}
				break;

			case 0: return;

			default: System.out.println("Optiune invalida");
			}
		}

	}

}
