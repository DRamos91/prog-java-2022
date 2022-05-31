package br.com.senaisp.aula04;

import java.util.Scanner;

public class CalculoJurosFuturos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calculo juros futuros
		Scanner sc = new Scanner(System.in);
		System.out.print("Valor a ser aplicado: ");
		double dblValor = sc.nextDouble();
		
		System.out.print("Tempo da aplica��o (em meses): ");
		int intTempo = sc.nextInt();
		
		System.out.print("Taxa de juros ao m�s (%): ");
		double dblTaxa = sc.nextDouble();
		
		double dblFv = dblValor * (Math.pow(1 + dblTaxa / 100.00, intTempo));
		System.out.println("O valor futuro da aplica��o ser�: R$" + dblFv);
		sc.close();
	}

}
