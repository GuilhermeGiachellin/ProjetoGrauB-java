package model;

public class Cliente extends Usuario{
	private String cpf;
	private String sobrenome;
	
	public Cliente(String nome, String senha, String email, Endereco endereco, String telefone, String cpf, String sobrenome) {
		super(nome,  senha, email, endereco, telefone);	
		this.cpf = cpf;
		this.sobrenome = sobrenome;
	}
	
	 public String getCpf() {
		 return this.cpf;		
	 }
	 
	 public void setCpf(String cpf) {
		 this.cpf = cpf;
	 }	 
	 
	 public String getSobrenome() {
		 return this.sobrenome;		
	 }	 	 

	 public void setSobrenome(String sobrenome) {
		 this.sobrenome = sobrenome;		
	 }
}
