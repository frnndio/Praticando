package Relatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Leitor {
	
	Charset utf8 = StandardCharsets.UTF_8;
	Path path = null;
	String line = null;
	
	public ArrayList<String> ler(String url) {
		path = Paths.get(url);
		ArrayList<String> lines = null;
		try (BufferedReader reader = Files.newBufferedReader(path, utf8)) {
			lines = new ArrayList<>();
			while((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public ArrayList<Object> lerRelatorio(String url, Relatorio relatorio) {
		path = Paths.get(url);
		ArrayList<Object> lines = null;
		try (BufferedReader reader = Files.newBufferedReader(path, utf8)) {
			lines = new ArrayList<>();
			while((line = reader.readLine()) != null) {
				lines.add(relatorio.tipoDoRelatorio(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
