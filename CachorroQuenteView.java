package view;

import javax.swing.JOptionPane;

public class CachorroQuenteView {
	
	public String selecionarMolho() {
		String[] opcoes = new String[] { "Tomate", "Branco" };
		int response = JOptionPane.showOptionDialog(null, "Escolha o molho:", "MOLHO", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return opcoes[response];
	}
	
	public int selecionarQtdSalsicha() {
		String[] opcoes = new String[] { "1", "2", "3" };
		int response = JOptionPane.showOptionDialog(null, "Escolha quantidade salsicha:", "SALSICHA", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return Integer.parseInt(opcoes[response]);
	}
}
