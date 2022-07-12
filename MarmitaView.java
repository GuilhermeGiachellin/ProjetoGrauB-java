package view;

import javax.swing.JOptionPane;

public class MarmitaView {
	
	public String selecionarCarne() {
		String[] opcoes = new String[] { "Frango", "Bovina", "Suina" };
		int response = JOptionPane.showOptionDialog(null, "Escolha a carne:", "CARNE", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return opcoes[response];
	}
	
	public String selecionarMassa() {
		String[] opcoes = new String[] { "Espaguete", "Tortei", "Nhoque" };
		int response = JOptionPane.showOptionDialog(null, "Escolha a massa:", "MASSA", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return opcoes[response];
	}
	
	public Boolean selecionarSalada() {
		String[] opcoes = new String[] { "Sim", "Não" };
		int response = JOptionPane.showOptionDialog(null, "Deseja salada?:", "SALADA", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
		if(response == 0) {
			return true;
		} else {
			return false;			
		}
	}
}
