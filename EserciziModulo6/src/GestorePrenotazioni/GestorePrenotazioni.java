package GestorePrenotazioni;

public class GestorePrenotazioni {
	private Prenotazione[] postiInterni, postiEsterni;

	GestorePrenotazioni(int numPostiInterni, int numPostiEsterni) {
		this.postiInterni = new Prenotazione[numPostiInterni];
		this.postiEsterni = new Prenotazione[numPostiEsterni];
	}

	public boolean prenota(Prenotazione prenotazione){
		// ciclo array prenotazioni
		return true;
	}

	public Prenotazione[] prenotazioniAttualiInterno(){
		return postiInterni;
	}

	public Prenotazione[] prenotazioniAttualiEsterno(){
		return postiEsterni;
	}

}
