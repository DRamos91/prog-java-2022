package br.com.daniel.clinica.classes;

import java.util.List;

public class CadastroPacientes {

	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private int idade;
	private List<CadastroPacientes> listaClientes;
	
	public CadastroPacientes() {
		super();
		ConexaoBd Bd = ConexaoBd.getInstance();
		listaClientes = Bd.getListaCliente();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
			//throws Exception {
//		if(id<=0) {
	//		throw new Exception("ID deve ser maior que 0!");
//		}
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void adicionar() throws Exception {
		int intId = pesqCliente(this.id);
		if (intId == -1) {
			// Criando o objeto cliente para adicionar as informa�oes
			CadastroPacientes cli = new CadastroPacientes();
			// Setando os dados para o novo objeto
			cli.setId(id);
			cli.setNome(nome);
			cli.setEndereco(endereco);
			cli.setIdade(idade);
			cli.setEmail(email);
			cli.setTelefone(telefone);
			// Colocando o objeto na lista
			listaClientes.add(cli);
		} else {
			System.out.println("J� existe esse cliente!");
		}
	}

	private int pesqCliente(int codigo) {
		int intRet = -1;
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getId() == codigo) {
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
			CadastroPacientes cli = listaClientes.get(i);
			System.out.print(i + " - ");
			System.out.print(cli.getId() + " - ");
			System.out.print(cli.getNome());
			System.out.println();
		}
	}

	public int getListaSize() {
		return listaClientes.size();
	}

	public void alterar() {
		int intId = pesqCliente(id);
		if (intId > -1) {
			CadastroPacientes cli = listaClientes.get(intId);
			cli.setNome(nome);
			cli.setEndereco(endereco);
		} else {
			System.out.println("Cliente n�o cadastrado!");
		}
	}

	public void excluir() {
		int intId = pesqCliente(id);
		if (intId > -1) {
			listaClientes.remove(intId);
		} else {
			System.out.println("Cliente n�o cadastrado!");
		}
	}

	public void consultar() {
		int intId = pesqCliente(id);
		if (intId > -1) {
			CadastroPacientes cli = listaClientes.get(intId);
			nome = cli.getNome();
			endereco = cli.getEndereco();
		} else {
			System.out.println("Cliente n�o cadastrado!");
		}
	}

	public void mostrarCliente() {
		System.out.println("Codigo...: " + id);
		System.out.println("Nome.....: " + nome);
		System.out.println("Endere�o.: " + endereco);
		System.out.println("Idade....: " + idade);
		System.out.println("Telefone.: " + telefone);
		System.out.println("Email....: " + email);
	}
}
