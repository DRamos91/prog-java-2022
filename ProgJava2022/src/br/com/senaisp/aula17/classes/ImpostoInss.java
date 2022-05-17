package br.com.senaisp.aula17.classes;

public class ImpostoInss extends Imposto {
	
	public Double calcularImposto() {
		
		if(BaseCalculo==1212) {
			return BaseCalculo *= 0.75;
		}else if(BaseCalculo > 1212 && BaseCalculo == 2472) {
			
		}
		
		return BaseCalculo;
		
		
		}
}
