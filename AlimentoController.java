package controller;

import java.util.ArrayList;
import model.Alimento;
import model.CachorroQuente;
import model.Cardapio;
import model.Hamburguer;
import model.Marmita;
import model.Pizza;
import model.Restaurante;
import model.Sushi;
import model.Usuario;
import view.AlimentoView;

public class AlimentoController {
public AlimentoView alimentoView = new AlimentoView();
public HamburguerController hamburguerController = new HamburguerController();
public PizzaController pizzaController = new PizzaController();
public CachorroQuenteController cachorroController = new CachorroQuenteController();
public SushiController sushiController = new SushiController();
public MarmitaController marmitaController = new MarmitaController();

public ArrayList<Alimento> alimentoList = new ArrayList<Alimento>();
public ArrayList<Alimento> alimentoFiltrado = new ArrayList<Alimento>();
	
	public void addAlimento(Alimento alimento) {
		alimentoList.add(alimento);
	}
	
	//RECEBE E VALIDA O NOME
	public String setAlimentoName() {
		String nome = "";		
		do {
			nome = alimentoView.setAlimentoName();
			if(nome.isEmpty()) {
				alimentoView.infoMessage("Alimento deve conter nome.", "ERRO");
			}
		} while(nome.isEmpty());
		return nome;
	}
	
	//RECEBE E VALIDA O VALOR
	public static boolean isNumeric(String response) {
		return response != null && response.matches("[-+]?\\d*\\.?\\d+");
	}
	
	public double setAlimentoValor() {
		String valorRecebido = "";
		double valorConvertido = 0.0;
		do {
			valorRecebido = alimentoView.setAlimentoValor();
			if(isNumeric(valorRecebido)) {
				valorConvertido = Double.parseDouble(valorRecebido);
				if(valorConvertido <= 0) {
					alimentoView.infoMessage("Valor inválido.", "ERRO");
				}				
			} else {
				alimentoView.infoMessage("Valor inválido.", "ERRO");
			}
		} while(valorConvertido <= 0);
		return valorConvertido;
	}
	
	
	public void createAlimento(Usuario restaurante) {		
		int option = alimentoView.createAlimento();		
		Cardapio cardapio = ((Restaurante) restaurante).getCardapio();
		String nome = "";	
		Double valor = 0.0;
		switch(option) {
		case 0:
			nome = setAlimentoName();
			valor = setAlimentoValor();
			Sushi novoSushi = new Sushi(null, nome, valor, null, null, cardapio);					
			addAlimento(novoSushi);
			alimentoView.infoMessage("Alimento adicionado no cardápio!", "SUCESSO");
			break;
		case 1:
			nome = setAlimentoName();
			valor = setAlimentoValor();
			Pizza novaPizza = new Pizza(null, null, nome, valor, null, null, cardapio);			
			addAlimento(novaPizza);
			alimentoView.infoMessage("Alimento adicionado no cardápio!", "SUCESSO");
			break;
		case 2:
			nome = setAlimentoName();
			valor = setAlimentoValor();
			Hamburguer novoBurguer = new Hamburguer(null, 0, nome, valor, null, null, cardapio);				
			addAlimento(novoBurguer);
			alimentoView.infoMessage("Alimento adicionado no cardápio!", "SUCESSO");
			break;
		case 3:
			nome = setAlimentoName();
			valor = setAlimentoValor();
			Marmita novaMarmita = new Marmita(null, null, null, null, nome, valor, null, null, cardapio);
			addAlimento(novaMarmita);
			alimentoView.infoMessage("Alimento adicionado no cardápio!", "SUCESSO");
			break;
		case 4:
			nome = setAlimentoName();
			valor = setAlimentoValor();
			CachorroQuente novoDogao = new CachorroQuente(0, null, nome, valor,  null, null, cardapio);
			addAlimento(novoDogao);
			alimentoView.infoMessage("Alimento adicionado no cardápio!", "SUCESSO");
			break;
		}
		nome = "";	
		valor = 0.0;		
	}
	
