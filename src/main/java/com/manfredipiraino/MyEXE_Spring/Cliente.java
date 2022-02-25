package com.manfredipiraino.MyEXE_Spring;

public class Cliente {
	/*Proprietà*/
	private int idCliente;
	private String nome;
	private String cartaCredito;
	/*Costruttore*/
	public Cliente(int idCliente, String nome, String cartaCredito) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cartaCredito = cartaCredito;
	}
	/*Getter*/
	public int getIdCliente() {
		return idCliente;
	}
	public String getNome() {
		return nome;
	}
	public String getCartaCredito() {
		return cartaCredito;
	}
	/*Setter*/
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCartaCredito(String cartaCredito) {
		this.cartaCredito = cartaCredito;
	}
}
