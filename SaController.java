package controller;

import java.util.ArrayList;
import java.util.Objects;

import model.Alimento;
import model.Cardapio;
import model.Cliente;
import model.Endereco;
import model.Hamburguer;
import model.Pedido;
import model.Pizza;
import model.Restaurante;
import model.Sushi;
import model.Transportador;
import model.Usuario;
import view.PedidoView;
import view.RestauranteView;
import view.SaView;
import view.UsuarioView;

public class SaController {
	SaView saView = new SaView();
	PedidoView pedidoView = new PedidoView();
	RestauranteView restauranteView = new RestauranteView();	
	UsuarioView usuarioView = new UsuarioView();
	
	PedidoController pedidoController = new PedidoController();
	ClienteController clienteController = new ClienteController();
	TransportadorController transportadorController = new TransportadorController();
	AlimentoController alimentoController = new AlimentoController();
	CardapioController cardapioController = new CardapioController();
	UsuarioController usuarioController = new UsuarioController();
	
	private Usuario usuarioAtivo = new Usuario(null, null, null, null, null);
	
	public SaController() {
		popula();
		telaInicial();		
	}
	
	public void telaInicial() {
		var escolha = 0;		
		while(escolha != 2 || usuarioAtivo == null) {
			escolha = saView.telaIncial();
			switch(escolha) {
			case 0:
				usuarioController.registrarUser();
			break;
			case 1:				
				//LOGIN
				usuarioAtivo = usuarioController.loginUser();
				if(usuarioAtivo != null) {						
					menuPrincipal();
				} else {
					saView.erroMensagem();
				}
			break;
			case 2:
				System.exit(0);
			break;
			}
		}
	}

	
	public void menuPrincipal() {
		ArrayList<String> menuOption = new ArrayList<String>();
		
		if(usuarioAtivo instanceof Restaurante) {
			menuOption.clear();		
			menuOption.add("Fila de pedidos");
			menuOption.add("Adicionar comida");
			menuOption.add("LogOut");
		} else {
			menuOption.clear();
			menuOption.add("Meus pedidos");
			menuOption.add("Ver restaurantes");
			menuOption.add("LogOut");
		}
		
		int option = saView.menuPrincipal(menuOption);		
		switch(option) {
		case 0:
			showPedidos();
		break;
		case 1: 	
			if(usuarioAtivo instanceof Restaurante) {
				createAlimento();
			} else {	
				Restaurante restaurante = usuarioController.listRestaurante();				
				if(restaurante == null) {					
					menuPrincipal();
				} else {
					menuCardapio(restaurante);					
				}
			}
		break;
		case 2:
			logOut();
		break;
	 }
	}
	
	//MOSTRA O CARDAPIO DO RESTAURANTE SELECIONADO PELO USUARIO
	public void menuCardapio(Restaurante restaurante) {		
		Cardapio cardapio = restaurante.getCardapio();		
		int option = alimentoController.filterAlimento(cardapio);	
		switch(option) {		
		case 0:		
			menuPedidoCliente(cardapio, restaurante);
			break;
		case 1: 			
			menuPrincipal();
			break;		
		}
	}
	
	//MOSTRA PEDIDOS DO USUARIO ATIVO
	public void showPedidos() {
		int response = pedidoController.listUserPedidos(usuarioAtivo);
		
		if(response < 0) {			
			menuPrincipal();			
		} else {			
			pedidoController.detalhesPedido(response);
			menuPrincipal();	
		}	
	}
	
	//CRIA O NOVO PEDIDO E ADICIONA ELE NA ARRAY LIST DE PEDIDOS
	public void menuPedidoCliente(Cardapio cardapio, Restaurante restaurante) {		
		Pedido novoPedido = new Pedido(restaurante, usuarioAtivo, null, null, 0.0, false);
		Alimento alimentoEscolhido = alimentoController.chooseAlimento(cardapio);
		if(alimentoEscolhido == null) {
			menuPrincipal();
		}
		Transportador transportador =  transportadorController.chooseTransportador();
		
		novoPedido.setAlimento(alimentoEscolhido);		
		novoPedido.setTransportador(transportador);		
		novoPedido.setValor(pedidoController.valorPedido(alimentoEscolhido.getValor(), transportador.getValorkm(), alimentoEscolhido.getTamanho()));
				
		pedidoController.addPedido(novoPedido);
		
		pedidoView.confirmationPedido(novoPedido);
		
		menuPrincipal();
	}
	
	public void createAlimento() {
		alimentoController.createAlimento(usuarioAtivo);
		menuPrincipal();
	}
	
	public void logOut() {
		usuarioAtivo = null;
		telaInicial();
	}
		
	public void popula() {
		Endereco enderecocliente = new Endereco("cidade1", "bairro1", "cep1", "rua1", 1, "clietne");
		Endereco enderecorestaurante = new Endereco("cidade2", "bairro2", "cep2", "rua2", 2, "Restaurante");
		Cardapio cardapio = new Cardapio("cardapio1");
		Cardapio cardapio2 = new Cardapio("cardapio1");
		Restaurante res = new Restaurante("restaurante1", "123", "restaurante1@g.com", enderecorestaurante, "telefone", "cnpj", cardapio);
		Restaurante res2 = new Restaurante("restaurante2", "123", "restaurante2@g.com", enderecorestaurante, "telefone", "cnpj", cardapio2);
		Cliente cliente = new Cliente("cliente1", "123", "cliente1@c.com", enderecocliente, "telefonecliente1", "cpf", "sobrenome");
		Hamburguer burguer = new Hamburguer(null, 0, "Baconator", 25.00, null, null, cardapio);
		Sushi shushi = new Sushi("atum", "sashimi", 5.0, null, null, cardapio);
		Pizza pizza = new Pizza(null, null, "chocodestruicao", 5, null, null, cardapio2);
		Transportador trans = new Transportador("fuca", "placa", 5.0);
		usuarioController.addUsuario(res);
		usuarioController.addUsuario(res2);
		usuarioController.addUsuario(cliente);
		usuarioController.addRestaurante(res);
		usuarioController.addRestaurante(res2);
		clienteController.addCliente(cliente);
		transportadorController.addTransporatodor(trans);
		alimentoController.addAlimento(burguer);
		alimentoController.addAlimento(shushi);
		alimentoController.addAlimento(pizza);		
	}
}
