package proiect33;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(new File("judete_in.txt"));
		String denumire;
		String[] judete = new String[10];
		int i=0;
		while (input.hasNext())
		{
			denumire = input.nextLine();
			judete[i]=denumire;
			i++;
		}
		Arrays.sort(judete);		
		System.out.println("Judetele ordonate: \n"+Arrays.toString(judete));

		System.out.println("Introduceti judetul cautat");
		BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
		String linie = flux_in.readLine(); 
		String str=linie;

		int index=Arrays.binarySearch(judete, str);

		if(index>0)
		{
			System.out.println("Judetul cautat se afla pe pozitia: "+ (index+1));
		}
		else
		{
			System.out.println("Judetul nu a fost gasit");
		}
	}
}
