package br.com.senaisp.aula09;

public class Aula09Exe01While {

	public static void main(String[] args) {

		int intLinha = 1;
		int intColuna;

		while (intLinha < 10) {
			intColuna = 1;
			while (intColuna < 10) {
				System.out.print(intLinha + "-" + intColuna + " ");
			intColuna++;
		}
		System.out.println();
		intLinha++;
		}
	}

}
