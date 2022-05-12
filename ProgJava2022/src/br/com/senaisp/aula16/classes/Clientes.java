package br.com.senaisp.aula16.classes;

public class Clientes {

	private int Codigo;
	private String Nome;
	private String Endereco;

	public int getCodigo() {
		return Codigo;
	}
	
/**
 * Setter para o c�digo. Dever� ser um n�mero entre 1 a 99
 * @param codigo Informar um c�digo de 1 a 99
 * @throws Exception Caso seja informado um c�digo menor que 1 ou maior que 99 ocorrer� erro.
 */
	public void setCodigo(int codigo) throws ParametroInvalidoException {
		if (codigo > 0 && codigo < 100) 
			this.Codigo = codigo;
		else
		throw new ParametroInvalidoException("Digite um numero de 1 a 99!");
	}

	public String getNome() {
		return Nome;
	}
/**
 * Setter para o nome. Dever� ter pelo menos 3 caracteres.
 * @param nome Informar nome com pelo menos 3 caracteres.
 * @throws Exception Caso seja informado nome com menos de 3 caracteres ocorrer� erro.
 */
	public void setNome(String nome) throws ParametroInvalidoException {
		if (nome.length() >= 3) 
			this.Nome = nome;
		else
		throw new ParametroInvalidoException("Nome inv�lido!");
	}

	public String getEndereco() {
		return Endereco;
	}

/**
 * Setter para o endere�o. Dever� ter pelo menos 3 caracteres.
 * @param endereco Informar endere�o com pelo menos 3 caracteres.
 * @throws Exception Caso seja informado endere�o com menos de 3 caracteres ocorrer� erro.
 */
	public void setEndereco(String endereco) throws ParametroInvalidoException {
		if (endereco.length() >= 3) 
			this.Endereco = endereco;
		else
		throw new ParametroInvalidoException("Endere�o inv�lido!");

	}

}
