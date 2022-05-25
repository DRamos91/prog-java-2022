package br.com.senaisp.aula22.classes;

import java.util.ArrayList;
import java.util.List;

import br.com.senaisp.aula21.classes.Cliente;

public class ConexaoFake {

	private static ConexaoFake instancia;
	private List<Cliente> listaClientes;

	// Constructor
	private ConexaoFake() {
		listaClientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getListaCliente() {
		return listaClientes;
	}

	public static synchronized ConexaoFake getInstance() {
		if (instancia == null) {
			instancia = new ConexaoFake();
		}
		return instancia;
	}
}
