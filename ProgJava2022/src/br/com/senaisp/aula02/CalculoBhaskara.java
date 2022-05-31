package br.com.senaisp.aula02;

import java.util.Scanner;

public class CalculoBhaskara {

	public static void main(String[] args) {
		//Solicitando ao usuario os valores para o calculo
		System.out.println("Cálculo de BHASKARA");
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o valor de A: ");
		int intA=sc.nextInt();
		System.out.print("Digite o valor de B: ");
		int intB=sc.nextInt();
		System.out.print("Digite o valor de C: ");
		int intC=sc.nextInt();
		
		//Calculando Delta
		double dblDelta = ((Math.pow(intB, 2))- 4 * intA * intC);
		System.out.println("Valor de Delta = " + dblDelta);
		
		//Calculando X1
		double dblX1 = (-intB + Math.sqrt(dblDelta))/(2*intA);
		System.out.println("Valor de X1 = " + dblX1);
		
		//Calculando X2
		double dblX2 = (-intB - Math.sqrt(dblDelta))/(2*intA);
		System.out.println("Valor de X2 = " + dblX2);
		
		sc.close();
	}

}
