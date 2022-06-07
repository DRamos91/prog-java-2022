package br.com.senaisp.aula26.classes;

import java.util.List;

public class Produto {

	private String descricao;
	private int codigo;
	private double preco;
	private List<Produto> listaProdutos;

	public Produto() {
		super();
		ConexaoFake fake = ConexaoFake.getInstance();
		listaProdutos = fake.getListaProdutos();
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void novo() {
		codigo = 0;
		descricao = "";
		preco = 0;
	}

	public void adicionar() {
		int intId = pesqProduto(this.codigo);
		if (intId == -1) {
			// Criando o objeto produto para adicionar as informaçoes
			Produto prod = new Produto();
			// Setando os dados para o novo objeto
			prod.setCodigo(codigo);
			prod.setDescricao(descricao);
			prod.setPreco(preco);
			// Colocando o objeto na lista
			listaProdutos.add(prod);
		} else {
			System.out.println("Já existe esse produto!");
		}
	}

	public boolean hasCodigo(int value) {
		return pesqProduto(value) != -1;
	}

	private int pesqProduto(int codigo) {
		int intRet = -1;
		for (int i = 0; i < listaProdutos.size(); i++) {
			if (listaProdutos.get(i).getCodigo() == codigo) {
				intRet = i;
				break;
			}
		}
		return intRet;
	}

	public int getListaSize() {
		return listaProdutos.size();
	}

	public void alterar() {
		int intId = pesqProduto(codigo);
		if (intId > -1) {
			Produto prod = listaProdutos.get(intId);
			prod.setDescricao(descricao);
			prod.setPreco(preco);
		} else {
			System.out.println("Produto não cadastrado!");
		}
	}

	public void excluir() {
		int intId = pesqProduto(codigo);
		if (intId > -1) {
			listaProdutos.remove(intId);
		} else {
			System.out.println("Produto não cadastrado!");
		}
	}

	public void consultar() {
		int intId = pesqProduto(codigo);
		if (intId > -1) {
			Produto prod = listaProdutos.get(intId);
			descricao = prod.getDescricao();
			preco = prod.getPreco();
		} else {
			System.out.println("Cliente não cadastrado!");
		}
	}

	public void mostrarProduto() {
		System.out.println("Codigo........: " + codigo);
		System.out.println("Descrição.....: " + descricao);
		System.out.println("Valor.........: " + preco);
	}
}
