package br.com.senaisp.aula14;

import java.util.Scanner;

import br.com.senaisp.aula14.classes.MamiferosEncapsulado;

public class ExemploMamiferoEncapsulado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MamiferosEncapsulado humano = new MamiferosEncapsulado();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Digite a cor da pele do humano: ");
			try {
				humano.setPele(sc.nextLine());
				break;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		} while (true);

		do {

			System.out.println("Digite a cor dos olhos do humano: ");
			try {
				humano.setOlhos(sc.nextLine());
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} while (true);

		do {
			System.out.println("Digite o tamanho da boca do humano: ");
			try {
				humano.setBoca(sc.nextLine());
				break;
			} catch (Exception e3) {
				System.out.println("Tamanho inválido!");
			}

		} while (true);
		do {
			System.out.println("Digite o peso do humano: ");
			try {
				humano.setPeso(sc.nextDouble());
				break;
			} catch (Exception e2) {
				System.out.println("Valor inválido!");
				sc.nextLine();
			}

		} while (true);

		// Mostrando os dados cadastrados
		System.out.println("Cor da pele: " + humano.getPele());
		System.out.println("Cor dos olhos: " + humano.getOlhos());
		System.out.println("Tamanho da boca: " + humano.getBoca());
		System.out.println("Peso: " + humano.getPeso() + "Kg");
		sc.close();
	}

}
