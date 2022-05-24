package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class Cachorro extends Mamiferos implements InFalantes{

	private String raca;

	@Override
	public void falar() {
		System.out.println("Cachorro latindo!");
		
	}

	public Cachorro(String corPele, int idade, String raca) {
		super(corPele, idade);
		this.raca = raca;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
}
