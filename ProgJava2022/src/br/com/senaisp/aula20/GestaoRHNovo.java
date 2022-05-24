package br.com.senaisp.aula20;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.senaisp.aula18.classes.Funcionario;
import br.com.senaisp.aula19.classes.FolhaPagamento;

public class GestaoRHNovo {
	// Definindo objetos globais
	private static List<Funcionario> listaFuncionario;
	private static List<FolhaPagamento> listaFolha;
	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Inicializando objetos
		listaFuncionario = new ArrayList<Funcionario>();
		listaFolha = new ArrayList<FolhaPagamento>();
		sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		int intOpc;

		do {
			System.out.println("Menu de opc�es:");
			System.out.println("1 - Cadastramento de funcion�rios");
			System.out.println("2 - Lista de funcion�rios");
			System.out.println("3 - Altera��o de funcion�rios");
			System.out.println("4 - Exclus�o de funcion�rios");
			System.out.println("5 - Lan�amento na folha");
			System.out.println("6 - Listagem da folha");
			System.out.println("7 - Exclus�o Lan�amento da folha");
			System.out.println("9 - Fim");
			intOpc = sc.nextInt();
			sc.nextLine();

			switch (intOpc) {
			case 1:
				cadastramentoFuncionario();
				break;
			case 2:
				listagemFuncionario();
				break;
			case 3:
				alteracaoFuncionario();
				break;
			case 4:
				exclusaoFuncionario();
				break;
			case 5:
				lancamentoFolha();
				break;
			case 6:
				listagemFolha();
				break;
			case 7:
				exclusaoFolha();
				break;
			}
			System.out.println("Pressione enter para voltar ao menu");
			sc.nextLine();

		} while (intOpc != 9);

	}

	private static void exclusaoFolha() {
		// TODO Auto-generated method stub

	}

	private static void listagemFolha() {
		// TODO Auto-generated method stub

	}

	private static void lancamentoFolha() {
		// TODO Auto-generated method stub

	}

	private static void exclusaoFuncionario() {
		// TODO Auto-generated method stub

	}

	private static void alteracaoFuncionario() {
		// TODO Auto-generated method stub

	}

	private static void listagemFuncionario() {
		// TODO Auto-generated method stub

	}

	private static void cadastramentoFuncionario() {
		System.out.println("Cadastramento de funcion�rio");
		// Criando o objeto do funcion�rio
		Funcionario fun = new Funcionario();
		// Chamando o m�todo de cadastramento
		manutencaoFuncionario(fun);
		// Adicionando na lista Funcionarios
		listaFuncionario.add(fun);
	}

	private static void manutencaoFuncionario(Funcionario funcionario) {
		do {
			System.out.print("Digite a chapa do funcion�rio: ");
			try {
				int intNrChapa = sc.nextInt();
				// Se a chapa digitada for diferente da chapa que o funcion�rio tem no objeto
				// posicionado,
				// tenho que pesquisar se j� existe um funcion�rio com essa chapa. Se existir,
				// dever� usar outra chapa.
				if (intNrChapa != funcionario.getChapa()) {
					if (pesqFunc(intNrChapa) != -1) {
						System.out.println("Chapa j� existe para um funcion�rio! Digite outra chapa!");
						continue;
					}
				}
				funcionario.setChapa(intNrChapa);
				sc.nextLine();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException)
					sc.nextLine();
			}
		} while (true);
		// Nome do funcion�rio
		do {
			System.out.print("Digite o nome do funcion�rio: ");
			try {
				funcionario.setNome(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		// Endere�o do funcion�rio
		do {
			System.out.print("Digite o endere�o do funcion�rio: ");
			try {
				funcionario.setEndereco(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		} while (true);
		// Numero de dependentes do funcion�rio
		do {
			System.out.print("Digite o n�mero de dependentes do funcion�rio: ");
			try {
				funcionario.setNrDependentes(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException)
					sc.nextLine();
			}
		} while (true);
		// Sal�rio do funcion�rio
		do {
			System.out.print("Digite o sal�rio do funcion�rio: ");
			try {
				funcionario.setSalario(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException)
					sc.nextLine();
			}
		} while (true);
		sc.nextLine();

	}

	private static int pesqFunc(int intChapa) {
		int intRet = -1;
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getChapa() == intChapa) {
				intRet = i;
				break;
			}
		}
		return intRet;
	}

}
