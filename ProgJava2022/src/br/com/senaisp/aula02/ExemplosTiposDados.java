package br.com.senaisp.aula02;

import java.util.Scanner;

public class ExemplosTiposDados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intSoma = 3 + 5;
		System.out.println("soma: " + intSoma);
		
		int intSub = 5 - 2;
		System.out.println("Subtra��o: " + intSub);
		
		int intMult = 3 * 2;
		System.out.println("Subtra��o: " + intMult);
		
		int intDiv = 3 / 2;
		System.out.println("Subtra��o: " + intDiv);
		
		double dblDiv = 3.00 / 2.00;
		System.out.println("Subtra��o: " + dblDiv);
		
		int intRest = 3 % 2;
		System.out.println("Subtra��o: " + intRest);
		
		System.out.println("Mostrando um valor");
		System.out.println("Outro valor");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		String nome=sc.nextLine();
		System.out.println("Ola: " + nome);
		sc.close();
	}

}
