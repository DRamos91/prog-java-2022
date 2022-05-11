package br.com.senaisp.aula15;

import br.com.senaisp.aula15.classes.ConversorTemperatura;

public class ExemploCalculoTemperatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversorTemperatura conv = new ConversorTemperatura();
		
		try {
			conv.setTempOrigem(1);
			conv.setTempDestino(2);
			conv.setTemperatura(35.00);
			System.out.println("Temperatura calculada é " + conv.getTempConvertida());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
