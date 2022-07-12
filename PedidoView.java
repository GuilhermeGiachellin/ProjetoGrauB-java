package view;

import javax.swing.JOptionPane;

import model.Pedido;

public class PedidoView {
	
	public void confirmationPedido(Pedido pedido) {
		 JOptionPane.showMessageDialog(null, "Pedido concluido e encaminhado para " + pedido.getRestaurante().getNome() + "!\n\n"
			 		+ "O seu pedido inclui " + pedido.getAlimento().getNome() + "\n\nValor Total: R$" + pedido.getValor(), "CONFIRMAÇÃO!", JOptionPane.WARNING_MESSAGE);
	}	
	
	public int listUserPedidos(String content) {	
		String opcao = JOptionPane.showInputDialog(null, content + "\n\n Para mais detalhes digite o numero do pedido ou 0 para voltar" ,"ESCOLHA OS ITENS", -1);	
		if(opcao == null) {
			erroMensagem("Botão cancel desativado!");
			return 0;
		} else if(opcao.isEmpty() || Integer.parseInt(opcao) < 0) {		
			erroMensagem("Digite um valor válido!");
			return 0;
		}
		return Integer.parseInt(opcao);
	}
	
	public void detalhesPedido(String content) {
		JOptionPane.showMessageDialog(null, content, "DETALHES DO PEDIDO", JOptionPane.WARNING_MESSAGE);
	}
	
	public void erroMensagem(String mensagem) {
		 JOptionPane.showMessageDialog(null, mensagem, "ERRO", JOptionPane.WARNING_MESSAGE);
	}
}
