package CarSharing;

public class Noleggio {
	private final Utente utente;
	private final Vettura vettura;
	private final int minutiNoleggio;

	public Noleggio(Utente utente, Vettura vettura, int minutiNoleggio) {
		this.utente = utente;
		this.vettura = vettura;
		this.minutiNoleggio = minutiNoleggio;
	}

	@Override
	public String toString() {
		return utente.getEmail() + " ha noleggiato " + vettura.getTarga() + " per " + minutiNoleggio + " minuti";
	}
}
