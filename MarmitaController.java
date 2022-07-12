package controller;

import model.Marmita;
import view.MarmitaView;

public class MarmitaController {
	MarmitaView marmitaView = new MarmitaView();
	
	public void marmitaExtras(Marmita marmita) {
		marmita.setTipoCarne(marmitaView.selecionarCarne());
		marmita.setMassa(marmitaView.selecionarMassa());
		marmita.setSalada(marmitaView.selecionarSalada());
	}

}
