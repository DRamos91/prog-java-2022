package br.com.senaisp.aula07;

public class ExemplosComandoFor {

	public static void main(String[] args) {
		for (int i = 10; i > 0; i--) {
			if (i % 2 == 0)
				System.out.println("O n�mero " + i + " � par!");
			else
				System.out.println("O n�mero " + i + " � �mpar!");
		}

	}

}
