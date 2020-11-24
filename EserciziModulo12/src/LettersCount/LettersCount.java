package LettersCount;

import java.util.*;
import java.util.stream.Stream;

public class LettersCount {
	public static void main(String[] args) {
		ArrayList<String> nomi = new ArrayList<>(Arrays.asList("Andrea", "Luigi", "Fabio", "Francesco", "Ferdinando"));

		// Senza Stream
		int somma = 0;
		for (String s : nomi) {
			if(s.toLowerCase().startsWith("f")){
				somma += s.length();
			}
		}
		System.out.println(somma);

		// Con Stream
		System.out.println(nomi.stream().map(String::toLowerCase).filter(n -> n.startsWith("f")).mapToInt(String::length).sum());

	}
}
