package br.com.senaisp.aula09;

public class Aula09Exe02 {

	public static void main(String[] args) {

		for (int intLinha = 1; intLinha < 10; intLinha++) {
			
			for (int intColuna = 1; intColuna < 10; intColuna++) {
			//	System.out.print(intLinha + "-" + intColuna + " ");
			
			if (intLinha <= intColuna)
				System.out.print(intLinha + "-" + intColuna + " ");
			else
				System.out.print("    ");
			}
			System.out.println();
		}

	}

}