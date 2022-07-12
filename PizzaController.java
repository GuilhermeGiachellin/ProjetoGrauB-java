package controller;

import model.Pizza;
import view.PizzaView;

public class PizzaController {
	PizzaView pizzaView = new PizzaView();
	
	public void pizzaExtras(Pizza pizza) {		
		pizza.setTipoDeBorda(pizzaView.selecionarTipoDeBorda());
		pizza.setEspessuraMassa(pizzaView.selecionarEspessuraMassa());
	}
}
