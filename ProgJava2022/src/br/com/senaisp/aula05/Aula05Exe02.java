package br.com.senaisp.aula05;

import java.util.Scanner;

public class Aula05Exe02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um número: ");
		int intTeste = sc.nextInt();
		
		if (intTeste % 3 == 0 && intTeste % 5 == 0) {
			System.out.println("Número divisível por 3 e por 5");
		}
		else {
			System.out.println("Número nao é divisível por 3 e por 5");
		}
	}

}
