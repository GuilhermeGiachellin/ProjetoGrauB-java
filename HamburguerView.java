package view;

import javax.swing.JOptionPane;

public class HamburguerView {
	
	public String selecionarCarne() {
		String[] opcoes = new String[] { "Bovina", "Frango", "Vegetariano" };
		int response = JOptionPane.showOptionDialog(null, "Escolha o tipo de carne:", "CARNE", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return opcoes[response];
	}
	
	public int selecionarQtdHamburguer() {
		String[] opcoes = new String[] { "1", "2" };
		int response = JOptionPane.showOptionDialog(null, "Escolha o numero de hamburguers:", "HAMBURGUERS", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);	
		return Integer.parseInt(opcoes[response]);		
	}
}
