package model;

public class Hamburguer extends Alimento{
	/*mudei sabor para tipo parece faze mais sentido sei la*/ 
    private String tipo_carne;
    private int qtd_hamburguer;

    public Hamburguer(String tipo_carne, int qtd_hamburguer, String nome, double valor, String tamanho, String observacoes, Cardapio cardapio) { 
    	super(nome, valor, tamanho, observacoes, cardapio);
    
    	this.tipo_carne = tipo_carne;
    	this.qtd_hamburguer = qtd_hamburguer;    	
    }

    public void setTipoCarne(String tipo_carne) {
        this.tipo_carne = tipo_carne;
    }
    
    public String getTipoCarne() {
        return this.tipo_carne;
    }
    
    public void setQtd_hamburguer(int qtd_hamburguer) {
        this.qtd_hamburguer = qtd_hamburguer;
    }
    
    public int getQtd_hamburguer() {
        return this.qtd_hamburguer;
    }
}
