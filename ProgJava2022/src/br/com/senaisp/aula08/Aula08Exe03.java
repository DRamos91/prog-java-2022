package br.com.senaisp.aula08;

import java.util.Scanner;

public class Aula08Exe03 {

	public static void main(String[] args) {
		int intMenor = Integer.MAX_VALUE;
		int intMaior = Integer.MIN_VALUE;
		int intNum;
		Scanner sc = new Scanner(System.in);
	
		do {
			System.out.println("Programa menor e maior de numeros positivos");
			System.out.println("Digite um numero positivo: " + "(Numero negativo finaliza o programa)");
			intNum = sc.nextInt();
			if (intNum >= 0) {
			if (intNum > intMaior)
				intMaior = intNum;
			if (intNum < intMenor)
				intMenor = intNum;
			}
		}while (intNum >= 0);
				
		System.out.println("O menor é " + intMenor +  " e o maior é " + intMaior);
		sc.close();
	}

}