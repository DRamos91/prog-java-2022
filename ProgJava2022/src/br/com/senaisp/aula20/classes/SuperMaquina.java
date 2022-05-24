package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class SuperMaquina extends Carro implements InFalantes {

	public SuperMaquina(String marca, String modelo, int anoFabricacao, String motor, String volante) {
		super(marca, modelo, anoFabricacao, motor, volante);
	}

	@Override
	public void falar() {
		System.out.println("Olá, em que posso ajudar?");

	}

	@Override
	public void ligarVeiculo() {
		System.out.println("Super máquina ligando!");
	}
	
	
}
