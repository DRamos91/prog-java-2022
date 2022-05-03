package br.com.senaisp.aula04;

public class ExemploConversoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Definindo uma variavel Double com um valor qualquer
		System.out.println("Conversão entre tipos de dados");
		System.out.println();
		double dblTeste = 51.12;
		System.out.println("Double: " + dblTeste);
		
		//Convertendo para Float
		float fltTeste = (float) dblTeste;
		System.out.println("Float: " + fltTeste);
		
		//Convertendo para Long (inteiro)
		long lngTeste = (long) fltTeste;
		System.out.println("Long: " + lngTeste);
		
		//Convertendo para Int (inteiro)
		int intTeste = (int) fltTeste;
		System.out.println("Int: " + intTeste);
		
		//Convertendo para Short (inteiro)
		short shtTeste = (short) fltTeste;
		System.out.println("Short: " + shtTeste);
		
		//Convertendo para Byte (inteiro)
		byte bytTeste = (byte) fltTeste;
		System.out.println("Byte: " + bytTeste);
		
		System.out.println("-----------------------------------------------------");
		
		//Convertendo texto para numeros
		System.out.println("Vamos iniciar conversão de String para Números");
		String strValor = "52";
		
		//Convertendo para Double
		dblTeste = Double.parseDouble(strValor);
		System.out.println("Double: " + dblTeste);		

		//Convertendo para Float
		fltTeste = Float.parseFloat(strValor);
		System.out.println("Float: " + fltTeste);
		
		//Convertendo para Int
		intTeste = Integer.parseInt(strValor);
		System.out.println("Int: " + intTeste);
		
		//Convertendo para Short
		shtTeste = Short.parseShort(strValor);
		System.out.println("Short: " + shtTeste);
		
		//Convertendo para Byte
		bytTeste = Byte.parseByte(strValor);
		System.out.println("Byte: " + bytTeste);
		
		System.out.println("-----------------------------------------------------");
		
		//Convertendo para String
		System.out.println("Agora vamos de numeros para String/Caracter");
		intTeste = 65; //Tabela ASCII A = 65
		char chrTeste = (char) intTeste;
		System.out.println("Char: " + chrTeste);
		
		//Convertendo de Double para String
		dblTeste = 52.12;
		String strTeste = Double.toString(dblTeste);
		System.out.println("Double para String: " + strTeste);
		
		//Convertendo de Float para String
		fltTeste = 52.12f;
		strTeste = Float.toString(fltTeste);
		System.out.println("Float para String: " + fltTeste);
		
		//Convertendo de Long para String
		lngTeste = 523;
		strTeste = Long.toString(lngTeste);
		System.out.println("Float para String: " + lngTeste);		

		//Convertendo de Inteiro para String
		intTeste = 523;
		strTeste = Integer.toString(intTeste);
		System.out.println("Inteiro para String: " + intTeste);	

		//Convertendo de short para String
		shtTeste = 523;
		strTeste = Short.toString(shtTeste);
		System.out.println("Short para String: " + shtTeste);	
		
		//Convertendo de Byte para String
		intTeste = 52;
		strTeste = Byte.toString(bytTeste);
		System.out.println("Float para String: " + bytTeste);	
		
		System.out.println("-----------------------------------------------------");
		
		//Convertendo numeros para outras bases
		System.out.println("Convertendo números para outras bases");
		intTeste = 255;
		
		//Convertendo para Binario (Base 2)
		strTeste = Integer.toString(intTeste, 2);
		System.out.println("O numero " + intTeste + " em binário é " + strTeste);
		
		//Convertendo para Hexadecimal (Base 16)
		strTeste = Integer.toString(intTeste, 16);
		System.out.println("O numero " + intTeste + " em hexadecimal é " + strTeste);	
		
		//Convertendo para Octal (Base 8)
		strTeste = Integer.toString(intTeste, 8);
		System.out.println("O numero " + intTeste + " em octal é " + strTeste);
		
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Convertendo de outras bases (2, 8, 16) para o inteiro");
		//Hexadecimal para Decimal
		strTeste = "ff";
		intTeste = Integer.parseInt(strTeste, 16);
		System.out.println("Hexadecimal " + strTeste + " na base 10 " + intTeste);
		
		//Binario para Decimal
		strTeste = "11111111";
		intTeste = Integer.parseInt(strTeste, 2);
		System.out.println("Binário " + strTeste + " na base 10 " + intTeste);
		
		//Octal para Decimal
		strTeste = "3771";
		intTeste = Integer.parseInt(strTeste, 8);
		System.out.println("Octal " + strTeste + " na base 10 " + intTeste);		
		
	
	}

}
