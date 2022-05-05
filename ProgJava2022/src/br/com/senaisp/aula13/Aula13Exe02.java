package br.com.senaisp.aula13;

import java.util.Scanner;

public class Aula13Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declarando um vetor de 10 posições inteiras
		int intVetor[] = new int[10];
		int intApoio;
		Scanner sc = new Scanner(System.in);
		// Entrando com os números inteiros
		for (int i = 0; i < 10; i++) {
			System.out.print("Digite um número inteiro[" + (i + 1) + "]: ");
			intVetor[i] = sc.nextInt();
		}
		// Ordenando os valores - BubbleSort - Bolha
		for (int i = 0; i < 9; i++) {
			for (int f = i; f < 10; f++) {
				if (intVetor[i] < intVetor[f]) {
					intApoio = intVetor[i];
					intVetor[i] = intVetor[f];
					intVetor[f] = intApoio;
				}
			}
		}
		// Mostrando os nomes
		System.out.println("Mostrando os nomes digitados!");
		for (int i = 0; i < 10; i++) {
			System.out.println(intVetor[i]);
		}

		sc.close();
	}

}