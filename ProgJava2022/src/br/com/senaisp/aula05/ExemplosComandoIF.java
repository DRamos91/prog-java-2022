package br.com.senaisp.aula05;

public class ExemplosComandoIF {

	public static void main(String[] args) {
		int intIdade = 36;
		
		if(intIdade >= 18)
			System.out.println("Voc� � maior de idade!");
		
		if (intIdade >= 60) {
			System.out.println("Voc� � adulto");
			System.out.println("Voc� � sexagen�rio");
		}
		
		if (intIdade >= 18 && intIdade <=25)
			System.out.println("Voc� � jovem");
		else
			System.out.println("Voc� tem mais ou menos que 25 anos");
		
		if (intIdade >= 18 && intIdade <=25) {
			System.out.println("Voc� � jovem");
		}
		else {
			System.out.println("Voc� tem mais ou menos que 25 anos");
		}
		
		if (intIdade >= 18 && intIdade <= 25) 
			System.out.println("Voc� tem entre 18 e 25 anos");
		else if (intIdade >= 26 && intIdade <= 35)
			System.out.println("Voc� tem entre 26 e 35 anos");
		else
			System.out.println("Voc� tem idade menor que 18 ou maior que  35 anos!");
			
	}

}
