package br.com.senaisp.aula09;

public class Aula09Exe02DoWhile {

	public static void main(String[] args) {

		int intLinha = 1;
		int intColuna;
		do {
			intColuna = 1;
			do {
				if (intLinha <= intColuna)
					System.out.print(intLinha + "-" + intColuna + " ");
				else
					System.out.print("    ");
				intColuna++;
			} while (intColuna < 10);
			System.out.println();
			intLinha++;
		} while (intLinha < 10);
	}

}