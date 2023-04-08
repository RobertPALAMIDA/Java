package proiect41;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	enum Stare{
		ACHIZITIONAT,
		EXPUS,
		VANDUT
	}

	enum Mod{
		COLOR,
		ALBNEGRU
	}

	enum Layout{
		A4,
		A3
	}

	enum SO{
		WINDOWS,
		LINUX
	}

	static void scrie(Object o, String fis) {
		try {
			FileOutputStream f = new FileOutputStream(fis);
			ObjectOutputStream oos = new ObjectOutputStream(f);
			oos.writeObject(o);
			oos.close();
			f.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	static Object citeste(String fis) {
		try {
			FileInputStream f = new FileInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(f);
			Object o=ois.readObject();
			ois.close();
			f.close();
			return o;
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		List<Echipament> listaEchipamente=new ArrayList<Echipament>();
		Scanner input=new Scanner(new File("electronice.txt"));
		input.useDelimiter("\r\n");
		while (input.hasNext())
		{
			String line = input.next();
			String cells[]=line.split(";");
			int i=0;
			String denumire = cells[i++];
			int nr_inventar = Integer.valueOf(cells[i++]);
			float pret = Float.valueOf(cells[i++]);
			String zona_mag=cells[i++];
			Stare stare=Stare.valueOf(cells[i++].toUpperCase());

			String nume_echipament=cells[i++];
			if(nume_echipament.compareTo("imprimanta") == 0)
			{	
				int ppm=Integer.valueOf(cells[i++]);
				String rezolutie=cells[i++];
				int p_car=Integer.valueOf(cells[i++]);
				Mod mod=Mod.valueOf(cells[i++].toUpperCase());
				Imprimanta imp=new Imprimanta(denumire,nr_inventar,pret,zona_mag,stare,nume_echipament,ppm,rezolutie,p_car,mod);
				listaEchipamente.add(imp);
			}
			if(nume_echipament.compareTo("copiator")==0)
			{
				int nr_pag=Integer.valueOf(cells[i++]);
				int p_ton=Integer.valueOf(cells[i++]);
				Layout format=Layout.valueOf(cells[i++].toUpperCase());
				Copiator cop=new Copiator(denumire,nr_inventar,pret,zona_mag,stare,nume_echipament,nr_pag,p_ton,format);
				listaEchipamente.add(cop);
			}
			if(nume_echipament.compareTo("sistem de calcul")==0)
			{
				String tip_mon=cells[i++];
				float vit_proc=Float.valueOf(cells[i++]);
				int c_hdd=Integer.valueOf(cells[i++]);
				SO sistop=SO.valueOf(cells[i++].toUpperCase());
				SistemCalcul sist=new SistemCalcul(denumire,nr_inventar,pret,zona_mag,stare,nume_echipament,tip_mon,vit_proc,c_hdd,sistop);
				listaEchipamente.add(sist);
			}
		}
		while(true)
		{
			System.out.println("\nMENIU");
			System.out.println("1.Afisare lista imprimante");
			System.out.println("2.Afisare lista copiatoare");
			System.out.println("3.Afisarea lista sisteme de calcul");
			System.out.println("4.Schimbare stare echipament");
			System.out.println("5.Schimbare mod imprimanta");
			System.out.println("6.Schimbare format copiator");
			System.out.println("7.Schimbare sistem de operare sistem calcul");
			System.out.println("8.Afisarea echipamentelor vandute");
			System.out.println("9.Serializare");
			System.out.println("10.Deserializare");
			System.out.println("0.Iesire");
			System.out.println("Selectati optiunea dorita");
			BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
			String linie = flux_in.readLine(); 
			int opt=Integer.parseInt(linie);

			switch(opt)
			{
			case 1:
				for(Echipament e : listaEchipamente)
				{
					if(e instanceof Imprimanta)
					{
						System.out.println(e);
					}
				}
				break;
			case 2:
				for(Echipament e : listaEchipamente)
				{
					if(e.getClass()== Copiator.class)
					{
						System.out.println(e);
					}
				}
				break;
			case 3:
				for(Echipament e : listaEchipamente)
				{
					if(e instanceof SistemCalcul)
					{
						System.out.println(e);
					}
				}
				break;
			case 4:
				System.out.print("Introduceti numele echipamentului:");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String nume = flux_in.readLine(); 
				boolean ok=false;
				boolean stareVf=false;

				for(Echipament e : listaEchipamente)
				{
					if(e.getDenumire().compareTo(nume)==0)
					{
						ok=true;
						do
						{
							System.out.println("Introduceti starea: ");
							flux_in = new BufferedReader(new InputStreamReader (System.in)); 
							String stare=flux_in.readLine().toUpperCase();
							if(stare.compareTo("ACHIZITIONAT")==0 || stare.compareTo("EXPUS")==0 || stare.compareTo("VANDUT")==0)
							{
								stareVf=true;
								e.setStare(Stare.valueOf(stare));
							}	
							else
							{
								System.out.println("Starea introdusa nu este valida! Va rugam sa o reintroduceti");
							}
						}while(!stareVf);
					}			
				}
				if(ok==false)
				{
					System.out.println("Nu exista echipamentul cautat");
				}			
				break;
			case 5:
				System.out.print("Introduceti numele echipamentului:");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				nume = flux_in.readLine(); 
				ok=false;
				stareVf=false;
				for(Echipament e : listaEchipamente)
				{
					if(e.getDenumire().compareTo(nume)==0)
					{
						if(!(e instanceof Imprimanta))
						{
							System.out.println("Acest echipament nu este o imprimanta!");
						}
						else
						{
							ok=true;
							do
							{
								System.out.println("Introduceti modul: ");
								flux_in = new BufferedReader(new InputStreamReader (System.in)); 
								String stare=flux_in.readLine().toUpperCase();
								if(stare.compareTo("COLOR")==0 || stare.compareTo("ALBNEGRU")==0)
								{
									stareVf=true;
									((Imprimanta)e).setMod(Mod.valueOf(stare));
								}	
								else
								{
									System.out.println("Modul introdus nu este valid! Va rugam sa il reintroduceti");
								}
							}while(!stareVf);
						}
					}
				}
				if(ok==false)
				{
					System.out.println("Nu exista echipamentul cautat");
				}		
				break;
			case 6:
				System.out.print("Introduceti numele echipamentului:");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				nume = flux_in.readLine(); 
				ok=false;
				stareVf=false;
				for(Echipament e : listaEchipamente)
				{
					if(e.getDenumire().compareTo(nume)==0)
					{
						if(!(e instanceof Copiator cop))
						{
							System.out.println("Acest echipament nu este un copiator!");
						}
						else
						{
							ok=true;
							do
							{
								System.out.println("Introduceti formatul: ");
								flux_in = new BufferedReader(new InputStreamReader (System.in)); 
								String stare=flux_in.readLine().toUpperCase();
								if(stare.compareTo("A4")==0 || stare.compareTo("A3")==0)
								{
									stareVf=true;
									cop.setLayout(Layout.valueOf(stare));
								}	
								else
								{
									System.out.println("Formatul introdus nu este valid! Va rugam sa il reintroduceti");
								}
							}while(!stareVf);
						}
					}
				}
				if(ok==false)
				{
					System.out.println("Nu exista echipamentul cautat");
				}		
				break;
			case 7:
				System.out.print("Introduceti numele echipamentului:");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				nume = flux_in.readLine(); 
				ok=false;
				stareVf=false;
				for(Echipament e : listaEchipamente)
				{
					if(e.getDenumire().compareTo(nume)==0)
					{
						if(!(e instanceof SistemCalcul))
						{
							System.out.println("Acest echipament nu este un sistem de calcul!");
						}
						else
						{
							ok=true;
							do
							{
								System.out.println("Introduceti sistemul de operare: ");
								flux_in = new BufferedReader(new InputStreamReader (System.in)); 
								String stare=flux_in.readLine().toUpperCase();
								if(stare.compareTo("WINDOWS")==0 || stare.compareTo("LINUX")==0)
								{
									stareVf=true;
									((SistemCalcul)e).setSist(SO.valueOf(stare));
								}	
								else
								{
									System.out.println("Modul introdus nu este valid! Va rugam sa il reintroduceti");
								}
							}while(!stareVf);
						}
					}
				}
				if(ok==false)
				{
					System.out.println("Nu exista echipamentul cautat");
				}		
				break;
			case 8:
				for(Echipament e : listaEchipamente)
				{
					if(e.stare==Stare.VANDUT)
					{
						System.out.println(e);
					}
				}
				break;
			case 9:
				scrie(listaEchipamente,"echipamente.bin");
				break;
			case 10:
				List<Echipament>verificare=new ArrayList<Echipament>();
				verificare=(List<Echipament>)citeste("echipamente.bin");
				for(Echipament e : verificare)
				{
					System.out.println(e);
				}
				break;
			case 0: return;

			default: System.out.println("Optiune invalida");
			}
		}
	}
}