package model;

public class Transportador {
	private String modeloVeiculo;
	private String placaVeiculo;
	private Double valorKm;
	
	public Transportador(String modeloVeiculo, String placaVeiculo, Double valorKm) {
		this.modeloVeiculo = modeloVeiculo;
		this.placaVeiculo = placaVeiculo;
		this.valorKm = valorKm;
	}
	
	 public String getModeloVeiculo() {
		 return this.modeloVeiculo;		
	 }
	 
	 public void setModeloVeiculo(String modeloVeiculo) {
		 this.modeloVeiculo = modeloVeiculo;
	 }
	 
	 public String getPlacaVeiculo() {
		 return this.placaVeiculo;		
	 }
	 
	 public void setPlacaVeiculo(String placaVeiculo) {
		 this.placaVeiculo = placaVeiculo;
	 }	 
	 
	 public Double getValorkm() {
		 return this.valorKm;		
	 }	 	 

	 public void setValorkm(Double valorKm) {
		 this.valorKm = valorKm;		
	 }
}
