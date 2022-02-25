package com.manfredipiraino.MyEXE_Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	private final List<Ordine> myOrdersList=new ArrayList<>();
	private Cliente c1=new Cliente(1,"Mario Rossi","4242 4242 4242 4242");
	private Cliente c2=new Cliente(2,"Viola Biondi","4232 4242 4242 4142");
	private Cliente c3=new Cliente(3,"Davide Gialli","4422 4242 2242 3342");
	@Autowired
	private ApplicationContext myContext;
	
	// Menu view + model
	@GetMapping("/mymenu")
	public ModelAndView myMenu() {
		ModelAndView myView = new ModelAndView("menu");
		Menu myMenu=myContext.getBean(Menu.class);
		myView.addObject("mymenu",myMenu);
		return myView;
	}
	
	//Lista di ordini view + model
	@GetMapping("/myorderlist")
	public ModelAndView myOrders() {
		ModelAndView myView = new ModelAndView("orderlist");
		Menu myMenu=myContext.getBean(Menu.class);
		
		/*Creo diverse istanze di ordini*/
		Ordine myOrder1=myContext.getBean(Ordine.class,1,c1);
		Ordine myOrder2=myContext.getBean(Ordine.class,2,c2);
		Ordine myOrder3=myContext.getBean(Ordine.class,3,c3);
		
		/*popolo le istanze create*/
		myOrder1.addConsumazione(myMenu.getHb());
		myOrder1.addConsumazione(myMenu.getBeerR());
		myOrder1.calculateConto();
		
		myOrder2.addConsumazione(myMenu.getHb());
		myOrder2.addConsumazione(myMenu.getCkb());
		myOrder2.addConsumazione(myMenu.getBeerR());
		myOrder2.addConsumazione(myMenu.getBeerB());
		myOrder2.calculateConto();
		
		myOrder3.addConsumazione(myMenu.getCsb());
		myOrder3.addConsumazione(myMenu.getBeerR());
		myOrder3.calculateConto();
		
		/*verifico se la lista è vuota ed inserisco le istanze create*/
		if(myOrdersList.size()==0) {
			myOrdersList.add(myOrder1);
			myOrdersList.add(myOrder2);
			myOrdersList.add(myOrder3);
		}
		
		/*ritorno la collezione di tipo Ordine nella view*/
		myView.addObject("myorders",myOrdersList);
		
		return myView;
	}
	
	//Ordine singolo view + model
	@GetMapping("/mygetorder/{id}")
	@ResponseBody
	public ModelAndView myGetParameter(@PathVariable int id) {
		ModelAndView myView = new ModelAndView("singleorder");
		Ordine myOrder=myOrdersList.get(id);
		myView.addObject("myorder",myOrder);
		
		return myView;
	}
	// Form aggiunta ordine view + model
	@GetMapping("/form")
	public ModelAndView myForm() {
		ModelAndView myView = new ModelAndView("form");
		Menu myMenu=myContext.getBean(Menu.class);
		myView.addObject("mymenu",myMenu);
		
		return myView;
	}
	/*Gestione richiesta post dal form, per creare ed aggiungere un'ordine*/
	@PostMapping("/mypost")
	@ResponseBody
	public String myPost(@RequestParam String hamburger,@RequestParam String cheeseBurger,@RequestParam String chickenBurger,@RequestParam String birraB,@RequestParam String birraR,@RequestParam String nome,@RequestParam String cartaDiCredito) {
		Cliente newCliente=new Cliente(122231,nome,cartaDiCredito);
		Ordine newOrdine=myContext.getBean(Ordine.class,43,newCliente);
		Menu myMenu=myContext.getBean(Menu.class);
		List<Consumazione> myList=myMenu.getMyList();
		
		if(hamburger!="") {
			for(int i=0;i<Integer.parseInt(hamburger);i++) {
				newOrdine.addConsumazione(myList.get(0));
			}
		}
		if(cheeseBurger!="") {
			for(int i=0;i<Integer.parseInt(cheeseBurger);i++) {
				newOrdine.addConsumazione(myList.get(1));
			}
		}
		if(chickenBurger!="") {
			for(int i=0;i<Integer.parseInt(chickenBurger);i++) {
				newOrdine.addConsumazione(myList.get(2));
			}
		}
		if(birraB!="") {
			for(int i=0;i<Integer.parseInt(birraB);i++) {
				newOrdine.addConsumazione(myList.get(3));
			}
		}
		if(birraR!="") {
			for(int i=0;i<Integer.parseInt(birraR);i++) {
				newOrdine.addConsumazione(myList.get(4));
			}
		}
		newOrdine.calculateConto();
		myOrdersList.add(newOrdine);
		return "Cliente aggiunto " +"<a href='http://localhost:8080/' alt=''>Ritorna alla Home</a>";

	}

}
