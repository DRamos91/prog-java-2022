package br.com.senaisp.aula07;

import java.util.Locale;
import java.util.Scanner;

public class Aula07Exe04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp = 1;
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		while (intResp != 2) {

			System.out.print("Digite um n�mero: ");
			int intNumero = sc.nextInt();
			int intRes = 1;
			for (int i = intNumero; i > 1; i--) {
				intRes *= i;
				System.out.println("O fatorial do n�mero digitado �: " + intRes);

			}
			System.out.println("Deseja converter outra temperatura? (1-Sim / 2-N�o)");
			intResp = sc.nextInt();
		}
		sc.close();
	}

}
