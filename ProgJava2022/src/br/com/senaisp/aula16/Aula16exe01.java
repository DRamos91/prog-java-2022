package br.com.senaisp.aula16;

import java.util.Scanner;

import br.com.senaisp.aula16.classes.Clientes;
import br.com.senaisp.aula16.classes.ParametroInvalidoException;

public class Aula16exe01 {
	public static final int LIMITE_CLIENTE = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clientes cliVetor[] = new Clientes[LIMITE_CLIENTE];
		Scanner sc = new Scanner(System.in);
		int intOpc;
		do {
			System.out.println("Menu");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Consultar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			System.out.println("5 - Listar");
			System.out.println("9 - Fim do programa");
			System.out.print("Esolha uma das op��es a cima: ");
			intOpc = sc.nextInt();
			sc.nextLine();
			switch (intOpc) {
			case 1:
				cadastrarCliente(cliVetor, sc);
				break;
			case 2:
				System.out.println("Consulta de clientes");
				consultaCliente(cliVetor, sc);
				break;
			case 3:
				alterarCliente(cliVetor, sc);
				sc.nextLine();
				break;
			case 4:
				excluirCliente(cliVetor, sc);
				break;
			case 5:
				listarCliente(cliVetor, sc);
				break;
			}
			System.out.println("Tecle enter para continuar");
			sc.nextLine();
		} while (intOpc != 9);

	}

	private static void listarCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Lista de clientes");
		System.out.println("#  - Cod - Nome");
		for (int i = 0; i < LIMITE_CLIENTE; i++) {
			if (cliVetor[i] != null) {
				System.out.print(String.format("%-3s", i + ""));
				System.out.print("-  ");
				System.out.print(String.format("%-3s", cliVetor[i].getCodigo() + ""));
				System.out.println("- " + cliVetor[i].getNome());
			}
		}

	}

	private static void excluirCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Exclus�o de cliente");
		int intCod = consultaCliente(cliVetor, sc);
		if (intCod > -1) {
			System.out.println("Deseja excluir? (1-sim, 2-n�o)");
			int intRes = sc.nextInt();
			if (intRes == 1) {
				cliVetor[intCod] = null;
				System.out.println("Cliente exclu�do com sucesso!");

			}

		}

	}

	private static void alterarCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Altera��o de cliente");
		int intCod = consultaCliente(cliVetor, sc);
		if (intCod > -1)
			efetuarCadastro(cliVetor[intCod], sc);

	}

	private static int consultaCliente(Clientes[] cliVetor, Scanner sc) {
		int intRet = -1;
		int intCod;
		System.out.print("Digite o c�digo a ser pesquisado: ");
		intCod = sc.nextInt();
		for (int i = 0; i < LIMITE_CLIENTE; i++) {
			if (cliVetor[i] != null && cliVetor[i].getCodigo() == intCod) {
				intRet = i;
				System.out.println("Cliente encontrado!");
				System.out.println("C�digo  : " + cliVetor[i].getCodigo());
				System.out.println("Nome    : " + cliVetor[i].getNome());
				System.out.println("Endere�o: " + cliVetor[i].getEndereco());

				break;
			}
		}
		if (intCod == -1) {
			System.out.println("Cliente n�o encontrado!");
		}
		return intRet;
	}

	/**
	 * Fun��o que retorna o �ndice disponivel para cadastro do cliente, se n�o
	 * houver retorna -1.
	 * 
	 * @param cliVetor Informar o vator de clientes.
	 * @return Retorna o �ndice disponivel ou -1 se n�o houver mais espa�o para
	 *         cadastramento.
	 */
	private static int getIdLivre(Clientes[] cliVetor) {
		int intRet = -1;
		for (int i = 0; i < LIMITE_CLIENTE; i++) {
			if (cliVetor[i] == null) {
				intRet = i;
				break;
			}
		}
		return intRet;
	}

	private static void cadastrarCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Cadastramento de Clientes");
		int intLivre = getIdLivre(cliVetor);
		if (intLivre > -1) {
			// Cliente o objeto cliente e atribuindo ao vetor.
			cliVetor[intLivre] = new Clientes();
			efetuarCadastro(cliVetor[intLivre], sc);
		} else {
			System.out.println("Sem espa�o para cadastro!");
		}

	}

	private static void efetuarCadastro(Clientes clientes, Scanner sc) {
		// Entrada do c�digo
		do {
			System.out.print("Digite o c�digo do cliente: ");
			try {
				clientes.setCodigo(sc.nextInt());
				sc.nextLine();
				break;
			} catch (ParametroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		// Entrada do nome
		do {
			System.out.print("Digite o nome do cliente: ");
			try {
				clientes.setNome(sc.nextLine());
				break;
			} catch (ParametroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		// Entrada do endere�o
		do {
			System.out.print("Digite o endere�o do cliente: ");
			try {
				clientes.setEndereco(sc.nextLine());
				break;
			} catch (ParametroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		} while (true);

	}

}
