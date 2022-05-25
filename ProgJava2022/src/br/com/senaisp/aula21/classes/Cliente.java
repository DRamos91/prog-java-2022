package br.com.senaisp.aula21.classes;

import java.util.List;

import br.com.senaisp.aula22.classes.ConexaoFake;

public class Cliente {

	private List<Cliente> listaClientes;
	private int codigo;
	private String nome;
	private String endereco;

	public Cliente() {
		super();
		ConexaoFake fake = ConexaoFake.getInstance();
		// listaClientes = new ArrayList<Cliente>();
		listaClientes = fake.getListaCliente();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void adicionar() {
		int intId = pesqCliente(this.codigo);
		if (intId == -1) {
			// Criando o objeto cliente para adicionar as informaçoes
			Cliente cli = new Cliente();
			// Setando os dados para o novo objeto
			cli.setCodigo(codigo);
			cli.setNome(nome);
			cli.setEndereco(endereco);
			// Colocando o objeto na lista
			listaClientes.add(cli);
		} else {
			System.out.println("Já existe esse cliente!");
		}
	}

	private int pesqCliente(int codigo) {
		int intRet = -1;
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getCodigo() == codigo) {
				intRet = i;
				break;
			}
		}
		return intRet;
	}

	public void listarClientes() {
		System.out.println("Listagem clientes");
		System.out.println("# - Codigo - Nome");
		System.out.println("--------------------");
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente cli = listaClientes.get(i);
			System.out.print(i + " - ");
			System.out.print(cli.getCodigo() + " - ");
			System.out.print(cli.getNome() + " - ");
			System.out.println(cli.toString() + " - " + cli.getListaSize());
		}
	}

	public int getListaSize() {
		return listaClientes.size();
	}

	public void alterar() {
		int intId = pesqCliente(codigo);
		if (intId > -1) {
			Cliente cli = listaClientes.get(intId);
			cli.setNome(nome);
			cli.setEndereco(endereco);
		} else {
			System.out.println("Cliente não cadastrado!");
		}
	}

	public void excluir() {
		int intId = pesqCliente(codigo);
		if (intId > -1) {
			listaClientes.remove(intId);
		} else {
			System.out.println("Cliente não cadastrado!");
		}
	}

	public void consultar() {
		int intId = pesqCliente(codigo);
		if (intId > -1) {
			Cliente cli = listaClientes.get(intId);
			nome = cli.getNome();
			endereco = cli.getEndereco();
		} else {
			System.out.println("Cliente não cadastrado!");
		}
	}

	public void mostrarCliente() {
		System.out.println("Codigo...: " + codigo);
		System.out.println("Nome.....: " + nome);
		System.out.println("Endereço.: " + endereco);
	}
}
