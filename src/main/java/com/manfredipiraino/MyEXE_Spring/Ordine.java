package com.manfredipiraino.MyEXE_Spring;

import java.util.ArrayList;
import java.util.List;

public class Ordine {
	/*Proprietà*/
	private int idOrdine;
	private Cliente myCliente;
	private List <Consumazione> myList= new ArrayList<>();
	private Double conto=0.0d;

	/*Costruttore*/
	public Ordine(int idOrdine, Cliente myCliente) {
		this.idOrdine = idOrdine;
		this.myCliente = myCliente;
	}
	
	/*Metodi*/
	public Double calculateConto() {	
		for(Consumazione consumazione:myList) {
			conto+=consumazione.getPrezzo();			
		}
		return conto;
	}	
	public void addConsumazione(Consumazione consumazione) {
		myList.add(consumazione);
	}
	
	/*Getter*/
	public List<Consumazione> getMyList() {
		return myList;
	}
	public int getIdOrdine() {
		return idOrdine;
	}
	public Cliente getMyCliente() {
		return myCliente;
	}
	public Double getConto() {
		return conto;
	}
	/*Setter*/
	public void setMyList(List<Consumazione> myList) {
		this.myList = myList;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public void setMyCliente(Cliente myCliente) {
		this.myCliente = myCliente;
	}
	public void setConto(Double conto) {
		this.conto = conto;
	}
	
}
