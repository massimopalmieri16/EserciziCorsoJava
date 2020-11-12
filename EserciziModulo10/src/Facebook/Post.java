package Facebook;

import java.util.*;

public class Post {
	private Utente autorePost;
	private String testo;
	private ArrayList<Commento> commenti;
	private HashSet<Utente> likes;

	public Post(Utente autorePost, String testo) {
		this.autorePost = autorePost;
		this.testo = testo;
		commenti = new ArrayList<>();
		likes = new HashSet<>();
	}

	public Utente getAutorePost() {
		return autorePost;
	}

	public void aggiungiCommento(Utente autoreCommento, String testo){
		commenti.add(new Commento(autoreCommento, testo));
	}

	public void aggiungiLike(Utente utente){
		likes.add(utente);
	}

	public ArrayList<Commento> getCommenti() {
		return commenti;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("Autore post: ").append(autorePost.getNomeCognome()).append(System.lineSeparator()).append("Testo: ").append(testo);
		out.append(System.lineSeparator()).append("Commenti:").append(System.lineSeparator());
		out.append("Numero like ").append(likes.size());
		for (Commento commento : commenti) {
			out.append(System.lineSeparator());
			out.append(commento.toString());
		}
		return out.toString();
	}
}
