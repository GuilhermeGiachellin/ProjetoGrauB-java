package model;

public class Restaurante extends Usuario{		
	private String cnpj;
	private Cardapio cardapio;
	
	public Restaurante(String nome, String senha, String email, Endereco endereco, String telefone, String cnpj, Cardapio cardapio) {
		super(nome,  senha, email, endereco, telefone);		
		this.cnpj = cnpj;
		this.cardapio = cardapio;
	}

	public String getCnpj() {
		 return this.cnpj;		
	 }
	 
	 public void setCnpj(String cnpj) {
		 this.cnpj = cnpj;
	 }	 
	 
	 public Cardapio getCardapio() {
		 return this.cardapio;		
	 }	 	 

	 public void setCardapio(Cardapio cardapio) {
		 this.cardapio = cardapio;		
	 }
}

