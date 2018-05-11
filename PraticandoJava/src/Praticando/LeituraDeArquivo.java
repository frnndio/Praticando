package Praticando;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeituraDeArquivo {

	
	
	public static void main(String[] args) {
		
		Path path = Paths.get("C:/arquivo.txt");
		Charset utf8 = StandardCharsets.UTF_8;
		
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		
		try (BufferedReader reader = Files.newBufferedReader(path, utf8)) {
			String line = null;
				
			int aux = 0;
			Cliente cliente = null;
			while((line = reader.readLine()) != null) {
				if (aux == 0) {
					cliente = new Cliente();
					cliente.setNome(line);
				}
				if (aux == 1) {
					cliente.setSexo(line);
				}
				if (aux == 2) {
					cliente.setIdade(Integer.parseInt(line));
					aux = -1;
					listaClientes.add(cliente);
				}
				aux++;
			}
//			relatorio();
			for(Cliente cli : listaClientes) {
				System.out.println("Nome: " + cli.getNome() + ", tem " + cli.getIdade() + " anos e é do sexo " + cli.getSexo() + ".");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


//	public static void relatorio() {
//		
//		for(Cliente cliente : listaClientes) {
//			System.out.println("Nome: " + cliente.getNome() + ", tem " + cliente.getIdade() + " anos e é do sexo " + cliente.getSexo() + ".");
//		}
//		
//	}

}
