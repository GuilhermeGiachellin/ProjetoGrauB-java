package controller;

import java.util.ArrayList;

import model.Cliente;


public class ClienteController {
	public ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
	
	public void addCliente(Cliente cliente) {
		clienteList.add(cliente);
	}

}
