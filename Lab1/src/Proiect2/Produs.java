package Proiect2;

public class Produs {
private String denumire;
private float pret;
private float cantitate;

public Produs(String denumire,float pret,float cantitate)
{
this.denumire=denumire;
this.pret=pret;
this.cantitate=cantitate;
}


public String toString()
{
	return (this.denumire+" "+this.pret+" "+this.cantitate);
}


public String GetDenumire()
{
	return this.denumire;
}

public float GetPret()
{
	return this.pret;
}

public float GetCantitate()
{
	return this.cantitate;
}


}
