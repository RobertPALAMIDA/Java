package proiect32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {

	public static String insertString(String str,String strInsert,int index) 
	{ 
		String newStr=str.substring(0,index-1)+strInsert+str.substring(index-1);
		return newStr;
	}

	public static void main(String[] args) throws IOException {
		String str,strInsert;
		int index;

		System.out.println("Introduceti stringul principal: ");
		BufferedReader flux_in = new BufferedReader(new InputStreamReader (System.in)); 
		String linie = flux_in.readLine(); 
		str=linie;

		System.out.println("Introduceti alt string: ");
		linie = flux_in.readLine(); 
		strInsert=linie;

		System.out.println("Introduceti pozitia unde doriti sa se insereze stringul: ");
		linie = flux_in.readLine();
		index=Integer.parseInt(linie);

		System.out.println(insertString(str,strInsert,index));


		StringBuilder strBuild = new StringBuilder();

		System.out.println("Introduceti stringul principal: ");
		linie = flux_in.readLine(); 
		String strB=linie;

		strBuild.append(strB);

		System.out.println("Introduceti portiunea de string pe care doriti sa o stergeti: ");
		linie = flux_in.readLine(); 
		String strStergere=linie;

		int i=strBuild.indexOf(strStergere);
		if(i!=-1)
		{
			strBuild.delete(i,i+strStergere.length());
		}
		System.out.println(strBuild);
	}

}
