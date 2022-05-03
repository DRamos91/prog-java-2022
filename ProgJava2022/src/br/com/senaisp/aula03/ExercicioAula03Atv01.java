package br.com.senaisp.aula03;

import java.util.Scanner;

public class ExercicioAula03Atv01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um valor inteiro de ate 3 digitos: ");
		int intValor=sc.nextInt();
		
		int intCentena = intValor/100;
		int intDezena = intValor%100/10;
		int intUnidade = intValor%10;
		int intValorInvertido = intUnidade * 100 + intDezena * 10 + intCentena;
		
		System.out.println("O valor invertido é: " + intValorInvertido);
	}

}
