package br.com.senaisp.aula05;

import java.util.Scanner;

public class Aula05Exe01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um n�mero: ");
		int intParImpar = sc.nextInt();
		
		if (intParImpar %2 == 0) {
			System.out.println("O n�mero digitado � par!");
		}
		else {
			System.out.println("O n�mero digitado � impar!");
		}
	}

}
