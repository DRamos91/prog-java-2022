package br.com.senaisp.aula24.classes;

import java.util.ArrayList;
import java.util.List;

public class ConexaoFake {

	private static ConexaoFake instancia;
	private List<Produto> listaProdutos;

	// Constructor
	private ConexaoFake() {
		listaProdutos = new ArrayList<Produto>();
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public static synchronized ConexaoFake getInstance() {
		if (instancia == null) {
			instancia = new ConexaoFake();
		}
		return instancia;
	}
}
