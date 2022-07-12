package model;

public class Sushi extends Alimento {
    private String peixe;

    public Sushi(String peixe,  String nome, double valor, String tamanho, String observacoes, Cardapio cardapio) {
    	super(nome, valor, tamanho, observacoes, cardapio);
        this.peixe = peixe;
    }

    public void setTipoPeixe(String peixe) {
        this.peixe = peixe;
    }
    
    public String getTipoPeixe() {
        return this.peixe;
    }
}
