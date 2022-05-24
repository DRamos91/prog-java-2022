package br.com.senaisp.aula20;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import br.com.senaisp.aula20.classes.Cachorro;
import br.com.senaisp.aula20.classes.Carro;
import br.com.senaisp.aula20.classes.Gato;
import br.com.senaisp.aula20.classes.Humano;
import br.com.senaisp.aula20.classes.Mamiferos;
import br.com.senaisp.aula20.classes.Moto;
import br.com.senaisp.aula20.classes.SuperMaquina;
import br.com.senaisp.aula20.classes.Veiculo;
import br.com.senaisp.aula20.interfaces.InFalantes;

public class TesteClassesInterfaces {

	public static void main(String[] args) {
		List<Mamiferos> listaMamiferos = new ArrayList<Mamiferos>();
		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		List<InFalantes> listaInFalantes = new ArrayList<InFalantes>();

		listaMamiferos.add(new Gato("Branco", 10, "SRD"));
		listaMamiferos.add(new Cachorro("Preto", 5, "SRD"));
		listaMamiferos.add(new Humano("Amarelo", 30, "Branco"));

		listaVeiculos.add(new SuperMaquina("Chevrolet", "Cruze", 2022, "Turbo", "Eletrica"));
		listaVeiculos.add(new Carro("Hyundai", "Creta", 2020, "1.6", "Eletrica"));
		listaVeiculos.add(new Moto("Honda", "Titan", 2008, "150cc", ""));

		listaInFalantes.add(new Gato("Malhado", 5, "SRD"));
		listaInFalantes.add(new Cachorro("Cinza", 10, "SRD"));
		listaInFalantes.add(new Humano("Loiro", 30, "Branco"));
		listaInFalantes.add(new SuperMaquina("Honda", "Civic", 2020, "2.0", "Hidraulica"));

		for (int i = 0; i < listaMamiferos.size(); i++) {
			System.out.println(listaMamiferos.get(i).getClass().getName());
		}
		System.out.println("---------------------------------");
		for (int i = 0; i < listaVeiculos.size(); i++) {
			Veiculo vei = listaVeiculos.get(i);
			System.out.println(vei.getClass().getName());
			vei.ligarVeiculo();
		}
		System.out.println("---------------------------------");
		for (int i = 0; i < listaInFalantes.size(); i++) {
			InFalantes fal = listaInFalantes.get(i);
			System.out.println(fal.getClass().getName());
			fal.falar();
		}
	}

}
