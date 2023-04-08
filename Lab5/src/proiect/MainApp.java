package proiect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {

	public static List<Angajat> citireLista() throws FileNotFoundException
	{
		List<Angajat>lista=new ArrayList<Angajat>();
		Scanner input=new Scanner(new File("angajati_in.txt"));
		input.useDelimiter("\r\n");
		while (input.hasNext())
		{
			String line = input.next();
			String cells[]=line.split(";");
			int i=0;
			String nume = cells[i++];
			String post = cells[i++];
			LocalDate data_angajarii = LocalDate.of(Integer.valueOf(cells[i].substring(6,10)),Integer.valueOf(cells[i].substring(3,5)),Integer.valueOf(cells[i++].substring(0,2)));
			float salariu=Float.parseFloat(cells[i]);
			Angajat ang=new Angajat(nume,post,data_angajarii,salariu);
			lista.add(ang);
		}
		return lista;
	}

	public static void main(String[] args) throws IOException {
		List<Angajat> listaAngajati=new ArrayList<Angajat>();

		while(true)
		{
			System.out.println("MENIU");
			System.out.println("1.Citire fisier");
			System.out.println("2.Afisare lista");
			System.out.println("3.Afisare angajati cu salar peste 2500 RON");
			System.out.println("4.Afisare angajati din luna aprilie cu pozitie de sef sau director");
			System.out.println("5.Afisare muncitori in ordinea descrescatoare a salariilor");
			System.out.println("6.Extragere lista de nume");
			System.out.println("7.Afisare salarii mai mici de 3000 RON");
			System.out.println("8.Iesire");
			System.out.print("Selectati optiunea dorita: ");
			BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
			String linie = flux_in.readLine(); 
			int opt=Integer.parseInt(linie);

			switch(opt)
			{
			case 1:
				listaAngajati=citireLista();
				break;

			case 2:
				listaAngajati.forEach(System.out::println);
				break;

			case 3:
				System.out.println("Angajati care au salariul mare mare decat 2500 lei: ");
				listaAngajati
				.stream()
				.filter((a) -> a.getSalariul()>2500)
				.forEach(System.out::println);
				break;

			case 4:
				System.out.println("Angajati in luna aprilie: ");
				List<Angajat>listaDirectori=new ArrayList<Angajat>();
				listaDirectori=listaAngajati
						.stream()
						.filter((a) -> a.getData_angajarii().getMonthValue()==4 && a.getData_angajarii().getYear()==LocalDate.now().getYear())
						.filter((a)-> a.getPost().contains("sef") || a.getPost().contains("director"))
						.collect((Collectors.toList()));
				listaDirectori.forEach(System.out::println);
				break;

			case 5:
				System.out.println("Angajati care nu au pozitie de sef:");
				List<Angajat>listaMuncitori=new ArrayList<Angajat>();
				listaMuncitori=listaAngajati
						.stream()
						.filter((a) -> !(a.getPost().contains("sef") || a.getPost().contains("director")))
						.sorted((a,b) -> a.compareTo(b))
						.collect((Collectors.toList()));
				listaMuncitori.forEach(System.out::println);
				break;

			case 6:
				List<String>listaNume=new ArrayList<>();
				listaNume=listaAngajati
						.stream()
						.map(Angajat::getNume)
						.map(String::toUpperCase)
						.collect(Collectors.toList());

				listaNume.forEach(System.out::println);
				break;

			case 7:
				listaAngajati
				.stream()
				.filter(a -> a.getSalariul()<3000)
				.forEach(item -> item.printSalariul());
				//.map(Angajat::getSalariul)
				//.forEach(System.out::println);
				break;

			case 8:
				return;

			default:
				System.out.println("Optiune invalida");
			}
		}
	}
}