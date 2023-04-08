package proiect34;

public class Melodie {

	private String nume_melodie;
	private String nume_artist;
	private int an_lansare;
	private int numar_vizualizari_youtube;

	public Melodie(String nume_melodie,String nume_artist,int an_lansare,int numar_vizualizari_youtube)
	{
		this.nume_melodie=nume_melodie;
		this.nume_artist=nume_artist;
		this.an_lansare=an_lansare;
		this.numar_vizualizari_youtube=numar_vizualizari_youtube;
	}

	public String getNume_melodie() 
	{
		return nume_melodie;
	}

	public String getNume_artist() 
	{
		return nume_artist;
	}

	public int getAn_lansare() 
	{
		return an_lansare;
	}

	public int getNumar_vizualizari_youtube() 
	{
		return numar_vizualizari_youtube;
	}

	@Override
	public String toString()
	{
		return (this.nume_melodie+" "+this.nume_artist+" "+this.an_lansare+" "+this.numar_vizualizari_youtube);
	}

}
