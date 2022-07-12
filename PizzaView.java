package view;

import javax.swing.JOptionPane;

public class PizzaView {
	
	public String selecionarTipoDeBorda() {
		String[] opcoes = new String[] { "Catupiri", "Cheedar", "Nenhuma" };
		int response = JOptionPane.showOptionDialog(null, "Escolha o tipo de borda:", "BORDA", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);	
		return opcoes[response];		
	}
	
	public String selecionarEspessuraMassa() {		
		String[] opcoes = new String[] { "Fina", "Media", "Grossa" };
		int response = JOptionPane.showOptionDialog(null, "Escolha espessura da massa:", "ESPESSURA", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);	
		return opcoes[response];
	}
}
