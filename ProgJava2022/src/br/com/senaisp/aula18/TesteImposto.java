package br.com.senaisp.aula18;

import br.com.senaisp.aula17.classes.ImpostoInss;
import br.com.senaisp.aula18.classes.ImpostoIrrf;

public class TesteImposto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImpostoInss imp = new ImpostoInss();
		ImpostoIrrf impir = new ImpostoIrrf();
		double dblSalario = 4000.00;
		
		try {
			imp.setBaseCalculo(dblSalario);
			System.out.println("Inss: " + imp.calcularImposto());
		
			impir.setBaseCalculo(dblSalario - imp.calcularImposto());
			System.out.println("Irrf: " + impir.calcularImposto());
			
			System.out.println("Salario Líquido do coitado:" +
			( dblSalario - imp.calcularImposto() - impir.calcularImposto() )
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
