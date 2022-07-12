package controller;

import java.util.ArrayList;
import java.util.Random;

import model.CachorroQuente;
import model.Hamburguer;
import model.Marmita;
import model.Pedido;
import model.Pizza;
import model.Sushi;
import model.Usuario;
import view.PedidoView;

public class PedidoController {
	public ArrayList<Pedido> pedidoList = new ArrayList<Pedido>();	
	public ArrayList<Pedido> pedidoFiltrado = new ArrayList<Pedido>();	
	public PedidoView pedidoView = new PedidoView();
	
	public void addPedido(Pedido pedido) {
		pedidoList.add(pedido);		
	}
	
	public Double valorPedido(Double valorAlimento, Double valorEntrega, String tamanho) {
		switch(tamanho) {
			case "G":
				valorAlimento = valorAlimento * 0.5;
			break;
			case "M":
				valorAlimento = valorAlimento * 0.25;
			break;			
		}
		Double sum = 0.0;
		int min = 1;
		int max = 10;
		int randomKm = 0;
		Random random = new Random();	
		randomKm = random.nextInt(max + min) + min;
		sum = (valorEntrega * randomKm) + valorAlimento;
		return sum;
	}
	
	public void filterPedidos(Usuario usuarioAtivo) {				
		for(int i=0; i < pedidoList.size(); i++) {		
			if(pedidoList.get(i).getUsuario() == usuarioAtivo || pedidoList.get(i).getRestaurante() == usuarioAtivo) {				
				pedidoFiltrado.add(pedidoList.get(i));
			}
		}
	}
	
	public int listUserPedidos(Usuario usuarioAtivo) {
		pedidoFiltrado.clear();
		String content = "";	
		filterPedidos(usuarioAtivo);
		for(int i=0; i < pedidoFiltrado.size(); i++) {				
			content += "-" + (i + 1) + " Pedido nº " +		" ||		Valor pedido: R$" + pedidoFiltrado.get(i).getValor() + "\n";			
		}		
		int response = pedidoView.listUserPedidos(content);		
		return response - 1;	
	}
	
	//RETORNA OS DETALHES DE PEDIDO FILTRADO POR INSTANCIA
	public void detalhesPedido(int index) {
		String content = "";	
		if(pedidoFiltrado.size() > index) {
			if(pedidoFiltrado.get(index).getAlimento() instanceof Hamburguer) {
				content += "-Pedido nº" + (index + 1) + "\n-Hamburguer do nome: " + pedidoFiltrado.get(index).getAlimento().getNome() +
						"\n-Restaurante: " + pedidoFiltrado.get(index).getRestaurante().getNome() +
						"\n-Cliente: " + pedidoFiltrado.get(index).getUsuario().getNome() +
						"\n-Tipo de carne:" +  ((Hamburguer) pedidoFiltrado.get(index).getAlimento()).getTipoCarne() +
						"\n-Observação: " + pedidoFiltrado.get(index).getAlimento().getObservacao() +
						"\n\n-Valor pedido: R$" + pedidoFiltrado.get(index).getValor();
			} else if(pedidoFiltrado.get(index).getAlimento() instanceof Pizza) {
				content += "-Pedido nº" + (index + 1) + "\n-Pizza do nome: " + pedidoFiltrado.get(index).getAlimento().getNome() +
						"\n-Restaurante: " + pedidoFiltrado.get(index).getRestaurante().getNome() +
						"\n-Cliente: " + pedidoFiltrado.get(index).getUsuario().getNome() +
						"\n-Recheio da borda:" +  ((Pizza) pedidoFiltrado.get(index).getAlimento()).getTipoDeBorda() +
						"\n-Espessura massa:" +  ((Pizza) pedidoFiltrado.get(index).getAlimento()).getEspessuraMassa() +
						"\n-Observação: " + pedidoFiltrado.get(index).getAlimento().getObservacao() +
						"\n\n-Valor pedido: R$" + pedidoFiltrado.get(index).getValor();			
			} else if(pedidoFiltrado.get(index).getAlimento() instanceof CachorroQuente) {
				content += "-Pedido nº" + (index + 1) + "\n-Cachorro Quente do nome: " + pedidoFiltrado.get(index).getAlimento().getNome() +
						"\n-Restaurante: " + pedidoFiltrado.get(index).getRestaurante().getNome() +
						"\n-Cliente: " + pedidoFiltrado.get(index).getUsuario().getNome() +
						"\n-Quantidade de salchichas" +  ((CachorroQuente) pedidoFiltrado.get(index).getAlimento()).getQuantidadeSalsicha() +
						"\n-Tipo de molho" +  ((CachorroQuente) pedidoFiltrado.get(index).getAlimento()).getMolho() +
						"\n-Observação: " + pedidoFiltrado.get(index).getAlimento().getObservacao() +
						"\n\n-Valor pedido: R$" + pedidoFiltrado.get(index).getValor();			
			} else if(pedidoFiltrado.get(index).getAlimento() instanceof Marmita) {
				content += "-Pedido nº" + (index + 1) + "\n-Marmita do nome: " + pedidoFiltrado.get(index).getAlimento().getNome() +
						"\n-Restaurante: " + pedidoFiltrado.get(index).getRestaurante().getNome() +
						"\n-Cliente: " + pedidoFiltrado.get(index).getUsuario().getNome() +
						"\n-Tipo de massa:" +  ((Marmita) pedidoFiltrado.get(index).getAlimento()).getMassa() +
						"\n-Top de carne:" +  ((Marmita) pedidoFiltrado.get(index).getAlimento()).getTipoCarne() +
						"\n-Com salada:" +  ((Marmita) pedidoFiltrado.get(index).getAlimento()).getSalada() +
						"\n-Observação: " + pedidoFiltrado.get(index).getAlimento().getObservacao() + 
						"\n\n-Valor pedido: R$" + pedidoFiltrado.get(index).getValor();				
			} else if(pedidoFiltrado.get(index).getAlimento() instanceof Sushi) {
				content += "-Pedido nº" + (index + 1) + "\n-Sushi do nome: " + pedidoFiltrado.get(index).getAlimento().getNome() +
						"\n-Restaurante: " + pedidoFiltrado.get(index).getRestaurante().getNome() +
						"\n-Cliente: " + pedidoFiltrado.get(index).getUsuario().getNome() +
						"\n-Tipo de Peixe" +  ((Sushi) pedidoFiltrado.get(index).getAlimento()).getTipoPeixe() +
						"\n-Observação: " + pedidoFiltrado.get(index).getAlimento().getObservacao() +
						"\n\n-Valor pedido: R$" + pedidoFiltrado.get(index).getValor();
			}		
			pedidoView.detalhesPedido(content);
		} else
			pedidoView.erroMensagem("Pedido não encontrado!");
	}
}
