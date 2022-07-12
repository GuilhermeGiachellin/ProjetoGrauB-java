package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SaView {
	public int menuPrincipal(ArrayList<String> listaOpcoes) {	
		Object[] opcoes = listaOpcoes.toArray();
		int response = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo:", "MENU PRINCIPAL", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return response;
	}
		
	public int menuPedido() {
		String[] opcoes = new String[] { "Fazer pedido", "Ver Restaurantes" };
		int response = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo:", "MENU PRINCIPAL", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);		
		return response;
	}
	
	public int telaIncial() {
		Object[] opcoes = {"Registrar", "Logar", "Sair"};
		var escolha = JOptionPane.showOptionDialog(null, "Bem vindo!", "APP COMIDA", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,  opcoes, opcoes[0]);	
	    return escolha;
	}
	
	public void erroMensagem() {
		 JOptionPane.showMessageDialog(null, "Não foi possível realizar o login", "ERRO", JOptionPane.WARNING_MESSAGE);
	}
}
