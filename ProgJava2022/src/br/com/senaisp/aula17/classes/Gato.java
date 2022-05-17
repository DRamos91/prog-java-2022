package br.com.senaisp.aula17.classes;

public class Gato extends Felino {

	private String Raca;

	public String getRaca() {
		return Raca;
	}

	public void setRaca(String raca) {
		Raca = raca;
	}

	@Override
	public void Falar() {
		// TODO Auto-generated method stub
		super.Falar();
		System.out.println("Miau!");
	}
}
