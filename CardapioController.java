package controller;

import java.util.ArrayList;

import model.Cardapio;
import view.CardapioView;

public class CardapioController {
	public CardapioView cardapioView = new CardapioView();
	public ArrayList<Cardapio> cardapioList = new ArrayList<Cardapio>();
	
	public void addCardapio(Cardapio cardapio) {
		cardapioList.add(cardapio);
	}	

}
