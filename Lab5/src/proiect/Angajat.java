package proiect;

import java.time.LocalDate;

public class Angajat {
	private String nume;
	private String post;
	private LocalDate data_angajarii;
	private float salariul;
	public Angajat(String nume, String post, LocalDate data_angajarii, float salariul) {
		this.nume = nume;
		this.post = post;
		this.data_angajarii = data_angajarii;
		this.salariul = salariul;
	}

	@Override
	public String toString() {
		return "Angajat nume:" + getNume() + ", post:" + getPost() + ", data angajarii:"+ getData_angajarii() + ", salariul:" + getSalariul();
	}

	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public LocalDate getData_angajarii() {
		return data_angajarii;
	}
	public void setData_angajarii(LocalDate data_angajarii) {
		this.data_angajarii = data_angajarii;
	}
	public float getSalariul() {
		return salariul;
	}
	public void setSalariul(float salariul) {
		this.salariul = salariul;
	}

	public int compareTo(Angajat b)
	{
		if(this.salariul > b.salariul)
			return -1;
		else 
			return 1;
	}

	public void printSalariul()
	{
		System.out.println(this.getSalariul());
	}
}
