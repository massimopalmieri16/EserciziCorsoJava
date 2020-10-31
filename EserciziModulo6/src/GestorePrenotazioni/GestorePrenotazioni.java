package GestorePrenotazioni;

public class GestorePrenotazioni {
	private int nPostiInterno, nPostiEsterno;
	private Prenotazione prenotazioniInterno[] = new Prenotazione[100];
	private Prenotazione prenotazioniEsterno[] = new Prenotazione[100];

	GestorePrenotazioni(int nPostiInterno, int nPostiEsterno) {
		this.nPostiInterno = nPostiInterno;
		this.nPostiEsterno = nPostiEsterno;
	}

	public boolean prenota(Prenotazione p) {
		boolean prenotazioneInserita;
		if (p instanceof PrenotazioneSingola) {
			PrenotazioneSingola prenotazioneSingola = (PrenotazioneSingola) p;
			if (prenotazioneSingola.getPreferenza() == Preferenza.INTERNO) {
				prenotazioneInserita = inserisciPrenotazioneInterno(p);
				if(!prenotazioneInserita)
					prenotazioneInserita = inserisciPrenotazioneEsterno(p);
			}
			else {
				prenotazioneInserita = inserisciPrenotazioneEsterno(p);
				if(!prenotazioneInserita)
					prenotazioneInserita = inserisciPrenotazioneInterno(p);
			}
			return prenotazioneInserita;
		}
		else {
			prenotazioneInserita = inserisciPrenotazioneInterno(p);
			if(!prenotazioneInserita)
				prenotazioneInserita = inserisciPrenotazioneEsterno(p);
			return prenotazioneInserita;
		}

	}

	private boolean inserisciPrenotazioneInterno(Prenotazione p) {
		int prenotazioniInternoAttuali = postiOccupati(prenotazioniInterno);
		if (prenotazioniInternoAttuali < nPostiInterno) {
			for (int i = 0; i < prenotazioniInterno.length; i++)
				if (prenotazioniInterno[i] == null) {
					prenotazioniInterno[i] = p;
					return true;
				}
			return  false;
		}
		return false;
	}

	private boolean inserisciPrenotazioneEsterno(Prenotazione p) {
		int prenotazioniEsternoAttuali = postiOccupati(prenotazioniEsterno);
		if (prenotazioniEsternoAttuali < nPostiEsterno) {
			for (int i = 0; i < prenotazioniEsterno.length; i++)
				if (prenotazioniEsterno[i] == null) {
					prenotazioniEsterno[i] = p;
					return true;
				}
			return  false;
		}
		return false;
	}

	private int postiOccupati(Prenotazione[] prenotazioni) {
		int prenotazioniAttuali = 0;
		for(int i=0; i<prenotazioni.length; i++) {
			if(prenotazioni[i] != null)
				prenotazioniAttuali += prenotazioni[i].getNumPosti();
		}
		return prenotazioniAttuali;
	}

	public boolean terminaPrenotazione(Prenotazione prenotazione) {
		boolean prenotazioneTrovata = false;
		for (int i = 0; i < prenotazioniInterno.length; i++)
			if (prenotazioniInterno[i].getCode().equals(prenotazione.getCode())) {
				prenotazioniInterno[i] = null;
				return true;
			}
		for (int i = 0; i < prenotazioniEsterno.length; i++)
			if (prenotazioniEsterno[i].getCode().equals(prenotazione.getCode())) {
				prenotazioniEsterno[i] = null;
				return true;
			}
		return false;
	}
	public Prenotazione[] prenotazioniAttualiInterno(){
		return prenotazioniInterno;
	}

	public Prenotazione[] prenotazioniAttualiEsterno(){
		return prenotazioniEsterno;
	}

}
