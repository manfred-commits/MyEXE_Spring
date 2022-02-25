package com.manfredipiraino.MyEXE_Spring;

public abstract class Hamburger implements Consumazione{
	/*Proprietà*/
	private String nome;
	private Double prezzo;
	private Double valoriNutrizionali;
	
	/*Costruttore*/
	public Hamburger(String nome, Double prezzo, Double valoriNutrizionali) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.valoriNutrizionali = valoriNutrizionali;
	}
	
	/*Getter*/
	public String getNome() {
		return nome;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public Double getValoriNutrizionali() {
		return valoriNutrizionali;
	}
	/*Setter*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public void setValoriNutrizionali(Double valoriNutrizionali) {
		this.valoriNutrizionali = valoriNutrizionali;
	}
}
