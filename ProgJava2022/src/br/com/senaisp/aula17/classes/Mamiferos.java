package br.com.senaisp.aula17.classes;

public class Mamiferos {

	private String Nome;
	private int idade;
	private String CorPelo;

	public void Falar() {
		System.out.println("Mamifero falando!");
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCorPelo() {
		return CorPelo;
	}

	public void setCorPelo(String corPelo) {
		CorPelo = corPelo;
	}

}
