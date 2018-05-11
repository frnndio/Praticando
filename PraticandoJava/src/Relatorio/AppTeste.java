package Relatorio;

public class AppTeste {
	
	public static void main(String[] args) {
		
		Leitor leitor = new Leitor();
		RelatorioBasico relatorio = new RelatorioBasico();
		
		relatorio.apresentarRelatorio(leitor.lerRelatorio("C:/arquivo.txt", relatorio));
	}

}