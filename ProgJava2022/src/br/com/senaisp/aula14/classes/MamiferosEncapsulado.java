package br.com.senaisp.aula14.classes;

public class MamiferosEncapsulado {
	private String Pele;
	private String Olhos;
	private String Boca;
	private double Peso;

	public String getPele() {
		return Pele;
	}

	public void setPele(String pele) throws Exception {
		if (!pele.equalsIgnoreCase("branco") && !pele.equalsIgnoreCase("preto") && !pele.equalsIgnoreCase("pardo")
				&& !pele.equalsIgnoreCase("amarelo"))
			throw new Exception("Cor inválida!");
		Pele = pele;
	}

	public String getOlhos() {
		return Olhos;
	}

	/**
	 * Setters dos olhos Valores válidos: castanho, preto, azul, verde.
	 * 
	 * @param olhos Informar a cor dos olhos
	 * @throws Exception
	 */
	public void setOlhos(String olhos) throws Exception {
		if (!olhos.equalsIgnoreCase("castanho") && !olhos.equalsIgnoreCase("preto") && !olhos.equalsIgnoreCase("azul")
				&& !olhos.equalsIgnoreCase("verde"))
			throw new Exception("Cor inválida!");
		Olhos = olhos;
	}

	public String getBoca() {
		return Boca;
	}

	public void setBoca(String boca) throws Exception {
		if (!boca.equalsIgnoreCase("pequena") && !boca.equalsIgnoreCase("média") && !boca.equalsIgnoreCase("grande"))
			throw new Exception("Tamanho inválido!");
		Boca = boca;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

}
