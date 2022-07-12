package model;

public class Marmita extends Alimento {	
	private String tipo_carne;	
	private String massa;
	private Boolean salada;	
	
	 public Marmita(String tipo_carne, String pre_aquecido, String massa, Boolean salada,  String nome, double valor, String tamanho, String observacoes, Cardapio cardapio) {
		 super(nome, valor, tamanho, observacoes, cardapio);		 	
		 	this.tipo_carne = tipo_carne;
		 	this.massa = massa;
		 	this.salada = salada;
	    }	 
	    
	    public void setTipoCarne(String tipo_carne) {
	        this.tipo_carne = tipo_carne;
	    }
	    
	    public String getTipoCarne() {
	        return this.tipo_carne;
	    }
	    
	    public void setMassa(String massa) {
	        this.massa = massa;
	    }
	    
	    public String getMassa() {
	        return this.massa;
	    }
	    
	    public void setSalada(Boolean salada) {
	        this.salada = salada;
	    }
	    
	    public String getSalada() {
	        return this.salada ? "Sim" : "Não" ;
	    }	
}
