package Proiect1;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Persoana {
String nume; 
public Persoana() {
	this.nume = "Ionel";
}
}
class Angajat extends Persoana {};

public class MainApp {

	public static void main(String[] args) throws IOException {

		//1
		/*
			System.out.println("Introduceti valoarea lungimii: ");
			BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
			String linie = flux_in.readLine(); 
			int lung=Integer.parseInt(linie);

			System.out.println("Introduceti valoarea latimii: ");
			linie = flux_in.readLine();
			int lat=Integer.parseInt(linie);

			Dreptunghi d=new Dreptunghi(lung,lat);
			System.out.println("Perimetrul este: " + d.Perimetru() + " Aria este: "+ d.Arie());
		 */
		//2

		/*
			Scanner input=new Scanner(new File("in.txt")); 
			int [] vector=new int[10];
			int contor=0;
	while(input.hasNextInt())
	{
		vector[contor]=input.nextInt();
		contor++;
	}
			int i;
			int suma=0;
			int max=0;
			int min=100;
			float ma=0;
			for(i=0;i<contor;i++)
			{
			suma=suma+vector[i];
			if(max<vector[i])
				max=vector[i];
			if(min>vector[i])
				min=vector[i];
			}
			ma=suma/contor;
			PrintWriter writer=new PrintWriter("out.txt","UTF-8");
			writer.println("Media aritmetica este: "+ Float.toString(ma));
			writer.println("Minimul este: "+ Integer.toString(min));
			writer.println("Maximul este: "+ Integer.toString(max));
			writer.close();
		 */

		//3
		/*
			System.out.println("Introduceti valoarea lui n: ");
			BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
			String linie = flux_in.readLine(); 
			int n=Integer.parseInt(linie);
			int i;
			int contor=0;
			for(i=1;i<=n;i++)
				{
				if(n%i==0)
					{
					contor++;
					System.out.println(i + "");
					}
				}
			if(contor==2)
			{
				System.out.println("\nEste numar prim");
			}
			else
				System.out.println("\nNu este numar prim");
		 */

		//4
		/*
			Random rand=new Random();
			int x= rand.nextInt(30)+1;
			int y= rand.nextInt(30)+1;

			int max=Math.max(x,y);
			int i;
			int cmmdc=0;
			for(i=1;i<=max;i++)
			{
				if(x%i==0 && y%i==0)
				{
					cmmdc=i;
				}
			}
			System.out.println("Cel mai mare divizor comun al numerelor " + x +" si " + y + " este: "+cmmdc);
		 */

		//5
		/*
			Random rand=new Random();
			int x= rand.nextInt(20)+1;
			System.out.println(isFibonacci(x) ?  x +  " is a Fibonacci Number" : x + " is a not Fibonacci Number");
		}

		static  boolean isPerfectSquare(int x)
	    {
	        int s = (int) Math.sqrt(x);
	        return (s*s == x);
	    }
		 static boolean isFibonacci(int n)
		    {
		        return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
		    }*/
	}
}