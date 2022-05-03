package br.com.senaisp.aula05;

import java.util.Scanner;

public class Aula05Exe04 {

	public static void main(String[] args) {
		System.out.println("Menu principal");
		System.out.println("1 - Mercúrio");
		System.out.println("2 - Vênus");
		System.out.println("3 - Marte");
		System.out.println("4 - Júpiter");
		System.out.println("5 - Saturno");
		System.out.println("6 - Urano");
		System.out.print("Digite uma opção: ");
	
		Scanner sc = new Scanner(System.in);
		double dblPesoTerra, dblRes = 10.00;
		int intOpcao = sc.nextInt();

		System.out.print("Digite o peso na Terra: ");
		dblPesoTerra = sc.nextDouble();
	
		switch (intOpcao) {
		case 1:
			dblRes = (dblPesoTerra / 10) * 0.37;
			break;
		case 2:
			dblRes = (dblPesoTerra / 10) * 0.88;
			break;		
		case 3:
			dblRes = (dblPesoTerra / 10) * 0.38;
			break;
		case 4:
			dblRes = (dblPesoTerra / 10) * 2.64;
			break;
		case 5:
			dblRes = (dblPesoTerra / 10) * 1.15;
			break;
		case 6:
			dblRes = (dblPesoTerra / 10) * 1.17;
			break;
		
		default:
			System.out.println("Você digitou uma opção inválida!");
		}
		
		System.out.print("O peso no Planeta selecionado será:  " + dblRes);
	}

}
