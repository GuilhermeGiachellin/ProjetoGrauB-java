package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Transportador;

public class TransportadorController {
	public ArrayList<Transportador> transportadorList = new ArrayList<Transportador>();
	
	public void addTransporatodor(Transportador transportador) {
		transportadorList.add(transportador);
	}
	
	public Transportador chooseTransportador() {
		int min = 1;
		int max = 10;
		int value = 0;
		Random random = new Random();
		do {
			value = random.nextInt(max + min) + min;			
		}while(value > transportadorList.size());			
		return transportadorList.get(value-1);
	}	
}
