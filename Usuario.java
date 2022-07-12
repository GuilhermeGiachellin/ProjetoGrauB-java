package model;

public class Usuario {
	private String nome;	
	private String senha;	
	private String email;
	private String telefone;
	private Endereco endereco;
	
	 public Usuario(String nome, String senha, String email, Endereco endereco, String telefone) {
		 this.nome = nome;		 
		 this.senha = senha;		 
		 this.email = email;
		 this.endereco = endereco;
		 this.telefone = telefone;
	 }
	 
	 public String getNome() {
		 return this.nome;		
	 }
	 
	 public void setNome(String nome) {
		 this.nome = nome;
	 }	
	 
	 public String getSenha() {
		 return this.senha;		
	 }
	 
	 public void setSenha(String senha) {
		 this.senha = senha;
	 }
	
	 
	 public String getEmail() {
		 return this.email;		
	 }
	 
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 
	 public Endereco getEndereco() {
		 return this.endereco;		
	 }
	 
	 public void setEndereco(Endereco endereco) {
		 this.endereco = endereco;
	 }
	 
	 public String getTelefone() {
		 return this.telefone;		
	 }
	 
	 public void setTelefone(String telefone) {
		 this.telefone = telefone;
	 }	
}
