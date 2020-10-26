package DittaRiparazione;

public class DittaRiparazioni {
	Riparazione[] riparazioni = new Riparazione[100];
	Tecnico[] tecnici = new Tecnico[100];
	int cont_riparazioni = 0;

	public void aggiungiRiparazione(String indirizzo, PrioritàIntervento prioritàIntervento, StatoRiparazione statoRiparazione){
		riparazioni[cont_riparazioni] = new Riparazione(indirizzo, prioritàIntervento, statoRiparazione);
		cont_riparazioni ++;
	}

	public void estraiRiparazioni(){
		for (Riparazione i:riparazioni) {
			if(i != null && i.statoRiparazione == StatoRiparazione.ATTESA){
				System.out.println(i.indirizzo);
			}
		}
	}

	public void estraiRiparazionePriorità(){
		Riparazione prioritàAlta = null;
		Riparazione prioritàMedia = null;
		Riparazione prioritàBassa = null;

		for (Riparazione i:riparazioni) {
			if(i != null && i.statoRiparazione != StatoRiparazione.CONCLUSA){
				if(i.prioritàIntervento == PrioritàIntervento.ALTA && prioritàAlta == null) prioritàAlta = i;
				if(i.prioritàIntervento == PrioritàIntervento.MEDIA && prioritàMedia == null) prioritàMedia = i;
				if(i.prioritàIntervento == PrioritàIntervento.BASSA && prioritàBassa == null) prioritàBassa = i;
			}
		}
		if(prioritàAlta != null) {
			System.out.println(prioritàAlta.indirizzo);
		}else if(prioritàMedia != null){
			System.out.println(prioritàMedia.indirizzo);
		}else if(prioritàBassa != null){
			System.out.println(prioritàBassa.indirizzo);
		}
	}
}
