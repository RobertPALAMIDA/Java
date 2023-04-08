package proiect;

import java.util.ArrayList;
import java.util.List;

public class Banca {
	private String denumire_banca;
	private List<Client>listaClienti=new ArrayList<Client>();

	public Banca(String denumire_banca, Client client) {
		this.denumire_banca = denumire_banca;
		this.listaClienti.add(client);
	}

	public Banca(String denumire_banca) {
		this.denumire_banca=denumire_banca;
	}

	public Banca(Client client) {
		this.listaClienti.add(client);
	}

	@Override
	public String toString() {
		return "Banca denumire_banca=" + denumire_banca + ", listaClienti:" + listaClienti;
	}

	public String getDenumire_banca() {
		return denumire_banca;
	}
	public void setDenumire_banca(String denumire_banca) {
		this.denumire_banca = denumire_banca;
	}
	public List<Client> getListaClienti() {
		return listaClienti;
	}
	public void setListaClienti(Client client) {
		listaClienti.add(client);
	}
}
