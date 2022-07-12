package view;

import javax.swing.JOptionPane;

public class SushiView {
	
	public String selecionarPeixe() {
		String[] opcoes = new String[] { "Atum", "Salmao" };
		int response = JOptionPane.showOptionDialog(null, "Escolha o tipo de peixe:", "PEIXE", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return opcoes[response];
	}

}
