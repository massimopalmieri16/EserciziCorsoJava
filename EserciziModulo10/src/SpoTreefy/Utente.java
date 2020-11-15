package SpoTreefy;

import java.util.*;

public class Utente {
	private final String email;
	private final String nome;
	private ArrayDeque<Canzone> codaDiRiproduzione;
	private HashSet<Utente> utentiSeguiti;
	private TreeSet<CanzoneStorico> storicoCanzoni;

	public Utente(String email, String nome) {
		this.email = email;
		this.nome = nome;
		codaDiRiproduzione = new ArrayDeque<>();
		utentiSeguiti = new HashSet<>();
		storicoCanzoni = new TreeSet<>();
	}

	public void aggiungiBranoCoda(Canzone c){
		codaDiRiproduzione.offer(c);
	}

	public void aggiungiBranoProssimo(Canzone c){
		codaDiRiproduzione.addFirst(c);
	}

	public Canzone riproduciBranoSuccessivo(){
		if(codaDiRiproduzione.size() == 0) return null;
		Canzone canzone = codaDiRiproduzione.pollFirst();
		// TODO non c'è nessun altro modo più carino per creare un oggetto CanzoneStorica partendo da canzone?
		CanzoneStorico c = new CanzoneStorico(canzone.getTitolo(), canzone.getArtista(), canzone.getAlbum(), canzone.getGenere());
		for (CanzoneStorico canzoneStorico : storicoCanzoni) {
			if(canzoneStorico.equals(c)){
				canzoneStorico.incrAscolti();
				return c;
			}
		}

		System.out.println(storicoCanzoni.add(c));
		c.incrAscolti();
		return c;
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
		if(codaDiRiproduzione.isEmpty()) System.out.println("Coda di riproduzione vuota");
		for (Canzone canzone : codaDiRiproduzione) {
			System.out.println(canzone.toString());
		}
	}

	public void stampaStoricoRiproduzione(){
		System.out.println("Storico canzoni ascoltate di " + this.nome);
		if(storicoCanzoni.isEmpty()) System.out.println("Storico canzoni vuoto");
		for (CanzoneStorico canzoneStorico : storicoCanzoni) {
			System.out.println(canzoneStorico.toString() + " ascoltata " + canzoneStorico.getNumAscolti() + " volte");
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
