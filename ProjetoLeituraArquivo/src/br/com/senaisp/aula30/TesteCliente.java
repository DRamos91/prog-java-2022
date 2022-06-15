package br.com.senaisp.aula30;

import br.com.senaisp.aula30.classes.Cliente;
import br.com.senaisp.aula30.classes.Cliente.TipoArquivo;

public class TesteCliente {

	public static void main(String[] args) {

		Cliente cli = new Cliente();
		cli.importarArquivo("C:\\Users\\Aluno\\Downloads\\convertcsv.csv", TipoArquivo.CSV);
		for (Object obj[] : cli.getLstClientes()) {
			System.out.println(obj[0]);
		}
	}

}
