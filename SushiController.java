package controller;

import model.Sushi;
import view.SushiView;

public class SushiController {
	SushiView sushiView = new SushiView();
	
	public void sushiExtras(Sushi sushi) {
		sushi.setTipoPeixe(sushiView.selecionarPeixe());
	}
}
