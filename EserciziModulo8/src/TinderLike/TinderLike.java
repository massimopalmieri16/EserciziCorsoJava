package TinderLike;

import java.util.*;

public class TinderLike {
	private HashMap<String, HashSet<String>> utenti;

	public TinderLike() {
		utenti = new HashMap<>();
	}

	public boolean aggiungiUtente(String nome, String[] interessi){
		if(!utenti.containsKey(nome)){
			// se utente non presente
			HashSet<String> i = new HashSet<>(Arrays.asList(interessi));
			utenti.put(nome, i);
			return true;
		}else{
			return false;
		}
	}

	public void rimuoviUtente(String nome){
		utenti.remove(nome);
	}

	public void stampaUtenti(){
		for (Map.Entry<String, HashSet<String>> entry : utenti.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue().toString());
		}
	}

	public String getMatch(String utenteInput){
		HashSet<String> interessi = new HashSet<>(utenti.get(utenteInput));
		String utenteOut = "Nobody loves you";
		int numInteressiInComune = 0;
		for (Map.Entry<String, HashSet<String>> entry : utenti.entrySet()) {
			HashSet<String> interessiTemp = new HashSet<>(entry.getValue());
			interessiTemp.retainAll(interessi);
			if(interessiTemp.size() > numInteressiInComune && !entry.getKey().equals(utenteInput)) {
				numInteressiInComune = interessiTemp.size();
				utenteOut = entry.getKey();
			}
		}

		return utenteOut;
	}
}
