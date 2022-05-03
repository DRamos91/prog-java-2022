package br.com.senaisp.aula07;

import java.util.Locale;
import java.util.Scanner;

public class Aula07Exe05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp = 1;
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		while (intResp != 2) {

			System.out.println("Programa frequencia de Fibonacci");
			System.out.print("Entre com o número do termo desejado: ");
			int intTermo = sc.nextInt();
			int intAnt1 = 0;
			int intAnt2 = 1;
			int intApoio = 0;

			System.out.print(intAnt1 + " " + intAnt2 + " ");

			for (int intCont = 3; intCont <= intTermo; intCont++) {
				System.out.print((intAnt1 + intAnt2) + " ");
				intApoio = intAnt1;
				intAnt1 = intAnt2;
				intAnt2 = intApoio + intAnt2;
			}
			System.out.println();
			System.out.println("Deseja entrar com outro valor? (1-Sim / 2-Não)");
			intResp = sc.nextInt();
		}
		sc.close();
	}
}
