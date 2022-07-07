package it.polito.tdp.crimes.model;

public class Adiacenza {

	String a1; 
	String a2; 
	int peso;
	
	public Adiacenza(String a1, String a2, int peso) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.peso = peso;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "R1: " + a1 + ",   R2: " + a2 + ",   Peso= " + peso;
	} 
	
	
}
