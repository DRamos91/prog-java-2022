package br.com.senaisp.aula04;

import java.util.Scanner;

public class CalculoIrrf {

	public static void main(String[] args) {
		//Calculo do IRFF
		Scanner sc = new Scanner(System.in);
		System.out.print("Salário Base (maior que 5.000,00): ");
		double dblSalario = sc.nextDouble();
		
		System.out.print("Dependentes: ");
		int intDependentes = sc.nextInt();
		
		double dblBase = dblSalario - intDependentes * 189.59 - 828.38;
		System.out.println("A base de cálculo do IRFF é: R$" + dblBase);
		
		double dblIrff = dblBase*0.275 - 869.36;
		System.out.println("O valor do IRFF é: R$ " + dblIrff);		
		sc.close();
	}

}
