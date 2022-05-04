package br.com.senaisp.aula10;

import java.util.Locale;
import java.util.Scanner;

public class Aula10Exe04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp = 1;
		// Scanner irá colocar ponto decimal ao invés de vírgula decimal
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		// While de continuação
		while (intResp != 2) {
			montagemTela();
			
			int intTempOri = entradaTemperatura(sc, "Temperatura de origem: (1, 2 ou 3)");
			int intTempDes = entradaTemperatura(sc, "Temperatura de destino: (1, 2 ou 3)");

			System.out.println("Valor Temperatura a ser convertida:");
			double dblTemperatura = sc.nextDouble();
			
			double dblTempConv = calculoTemperatura(intTempOri, intTempDes, dblTemperatura);
			// teste de conversão
			
			System.out.println("A temperatura calculada final é " + dblTempConv);
			System.out.println("Deseja calcular mais uma temperatura? (1-sim,2-não):");
			intResp = sc.nextInt();
		}
		sc.close();
	}

	/**
	 * Função que daré entrada na temperatura e tratará os valores entre 1, 2 ou 3
	 * @param strMsg Deve ser passado a mensagem de apresentação
	 * @param sc Devem ser passado o Scanner para entrada de dados
	 * @return Retorna um valor inteiro entre 1 e 3
	 */
	public static int entradaTemperatura(Scanner sc, String strMsg) {
		int intTemp;
		do {
			System.out.println(strMsg);
			intTemp = sc.nextInt();
		} while (intTemp != 1 && intTemp != 2 && intTemp != 3);
		return intTemp;
	}
	public static void montagemTela () {
		System.out.println("Sistema de cálculo de temperatura");
		System.out.println("1 - Celsius");
		System.out.println("2 - Fahrenheit");
		System.out.println("3 - Kelvin");
	}
	
	/**
	 * Função que converte uma temperatura com base nos parâmetros passados
	 * @param intTempO Indicador temperatura origem 1-Celsius, 2-Fahrenheit, 3-kelvin
	 * @param intTempD Indicador temperatura destino 1-Celsius, 2-Fahrenheit, 3-kelvin
	 * @param dblTemp Temperatura a ser convertida
	 * @return Retorna a temperatura convertida com base nos parâmetros passados
	 */
	public static double calculoTemperatura (int intTempO, int intTempD, double dblTemp) {
		double dblTempConv = dblTemp;
		
		if (intTempO == 1) { // testando origem celsius
			if (intTempD == 2) { // testando destino Fahrenheit
				dblTempConv = dblTemp * 9 / 5 + 32;
			} else if (intTempD == 3) { // testando destino kelvin
				dblTempConv = dblTemp + 273;
			}
		} else if (intTempO == 2) { // testando origem fahrenheit
			if (intTempD == 1) { // testando destino Celsius
				dblTempConv = (dblTemp - 32) * 5 / 9;
			} else if (intTempD == 3) { // testando destino kelvin
				dblTempConv = (dblTemp - 32) * 5 / 9 + 273;
			}
		} else { // Calculand origem Kelvin
			if (intTempD == 1) { // testando destino Celsius
				dblTempConv = dblTemp - 273;
			} else if (intTempD == 2) { // testando destino Fahenheit
				dblTempConv = (dblTemp - 273) * 9 / 5 + 32;
			}
		}
		return dblTemp;
	}
	

}
