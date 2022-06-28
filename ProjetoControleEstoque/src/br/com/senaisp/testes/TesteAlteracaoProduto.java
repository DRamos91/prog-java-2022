package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteAlteracaoProduto {

	public static void main(String[] args) {
		Produto prod = new Produto();
		//Setando o id para pesquisar
		prod.setId(1);
		//Pesquisando
		if(prod.read()) {
			//Agora podemos alterar
			System.out.println("Produto encontrado!");
			//Alterando os dados
			prod.setDescricao("Produto 1 - Alterado");
			prod.setPreco(30.00);
			//Executando a altera��o
			if(prod.update()) {
				System.out.println("Altera��o efetuada com sucesso!");
			}else {
				System.out.println("Problemas ao alterar!");
				System.out.println("Erro: " + prod.getMsgErro());
			}
		}

	}

}
