package br.com.senaisp.aula30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExemploArrayList {

	private List<String> listaFilmes;

	public static void main(String[] args) {
		ExemploArrayList ex = new ExemploArrayList();
		ex.listaFilmes = new ArrayList<String>();
		
		System.out.println("Exemplo de uso de interface LIST");
			
		ex.insereInicio("Blade Runner - O ca�ador de androides");
		ex.insereInicio("O exterminador do futuro 2");
		
		ex.insereFim("Apocalipse Now");
		ex.insereFim("Star Wars IV - Uma nova experi�ncia");
		
		ex.insereInicio("Curtindo a vida adoidado");
		ex.insereFim("Dr�cula - De Bram Stocker");
		ex.insereInicio("2001 - Uma odisseia no espa�o");
		
		ex.imprimirLista();
		
		ex.removeInicio();
		ex.removeFim();
		
		ex.imprimirLista();
	}

	public void insereInicio(String strTitulo) {
		listaFilmes.add(0, strTitulo);
	}

	public void insereFim(String strTitulo) {
		listaFilmes.add(strTitulo);
	}

	public void removeInicio() {
		listaFilmes.remove(0);
	}

	public void removeFim() {
		int ult = listaFilmes.size() - 1;
		listaFilmes.remove(ult);
	}

	public void imprimirLista() {
		System.out.println();
		System.out.println();
		Iterator<String> iteratorLista = listaFilmes.iterator();
		while(iteratorLista.hasNext()) {
		System.out.println("T�tulo do Filme: " + iteratorLista.next());
		}
	}
}
