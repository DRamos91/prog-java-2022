package br.com.senaisp.aula15.classes;

public class ConversorTemperatura {
	private int tempOrigem;
	private int tempDestino;
	private double temperatura;
	public ConversorTemperatura() {
		// TODO Auto-generated constructor stub
		this.tempOrigem = 1;
		this.tempDestino = 1;
		this.temperatura = 0;
	}
	public int getTempOrigem() {
		return tempOrigem;
	}
	/**
	 * Setter do tipo de temparatura de origem
	 * Valores válidos: 1 - Celsius, 2 Fahreinheit, 3 - Kelvin
	 * @param tempOrigem Indicar valores de 1 a 3
	 * @throws Exception Se valores inválidos, retorna Erro
	 */
	public void setTempOrigem(int tempOrigem) throws Exception {
		if(tempOrigem!= 1 && tempOrigem!=2 && tempOrigem!=3) {
			throw new Exception("Valor inválido!");
		}
		this.tempOrigem = tempOrigem;
	}
	public int getTempDestino() {
		return tempDestino;
	}
	/**
	 * Setter do tipo de temparatura de destino
	 * Valores válidos: 1 - Celsius, 2 Fahreinheit, 3 - Kelvin
	 * @param tempDestino Indicar valores de 1 a 3
	 * @throws Exception Se valores inválidos, retorna Erro
	 */
	public void setTempDestino(int tempDestino) throws Exception {
		if(tempDestino!=1 && tempDestino!=2 && tempDestino!=3) {
			throw new Exception("Valor inválido!");
		}
		this.tempDestino = tempDestino;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	public double getTempConvertida() {
		double dblTempConv = this.temperatura;
		if (tempOrigem == 1) { // testando origem celsius
			if (tempDestino == 2 ){ // testando destino Fahrenheit
				dblTempConv =  9*temperatura/5 + 32;
			}
			else if (tempDestino == 3) { // testando destino Kelvin
				dblTempConv =  temperatura + 273;
			}
		}else if(tempOrigem == 2) { // testando origem Fahrenheit
			if (tempDestino == 1 ){ // testando destino Celsius
				dblTempConv =  (temperatura - 32) * 5 / 9; 
			}
			else if (tempDestino == 3) { // testando destino Kelvin
				dblTempConv =  (temperatura - 32) * 5 / 9 + 273;
			}
			
		} else { // Calculando origem Kelvin
			if (tempOrigem == 1) { // testando destino Celsius
				dblTempConv =  temperatura - 273;
			} else if (tempOrigem == 2) { // testando destino Fahenheit
				dblTempConv =  (temperatura - 273) * 9 /5 +32;
			}
		}
		return dblTempConv;
		
	}
	
	
}
