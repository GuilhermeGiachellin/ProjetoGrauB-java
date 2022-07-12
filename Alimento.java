package model;

public class Alimento {
	/*o alimento pertence a um cardapio entao aponta pra ele*/
	private String nome;
    private double valor; 
    private String tamanho;
    private String observacoes;
    private Cardapio cardapio;

	
	public Alimento(String nome, double valor, String tamanho, String observacoes, Cardapio cardapio) {
		this.nome = nome;
		this.valor = valor;		
		this.tamanho = tamanho;	
		this.observacoes = observacoes;
		this.cardapio = cardapio;
	}

    
    public void setNome(String nome) {
       this.nome = nome;
    }
   
    public String getNome() {
        return this.nome;
    }
	    
    public void setValor(double valor) {
        this.valor = valor;
    }
	    
    public double getValor() {
        return this.valor;
    }
	   
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
	   
    public String getTamanho() {
        return this.tamanho;
    }
    
    public void setObservacao(String observacoes) {
        this.observacoes = observacoes;
    }
	   
    public String getObservacao() {
        return this.observacoes;
    }
    
    public void setCardapio(Cardapio cardapio) {
    	this.cardapio = cardapio;
    }
    
    public Cardapio getCardapio() {
    	return this.cardapio;
    }
}

