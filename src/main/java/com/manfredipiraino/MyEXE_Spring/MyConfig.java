package com.manfredipiraino.MyEXE_Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
	
	@Bean
	@Scope("prototype") 
	public Menu myMenu() {
		return new Menu();
	}
	@Bean
	@Scope("prototype") 
	public Ordine myOrder(int idOrdine, Cliente myCliente) {
		return new Ordine(idOrdine,myCliente);
	}
}
