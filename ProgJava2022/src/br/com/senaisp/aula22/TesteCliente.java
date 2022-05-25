package br.com.senaisp.aula22;

import br.com.senaisp.aula21.classes.Cliente;

public class TesteCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		//Gerando 10 clientes aleatoriamente
		for (int i = 0; i<10; i++) {
			cli.setCodigo(i + 1);
			cli.setNome("Genérico " + (i + 1));
			cli.setEndereco("Rua " + (i + 1));
			cli.adicionar();
		}
		cli.listarClientes();
		//Alterar o cliente 5
		cli.setCodigo(5);
		cli.consultar();
		cli.mostrarCliente();
		//Alterando somente o nome do cliente 5
		cli.setNome("Generico 5 alterado");
		cli.alterar();
		System.out.println("----------------");
		cli.listarClientes();
		System.out.println("----------------");
		//Excluindo o cliente 4
		cli.setCodigo(4);
		cli.consultar();
		cli.mostrarCliente();
		cli.excluir();
		System.out.println("----------------");
		cli.listarClientes();
	}

}
