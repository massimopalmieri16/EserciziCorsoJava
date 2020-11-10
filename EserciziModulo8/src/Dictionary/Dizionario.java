package Dictionary;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Dizionario {
	private TreeMap<Character, TreeSet<Parola>> dizionario;

	public Dizionario() {
		this.dizionario = new TreeMap<>();
	}

	public void aggiungiParola(String parola, String significato){
		Character iniziale = parola.charAt(0);
		if(dizionario.containsKey(iniziale)){
			// se iniziale presente cerco se presente nel dizionario e in caso aggiungo significato
			for (Parola i : dizionario.get(iniziale)) {
				if(i.getParola().equals(parola)){
					i.aggiungiSignificato(significato);
				}else{
					dizionario.get(iniziale).add(new Parola(parola, significato));
				}
			}
		}else{
			// se iniziale non presente aggiungo elemento a dizionario
			TreeSet<Parola> parole = new TreeSet<>();
			parole.add(new Parola(parola, significato));
			dizionario.put(parola.charAt(0), parole);
		}
	}

	public void aggiungiSignificato(String parola, String significato){
		aggiungiParola(parola, significato);
	}

	public void stampaDizionario(){
		for (Map.Entry<Character, TreeSet<Parola>> entry : dizionario.entrySet()) {
			System.out.println(entry.getKey() + " : [" + entry.getValue().toString() + "]");
		}
	}
}
