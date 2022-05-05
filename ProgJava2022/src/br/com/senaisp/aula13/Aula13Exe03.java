package br.com.senaisp.aula13;

import java.util.Scanner;

public class Aula13Exe03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String strDados[][] = new String[10][2];
		int intOpc;
		// Inicializando a matriz
		for (int i = 0; i < 10; i++)
			strDados[i][1] = "*";

		do {
			// Monstrar menu de opções
			montagemTela();
			intOpc = sc.nextInt();

			int intDisponivel;
			switch (intOpc) {
			case 1:
				System.out.println();
				System.out.println("Cadastrar novo cliente");
				intDisponivel = -1;
				for (int i = 0; i < 10; i++) {
					if (strDados[i][1].equals("*")) {
						intDisponivel = i;
						break; // quebrando o laço de repetição
					}
				}
				sc.nextLine();
				if (intDisponivel > -1) {
					System.out.print("Digite o nome a ser cadastrado: ");
					strDados[intDisponivel][0] = sc.nextLine();
					strDados[intDisponivel][1] = "";

					System.out.println("Cadastrado com sucesso! Seu ID é: " + intDisponivel);
				} else {
					System.out.println("Sem espaço para cadastramento!");

				}
				System.out.println("Digite enter para voltar ao menu");
				System.out.println();
				sc.nextLine();
				break; // break do case

			case 2: // Consulta dos clientes pelo ID
				System.out.println("Consultar cliente pelo ID");
				sc.nextLine();
				System.out.print("Digite o ID do cliente a ser buscado: ");
				intDisponivel = sc.nextInt();
				if (intDisponivel >= 0 && intDisponivel < 10 && strDados[intDisponivel][1].equals("")) {
					System.out.println("Nome encontrado!");
					System.out.println("Nome: " + strDados[intDisponivel][0]);
				} else {
					System.out.println("Nome não encontrado!");
				}
				sc.nextLine();
				System.out.println("Digite enter para voltar ao menu");
				sc.nextLine();
				break;
				
			case 3: // Alterar clientes pelo ID
				System.out.println("Alterar cliente pelo ID");
				sc.nextLine();
				System.out.print("Digite o ID do cliente a ser alterado: ");
				intDisponivel = sc.nextInt();
				if (intDisponivel >= 0 && intDisponivel < 10 && strDados[intDisponivel][1].equals("")) {
					System.out.println("Nome encontrado!");
					System.out.println("Nome: " + strDados[intDisponivel][0]);
				} else {
					System.out.println("Nome não encontrado!");
				}
				System.out.println("Digite enter para voltar ao menu");
				sc.nextLine();
				break;

			case 5: // Listagem dos clientes
				System.out.println("Lista de cadastros: ");
				for (int i = 0; i < 10; i++) {
					if (strDados[i][1].equals("")) {
						System.out.println(i + " - " + strDados[i][0]);
					}
				}
				System.out.println("Digite enter para voltar ao menu");
				System.out.println();
				sc.nextLine();
				break;

			}
		} while (intOpc != 9);

	}

	public static void montagemTela() {
		System.out.println("Menu");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar pelo ID");
		System.out.println("3 - Alterar pelo ID");
		System.out.println("4 - Excluir pelo ID");
		System.out.println("5 - Listar em ordem de ID");
		System.out.println("9 - Fim do programa");
		System.out.print("Esolha uma das opções a cima: ");

	}
}
