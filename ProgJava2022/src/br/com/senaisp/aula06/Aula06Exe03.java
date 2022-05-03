package br.com.senaisp.aula06;

import java.util.Locale;
import java.util.Scanner;

public class Aula06Exe03 {

	public static void main(String[] args) {
		int intResp = 1;
		while (intResp != 2) {
		int intContador = 1;
		int intCiclo = 1;
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		System.out.print("Digite um numero: ");
		int intNumero = sc.nextInt();
		
		while (intCiclo < intNumero) {
			intCiclo++;
			
			if (intNumero % intCiclo == 0)
				intContador++;//intContador
		}
		if (intContador <= 2) {
			System.out.println("O número digitado é primo");
		}
		else {
			System.out.println("O número digitado não é primo");
		}
		
			System.out.println("Deseja continuar? (1-sim/2-nao): ");
		intResp = sc.nextInt();
		}
	}

}
