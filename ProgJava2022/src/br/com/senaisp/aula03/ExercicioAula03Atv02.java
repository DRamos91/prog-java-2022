package br.com.senaisp.aula03;

import java.util.Scanner;

public class ExercicioAula03Atv02 {

	public static void main(String[] args) {
		
		//Conversao de Celsius para Fahrenheit
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite uma temperatura em °C: ");
		double dblTempC = sc.nextDouble();
		
		double dblTempF = (9*dblTempC/5) + 32;
		System.out.println("A temperatura em Fahrenheit = " + dblTempF +"°F");
		sc.close();
	}

}
