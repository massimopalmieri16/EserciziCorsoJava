package DittaRiparazione;

public class TestDittaRiparazioni {
	public static void main(String[] args) {
		DittaRiparazioni dittaRiparazioni = new DittaRiparazioni();

		dittaRiparazioni.aggiungiRiparazione("via prova 1", PrioritàIntervento.MEDIA, StatoRiparazione.ATTESA);
		dittaRiparazioni.aggiungiRiparazione("via prova 2", PrioritàIntervento.BASSA, StatoRiparazione.ATTESA);
		dittaRiparazioni.aggiungiRiparazione("via prova 3", PrioritàIntervento.BASSA, StatoRiparazione.ATTESA);
		dittaRiparazioni.aggiungiRiparazione("via prova 4", PrioritàIntervento.BASSA, StatoRiparazione.CONCLUSA);
		dittaRiparazioni.estraiRiparazionePriorità();
	}
}
