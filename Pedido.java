package model;

public class Pedido {	
	private Restaurante restaurante;
	private Usuario usuario;
	private Transportador transportador;
	private Alimento alimento;
	private double valor;
	private Boolean status;
	
	 public Pedido(Restaurante restaurante, Usuario usuario, Transportador transportador, Alimento alimento, Double valor, Boolean status) {
		 this.restaurante = restaurante;
		 this.usuario = usuario;
		 this.transportador = transportador;
		 this.alimento = alimento;
		 this.valor = valor;
		 this.status = status;
	 }
	 
	 public Restaurante getRestaurante() {
		 return this.restaurante;		
	 }
	 
	 public void setRestaurante(Restaurante restaurante) {
		 this.restaurante = restaurante;
	 }
	 
	 public Usuario getUsuario() {
		 return this.usuario;		
	 }
	 
	 public void setUsuario(Usuario usuario) {
		 this.usuario = usuario;
	 }
	 
	 public Transportador getTransportador() {
		 return this.transportador;		
	 }
	 
	 public void setTransportador(Transportador transportador) {
		 this.transportador = transportador;
	 }
	 
	 public Alimento getAlimento() {
		 return this.alimento;		
	 }
	 
	 public void setAlimento(Alimento alimento) {
		 this.alimento = alimento;
	 }
	 
	 public double getValor() {
		 return this.valor;		
	 }
	 
	 public void setValor(double valor) {
		 this.valor = valor;
	 }
	 
	 public Boolean getStatus() {
		 return this.status;		
	 }
	 
	 public void setStatus(Boolean status) {
		 this.status = status;
	 }
}
