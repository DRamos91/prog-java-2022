package br.com.senaisp.aula20.classes;

public abstract class Felinos extends Mamiferos {

	private String raca;

	public Felinos(String corPele, int idade, String raca) {
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
