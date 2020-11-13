package SpoTreefy;

import java.util.*;

public class Utente {
	private final String email;
	private final String nome;
	private ArrayDeque<Canzone> codaDiRiproduzione;
	private HashSet<Utente> utentiSeguiti;
	private HashSet<Canzone> storicoCanzoni;
	//private TreeSet<CanzoneStorico> storicoCanzoni;

	public Utente(String email, String nome) {
		this.email = email;
		this.nome = nome;
		codaDiRiproduzione = new ArrayDeque<>();
		utentiSeguiti = new HashSet<>();
		storicoCanzoni = new HashSet<>();
	}

	public void aggiungiBranoCoda(Canzone c){
		codaDiRiproduzione.offer(c);
	}

	public void aggiungiBranoProssimo(Canzone c){
		codaDiRiproduzione.addFirst(c);
	}

	public Canzone riproduciBranoSuccessivo(){
		if(codaDiRiproduzione.size() == 0) return null;
		storicoCanzoni.add(codaDiRiproduzione.pollFirst());
		return codaDiRiproduzione.pollFirst();
		/*Canzone canzone = codaDiRiproduzione.pollFirst();
		CanzoneStorico c = new CanzoneStorico(canzone.getTitolo(), canzone.getArtista(), canzone.getAlbum(), canzone.getGenere());
		for (CanzoneStorico canzoneStorico : storicoCanzoni) {
			if(canzoneStorico.equals(c)){
				canzoneStorico.incrAscolti();
				return c;
			}
		}

		c.incrAscolti();
		System.out.println(storicoCanzoni.add(c));
		return c;*/
	}

	public void svuotaCodaRiproduzione(){
		codaDiRiproduzione.clear();
	}

	public void aggiungiPlaylistCoda(Playlist p){
		codaDiRiproduzione.addAll(p.getCanzoni());
	}

	public boolean seguiUtente(Utente u){
		return utentiSeguiti.add(u);
	}

	public void stampaCodaRiproduzione(){
		System.out.println("Coda di riproduzione di " + this.nome);
		for (Canzone canzone : codaDiRiproduzione) {
			System.out.println(canzone.toString());
		}
	}

	public void stampaStoricoRiproduzione(){
		System.out.println("Storico canzoni ascoltate di " + this.nome);
		for (Canzone canzoneStorico : storicoCanzoni) {
			System.out.println(canzoneStorico.toString() + " ascoltata " /*+ canzoneStorico.getNumAscolti() + " volte"*/);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Utente utente = (Utente) o;
		return Objects.equals(email, utente.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
}
