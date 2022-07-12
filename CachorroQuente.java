package model;

public class CachorroQuente extends Alimento {
	private int quantidadeSalsicha;
	private String tipoMolho;
	
	 public CachorroQuente(int quantidadeSalsicha, String tipoMolho, String nome, double valor, String tamanho, String observacoes, Cardapio cardapio) {
		 super(nome, valor, tamanho, observacoes, cardapio);
	        this.quantidadeSalsicha = quantidadeSalsicha;
	        this.tipoMolho = tipoMolho;	       
	    }

	    public void setMolho(String tipoMolho) {
	        this.tipoMolho = tipoMolho;
	    }
	    
	    public String getMolho() {
	        return this.tipoMolho;
	    }
	    
	    public void setQuantidadeSalsicha(int quantidadeSalsicha) {
	        this.quantidadeSalsicha = quantidadeSalsicha;
	    }
	    
	    public int getQuantidadeSalsicha() {
	        return this.quantidadeSalsicha;
	    }
}
