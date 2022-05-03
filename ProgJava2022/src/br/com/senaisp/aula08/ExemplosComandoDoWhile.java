package br.com.senaisp.aula08;

import java.time.LocalDate;
import java.util.Scanner;

public class ExemplosComandoDoWhile {

	public static void main(String[] args) {
		int intResp; //(1-Sim / 2-Não)
		Scanner sc = new Scanner(System.in);
		//Iniciando o laço de repetição
		do {
			System.out.println("Programa de cáculo de idade");
			System.out.println("Digite o ano de seu nascimento: ");
			int intAnoNascimento = sc.nextInt();
			//Obtendo ano atual
			int intAnoAtual = LocalDate.now() .getYear();
			int intIdade = intAnoAtual - intAnoNascimento;
			System.out.println("Sua idade é " + intIdade);
			System.out.println("Deseja entrar com outra idade? (1-Sim / 2-Não");
			intResp = sc.nextInt();
			
		}while (intResp != 2);
		sc.close();
	}
	
}
