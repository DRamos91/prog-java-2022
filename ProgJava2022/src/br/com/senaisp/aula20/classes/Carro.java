package br.com.senaisp.aula20.classes;

public class Carro extends Veiculo {

	private String volante;
	
	@Override
	public void ligarVeiculo() {
		System.out.println("Ligando o carro!");

	}

	public Carro(String marca, String modelo, int anoFabricacao, String motor, String volante) {
		super(marca, modelo, anoFabricacao, motor);
		this.volante = volante;
	}

	public String getVolante() {
		return volante;
	}

	public void setVolante(String volante) {
		this.volante = volante;
	}

}
