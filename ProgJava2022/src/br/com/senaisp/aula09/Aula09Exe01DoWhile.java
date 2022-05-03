package br.com.senaisp.aula09;

public class Aula09Exe01DoWhile {

	public static void main(String[] args) {

		int intLinha = 1;
		int intColuna;
		do {
			intColuna = 1;
			do {
				System.out.print(intLinha + "-" + intColuna + " ");
				intColuna++;
			} while (intColuna < 10);
			System.out.println();
			intLinha++;
		} while (intLinha < 10);
	}

}