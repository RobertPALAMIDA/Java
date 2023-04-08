package Proiect3;

public class Vers {
	private String vers;

	public Vers(String vers)
	{
		this.vers=vers;
	}

	public int Split()
	{
		return (vers.split(" ")).length;
	}

	public int Vocale()
	{
		int contor=0;
		vers=vers.toLowerCase();
		for (int i = 0; i < vers.length(); i++) 
		{
			if (vers.charAt(i) == 'a' || vers.charAt(i) == 'e' || vers.charAt(i) == 'i' || vers.charAt(i) == 'o' || vers.charAt(i) == 'u')
			{
				contor++;
			}
		}
		return contor;
	}

	public boolean Steluta(String grupare)
	{
		boolean ok=false;
		if(vers.endsWith(grupare))
		{
			ok=true;
		}
		return ok;
	}

	public String Upper(float rand)
	{
		String vers_=vers;
		if(rand<0.1)
		{
			vers_=vers_.toUpperCase();
		}
		return vers_;
	}
}
