package proiect;
import java.util.HashSet;
import java.util.Set;

public class Client {
	private String nume;
	private String adresa;
	private Set<ContBancar>Scb=new HashSet<ContBancar>();

	public Client(String nume, String adresa, ContBancar cont) {
		this.nume = nume;
		this.adresa = adresa;
		Scb.add(cont);
	}

	public Client(String nume, String adresa) {
		this.nume = nume;
		this.adresa = adresa;
	}

	public Client(ContBancar cont) {
		Scb.add(cont);
	}

	@Override
	public String toString() {
		return "\n	Client nume=" + nume + ", adresa=" + adresa + ", conturi:" + Scb;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Set<ContBancar> getConturi() {
		return Scb;
	}

	public void setConturi(ContBancar cont) {
		this.Scb.add(cont);
	}
}
