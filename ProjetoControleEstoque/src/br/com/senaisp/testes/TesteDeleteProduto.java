package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteDeleteProduto {

	public static void main(String[] args) {
		
		Produto prod = new Produto();
		//Setando o id para pesquisar
		prod.setId(2);
		//Pesquisando
		if(prod.read()) {
			//Agora podemos deletar
			System.out.println("Produto encontrado!");
			//Executando a exclusão
			if(prod.delete()) {
				System.out.println("Produto excluído com sucesso!");
			}else {
				System.out.println("Problemas ao excluir!");
				System.out.println("Erro: " + prod.getMsgErro());
			}
		}else {
			System.out.println("Produto não encontrado!");
		}
	}

}
