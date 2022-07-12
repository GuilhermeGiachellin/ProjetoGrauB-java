package controller;

import model.CachorroQuente;
import view.CachorroQuenteView;

public class CachorroQuenteController {
	CachorroQuenteView cachorroView = new CachorroQuenteView();
	
	public void cachorroExtras(CachorroQuente cachorro) {
		cachorro.setMolho(cachorroView.selecionarMolho());
		cachorro.setQuantidadeSalsicha(cachorroView.selecionarQtdSalsicha());
	}
}
