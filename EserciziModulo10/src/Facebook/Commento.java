package Facebook;

public class Commento {
	private Utente utente;
	private String testo;

	public Commento(Utente utente, String testo) {
		this.utente = utente;
		this.testo = testo;
	}

	public Utente getUtente() {
		return utente;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("Autore commento: ").append(utente.getNomeCognome()).append(System.lineSeparator()).append("Testo: ").append(testo);
		return out.toString();
	}
}
