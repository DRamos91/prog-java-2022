package br.com.senaisp.aula12;

import java.util.Scanner;

public class Aula12exe01 {

	public static final int TOTAL_COLUNAS = 9; //constante
	public static final int TOTAL_LINHAS = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strCinema[][] = new String[TOTAL_LINHAS][TOTAL_COLUNAS];
		limpezaCinema(strCinema);
		do {
			mostrarCinema(strCinema);
			Scanner sc = new Scanner(System.in);
			System.out.println("Bem vindo ao cinema 3");
			System.out.print("Digite a fileira desejada: ");
			int intFil = sc.nextInt();
			System.out.print("Digite a coluna desejada: ");
			int intPol = sc.nextInt();
			if (strCinema[intFil-1][intPol-1].equals("-")) {
				System.out.println("Poltrona reservada com sucesso!");
				strCinema[intFil-1][intPol-1] = "*";
			} else {
				System.out.println("Poltrona indisponível!");
			}
		} while (true);

	}

	public static void limpezaCinema(String[][] strAss) {
		for (int intLin = 0; intLin < TOTAL_LINHAS; intLin++) {
			for (int intCol = 0; intCol < TOTAL_COLUNAS; intCol++) {
				strAss[intLin][intCol] = "-";
			}
		}
	}

	public static void mostrarCinema(String[][] strAss) {
		System.out.print("  ");
		for (int intCol = 0; intCol < TOTAL_COLUNAS; intCol++) {
			System.out.print((intCol + 1) + " ");
		}
		System.out.println();
		for (int intLin = 0; intLin < TOTAL_LINHAS; intLin++) {
			System.out.print((intLin + 1) + " ");
			for (int intCol = 0; intCol < TOTAL_COLUNAS; intCol++) {
				System.out.print(strAss[intLin][intCol] + " ");
			}
			System.out.println();
		}
	}

}
