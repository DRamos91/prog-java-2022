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
			System.out.println("Menu de opcões:");
			System.out.println("1 - Cadastramento de funcionários");
			System.out.println("2 - Lista de funcionários");
			System.out.println("3 - Alteração de funcionários");
			System.out.println("4 - Exclusão de funcionários");
			System.out.println("5 - Lançamento na folha");
			System.out.println("6 - Listagem da folha");
			System.out.println("7 - Exclusão Lançamento da folha");
			System.out.println("9 - Lançamento na folha");
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
		System.out.println("# - Chapa - Salário Líquido");
		for (int i=0; i<LIMITE_FUNCIONARIOS; i++) {
			if(listaFolha[i]!=null) {
				System.out.println(i + " - " + listaFolha[i].getChapa() + " - " + listaFolha[i].salarioLiquido());
			}
		}
		
	}

	private static void lancamentoFolha(FolhaPagamento[] listaFolha, Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Lançamento na folha");
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
			System.out.println("Digite a chapa do funcionário: ");
			int intChapa = sc.nextInt();
			sc.nextLine();
			intIdFunc = pesqFunc(listaFuncionario, intChapa);
			if (intIdFunc == -1) {
				System.out.println("Funcionario não existe!");
				continue;
			}
			if (pesqLancto(listaFolha, intChapa) > -1) {
				System.out.println("Lançamento da folha do funcionário já existe!");
				continue;
			}
			try {
				folhaPagamento.setChapa(intChapa);
				//Colocando o salário bruto através do salário do funcionário cadastrado
				folhaPagamento.setSalarioBruto(listaFuncionario[intIdFunc].getSalario());
				//Criando os objetos de impostos para serem calculados
				ImpostoInss inss = new ImpostoInss();
				ImpostoIrrf irrf = new ImpostoIrrf();
				//Setando a base de calculo do inss pelo salário bruto informado
				inss.setBaseCalculo(folhaPagamento.getSalarioBruto());
				//Setando o valor do inss na folha de pagamento
				folhaPagamento.setValorInss(inss.calcularImposto());
				//Setando a base de calculo do IRRF através do salário bruto na folha - o valor do inss calculado
				irrf.setBaseCalculo(folhaPagamento.getSalarioBruto() - folhaPagamento.getValorInss());
				//Informando o numero de dependentes do funcionario
				irrf.setNrDependentes(listaFuncionario[intIdFunc].getNrDependentes());
				//Setando o irrf calculado na folha
				folhaPagamento.setValorIrrf(irrf.calcularImposto());
				//Mostrando o salário líquido
				System.out.println("Salário líquido: " + folhaPagamento.salarioLiquido());
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
		System.out.println("Exclusão de funcionários");
		int intFun = pesquisarFuncionario(listaFuncionario, sc);
		if (intFun > -1) {
			mostrarFuncionario(listaFuncionario[intFun]);
			System.out.println("--------------------------");
			System.out.println("Deseja excluir? (1-Sim/2-Não");
			int intOpc = sc.nextInt();
			if (intOpc == 1) {
				listaFuncionario[intFun] = null;
			}
			sc.nextLine();
		} else {
			System.out.println("Funcionário não encontrado!");
		}

	}

	private static void alteracaoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Alteração de funcionários");
		int intFun = pesquisarFuncionario(listaFuncionario, sc);
		if (intFun > -1) {
			mostrarFuncionario(listaFuncionario[intFun]);
			System.out.println("--------------------------");
			manutencaoFuncionario(listaFuncionario[intFun], sc, listaFuncionario);
		} else {
			System.out.println("Funcionário não encontrado!");
		}
	}

	private static void mostrarFuncionario(Funcionario funcionario) {
		System.out.println("Chapa do funcionário................ : " + funcionario.getChapa());
		System.out.println("Nome do funcionário................. : " + funcionario.getNome());
		System.out.println("Endereço do funcionário............. : " + funcionario.getEndereco());
		System.out.println("Numero de dependentes do funcionário : " + funcionario.getNrDependentes());
		System.out.println("Sálario do funcionário.............. : " + funcionario.getSalario());
	}

	private static int pesquisarFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		int intRet = -1;
		System.out.print("Digite o número da chapa a ser pesquisada: ");
		int intChapa = sc.nextInt();
		sc.nextLine();

		return pesqFunc(listaFuncionario, intChapa);
	}

	/**
	 * Função para pesquisar se encontra uma chapa na lsta de funcionarios
	 * 
	 * @param listaFuncionario Deve -se passsar a lista de funcionarios
	 * @param intChapa         Deve - se passar a chapa a ser pesquisada
	 * @return Retorna o índice onde se encontra a chapa ou -1 se não encontrou o
	 *         funcionário com a chapa informada.
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
		System.out.println("Listagem de funcionários");
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
		// Encontrando o item livre da lista para cadastrar o funcionário.
		int intDisp = -1;
		for (int i = 0; i < listaFuncionario.length; i++) {
			if (listaFuncionario[i] == null) {
				intDisp = i;
				break;
			}
		}
		// Inicio do cadastro
		System.out.println("Cadastramento de funcionário");
		if (intDisp > -1) {
			// Criando o objeto do funcionário
			listaFuncionario[intDisp] = new Funcionario();
			// Chamando o método de cadastramento
			manutencaoFuncionario(listaFuncionario[intDisp], sc, listaFuncionario);
		} else {
			System.out.println("Não há espaço para cadastrar funcionário!");
		}
	}

	private static void manutencaoFuncionario(Funcionario funcionario, Scanner sc, Funcionario[] listaFuncionario) {
		// TODO Auto-generated method stub
		do {
			System.out.print("Digite a chapa do funcionário: ");
			try {
				int intNrChapa = sc.nextInt();
				// Se a chapa digitada for diferente da chapa que o funcionário tem no objeto
				// posicionado,
				// tenho que pesquisar se já existe um funcionário com essa chapa. Se existir,
				// deverá usar outra chapa.
				if (intNrChapa != funcionario.getChapa()) {
					if (pesqFunc(listaFuncionario, intNrChapa) != -1) {
						System.out.println("Chapa já existe para um funcionário! Digite outra chapa!");
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
		// Nome do funcionário
		do {
			System.out.print("Digite o nome do funcionário: ");
			try {
				funcionario.setNome(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		// Endereço do funcionário
		do {
			System.out.print("Digite o endereço do funcionário: ");
			try {
				funcionario.setEndereco(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		} while (true);
		// Numero de dependentes do funcionário
		do {
			System.out.print("Digite o número de dependentes do funcionário: ");
			try {
				funcionario.setNrDependentes(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException)
					sc.nextLine();
			}
		} while (true);
		// Salário do funcionário
		do {
			System.out.print("Digite o salário do funcionário: ");
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
