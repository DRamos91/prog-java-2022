package br.com.daniel.clinica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.daniel.clinica.classes.CadastroPacientes;

public class Application {
	private static Scanner sc;
	private static List<CadastroPacientes> listaClientes;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		listaClientes = new ArrayList<CadastroPacientes>();
		sc = new Scanner(System.in).useLocale(Locale.ENGLISH);

		int intOpc;

		do {
			System.out.println("Menu de opções");
			System.out.println("1 - Cadastramento de Pacientes");
			System.out.println("2 - Lista de Pacientes");
			System.out.println("3 - Alteração de Pacientes");
			System.out.println("4 - Exclusão de Pacientes");
			System.out.println("9 - Fim");
			intOpc = sc.nextInt();
			sc.nextLine();
			switch (intOpc) {
			case 1:
				cadastrarPaciente();
				break;
			case 2:
				listagemPaciente();
				break;
			case 3:
				alteracaoPaciente();
				break;
			case 4:
				exclusaoPaciente();
				break;

			}
			System.out.println("Pressione enter para voltar ao menu");
			sc.nextLine();
		} while (intOpc != 9);

	}

	private static void cadastrarPaciente() {
		System.out.println("Cadastramento do Paciente");
		// Criando o objeto do paciente
		CadastroPacientes cli = new CadastroPacientes();
		// Chamando o método de cadastramento
		manutencaoPaciente(cli);
		// Adicionando na lista de pacientes
		listaClientes.add(cli);

	}

	private static void manutencaoPaciente(CadastroPacientes cli) {
		do {
			System.out.println("Digite o código do paciente:");
			try {
				int intNrId = sc.nextInt();
				if (intNrId != cli.getId()) {
					if (pesqPac(intNrId) != -1) {
						System.out.println("Chapa já existe para um funcionário! Redigite.");
						continue;
					}
				}
				cli.setId(intNrId);
				sc.nextLine();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException)
					sc.nextLine();
			}
		} while (true);
		// Nome do Paciente
		do {
			System.out.print("Nome: ");
			try {
				cli.setNome(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		// Endereço do paciente
		do {
			System.out.print("Endereço: ");
			try {
				cli.setEndereco(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		// Idade do paciente
		do {
			System.out.print("Idade: ");
			try {
				cli.setIdade(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException)
					sc.nextLine();
			}
		} while (true);
		// Email do paciente
		do {
			sc.nextLine();
			System.out.print("Email: ");
			try {
				cli.setEmail(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			sc.nextLine();
		} while (true);

		do {
			// Telefone do paciente
			System.out.print("Tefefone: ");
			try {
				cli.setTelefone(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			sc.nextLine();
		} while (true);

	}

	private static int pesqPac(int intNrId) {
		int intRet = -1;
		for (int intI = 0; intI < listaClientes.size(); intI++) {
			if (listaClientes.get(intI).getId() == intNrId) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}

	private static void exclusaoPaciente() {
		System.out.println("Excluir paciente");
		int pesqPaciente = pesquisarPaciente();
		if (pesqPaciente > -1) {
			CadastroPacientes pac = listaClientes.get(pesqPaciente);
			mostrarPaciente(pac);
			int resp;
			System.out.println("Deseja realmente excluir? 1-Sim/ 2-Não");
			resp = sc.nextInt();
			if (resp != 1) {
				System.out.println("Digite outro código");
			} else {
				listaClientes.remove(pesqPaciente);
			}

		}

	}

	private static void alteracaoPaciente() {
		System.out.println("Alterar paciente");
		int pesqPaciente = pesquisarPaciente();
		if (pesqPaciente > -1) {
			CadastroPacientes pac = listaClientes.get(pesqPaciente);
			mostrarPaciente(pac);
			manutencaoPaciente(pac);
		} else {
			System.out.println("Paciente não encontrado!");
		}

	}

	private static void mostrarPaciente(CadastroPacientes pac) {
		System.out.println("Código: " + pac.getId());
		System.out.println("Nome: " + pac.getNome());
		System.out.println("Endereco: " + pac.getEndereco());
		System.out.println("Email: " + pac.getEmail());
		System.out.println("Telefone: " + pac.getTelefone());
	}

	private static int pesquisarPaciente() {
		System.out.println("Digite o código do paciente");
		int intId = sc.nextInt();
		sc.nextLine();
		return pesqPac(intId);
	}

	private static void listagemPaciente() {
		System.out.println("Lista de pacientes");
		System.out.println("Codigo - Nome");
		System.out.println("--------------------");
		for (int i = 0; i < listaClientes.size(); i++) {
			CadastroPacientes pac = listaClientes.get(i);
			System.out.println(pac.getId() + "  " + pac.getNome());
		}

	}

}
