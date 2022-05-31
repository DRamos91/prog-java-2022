package br.com.senaisp.aula06;

import java.util.Locale;
import java.util.Scanner;

public class Aula06Exe02 {
	
	/* Criar um classe chamada Aula06Exe02. Desenvolver um aplicativo para solicitar a 
	altura e o peso de uma pessoa. Calcular o IMC da pessoa e apresentar o IMC e o 
	resultado de acordo com a tabela de IMC. Após apresentar perguntar se deseja 
	continuar, se sim, calcular novamente, se não finalizar o programa
	
	 Fórmula do IMC = pesoPessoa / alturaPessoa^2
	*/
		public static void main(String[] args) {
			int intResp = 1; // 1 Sim, 2 Nao
			Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
			
			while (intResp != 2) {
				//Limpando a tela (só funciona no terminal)
				System.out.println("\033[H\033[2J");
				System.out.flush();
				//Fim da limpeza de tela
				System.out.println("Programa de calculo do IMC");
				System.out.print("Digite a altura (m)= ");
				double dblAltura = sc.nextDouble();
				System.out.print("Digite o peso (kg)= ");
				double dblPeso = sc.nextDouble();
				double dblImc = dblPeso / Math.pow(dblAltura, 2) ;
				System.out.println("O seu IMC é = "+dblImc);
				
				if (dblImc < 20)
					System.out.println("Abaixo do peso");
				else if (dblImc >= 20 && dblImc <=25)
					System.out.println("Normal");
				else if (dblImc > 25 && dblImc <=30)
					System.out.println("Excesso de peso");
				else if (dblImc > 30 && dblImc <=35)
					System.out.println("Obesidade");
				else	
					System.out.println("Obesidade mórbida");
								
				System.out.println("Deseja continuar? (1-sim/2-nao): ");
				intResp = sc.nextInt();
				sc.close();
			}
		}
	}
