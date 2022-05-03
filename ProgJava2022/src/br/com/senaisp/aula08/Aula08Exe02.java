package br.com.senaisp.aula08;

import java.util.Scanner;

public class Aula08Exe02 {

	public static void main(String[] args) {
		int intContador = 0;
		int intNum;
		int intSoma = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Soma de valores positivos, exibe a media até que digite um número negativo");
			System.out.println("Digite um numero: ");
			intNum = sc.nextInt();
			
			if (intNum >= 0) {  
				intContador++;
				intSoma += intNum;
			}					
		}while (intNum >= 0);
		if (intContador>0) {
		System.out.println("A média de números " + "positivos digitados foi de " + (intSoma/intContador));
		sc.close();
		}
	}

}
