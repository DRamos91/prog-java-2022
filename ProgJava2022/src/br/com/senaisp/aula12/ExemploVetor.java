package br.com.senaisp.aula12;

import java.util.Scanner;

public class ExemploVetor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declarando um vetor de 10 posições inteiras
		int intVetor [] = new int[10];
		Scanner sc = new Scanner(System.in);
		//Agora podemos acessar as 10 posições do vetor de 0 a 9
		for(int i=0; i<10; i++) {
			System.out.println("Digite o valor de i["+i+"]: ");
			intVetor[i] = sc.nextInt();
		}
		//Listando os valores
		for(int i=0; i<10; i++) {
			System.out.println("O valor de i ["+i+"] = " + intVetor[i]);
		}
		sc.close();
		
	}

}
