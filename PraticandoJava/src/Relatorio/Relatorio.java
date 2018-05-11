package Relatorio;

import java.util.ArrayList;

import Praticando.Cliente;

public abstract class Relatorio {
	
	public abstract Cliente tipoDoRelatorio(String line);
	
	public abstract void apresentarRelatorio(ArrayList<Cliente> listaClientes);

}
