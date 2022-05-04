package br.com.senaisp.aula12;

import java.util.Random;
import java.util.Scanner;

public class ExemploMatriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declarando uma matriz bidimensional de 10 x 10
		int intMatriz[][] = new int[10][10];
		Random gerador = new Random();
		Scanner sc = new Scanner(System.in);
		// Agora podemos acessar as 100 posições da matriz
		for (int intLin = 0; intLin < 10; intLin++) {
			for (int intCol = 0; intCol < 10; intCol++) {
				intMatriz[intLin][intCol] = gerador.nextInt(100) + 1;
			}
		}
		// Listando os valores
		System.out.println("Listando os valores");
		for (int intLin = 0; intLin < 10; intLin++) {
			for (int intCol = 0; intCol < 10; intCol++) {
				System.out.print(intMatriz[intLin][intCol] + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
