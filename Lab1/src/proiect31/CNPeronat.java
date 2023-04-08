package proiect31;

@SuppressWarnings("serial")
public class CNPeronat extends Exception {
	private String cnperonat;
	public CNPeronat(String cnperonat)
	{
		this.cnperonat=cnperonat;
	}
	public String toString()
	{
		return "CNP-ul "+ cnperonat +" a fost introdus gresit! Va rugam sa il reintroduceti";
	}
}
