package controller;

import java.util.ArrayList;
import java.util.Objects;

import model.Cardapio;
import model.Cliente;
import model.Endereco;
import model.Restaurante;
import model.Usuario;
import view.ClienteView;
import view.RestauranteView;
import view.UsuarioView;

public class UsuarioController {
	private UsuarioView usuarioView = new UsuarioView();
	private ClienteView clienteView = new ClienteView();
	private RestauranteView restauranteView = new RestauranteView();
	private RestauranteController restauranteController = new RestauranteController();
	private ClienteController clienteController = new ClienteController();
	private ArrayList<Usuario> usuarioList = new ArrayList<Usuario>();
	
	public void addUsuario(Usuario user) {
		usuarioList.add(user);		
	}
	
	public void addRestaurante(Restaurante restaurante) {
		restauranteController.addRestaurante(restaurante);
	}
	
	public void registrarUser() {		
		var tipo = usuarioView.definirTipoUsuario();		
		if(tipo == null)
			return;		
		var user = new Usuario(
				usuarioView.QuestionString("Favor informar o seu nome:"),
				usuarioView.QuestionString("Favor informar o sua senha:"),
				usuarioView.QuestionString("Favor informar o seu email:")
				, new Endereco(usuarioView.QuestionString("Favor informar a sua cidade:"),
						       usuarioView.QuestionString("Favor informar o seu bairro:"), 
						       usuarioView.QuestionString("Favor informar o seu cep:"),
						       usuarioView.QuestionString("Favor informar a sua rua:"),
						       usuarioView.QuestionInt("Favor informar o numero da casa:"), 
						       usuarioView.QuestionString("Favor informar os detalhes:")), 
				usuarioView.QuestionString("Favor informar o seu telefone:"));
	
		switch(tipo) {
			case "Cliente":	
				Cliente cliente = clienteView.registrarCliente(user);				
				usuarioList.add(cliente);
				clienteController.addCliente(cliente);
				break;				
			case "Restaurante":
				Cardapio cardapio = new Cardapio(null);
				Restaurante restaurante = restauranteView.registrarRestaurante(user, cardapio);
				usuarioList.add(restaurante);
				restauranteController.addRestaurante(restaurante);
				break;		
		}

	}
		
	public Usuario loginUser() {
		var credenciais = usuarioView.login();		
		Usuario usuarioAtivo = usuarioList.stream().filter(user -> Objects.equals(user.getSenha(), credenciais.Senha) && Objects.equals(user.getEmail(), credenciais.Email)).findFirst().orElse(null);		
		return usuarioAtivo;
	}
	
	public Restaurante listRestaurante() {				
		return restauranteController.listRestaurante();		
	}
}

