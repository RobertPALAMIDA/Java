package proiect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class MainApp {

	public static int count(List<Client>listaClienti)
	{
		int contor=0;
		for(var Client:listaClienti)
		{
			contor++;
		}
		return contor;
	}

	public static void main(String[] args) throws IOException {
		Vector<Banca>listaBanci=new Vector<Banca>();


		while(true)
		{
			System.out.println("\nMENIU");
			System.out.println("1.Adaugare banca");
			System.out.println("2.Adaugare client");
			System.out.println("3.Adaugare cont");
			System.out.println("4.Afisare date");
			System.out.println("5.Afisare informatii banci");
			System.out.println("6.Afisare clienti banci");
			System.out.println("7.Afisare conturi client(in functie de banca)");
			System.out.println("8.Afisare conturi client");
			System.out.println("9.Depunere bani");
			System.out.println("10.Extragere bani");
			System.out.println("11.Transfer bani");
			System.out.println("12.Iesire");
			System.out.print("Selectati optiunea dorita: ");
			BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
			String linie = flux_in.readLine(); 
			int opt=Integer.parseInt(linie);

			switch(opt)
			{
			case 1:
				System.out.print("Introduceti denumirea bancii: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String denumire_banca=flux_in.readLine();
				Banca banc=new Banca(denumire_banca);
				
				if(listaBanci
				.stream()
				.filter((a)->a.getDenumire_banca().compareTo(denumire_banca) == 0)
				.findFirst().isPresent())
				{
					System.out.println("Banca exista deja");
				}
				else
				{
					listaBanci.add(banc);
				}
				break;
				
			case 2:
				System.out.print("Introduceti denumirea bancii: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				denumire_banca=flux_in.readLine();
				boolean ok=false;
				for(var b : listaBanci)
				{
					if(b.getDenumire_banca().compareTo(denumire_banca)==0)
					{
						System.out.print("Introduceti numele clientului: ");
						flux_in = new BufferedReader(new InputStreamReader (System.in)); 
						String nume=flux_in.readLine();
						System.out.print("Introduceti adresa clientului: ");
						flux_in = new BufferedReader(new InputStreamReader (System.in)); 
						String adresa=flux_in.readLine();
						Client cl=new Client(nume,adresa);

						System.out.print("Introduceti numarul contului: ");
						flux_in = new BufferedReader(new InputStreamReader (System.in)); 
						String numarCont=flux_in.readLine();

						System.out.print("Introduceti suma: ");
						flux_in = new BufferedReader(new InputStreamReader (System.in));
						float suma=Float.parseFloat(flux_in.readLine());

						System.out.print("Introduceti moneda(RON/EURO): ");
						flux_in = new BufferedReader(new InputStreamReader (System.in)); 
						String moneda=flux_in.readLine();

						System.out.print("Introduceti data deschiderii operatiuni(dd.mm.yyyy): ");	
						flux_in = new BufferedReader(new InputStreamReader (System.in)); 
						DateTimeFormatter dtf=DateTimeFormatter.ofPattern("d.MM.yyyy");
						LocalDate data_deschiderii=LocalDate.parse(flux_in.readLine(),dtf); 	
						
						System.out.print("Introduceti data ultimei operatiuni(dd.mm.yyyy): ");	
						flux_in = new BufferedReader(new InputStreamReader (System.in)); 
						LocalDate data_ultimei_operatiuni=LocalDate.parse(flux_in.readLine(),dtf); 	

						ContBancar cb=new ContBancar(numarCont,suma,moneda,data_deschiderii,data_ultimei_operatiuni);
						cl.setConturi(cb);

						b.setListaClienti(cl);
						ok=true;
					}
				}
				if(!ok)
				{
					System.out.println("Banca nu a fost gasita");
				}	
				break;

			case 3:
				System.out.print("Introduceti denumirea bancii: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				denumire_banca=flux_in.readLine();
				boolean ok1=false;
				boolean ok2=false;
				for(var b : listaBanci)
				{
					if(b.getDenumire_banca().compareTo(denumire_banca)==0)
					{
						System.out.print("Introduceti numele clientului: ");
						flux_in = new BufferedReader(new InputStreamReader (System.in)); 
						String nume=flux_in.readLine();
						for(var c : b.getListaClienti())
						{
							ok1=true;
							if(c.getNume().compareTo(nume)==0)
							{
								ok2=true;
								if(c.getConturi().size()<5)
								{
									System.out.print("Introduceti numarul contului: ");
									flux_in = new BufferedReader(new InputStreamReader (System.in)); 
									String numarCont=flux_in.readLine();

									System.out.print("Introduceti suma: ");
									flux_in = new BufferedReader(new InputStreamReader (System.in));
									float suma=Float.parseFloat(flux_in.readLine());

									System.out.print("Introduceti moneda(RON/EURO): ");
									flux_in = new BufferedReader(new InputStreamReader (System.in)); 
									String moneda=flux_in.readLine();

									System.out.print("Introduceti data deschiderii operatiuni(dd.mm.yyyy): ");	
									flux_in = new BufferedReader(new InputStreamReader (System.in)); 
									DateTimeFormatter dtf=DateTimeFormatter.ofPattern("d.MM.yyyy");
									LocalDate data_deschiderii=LocalDate.parse(flux_in.readLine(),dtf); 	
									
									
									System.out.print("Introduceti data ultimei operatiuni(dd.mm.yyyy): ");	
									flux_in = new BufferedReader(new InputStreamReader (System.in)); 
									LocalDate data_ultimei_operatiuni=LocalDate.parse(flux_in.readLine(),dtf); 	

									ContBancar cb2=new ContBancar(numarCont,suma,moneda,data_deschiderii,data_ultimei_operatiuni);
									c.setConturi(cb2);
								}
								else
									System.out.print("A fost depasita limita de conturi!");
							}
						}
					}
					if(!ok1)
					{
						System.out.println("Banca introdusa nu a fost gasita");
					}
					if(!ok2)
					{
						System.out.println("Clientul introdus nu a fost gasit");
					}
				}
				break;

			case 4:
				listaBanci.forEach(System.out::println);
				break;

			case 5:
				listaBanci
				.stream()
				.forEach(item->
				{
					System.out.println(item.getDenumire_banca()+":"+count(item.getListaClienti())+" clienti");
				});

				break;

			case 6:
				System.out.print("Introduceti numele bancii: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String nume_b=flux_in.readLine();	

				listaBanci
				.stream()
				.filter((a)-> a.getDenumire_banca().compareTo(nume_b) == 0)
				.forEach(System.out::println);

				break;

			case 7:
				System.out.print("Introduceti numele bancii: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String nume_banc=flux_in.readLine();

				System.out.print("Introduceti numele clientului: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String nume_cl=flux_in.readLine();

				listaBanci
				.stream()
				.filter((a)->a.getDenumire_banca().compareTo(nume_banc)==0)
				.forEach((item)->
				{
					List<Client>listaC=item.getListaClienti();
					listaC
					.stream()
					.filter((a)->a.getNume().compareTo(nume_cl)==0)
					.forEach(System.out::println);
				});
				break;

			case 8:
				System.out.print("Introduceti numele clientului: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String nume_client=flux_in.readLine();

				listaBanci
				.stream()
				.forEach((item)->
				{
					List<Client>listaC=item.getListaClienti();
					listaC
					.stream()
					.filter((a)->a.getNume().compareTo(nume_client)==0)
					.forEach(System.out::println);
				});
				break;

			case 9:
				System.out.print("Introduceti numarul Contului: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String nr_cont=flux_in.readLine();

				System.out.print("Introduceti suma pe care o doriti depusa: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				float suma=Float.parseFloat(flux_in.readLine());

				listaBanci
				.stream()
				.forEach((item1)->
				{
					List<Client>listaC=item1.getListaClienti();
					listaC
					.stream()
					.forEach((item2)->
					{
						Set<ContBancar>Scb=item2.getConturi();
						Scb
						.stream()
						.filter((a)->a.getNumarCont().compareTo(nr_cont)==0)
						.forEach(item3 ->item3.depunere(suma));
					});
				});
				break;

			case 10:
				System.out.print("Introduceti numarul Contului: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String nr_cont2=flux_in.readLine();

				System.out.print("Introduceti suma pe care o doriti extrasa: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				float suma2=Float.parseFloat(flux_in.readLine());

				listaBanci
				.stream()
				.forEach((item1)->
				{
					List<Client>listaC=item1.getListaClienti();
					listaC
					.stream()
					.forEach((item2)->
					{
						Set<ContBancar>Scb=item2.getConturi();
						Scb
						.stream()
						.filter((a)->a.getNumarCont().compareTo(nr_cont2)==0)
						.forEach(item3 ->item3.extragere(suma2));
					});
				});
				break;

			case 11:
				System.out.print("Introduceti numarul Contului din care se realizeaza transferul: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String cont_ext=flux_in.readLine();

				System.out.print("Introduceti numarul Contului in care se realizeaza transferul: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				String cont_dep=flux_in.readLine();

				System.out.print("Introduceti suma transferata: ");
				flux_in = new BufferedReader(new InputStreamReader (System.in)); 
				float suma_transf=Float.parseFloat(flux_in.readLine());

				listaBanci
				.stream()
				.forEach((item1)->
				{
					List<Client>listaC=item1.getListaClienti();
					listaC
					.stream()
					.forEach((item2)->
					{
						Set<ContBancar>Scb=item2.getConturi();
						Scb
						.stream()
						.filter((a)->a.getNumarCont().compareTo(cont_ext)==0)
						.forEach(item3 ->item3.extragere(suma_transf));

						Scb
						.stream()
						.filter((a)->a.getNumarCont().compareTo(cont_dep)==0)
						.forEach(item3->item3.depunere(suma_transf));
					});
				});
				break;

			case 12:
				return;

			default:
				System.out.println("Optiune invalida");
			}
		}
	}
}