package br.com.senaisp.aula30;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class ExemploTreeSet {

	private Set<String> listaFilmes;

	public static void main(String[] args) {
		ExemploTreeSet ex = new ExemploTreeSet();
		ex.listaFilmes = new TreeSet<String>();

		System.out.println("Exemplo de uso de interface LinkedList");

		ex.insere("Blade Runner - O caçador de androides");
		ex.insere("O exterminador do futuro 2");

		ex.insere("Apocalipse Now");
		ex.insere("Star Wars IV - Uma nova esperança");

		ex.insere("Curtindo a vida adoidado");
		ex.insere("Drácula - De Bram Stocker");
		ex.insere("2001 - Uma odisseia no espaço");

		ex.imprimirLista();

		ex.remove("Apocalipse Now");
		ex.remove("2001 - Uma odisseia no espaço");

		ex.imprimirLista();
	}

	public void insere(String strTitulo) {
		listaFilmes.add(strTitulo);
	}

	public void remove(String strTitulo) {
		listaFilmes.remove(strTitulo);
	}

	public void imprimirLista() {
		System.out.println();
		System.out.println();
		Iterator<String> iteratorLista = listaFilmes.iterator();
		while (iteratorLista.hasNext()) {
			System.out.println("Título do Filme: " + iteratorLista.next());
		}
	}
}
