package GestorePrenotazioni;

public class PrenotazioneSingola extends Prenotazione{
	Preferenza preferenza;

	public PrenotazioneSingola(String id, Preferenza preferenza) {
		super(id, 1);
		this.preferenza = preferenza;
	}

	public Preferenza getPreferenza() {
		return preferenza;
	}
}
