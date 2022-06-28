package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteLeituraProduto {

	public static void main(String[] args) {
		Produto prod = new Produto();
		// Indicando o produto a ser pesquisado
		prod.setId(1);
		// Verificando se o produto existe
		if (prod.read()) {
			System.out.println("Encontrei o produto!");
			System.out.println("Descricao: " + prod.getDescricao());
			System.out.println("Saldo: " + prod.getSaldo());
			System.out.println("Preço: " + prod.getPreco());
			System.out.println("Local no estoque: " + prod.getLocal_estoque());
		} else {
			System.out.println("Não foi encontrado o produto!");
			if (prod.isHaErro()) {
				System.out.println("Há erro no BD!");
				System.out.println(prod.getMsgErro());
			}
		}
	}

}
