package model;

public class Endereco {
	private String cidade;
	private String bairro;
	private String cep;
	private String rua;
	private int numero;
	private String detalhes;
	
	public Endereco(String cidade, String bairro, String cep, String rua, int numero, String detalhes) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.detalhes = detalhes;
	}
	
	 public String getCidade() {
		 return this.cidade;		
	 }
	 
	 public void setCidade(String cidade) {
		 this.cidade = cidade;
	 }
	 
	 public String getBairro() {
		 return this.bairro;		
	 }
	 
	 public void setBairro(String bairro) {
		 this.bairro = bairro;
	 }	 
	 
	 public String getCep() {
		 return this.cep;		
	 }	 	 

	 public void setCep(String cep) {
		 this.cep = cep;		
	 }
	 
	 public String getRua() {
		 return this.rua;		
	 }	 	 

	 public void setRua(String rua) {
		 this.rua = rua;		
	 }
	 
	 public int getNumero() {
		 return this.numero;		
	 }	 	 

	 public void setNumero(int numero) {
		 this.numero = numero;		
	 }
	 
	 public String getDetalhes() {
		 return this.detalhes;
	 }
	 
	 public void setDetalhes(String detalhes) {
		 this.detalhes = detalhes;
	 }
}
