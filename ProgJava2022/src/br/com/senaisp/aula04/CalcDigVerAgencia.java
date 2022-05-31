package br.com.senaisp.aula04;

import java.util.Scanner;

public class CalcDigVerAgencia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a Agencia (4 dígitos) : ");
		int intAgencia = sc.nextInt();
		System.out.println();
		
		int intMilhar = intAgencia / 1000 * 9;
		int intCentena = intAgencia % 1000 / 100 * 8;
		int intDezena = intAgencia % 100 / 10 * 7;
		int intUnidade = intAgencia % 10 * 6;
		
		int intSoma = intMilhar + intCentena + intDezena + intUnidade;
				
		int intCodverif = 10 - intSoma % 10;
		System.out.println("O digito verificador é : " + intCodverif);
		sc.close();
	}

}
