package br.com.daniel.clinica.classes;

import java.util.ArrayList;
import java.util.List;

public class ConexaoBd {
	private static ConexaoBd instancia;
	private List<CadastroPacientes> listaClientes;

	// Constructor
	private ConexaoBd() {
		listaClientes = new ArrayList<CadastroPacientes>();
	}

	public List<CadastroPacientes> getListaCliente() {
		return listaClientes;
	}

	public static synchronized ConexaoBd getInstance() {
		if (instancia == null) {
			instancia = new ConexaoBd();
		}
		return instancia;
	}
}
