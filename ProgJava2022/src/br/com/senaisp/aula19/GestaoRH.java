package br.com.senaisp.aula19;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import br.com.senaisp.aula17.classes.ImpostoInss;
import br.com.senaisp.aula18.classes.Funcionario;
import br.com.senaisp.aula18.classes.ImpostoIrrf;
import br.com.senaisp.aula19.classes.FolhaPagamento;

public class GestaoRH {
	public static final int LIMITE_FUNCIONARIOS = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		int intOpc = 0;
		Funcionario listaFuncionario[] = new Funcionario[LIMITE_FUNCIONARIOS];
		FolhaPagamento listaFolha[] = new FolhaPagamento[LIMITE_FUNCIONARIOS];

		do {
			System.out.println("Menu de opc�es:");
			System.out.println("1 - Cadastramento de funcion�rios");
			System.out.println("2 - Lista de funcion�rios");
			System.out.println("3 - Altera��o de funcion�rios");
			System.out.println("4 - Exclus�o de funcion�rios");
			System.out.println("5 - Lan�amento na folha");
			System.out.println("6 - Listagem da folha");
			System.out.println("7 - Exclus�o Lan�amento da folha");
			System.out.println("9 - Lan�amento na folha");
			intOpc = sc.nextInt();
			sc.nextLine();

			switch (intOpc) {
			case 1:
				cadastramentoFuncionario(listaFuncionario, sc);
				break;
			case 2:
				listagemFuncionario(listaFuncionario);
				break;
			case 3:
				alteracaoFuncionario(listaFuncionario, sc);
				break;
			case 4:
				exclusaoFuncionario(listaFuncionario, sc);
				break;
			case 5:
				lancamentoFolha(listaFolha, listaFuncionario, sc);
				break;
			case 6:
				listagemFolha(listaFolha);
				break;
			}
			System.out.println("Pressione enter para voltar ao menu");
			sc.nextLine();

		} while (intOpc != 9);
	}

	private static void listagemFolha(FolhaPagamento[] listaFolha) {
		System.out.println("Listagem da folha");
		System.out.println("# - Chapa - Sal�rio L�quido");
		for (int i=0; i<LIMITE_FUNCIONARIOS; i++) {
			if(listaFolha[i]!=null) {
				System.out.println(i + " - " + listaFolha[i].getChapa() + " - " + listaFolha[i].salarioLiquido());
			}
		}
		
	}

	private static void lancamentoFolha(FolhaPagamento[] listaFolha, Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Lan�amento na folha");
		int intDisp = -1;
		for (int i = 0; i < LIMITE_FUNCIONARIOS; i++) {
			if (listaFolha[i] == null) {
				intDisp = i;
				break;
			}
		}
		if (intDisp > -1) {
			listaFolha[intDisp] = new FolhaPagamento();
			manutencaoFolhaPagamento(listaFolha[intDisp], sc, listaFuncionario, listaFolha);
		} else {
			System.out.println("Folha de pagamento cheia!");
		}

	}

	private static void manutencaoFolhaPagamento(FolhaPagamento folhaPagamento, Scanner sc,
			Funcionario[] listaFuncionario, FolhaPagamento[] listaFolha) {
		int intIdFunc = -1;
		do {
			System.out.println("Digite a chapa do funcion�rio: ");
			int intChapa = sc.nextInt();
			sc.nextLine();
			intIdFunc = pesqFunc(listaFuncionario, intChapa);
			if (intIdFunc == -1) {
				System.out.println("Funcionario n�o existe!");
				continue;
			}
			if (pesqLancto(listaFolha, intChapa) > -1) {
				System.out.println("Lan�amento da folha do funcion�rio j� existe!");
				continue;
			}
			try {
				folhaPagamento.setChapa(intChapa);
				//Colocando o sal�rio bruto atrav�s do sal�rio do funcion�rio cadastrado
				folhaPagamento.setSalarioBruto(listaFuncionario[intIdFunc].getSalario());
				//Criando os objetos de impostos para serem calculados
				ImpostoInss inss = new ImpostoInss();
				ImpostoIrrf irrf = new ImpostoIrrf();
				//Setando a base de calculo do inss pelo sal�rio bruto informado
				inss.setBaseCalculo(folhaPagamento.getSalarioBruto());
				//Setando o valor do inss na folha de pagamento
				folhaPagamento.setValorInss(inss.calcularImposto());
				//Setando a base de calculo do IRRF atrav�s do sal�rio bruto na folha - o valor do inss calculado
				irrf.setBaseCalculo(folhaPagamento.getSalarioBruto() - folhaPagamento.getValorInss());
				//Informando o numero de dependentes do funcionario
				irrf.setNrDependentes(listaFuncionario[intIdFunc].getNrDependentes());
				//Setando o irrf calculado na folha
				folhaPagamento.setValorIrrf(irrf.calcularImposto());
				//Mostrando o sal�rio l�quido
				System.out.println("Sal�rio l�quido: " + folhaPagamento.salarioLiquido());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (true);

	}

	private static int pesqLancto(FolhaPagamento[] listaFolha, int intChapa) {
		int intRet = -1;
		for (int i = 0; i < LIMITE_FUNCIONARIOS; i++) {
			if (listaFolha[i] != null && listaFolha[i].getChapa() == intChapa) {
				intRet = i;
				break;
			}
		}
		return intRet;
	}

	private static void exclusaoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Exclus�o de funcion�rios");
		int intFun = pesquisarFuncionario(listaFuncionario, sc);
		if (intFun > -1) {
			mostrarFuncionario(listaFuncionario[intFun]);
			System.out.println("--------------------------");
			System.out.println("Deseja excluir? (1-Sim/2-N�o");
			int intOpc = sc.nextInt();
			if (intOpc == 1) {
				listaFuncionario[intFun] = null;
			}
			sc.nextLine();
		} else {
			System.out.println("Funcion�rio n�o encontrado!");
		}

	}

	private static void alteracaoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Altera��o de funcion�rios");
		int intFun = pesquisarFuncionario(listaFuncionario, sc);
		if (intFun > -1) {
			mostrarFuncionario(listaFuncionario[intFun]);
			System.out.println("--------------------------");
			manutencaoFuncionario(listaFuncionario[intFun], sc, listaFuncionario);
		} else {
			System.out.println("Funcion�rio n�o encontrado!");
		}
	}

	private static void mostrarFuncionario(Funcionario funcionario) {
		System.out.println("Chapa do funcion�rio................ : " + funcionario.getChapa());
		System.out.println("Nome do funcion�rio................. : " + funcionario.getNome());
		System.out.println("Endere�o do funcion�rio............. : " + funcionario.getEndereco());
		System.out.println("Numero de dependentes do funcion�rio : " + funcionario.getNrDependentes());
		System.out.println("S�lario do funcion�rio.............. : " + funcionario.getSalario());
	}

	private static int pesquisarFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		int intRet = -1;
		System.out.print("Digite o n�mero da chapa a ser pesquisada: ");
		int intChapa = sc.nextInt();
		sc.nextLine();

		return pesqFunc(listaFuncionario, intChapa);
	}

	/**
	 * Fun��o para pesquisar se encontra uma chapa na lsta de funcionarios
	 * 
	 * @param listaFuncionario Deve -se passsar a lista de funcionarios
	 * @param intChapa         Deve - se passar a chapa a ser pesquisada
	 * @return Retorna o �ndice onde se encontra a chapa ou -1 se n�o encontrou o
	 *         funcion�rio com a chapa informada.
	 */
	private static int pesqFunc(Funcionario[] listaFuncionario, int intChapa) {
		int intRet = -1;
		for (int i = 0; i < LIMITE_FUNCIONARIOS; i++) {
			if (listaFuncionario[i] != null && listaFuncionario[i].getChapa() == intChapa) {
				intRet = i;
				break;
			}
		}
		return intRet;
	}

	private static void listagemFuncionario(Funcionario[] listaFuncionario) {
		System.out.println("Listagem de funcion�rios");
		System.out.println("# - Chapa - Nome");
		System.out.println("----------------------");
		for (int i = 0; i < LIMITE_FUNCIONARIOS; i++) {
			if (listaFuncionario[i] != null) {
				System.out.print(i + " - ");
				System.out.print(listaFuncionario[i].getChapa() + " - ");
				System.out.println(listaFuncionario[i].getNome());
			}
		}

	}

	private static void cadastramentoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		// Encontrando o item livre da lista para cadastrar o funcion�rio.
		int intDisp = -1;
		for (int i = 0; i < listaFuncionario.length; i++) {
			if (listaFuncionario[i] == null) {
				intDisp = i;
				break;
			}
		}
		// Inicio do cadastro
		System.out.println("Cadastramento de funcion�rio");
		if (intDisp > -1) {
			// Criando o objeto do funcion�rio
			listaFuncionario[intDisp] = new Funcionario();
			// Chamando o m�todo de cadastramento
			manutencaoFuncionario(listaFuncionario[intDisp], sc, listaFuncionario);
		} else {
			System.out.println("N�o h� espa�o para cadastrar funcion�rio!");
		}
	}

	private static void manutencaoFuncionario(Funcionario funcionario, Scanner sc, Funcionario[] listaFuncionario) {
		// TODO Auto-generated method stub
		do {
			System.out.print("Digite a chapa do funcion�rio: ");
			try {
				int intNrChapa = sc.nextInt();
				// Se a chapa digitada for diferente da chapa que o funcion�rio tem no objeto
				// posicionado,
				// tenho que pesquisar se j� existe um funcion�rio com essa chapa. Se existir,
				// dever� usar outra chapa.
				if (intNrChapa != funcionario.getChapa()) {
					if (pesqFunc(listaFuncionario, intNrChapa) != -1) {
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

}
