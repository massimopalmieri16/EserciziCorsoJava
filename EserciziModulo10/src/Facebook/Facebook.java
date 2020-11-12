package Facebook;

import java.util.*;

public class Facebook {
	//private HashMap<Utente, ArrayList<Utente>> utenti;
	private ArrayList<Utente> utenti;
	private ArrayList<Post> posts;

	public Facebook() {
		utenti = new ArrayList<>();
		posts = new ArrayList<>();
	}

	public void aggiungiUtente(Utente utente){
		utenti.add(utente);
	}

	public void scriviPost(Post post){
		posts.add(post);
	}

	public boolean aggiungiAmico(Utente utente1, Utente utente2){
		if(utenti.contains(utente1) && utenti.contains(utente2)) {
			return utente1.aggiungiAmico(utente2) && utente2.aggiungiAmico(utente1);
		}else{
			return false;
		}
	}

	public boolean rimuoviAmico(Utente utente1, Utente utente2){
		return utente1.rimuoviAmico(utente2) && utente2.rimuoviAmico(utente1);
	}

	public void stampaPostUtente(Utente utente){
		System.out.println("Elenco post di " + utente.getNomeCognome());
		for (Post post : posts) {
			if(post.getAutorePost().equals(utente)){
				System.out.println(post.toString());
			}
		}
	}

	public void likePost(Utente utente, Post post){
		post.aggiungiLike(utente);
	}

	public void stampaCommentiUtente(Utente utente){
		System.out.println("Elenco commenti " + utente.getNomeCognome());
		for (Post post : posts) {
			for (Commento commento : post.getCommenti()) {
				if(commento.getUtente().equals(utente)){
					System.out.println(commento.toString());
				}
			}
		}
	}

	public void stampaUtenti(){
		System.out.println("Elenco utenti");
		for (Utente utente : utenti) {
			System.out.println(utente.toString());
		}
	}
}
