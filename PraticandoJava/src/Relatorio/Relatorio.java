package Relatorio;

import java.util.ArrayList;

public abstract class Relatorio {
	
	public abstract Cliente tipoDoRelatorio(String line);
	
	public abstract boolean tipoDoRelatorioFinalizado();
	
	public abstract void tipoDoRelatorioFinalizado(boolean finalizado);
	
	public abstract void apresentarRelatorio(ArrayList<Cliente> listaClientes);

}
