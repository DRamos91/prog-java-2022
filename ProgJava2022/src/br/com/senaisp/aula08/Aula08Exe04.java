package br.com.senaisp.aula08;

import java.time.LocalDate;
import java.util.Scanner;

public class Aula08Exe04 {

	public static void main(String[] args) {
		int intResp; /// (1-Sim 2-Não)
		int intIdade, intAnoNascimento;
		String strNome, strEndereco;
		
		//Para os controles de menor e maior
		int intIdadeMenor = Integer.MAX_VALUE;
		int intIdadeMaior = Integer.MIN_VALUE;
		String strNomeMenor = "", strNomeMaior = "";
		String strEnderecoMenor = "", strEnderecoMaior = "";
		
		//Obtendo o ano atual.
		int intAnoAtual = LocalDate.now().getYear();
			
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Sistema de cadastro de pacientes");
			System.out.print("Nome do paciente: ");
			strNome = sc.nextLine();
			System.out.print("Endereço do paciente: ");
			strEndereco = sc.nextLine();
			
			//Trava o usuário até que ele digite um ano válido ( a pessoa não pode entrar com um valor maior que 199 anos).
			do {
				System.out.print("Ano de nascimento do paciente: ");
				intAnoNascimento = sc.nextInt();
				if(intAnoNascimento <= intAnoAtual - 200 || intAnoNascimento >= intAnoAtual)
				System.out.println("Ano de nascimento inválido!");
			}while (intAnoNascimento <= intAnoAtual - 200 || intAnoNascimento >= intAnoAtual);
			
			//Lógica de teste
			
			//Calculando a idade
			intIdade = intAnoAtual - intAnoNascimento;
			
			//Testando as idades
			if (intIdade>intIdadeMaior) {
				intIdadeMaior = intIdade;
				strNomeMaior = strNome;
				strEnderecoMaior = strEndereco;
			}
			
			if (intIdade<intIdadeMenor) {
				intIdadeMenor = intIdade;
				strNomeMenor = strNome;
				strEnderecoMenor = strEndereco;
			}
				
			//Trava o usuário até que ele digite uma opção válida.
			do {			
				System.out.println("Deseja continuar? (1-Sim/2-Não)");
				intResp = sc.nextInt();
				if (intResp!=1 && intResp!=2)
				System.out.println("Digite 1 ou 2!");
				sc.nextLine();
				
			}while (intResp!=1 && intResp!=2);
			
			
		}while (intResp != 2);
		System.out.println("Menor idade: " + intIdadeMenor);
		System.out.println("Menor idade: " + strNomeMenor);
		System.out.println("Menor idade: " + strEnderecoMenor);
		System.out.println("Maior idade: " + intIdadeMaior);
		System.out.println("Maior idade: " + strNomeMaior);
		System.out.println("Maior idade: " + strEnderecoMaior);
		
		
		sc.close();
	}

	
}