package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class Humano extends Mamiferos implements InFalantes{

	private String etnia;
	
	@Override
	public void falar() {
		System.out.println("Humando falando!");
	}
	
	public Humano(String corPele, int idade, String etnia) {
		super(corPele, idade);
		this.etnia = etnia;
	}


	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

}
