package br.com.senaisp.aula05;

import java.util.Scanner;

public class Aula05Exe03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite seu sal�rio: R$");
		double dblSalario = sc.nextDouble();
		
		System.out.print("Digite o valor das presta��o: R$");
		double dblPrestacao = sc.nextDouble();
		
		if (dblPrestacao > dblSalario * 30 /100.00) {
			System.out.println("Emprestimo n�o aprovado!");
		}
		else
			System.out.println("Emprestimo aprovado!");
		sc.close();
	}

}
