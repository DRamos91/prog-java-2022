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

	public static void main(String[] args) {
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

	private static void exclusaoPaciente() {
		// TODO Auto-generated method stub

	}

	private static void alteracaoPaciente() {
		// TODO Auto-generated method stub

	}

	private static void listagemPaciente() {
		// TODO Auto-generated method stub

	}

	private static void cadastrarPaciente() {
		System.out.println("Cadastro de Paciente");
		CadastroPacientes paciente = new CadastroPacientes();
		manutencaoPacientes(paciente);

	}

	private static void manutencaoPacientes(CadastroPacientes paciente) {
		do {
			System.out.print("Digite o Id do paciente: ");
			int intId = sc.nextInt();
			if (intId != paciente.getId()) {
				if (pesqPac(intId) != -1) {
					System.out.println("Chapa já existe para um funcionário! Redigite.");
					continue;
				}
			}
			try {
				paciente.setId(intId);
				sc.nextLine();
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException)
					sc.nextLine();
			}
		} while (true);
		// Nome do paciente
		do {
			System.out.println("Digite o nome do paciente:");
			paciente.setNome(sc.nextLine());

		} while (true);

	}


	private static int pesqPac(int intId) {
		int intRet = -1;
		for (int intI = 0; intI < listaClientes.size(); intI++) {
			if (listaClientes.get(intI).getId() == intId) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}
}
