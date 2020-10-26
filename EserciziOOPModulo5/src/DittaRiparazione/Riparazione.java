package DittaRiparazione;

public class Riparazione {
	String indirizzo;
	PrioritàIntervento prioritàIntervento;
	StatoRiparazione statoRiparazione;
	Tecnico tecnico;

	Riparazione(String indirizzo, PrioritàIntervento prioritàIntervento, StatoRiparazione statoRiparazione){
		this.indirizzo = indirizzo;
		this.prioritàIntervento = prioritàIntervento;
		this.statoRiparazione = statoRiparazione;
	}

}
