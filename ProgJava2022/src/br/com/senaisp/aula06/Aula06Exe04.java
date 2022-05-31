package br.com.senaisp.aula06;

import java.util.Locale;
import java.util.Scanner;

public class Aula06Exe04 {

	public static void main(String[] args) {
		int intResp = 1;
	//	int intUniTempOut;
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		while (intResp != 2) {
			
	
		System.out.println("Digite uma temperatura");
		System.out.println("Temperatura: ");
		System.out.println("1 - Celsius");
		System.out.println("2 - Fahrenheit");
		System.out.println("3 - Kelvin");
		System.out.println("Qual a unidade de medida da Temperatura (1, 2 ou 3)");
		int intUniTempIn = sc.nextInt();
		System.out.println("Para qual unidade de medida deseja converter (1, 2 ou 3)?");
		int intUniTempOut = sc.nextInt();
		System.out.println("Qual o valor da temperatura a ser convertida: ");
		double dblTempIn = sc.nextDouble();
		double dblTempOut = dblTempIn;
		
		if (intUniTempIn == 1) { // testando origem celsius
			if (intUniTempOut == 2 ){ // testando destino Fahrenheit
				dblTempOut =  9*dblTempIn/5 + 32;
			}
			else if (intUniTempOut == 3) { // testando destino Kelvin
				dblTempOut =  dblTempIn + 273;
			}
		}else if(intUniTempIn == 2) { // testando origem Fahrenheit
			if (intUniTempOut == 1 ){ // testando destino Celsius
				dblTempOut =  (dblTempIn - 32) * 5 / 9; 
			}
			else if (intUniTempOut == 3) { // testando destino Kelvin
				dblTempOut =  (dblTempIn - 32) * 5 / 9 + 273;
			}
			
		} else { // Calculando origem Kelvin
			if (intUniTempIn == 1) { // testando destino Celsius
				dblTempOut =  dblTempIn - 273;
			} else if (intUniTempIn == 2) { // testando destino Fahenheit
				dblTempOut =  (dblTempIn - 273) * 9 /5 +32;
			}
		}
		System.out.println("A temperatura convertida é: " + dblTempOut);
		System.out.println("Deseja converter outra temperatura? (1-Sim / 2-Não)");
		intResp = sc.nextInt();
		sc.close();
	  }		
	}
}
