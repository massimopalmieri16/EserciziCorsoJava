package GestorePrenotazioni;

public class Prenotazione {
	String code;
	int numPosti;

	Prenotazione(String code, int numPosti){
		this.code = code;
		this.numPosti = numPosti;
	}

	public String getCode() {
		return code;
	}

	public int getNumPosti() {
		return numPosti;
	}
}
