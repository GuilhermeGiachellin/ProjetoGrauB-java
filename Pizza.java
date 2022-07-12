package model;
//implements a interface pizza2 EXIGE que os methods implementados em pizza
public class Pizza extends Alimento implements PizzaInterface {   
    private String tipo_borda;
    private String espessura_massa;


    public Pizza(String tipo_borda, String espessura_massa,  String nome, double valor, String tamanho, String observacoes, Cardapio cardapio) {
    	super(nome, valor, tamanho, observacoes, cardapio);    	
    	this.tipo_borda = tipo_borda;
    	this.espessura_massa = espessura_massa;
    }

    public void setTipoDeBorda(String tipo_borda) {
        this.tipo_borda = tipo_borda;
    }
    
    public String getTipoDeBorda() {
        return this.tipo_borda;
    }
    
    public void setEspessuraMassa(String espessura_massa) {
        this.espessura_massa = espessura_massa;
    }
    
    public String getEspessuraMassa() {
        return this.espessura_massa;
    }
}