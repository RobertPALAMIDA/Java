package proiect;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContBancar implements Operatiuni{
	private String numarCont;
	private float suma;
	private String moneda;
	private LocalDate data_deschiderii;
	private LocalDate data_ultimei_operatiuni;

	public ContBancar(String numarCont, float suma, String moneda, LocalDate data_deschiderii,
			LocalDate data_ultimei_operatiuni) {
		this.numarCont = numarCont;
		this.suma = suma;
		this.moneda = moneda;
		this.data_deschiderii = data_deschiderii;
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}
	@Override
	public String toString() {
		return "\n		ContBancar numarCont=" + numarCont + ", suma=" + suma + ", moneda=" + moneda + ", data_deschiderii="
				+ data_deschiderii + ", data_ultimei_operatiuni=" + data_ultimei_operatiuni;
	}
	public String getNumarCont() {
		return numarCont;
	}
	public void setNumarCont(String numarCont) {
		this.numarCont = numarCont;
	}
	public float getSuma() {
		return suma;
	}
	public void setSuma(float suma) {
		this.suma = suma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public LocalDate getData_deschiderii() {
		return data_deschiderii;
	}
	public void setData_deschiderii(LocalDate data_deschiderii) {
		this.data_deschiderii = data_deschiderii;
	}
	public LocalDate getData_ultimei_operatiuni() {
		return data_ultimei_operatiuni;
	}
	public void setData_ultimei_operatiuni(LocalDate data_ultimei_operatiuni) {
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}

	public float calculeaza_dobanda() 
	{
		float valoare=0;
		int nr_zile=(int)ChronoUnit.DAYS.between(getData_ultimei_operatiuni(),LocalDate.now());
		if(getMoneda().compareTo("RON") == 0)
		{
			if(getSuma()<=500)
				valoare=(float) (nr_zile*0.3);
			else
				valoare=(float)(nr_zile*0.8);
		}
		else
		{
			valoare=(float)(nr_zile*0.1);
		}
		return valoare;
	}

	public float actualizare_suma()
	{
		setSuma(getSuma()-calculeaza_dobanda());
		setData_ultimei_operatiuni(LocalDate.now());
		return getSuma();
	}

	public void depunere(float suma)
	{
		setSuma(getSuma()+suma);
		actualizare_suma();
		setData_ultimei_operatiuni(LocalDate.now());
	}

	public void extragere (float suma)
	{
		setSuma(getSuma()-suma);
		actualizare_suma();
		setData_ultimei_operatiuni(LocalDate.now());
	}
}
