package br.com.senaisp.aula19.classes;

public class FolhaPagamento {
	private int chapa;
	private double salarioBruto;
	private double valorInss;
	private double valorIrrf;

	public double salarioLiquido() {

		return salarioBruto - valorInss - valorIrrf;
	}

	public int getChapa() {
		return chapa;
	}

	public void setChapa(int chapa) throws Exception {
		if (chapa <= 0) {
			throw new Exception("Chapa deve ser maior que zero!");
		}
		this.chapa = chapa;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) throws Exception {
		if (salarioBruto <= 0) {
			throw new Exception("Salario Bruto deve ser maior que zero");
		}
		this.salarioBruto = salarioBruto;
	}

	public double getValorInss() {
		return valorInss;
	}

	public void setValorInss(double valorInss) throws Exception {
		if (valorInss < 0) {
			throw new Exception("Valor do Inss deve ser maior ou igual a zero!");
		}
		this.valorInss = valorInss;
	}

	public double getValorIrrf() {
		return valorIrrf;
	}

	public void setValorIrrf(double valorIrrf) throws Exception {
		if (valorIrrf < 0) {
			throw new Exception("Valor do Irrf deve ser maior ou igual a zero!");
		}
		this.valorIrrf = valorIrrf;
	}

}
