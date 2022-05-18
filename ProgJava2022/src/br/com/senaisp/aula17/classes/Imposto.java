package br.com.senaisp.aula17.classes;

/**
 * Classe Base para calculo de Imposto
 * 
 * @author Daniel
 * @since 2022-05-16
 * @version 1.0.0
 * 
 */

public class Imposto {
	private double BaseCalculo;
	private double Aliquota;

	/**
	 * Metodo que retorna o valor do imposto calculado para base nos campos
	 * BaseCalculo e Aliquota
	 * 
	 * @return Retorna o valor do imposto calculado;
	 */

	public double calcularImposto() {
		return BaseCalculo * Aliquota / 100;
	}

	public double getBaseCalculo() {
		return BaseCalculo;
	}

	/**
	 * Setter de Base de Calculo
	 * 
	 * @param baseCalculo Devera ser informada a base de calculo para o imposto,
	 *                    esta devera ser maior que zero
	 * @throws Exception ocorrera uma exception para valores inválidos
	 */
	public void setBaseCalculo(double baseCalculo) throws Exception {
		if (BaseCalculo < 0) {
			throw new Exception("Digite um valor positivo!");
		}
		BaseCalculo = baseCalculo;
	}

	public double getAliquota() {
		return Aliquota;
	}

	/**
	 * Setter de Aliquota do Imposto
	 * 
	 * @param aliquota Devera ser informada uma aliquota maior que 0 e menor que 99
	 * @throws Exception ocorrera uma exception para valores inválidos
	 */
	public void setAliquota(double aliquota) throws Exception {
		if (Aliquota <= 0 || Aliquota >= 100)
			throw new Exception("Digite um valor de 1 à 99!");
		Aliquota = aliquota;
	}

}
