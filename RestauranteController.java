package controller;

import java.util.ArrayList;

import model.Restaurante;
import view.RestauranteView;

public class RestauranteController {
	RestauranteView restauranteView = new RestauranteView();
	public ArrayList<Restaurante> restauranteList = new ArrayList<Restaurante>();
	
	public void addRestaurante(Restaurante restaurante) {		
		restauranteList.add(restaurante);	
	}
	
	public Restaurante listRestaurante() {		
		String content = "";
		for(int i=0; i < restauranteList.size(); i++) {			
			content += (i + 1) + "- " + restauranteList.get(i).getNome() + "\n";
		}	
		int op = restauranteView.listRestaurante(content);	
		op -= 1;
		if(op < 0 || op >= restauranteList.size()) {
			return null;
		} else {
			return restauranteList.get(op);				
		}
	}
}
