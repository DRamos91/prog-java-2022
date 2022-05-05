package br.com.senaisp.aula13;

import java.util.Scanner;

public class Aula13Exe01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declarando um vetor de 10 posições
		String strVetor[] = new String[10];
		String strApoio;
		Scanner sc = new Scanner(System.in);
		// Entrando com os nomes
		for (int i = 0; i < 10; i++) {
			System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
			strVetor[i] = sc.nextLine();

		}
		// Ordenando os valores - BubbleSort - Bolha
		for (int i = 0; i < 9; i++) {
			for (int f = i; f < 10; f++) {
				if (strVetor[i].compareToIgnoreCase(strVetor[f]) > 0) {
					strApoio = strVetor[i];
					strVetor[i] = strVetor[f];
					strVetor[f] = strApoio;
				}
			}
		}

		// Mostrando os nomes
		System.out.println("Mostrando os nomes digitados!");
		for (int i = 0; i < 10; i++) {
			System.out.println(strVetor[i]);
		}

		sc.close();
	}

}