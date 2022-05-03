package br.com.senaisp.aula06;

import java.util.Scanner;

public class Aula06Exe01 {

	/* Criar uma classe chamada Aula06Exe01. Desenvolver um aplicativo para solicitar
	o raio e altura de um cilindro. Calcular a área do cilindro e mostrar o valor da área
	calculada. Após apresentar a área calculada, solicitar ao usuário se deseja continuar,
	caso deseje continuar, calcular novamente até que o usuário responda que não
	deseja continuar. Fórmula = 2 * pi * raio * (raio + altura). Para Pi use 3.1415
	*/
	static final double pi=3.1415;
	public static void main(String[] args) {
		int intResp = 1; // 1 Sim, 2 Nao
		Scanner sc = new Scanner(System.in);
		
		while (intResp != 2) {
			//Limpando a tela (só funciona no terminal)
			System.out.println("\033[H\033[2J");
			System.out.flush();
			//Fim da limpeza de tela
			System.out.println("Programa de calculo de área de cilindro");
			System.out.print("Digite o raio = ");
			double dblRaio = sc.nextDouble();
			System.out.print("Digite a altura = ");
			double dblAltura = sc.nextDouble();
			double dblArea = 2* pi * (dblRaio + dblAltura);
			System.out.println("A area calculada é = "+dblArea);
			System.out.println("Deseja continuar? (1-sim/2-nao): ");
			intResp = sc.nextInt();
		}
	}
}
