package Proiect1;

public class Dreptunghi {
private int lung;
private int lat;

public Dreptunghi(int lung,int lat)
{
	this.lung=lung;
	this.lat=lat;
}

public int Perimetru()
{
	
	return (lung+lat)*2;
}

public int Arie()
{
	
	return lung*lat;
}

}
