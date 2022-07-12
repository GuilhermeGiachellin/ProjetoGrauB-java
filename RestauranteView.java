package view;

import javax.swing.JOptionPane;

import model.Cardapio;
import model.Restaurante;
import model.Usuario;

public class RestauranteView {
	UsuarioView usuarioView = new UsuarioView();
	
	public int listRestaurante(String content) {		 
		 String opcao = JOptionPane.showInputDialog(null, "Caso queira voltar, digite 0\n" + content, "LISTA DE RESTAURANTES", -1);	
		 if(opcao == null) {
				erroMensagem("Botão cancel desativado!");
				return 0;
			} else if(opcao.isEmpty() || Integer.parseInt(opcao) < 0) {		
				erroMensagem("Digite um valor válido!");
				return 0;
			}
		 return Integer.parseInt(opcao);
	}
	
	public Restaurante registrarRestaurante(Usuario user, Cardapio cardapio) {			
		var cnpj = usuarioView.QuestionString("Favor informar o cnpj:");	
		Restaurante restaurante = new Restaurante(user.getNome(), user.getSenha(), user.getEmail(), user.getEndereco(), user.getTelefone(), cnpj, cardapio);		
		return restaurante;
	}
	
	public void detalhesPedido(String content) {
		JOptionPane.showMessageDialog(null, content, "DETALHES DO PEDIDO", JOptionPane.WARNING_MESSAGE);
	}
	
	public void erroMensagem(String mensagem) {
		 JOptionPane.showMessageDialog(null, mensagem, "ERRO", JOptionPane.WARNING_MESSAGE);
	}
}
