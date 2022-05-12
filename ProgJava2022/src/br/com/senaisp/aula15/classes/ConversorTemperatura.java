package br.com.senaisp.aula15.classes;

public class ConversorTemperatura {
	private int TempOrigem;
	private int TempDestino;
	private double Temperatura;
	public ConversorTemperatura() {
		// TODO Auto-generated constructor stub
		this.TempOrigem = 1;
		this.TempDestino = 1;
		this.Temperatura = 0;
	}
	public int getTempOrigem() {
		return TempOrigem;
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
		this.TempOrigem = tempOrigem;
	}
	public int getTempDestino() {
		return TempDestino;
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
		this.TempDestino = tempDestino;
	}
	public double getTemperatura() {
		return Temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.Temperatura = temperatura;
	}
	
	public double getTempConvertida() {
		double dblTempConv = this.Temperatura;
		if (TempOrigem == 1) { // testando origem celsius
			if (TempDestino == 2 ){ // testando destino Fahrenheit
				dblTempConv =  9*Temperatura/5 + 32;
			}
			else if (TempDestino == 3) { // testando destino Kelvin
				dblTempConv =  Temperatura + 273;
			}
		}else if(TempOrigem == 2) { // testando origem Fahrenheit
			if (TempDestino == 1 ){ // testando destino Celsius
				dblTempConv =  (Temperatura - 32) * 5 / 9; 
			}
			else if (TempDestino == 3) { // testando destino Kelvin
				dblTempConv =  (Temperatura - 32) * 5 / 9 + 273;
			}
			
		} else { // Calculando origem Kelvin
			if (TempOrigem == 1) { // testando destino Celsius
				dblTempConv =  Temperatura - 273;
			} else if (TempOrigem == 2) { // testando destino Fahenheit
				dblTempConv =  (Temperatura - 273) * 9 /5 +32;
			}
		}
		return dblTempConv;
		
	}
	
	
}
