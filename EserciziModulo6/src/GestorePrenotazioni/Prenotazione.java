package GestorePrenotazioni;

public class Prenotazione {
	String id;
	Preferenza preferenza;
	int numPosti;

	Prenotazione(String id, Preferenza preferenza, int numPosti){
		this.id = id;
		this.preferenza = preferenza;
		this.numPosti = numPosti;
	}
}
