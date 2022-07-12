package view;

import javax.swing.JOptionPane;

public class AlimentoView {
	
	public int showFilteredAlimento(String content) {
		String[] opcoes = new String[] { "Fazer Pedido", "Voltar" };					 
		int response = JOptionPane.showOptionDialog(null, "(Valores referentes ao tamanho P)\n\n" + content, "CARDAPIO ", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
		return response;
	}
	
	public int chooseAlimento(String content) {		
		String opcao = JOptionPane.showInputDialog(null, "Digite o numero relacionado a sua comida: \nCaso queira voltar digite 0\n\n(Valores referentes ao tamanho P)\n\n" + content ,"ESCOLHA OS ITENS", -1);
		if(opcao == null)  {
			infoMessage("Botão cancel desativado!", "ERRO");	
			return -1;
		} else if(opcao.isEmpty() || Integer.parseInt(opcao) < 0) {
			infoMessage("Digite um valor valido!", "ERRO");	
			return -1;
		}
		int response = Integer.parseInt(opcao);
		return response - 1;
	}
	
	public int createAlimento() {
		String[] opcoes = new String[] { "Sushi", "Pizza", "Hamburguer", "Marmita", "Dogão"  };
		int response = JOptionPane.showOptionDialog(null, "Escolha o tipo de comida para registrar", "NOVA COMIDA: ", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
		return response;
	}
	
	public String setAlimentoName() {
		String response = JOptionPane.showInputDialog(null, "Qual o nome do alimento:" ,"NOME ALIMENTO", -1);	
		if(response == null)  {
			infoMessage("Botão cancel desativado!", "ERRO");	
			return "";
		}
		return response;
	}
	
	public String setAlimentoValor() {
		String response = JOptionPane.showInputDialog(null, "Informe o valor do Alimento:\n\n(Digite com o formato double ex: 2.0)" ,"VALOR ALIMENTO", -1);		
		if(response == null)  {
			infoMessage("Botão cancel desativado!", "ERRO");	
			return null;
		}
		return response;		
	}
	
	public String setAlimentoObservacoes() {
		String response = JOptionPane.showInputDialog(null, "Alguma observação?\nCaso não tenha, apenas pressione ok!", "OBSERVACÇÃO", -1);
		if(response == null)  {
			infoMessage("Botão cancel desativado!", "ERRO");	
			return null;
		}
		if(response.isEmpty()) {
			response = "Nenhuma observação";
		}		
		return response;
	}
	
	public String setAlimentoTamanho() {	
		String[] opcoes = new String[] { "G", "M", "P"  };
		int response = JOptionPane.showOptionDialog(null, "Escolha o tamanho do sua comida", "TAMANHO", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
		switch(response) {
			case 0:
				return "G";
			case 1:
				return "M";				
			case 2:
				return "P";								
		}
		return null;
	}
	
	public void infoMessage(String mensagem, String tipo) {
		 JOptionPane.showMessageDialog(null, mensagem, tipo, JOptionPane.WARNING_MESSAGE);
	}
}
