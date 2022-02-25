package com.manfredipiraino.MyEXE_Spring;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	/*Proprietà*/
	private HamburgerBase hb = new HamburgerBase("Hamburger", 8.50, 3000.00);
	private CheeseBurger csb = new CheeseBurger("CheeseBurger", 9.70,3250.00);
	private ChickenBurger ckb= new ChickenBurger("ChickenBurger", 7.80, 2870.00);
	private Birra beerB=new Birra("Birra Bionda Media", 5.00, 1200.00);
	private Birra beerR=new Birra("Birra Rossa Media", 6.00, 1400.00);
	private List <Consumazione> myList= new ArrayList<>();
	
	/*Methods*/
	public void stampa() {
		System.out.println("Menu: ");
		for(Consumazione consumazione:getMyList()) {
			System.out.println("Nome: "+consumazione.getNome()+" Prezzo: "+consumazione.getPrezzo()+" Valori nutrizionali: "+consumazione.getValoriNutrizionali());
		}
	}
	
	/*Getter*/
	public List<Consumazione> getMyList() {
		myList.add(hb);
		myList.add(csb);
		myList.add(ckb);
		myList.add(beerB);
		myList.add(beerR);
		return myList;
	}
	public HamburgerBase getHb() {
		return hb;
	}
	public CheeseBurger getCsb() {
		return csb;
	}
	public void setMyList(List<Consumazione> myList) {
		this.myList = myList;
	}
	public ChickenBurger getCkb() {
		return ckb;
	}
	public Birra getBeerB() {
		return beerB;
	}
	
	/*Setter*/
	public void setHb(HamburgerBase hb) {
		this.hb = hb;
	}
	public void setCsb(CheeseBurger csb) {
		this.csb = csb;
	}
	public void setCkb(ChickenBurger ckb) {
		this.ckb = ckb;
	}
	public void setBeerB(Birra beerB) {
		this.beerB = beerB;
	}
	public Birra getBeerR() {
		return beerR;
	}
	public void setBeerR(Birra beerR) {
		this.beerR = beerR;
	}
	
}