	//CONTROI O CONTENT STRING PARA MOSTRAR EM CHOOSEALIMENTO E FILTERALIMENTO	
	public String buildContent(Cardapio cardapio) {		
		String content = "";
		int i = 0;
		while(i < alimentoList.size()) {
			if (alimentoList.get(i).getCardapio() == cardapio) {
				alimentoFiltrado.add(alimentoList.get(i));
			}
			i++;	
		}
		for(int j=0; j < alimentoFiltrado.size(); j++) {			
			if(alimentoFiltrado.get(j) instanceof Hamburguer) {
				content += "- " + (j+1) + " Hamburguer " + alimentoFiltrado.get(j).getNome() + "  R$" + alimentoFiltrado.get(j).getValor() + "\n";
			} else if(alimentoFiltrado.get(j) instanceof Pizza) {
				content += "- " + (j+1) + " Pizza " + alimentoFiltrado.get(j).getNome() + "  R$" + alimentoFiltrado.get(j).getValor() + "\n";				
			} else if(alimentoFiltrado.get(j) instanceof CachorroQuente) {
				content += "- " + (j+1) + " Dogao " + alimentoFiltrado.get(j).getNome() + "  R$" + alimentoFiltrado.get(j).getValor() + "\n";				
			} else if(alimentoFiltrado.get(j) instanceof Marmita) {
				content += "- " + (j+1) + " Marmita " + alimentoFiltrado.get(j).getNome() + "  R$" + alimentoFiltrado.get(j).getValor() + "\n";				
			} else if(alimentoFiltrado.get(j) instanceof Sushi) {
				content += "- " + (j+1) + " Sushi " + alimentoFiltrado.get(j).getNome() + "  R$" + alimentoFiltrado.get(j).getValor() + "\n";
			}			
		}
		return content;
	}
	
	//MOSTRA OS ALIMENTOS FILTRADOS APOS ENTRAR NO RESTAURANTE
	public int filterAlimento(Cardapio cardapio) {			
		int option = alimentoView.showFilteredAlimento(buildContent(cardapio));
		alimentoFiltrado.clear();
		return option;
	}
	
	//QUANDO USER CLICA EM 'FAZER PEDIDO' ELE ESCOLHE O ALIMENTO
	public Alimento chooseAlimento(Cardapio cardapio) {			
		int option = alimentoView.chooseAlimento(buildContent(cardapio));	
		
		if(option >= 0 && alimentoFiltrado.size() > option) {	
			if(alimentoFiltrado.get(option) instanceof Hamburguer) {
				Hamburguer hamburguerEscolhido = new Hamburguer(null, 0, alimentoFiltrado.get(option).getNome(), alimentoFiltrado.get(option).getValor(), null, null, null);	
				hamburguerController.hamburguerExtras(hamburguerEscolhido);	
				hamburguerEscolhido.setTamanho(alimentoView.setAlimentoTamanho());
				hamburguerEscolhido.setObservacao(alimentoView.setAlimentoObservacoes());
				alimentoFiltrado.clear();
				return hamburguerEscolhido;
				
			} else if(alimentoFiltrado.get(option) instanceof Pizza) {
				Pizza pizzaEscolhida = new Pizza(null, null, alimentoFiltrado.get(option).getNome(), alimentoFiltrado.get(option).getValor(), null, null, null);			
				pizzaController.pizzaExtras(pizzaEscolhida);
				pizzaEscolhida.setTamanho(alimentoView.setAlimentoTamanho());
				pizzaEscolhida.setObservacao(alimentoView.setAlimentoObservacoes());
				alimentoFiltrado.clear();
				return pizzaEscolhida;
				
			} else if(alimentoFiltrado.get(option) instanceof CachorroQuente) {
				CachorroQuente cachorroEscolhido = new CachorroQuente(0, null,alimentoFiltrado.get(option).getNome(), alimentoFiltrado.get(option).getValor(), null, null, null);			
				cachorroController.cachorroExtras(cachorroEscolhido);
				cachorroEscolhido.setTamanho(alimentoView.setAlimentoTamanho());
				cachorroEscolhido.setObservacao(alimentoView.setAlimentoObservacoes());
				alimentoFiltrado.clear();
				return cachorroEscolhido;
				
			} else if(alimentoFiltrado.get(option) instanceof Marmita) {
				Marmita marmitaEscolhida = new Marmita(null, null, null, null, alimentoFiltrado.get(option).getNome(), alimentoFiltrado.get(option).getValor(), null, null, null);	
				marmitaController.marmitaExtras(marmitaEscolhida);
				marmitaEscolhida.setTamanho(alimentoView.setAlimentoTamanho());
				marmitaEscolhida.setObservacao(alimentoView.setAlimentoObservacoes());
				alimentoFiltrado.clear();
				return marmitaEscolhida;
				
			} else if(alimentoFiltrado.get(option) instanceof Sushi) {
				Sushi sushiEscolhido = new Sushi(null, alimentoFiltrado.get(option).getNome(), alimentoFiltrado.get(option).getValor(), null, null, null);
				sushiController.sushiExtras(sushiEscolhido);
				sushiEscolhido.setTamanho(alimentoView.setAlimentoTamanho());
				sushiEscolhido.setObservacao(alimentoView.setAlimentoObservacoes());
				alimentoFiltrado.clear();
				return sushiEscolhido;
			}
		}
		alimentoFiltrado.clear();
		return null;
	}
}

