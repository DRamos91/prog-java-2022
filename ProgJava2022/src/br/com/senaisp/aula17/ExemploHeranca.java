package br.com.senaisp.aula17;

import br.com.senaisp.aula17.classes.Cachorro;
import br.com.senaisp.aula17.classes.Gato;
import br.com.senaisp.aula17.classes.Humano;
import br.com.senaisp.aula17.classes.Mamiferos;

public class ExemploHeranca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mamiferos mam[] = new Mamiferos[4];
		mam[0] = new Cachorro();
		mam[0].setCorPelo("Malhado");
		mam[0].setIdade(5);
		mam[0].setNome("Toto");
		// Cast
		((Cachorro) mam[0]).setRaca("SRD");

		mam[1] = new Gato();
		mam[1].setCorPelo("Preto");
		mam[1].setIdade(3);
		mam[1].setNome("Gatinho");
		// Cast
		((Gato) mam[1]).setRaca("SRD");
		((Gato) mam[1]).setPorte("Pequeno");

		mam[2] = new Humano();
		mam[2].setCorPelo("Loiro");
		mam[2].setIdade(30);
		mam[2].setNome("Daniel");
		// Cast
		((Humano) mam[2]).setCordePele("Branco");

		mam[3] = new Mamiferos();
		mam[3].setCorPelo("Azul");
		mam[3].setIdade(20);
		mam[3].setNome("Avatar");
		for (int i = 0; i < 4; i++) {
			System.out.println("Nome: " + mam[i].getNome());
			System.out.println("Nome: " + mam[i].getCorPelo());
			System.out.println("Nome: " + mam[i].getIdade());
			mam[i].Falar();
			if (mam[i] instanceof Humano) {
				System.out.println("Eu sou Humano!");
			}
		}
	}

}
