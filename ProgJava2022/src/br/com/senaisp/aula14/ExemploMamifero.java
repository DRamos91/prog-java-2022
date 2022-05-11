package br.com.senaisp.aula14;

import br.com.senaisp.aula14.classes.Mamiferos;

public class ExemploMamifero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Objeto mam�fero
		Mamiferos boi = new Mamiferos();
		boi.Boca = "Pequena";
		boi.Pele = "Bege";
		boi.Olhos = "Marrom";
		boi.Peso = 800.5;
		// Objeto mam�fero
		Mamiferos humano = new Mamiferos();
		humano.Boca = "Pequena";
		humano.Pele = "Branca";
		humano.Olhos = "Azul";
		humano.Peso = 91.5;
		// Objeto conjunto mam�feros
		Mamiferos conjunto[] = new Mamiferos[10];
		// Criando o primeiro mamifero
		conjunto[0] = new Mamiferos();
		conjunto[0].Pele = "Branca";
		conjunto[0].Boca = "Grande";
		conjunto[0].Olhos = "Negro";
		conjunto[0].Peso = 10;
		// Criando o segundo mamifero
		conjunto[1] = new Mamiferos();
		conjunto[1].Pele = "Morena";
		conjunto[1].Boca = "Grande";
		conjunto[1].Olhos = "Negro";
		conjunto[1].Peso = 12;

	}

}
