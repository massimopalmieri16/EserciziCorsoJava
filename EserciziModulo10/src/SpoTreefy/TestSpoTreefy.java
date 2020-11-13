package SpoTreefy;

public class TestSpoTreefy {
	public static void main(String[] args) {
		SpoTreefy spoTreefy = new SpoTreefy();
		Utente utente1 = new Utente("mail1", "Paolo Paoli");
		Utente utente2 = new Utente("mail2", "Mario Rossi");
		Canzone canzone1 = new Canzone("canzone1", "artista", "album", "genere");
		Canzone canzone2 = new Canzone("canzone2", "artista", "album", "genere");
		Canzone canzone3 = new Canzone("canzone3", "artista", "album", "genere");
		Canzone canzone4 = new Canzone("canzone4", "artista", "album", "genere");
		Playlist playlist = new Playlist(utente1, "prova", null);

		// aggiunta utenti
		spoTreefy.aggiungiUtente(utente1);
		spoTreefy.aggiungiUtente(utente2);

		// test coda brani
		spoTreefy.aggiungiBranoCoda(utente1, canzone1);
		spoTreefy.aggiungiBranoCoda(utente1, canzone2);
		spoTreefy.aggiungiBranoCoda(utente1, canzone2);
		spoTreefy.stampaCodaRiproduzione(utente1);
		spoTreefy.riproduciBranoSuccessivo(utente1);
		spoTreefy.riproduciBranoSuccessivo(utente1);
		spoTreefy.riproduciBranoSuccessivo(utente1);
		spoTreefy.stampaStoricoRiproduzione(utente1);

		// test playlist

	}
}
