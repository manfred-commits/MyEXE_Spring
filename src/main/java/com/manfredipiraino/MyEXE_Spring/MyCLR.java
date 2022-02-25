package com.manfredipiraino.MyEXE_Spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCLR implements CommandLineRunner{
	
	/*Blocco di codice che viene eseguito prima del run*/
	@Override
	public void run(String... args) throws Exception {
		/*get annotation context from MyConfig class*/
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(MyConfig.class);
		
		/*get Beat Menu*/
		Menu myMenu=myContext.getBean(Menu.class);
		
		/*Print the full menu*/
		myMenu.stampa();
		
		/*Inizializziamo 3 istanze della classe Cliente*/
		Cliente c1=new Cliente(1,"Mario","4242 4242 4242 4242");
		Cliente c2=new Cliente(2,"Marco","4232 4242 4242 4142");
		Cliente c3=new Cliente(3,"Marzio","4422 4242 2242 3342");
		
		/*Inizializzo un'istanza di ordine*/
		Ordine myOrder=new Ordine(1,c1);
		
		/*Aggiungo consumazioni all'ordine*/
		myOrder.addConsumazione(myMenu.getHb());
		myOrder.addConsumazione(myMenu.getBeerR());
		
		/*stampa conto in base alle consumazioni del cliente*/
		System.out.println(myOrder.calculateConto());
	
	}

}
