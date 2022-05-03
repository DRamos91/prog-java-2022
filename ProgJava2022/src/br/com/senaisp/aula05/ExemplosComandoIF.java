package br.com.senaisp.aula05;

public class ExemplosComandoIF {

	public static void main(String[] args) {
		int intIdade = 36;
		
		if(intIdade >= 18)
			System.out.println("Você é maior de idade!");
		
		if (intIdade >= 60) {
			System.out.println("Você é adulto");
			System.out.println("Você é sexagenário");
		}
		
		if (intIdade >= 18 && intIdade <=25)
			System.out.println("Você é jovem");
		else
			System.out.println("Você tem mais ou menos que 25 anos");
		
		if (intIdade >= 18 && intIdade <=25) {
			System.out.println("Você é jovem");
		}
		else {
			System.out.println("Você tem mais ou menos que 25 anos");
		}
		
		if (intIdade >= 18 && intIdade <= 25) 
			System.out.println("Você tem entre 18 e 25 anos");
		else if (intIdade >= 26 && intIdade <= 35)
			System.out.println("Você tem entre 26 e 35 anos");
		else
			System.out.println("Você tem idade menor que 18 ou maior que  35 anos!");
			
	}

}
