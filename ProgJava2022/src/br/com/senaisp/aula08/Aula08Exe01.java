package br.com.senaisp.aula08;

import java.util.Scanner;

public class Aula08Exe01 {

	public static void main(String[] args) {
		int intContador = 0;
		int intNum;
		Scanner sc = new Scanner(System.in);
	
		do {
			System.out.println("Programa soma de valores positivos");
			System.out.println("Digite um numero: ");
			intNum = sc.nextInt();
			
			if (intNum >= 0) 
				intContador++;
						
		}while (intNum >= 0);
		
		System.out.println(intContador);
		sc.close();
	}

}
