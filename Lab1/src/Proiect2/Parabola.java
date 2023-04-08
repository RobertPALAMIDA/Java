package Proiect2;

public class Parabola {
	
private double a;
private double b;
private double c;
 
public Parabola(double a,double b,double c)
{
	this.a=a;
	this.b=b;
	this.c=c;
}

public Parabola(Parabola P)
{
	this.a=P.a;
	this.b=P.b;
	this.c=P.c;
}


public void Afisare()
{
	System.out.println("f(x)="+ a +"x^2+"+b+"x+"+c);
}


public double VarfX()
{
	double x;
	x=((-1)*GetB())/(2*GetA());
	return x;
}

public double VarfY()
{
	double y,delta;
	delta=GetB()*GetB()-4*GetA()*GetC();
	y=((-1)*delta)/(4*GetA());
	return y;
}

public void Varf()
{
	System.out.println("Varful se afla la coordonatele: " + VarfX() + " , " + VarfY());
}


public static void GetMijloc(Parabola p1,Parabola p2) 
{
double mx,my;
mx=(p1.VarfX()+p2.VarfX())/2;
my=(p1.VarfY()+p2.VarfY())/2;
System.out.println("Mijlocul dreptei se afla la coordonatele: " + mx + " , " + my);
}

public double GetA()
{
	return this.a;
}

public double GetB()
{
	return this.b;
}

public double GetC()
{
	return this.c;
}

}
