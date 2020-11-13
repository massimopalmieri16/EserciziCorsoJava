package CarSharing;

import java.util.*;

public class CarSharing {
	private HashSet<Utente> utenti;
	private HashSet<Vettura> vetture;
	private HashSet<Noleggio> noleggi;

	public CarSharing() {
		utenti = new HashSet<>();
		vetture = new HashSet<>();
		noleggi = new HashSet<>();
	}

	public boolean noleggiaVettura(Utente utente, Vettura vettura, int minutiNoleggio){
		if(vettura.getParcheggio() != null && utente.getCredito() >= vettura.getPrezzoMinuto() * minutiNoleggio){
			noleggi.add(new Noleggio(utente, vettura, minutiNoleggio));
			vettura.setParcheggio(null);
			utente.pagaNoleggio(vettura.getPrezzoMinuto() * minutiNoleggio);
			return true;
		}else {
			return false;
		}
	}

	public boolean terminaNoleggio(Vettura vettura, Parcheggio parcheggio){
		return vettura.parcheggiaVettura(parcheggio);
	}

	public boolean aggiungiUtente(Utente utente){
		return utenti.add(utente);
	}

	public boolean aggiungiVettura(Vettura vettura){
		return vetture.add(vettura);
	}

	public void stampaNoleggiUtente(Utente utente){
		for (Noleggio noleggio : noleggi) {
			System.out.println(noleggio.toString());
		}
	}

	public void stampaStatoVetture(){
		System.out.println("Stato vetture");
		for (Vettura vettura : vetture) {
			StringBuilder stato = new StringBuilder();
			stato.append("Targa: ").append(vettura.getTarga());
			stato.append(" ").append((vettura.getParcheggio() == null) ? ("Noleggio in corso"):(vettura.getParcheggio().getPosizioneParcheggio()));
			System.out.println(stato.toString());
		}
	}
}
