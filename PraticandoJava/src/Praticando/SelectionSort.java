package Praticando;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SelectionSort {
	
	public static void sort(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i].compareToIgnoreCase(a[j]) > 0) {
					String temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		String[] nomes = {"Fernandodes", "Fernando", "Rodrigo", "Alfredo", "Marlom", "aaa", "A", "a", "z", "bb", "aa", "asd", "c", "bcd"};
		
		System.out.println(Arrays.toString(nomes));
		sort(nomes);
		System.out.println(Arrays.toString(nomes));
		
		ArrayList<String> frutas = new ArrayList<>();
		frutas.add("Maça");
		frutas.add("Pera");
		frutas.add("Abacaxi");
		
		Collections.sort(frutas);
		System.out.println(frutas.toString());
		

	}
}
