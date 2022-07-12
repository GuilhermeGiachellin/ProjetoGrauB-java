package view;

import model.Cliente;
import model.Usuario;

public class ClienteView {
	UsuarioView usuarioView = new UsuarioView();
	
	public Cliente registrarCliente(Usuario user) {	
		var sobrenome = usuarioView.QuestionString("Favor informar o seu sobrenome:");
		var cpf = usuarioView.QuestionString("Favor informar o cpf:");		
		return new Cliente(user.getNome(), user.getSenha(), user.getEmail(), user.getEndereco(), user.getTelefone(), cpf, sobrenome);
	}

}
