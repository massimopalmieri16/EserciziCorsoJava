package Dictionary;

import java.util.ArrayList;

public class Parola implements Comparable<Parola> {
	private String parola;
	private ArrayList<String> significati;

	public Parola(String parola, String significato) {
		this.parola = parola;
		significati = new ArrayList<>();
		significati.add(significato);
	}

	public String getParola() {
		return parola;
	}

	public void aggiungiSignificato(String significato){
		significati.add(significato);
	}

	@Override
	public int compareTo(Parola p) {
		return this.getParola().compareTo(p.getParola());
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder(this.getParola() + " (");
		for(int i = 0; i < significati.size(); i ++){
			out.append(significati.get(i));
			if(i < significati.size() - 1) out.append("; ");
		}
		out.append(")");
		return out.toString();
	}
}
