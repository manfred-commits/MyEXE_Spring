package com.manfredipiraino.MyEXE_Spring;

public interface Consumazione {
	/*Getter*/
	public String getNome();
	public Double getValoriNutrizionali();
	public Double getPrezzo();
	/*Setter*/
	public void setNome(String nome);
	public void setPrezzo(Double prezzo);
	public void setValoriNutrizionali(Double valoriNutrizionali);
}
