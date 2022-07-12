package controller;

import model.Hamburguer;
import view.HamburguerView;

public class HamburguerController {
	HamburguerView hamburguerView = new HamburguerView();
	
	public void hamburguerExtras(Hamburguer hamburguer) {
		hamburguer.setTipoCarne(hamburguerView.selecionarCarne());
		hamburguer.setQtd_hamburguer(hamburguerView.selecionarQtdHamburguer());		
	}
}
