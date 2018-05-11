package Relatorio;

import java.util.ArrayList;


public class RelatorioBasico extends Relatorio {
	
	Cliente cliente = null;
	int aux = 0;
	
	@Override
	public Cliente tipoDoRelatorio(String line) {
		if(aux == 0) {
			cliente = new Cliente();
			cliente.setNome(line);
		}
		if(aux == 1) {
			cliente.setSexo(line);
		}
		if(aux == 2) {
			cliente.setIdade(Integer.parseInt(line));
		}
		if(aux == 3) {
			cliente.setSalario(Double.parseDouble(line));
			aux = -1;
		}
		aux++;
		return cliente;
	}
	
	@Override
	public void apresentarRelatorio(ArrayList<Cliente> listaClientes) {
		for(Cliente cli : listaClientes) {
			System.out.println("Nome: " + cli.getNome() + ", tem " + cli.getIdade() + " anos, é do sexo " + cli.getSexo() + " e seu salário é de " + cli.getSalario() + " reais.");
		}
	}

}
