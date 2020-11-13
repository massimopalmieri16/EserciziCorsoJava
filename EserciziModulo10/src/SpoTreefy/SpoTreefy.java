package SpoTreefy;

import java.util.HashSet;

public class SpoTreefy {
	private HashSet<Utente> utenti;
	private HashSet<Canzone> canzoni;
	private HashSet<Playlist> playlistHashSet;

	public SpoTreefy() {
		utenti = new HashSet<>();
		canzoni = new HashSet<>();
		playlistHashSet = new HashSet<>();
	}

	public boolean aggiungiUtente(Utente u){
		if(utenti.add(u)){
			System.out.println("Utente aggiunto correttamente");
			return true;
		}else {
			System.out.println("Utente non aggiunto correttamente");
			return false;
		}
	}

	public boolean aggiungiCanzone(Canzone c){
		if(canzoni.add(c)){
			System.out.println("Brano aggiunto correttamente");
			return true;
		}else {
			System.out.println("Brano non aggiunto correttamente");
			return false;
		}
	}

	public boolean aggiungiPlaylist(Playlist p){
		if(playlistHashSet.add(p)){
			System.out.println("Playlist aggiunta correttamente");
			return true;
		}else {
			System.out.println("Playlist non aggiunta correttamente");
			return false;
		}
	}

	public boolean cancellaPlaylist(Utente u, Playlist p){
		if(p.getProprietario().equals(u)){
			if(playlistHashSet.remove(p)){
				System.out.println("Playlist cancellata correttamente");
				return true;
			}else{
				System.out.println("Playlist non esistente");
				return false;
			}
		}else {
			System.out.println("Non sei il proprietario della playlist");
			return false;
		}
	}

	public boolean aggiungiBranoPlaylist(Playlist p, Canzone c){
		if(playlistHashSet.contains(p)){
			if(p.aggiungiCanzone(c)){
				System.out.println("Canzone aggiunta correttamente");
				return true;
			}else{
				System.out.println("Canzone già presente nella playlist");
				return false;
			}
		}else{
			System.out.println("Playlist non esistente");
			return false;
		}
	}

	public boolean rimuoviBranoPlaylist(Playlist p, Canzone c){
		if(playlistHashSet.contains(p)){
			if(p.rimuoviCanzone(c)){
				System.out.println("Canzone rimossa correttamente");
				return true;
			}else{
				System.out.println("Canzone non presente nella playlist");
				return false;
			}
		}else{
			System.out.println("Playlist non esistente");
			return false;
		}
	}

	public boolean aggiungiBranoCoda(Utente u, Canzone c){
		if(!utenti.contains(u)) {
			System.out.println("Utente non registrato");
			return false;
		}else {
			u.aggiungiBranoCoda(c);
			return true;
		}
	}

	public boolean aggiungiBranoProssimo(Utente u, Canzone c){
		if(!utenti.contains(u)) {
			System.out.println("Utente non registrato");
			return false;
		}else {
			u.aggiungiBranoProssimo(c);
			return true;
		}
	}

	public Canzone riproduciBranoSuccessivo(Utente u){
		if(!utenti.contains(u)) {
			System.out.println("Utente non registrato");
			return null;
		}else {
			return u.riproduciBranoSuccessivo();
		}
	}

	public boolean svuotaCodaRiproduzione(Utente u){
		if(!utenti.contains(u)) {
			System.out.println("Utente non registrato");
			return false;
		}else {
			u.svuotaCodaRiproduzione();
			return true;
		}
	}

	public boolean aggiungiPlaylistCoda(Utente u, Playlist p){
		if(!utenti.contains(u)) {
			System.out.println("Utente non registrato");
			return false;
		}else if(!playlistHashSet.contains(p)) {
			System.out.println("Playlist non esistente");
			return false;
		}else {
			u.aggiungiPlaylistCoda(p);
			return true;
		}
	}

	public void stampaCodaRiproduzione(Utente u){
		u.stampaCodaRiproduzione();
	}

	public void stampaStoricoRiproduzione(Utente u){
		u.stampaStoricoRiproduzione();
	}
}
