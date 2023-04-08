package proiect2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {
		Map<Integer,Carte>mapa=new HashMap<Integer, Carte>();
		List<Carte>listaCarti=new ArrayList<Carte>();
		Scanner input=new Scanner(new File("in.txt"));
		input.useDelimiter("\r\n");
		while (input.hasNext())
		{
			String line = input.next();
			String cells[]=line.split(";");
			int i=0;
			int id=Integer.valueOf(cells[i++]);
			String titlu=cells[i++];
			String autor=cells[i++];
			int an_aparitie=Integer.parseInt(cells[i++]);
			Carte car=new Carte(titlu,autor,an_aparitie);
			mapa.put(id, car);
		}

		while(true)
		{
			System.out.println("MENIU");
			System.out.println("1.Afisare colectie");
			System.out.println("2.Stocare obiecte in lista + afisare");
			System.out.println("3.Afisare lista carti in functie de titlu");
			System.out.println("0.Iesire");
			System.out.print("Selectati optiunea dorita: ");
			BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
			String linie = flux_in.readLine(); 
			int opt=Integer.parseInt(linie);

			switch(opt)
			{
			case 1:
				//for(Map.Entry<Integer,Carte> car:mapa.entrySet())
				for(var car:mapa.entrySet())
				{
					System.out.println(car.getKey()+":"+car.getValue());
				}
				break;

			case 2:
				listaCarti=mapa.values().stream().collect(Collectors.toList());
				listaCarti.forEach(System.out::println);
				break;

			case 3:
				listaCarti
				.stream()
				.sorted((a,b) -> a.getTitlu().compareTo(b.getTitlu()))
				.forEach(System.out::println);
				break;

			case 0:
				return;

			default: System.out.println("Optiune invalida!");
			}
		}
	}
}
