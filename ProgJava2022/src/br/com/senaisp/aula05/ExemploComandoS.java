package br.com.senaisp.aula05;

import java.util.Scanner;

public class ExemploComandoS {

	public static void main(String[] args) {
		System.out.println("Menu principal");
		System.out.println("1 - Mercúrio");
		System.out.println("2 - Vênus");
		System.out.println("3 - Marte");
		System.out.println("4 - Júpiter");
		System.out.println("5 - Saturno");
		System.out.println("6 - Urano");
	///	System.out.print("Digite um peso: ");
	
		Scanner sc = new Scanner(System.in);
		double intPesoTerra, intRes = 0;
		int intOpcao = sc.nextInt();

		System.out.print("Digite o peso na Terra: ");
		intPesoTerra = sc.nextInt();
	
		switch (intOpcao) {
		case 1:
			intRes = (intPesoTerra / 10) * 0.37;
			break;
		case 2:
			intRes = (intPesoTerra / 10) * 0.88;
			break;		
		case 3:
			intRes = (intPesoTerra / 10) * 0.38;
			break;
		case 4:
			intRes = (intPesoTerra / 10) * 2.64;
			break;
		case 5:
			intRes = (intPesoTerra / 10) * 1.15;
			break;
		case 6:
			intRes = (intPesoTerra / 10) * 1.17;
			break;
		
		default:
			System.out.println("Você digitou uma opção inválida!");
		}
		
		System.out.print("O resultado sera:  " + intRes);
	}

}
