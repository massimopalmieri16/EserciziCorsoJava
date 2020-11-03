package Treno;

import java.util.ArrayList;

public class VagoneRistorante extends Vagone{
	private ArrayList<Tavolo> tavoli = new ArrayList<>();

	VagoneRistorante(int capienzaMassima) {
		super(capienzaMassima, TipoVagone.RISTORANTE);
		initTavoli();
	}

	@Override
	public boolean salePassegero(Passeggero passeggero) {
		if(passeggero.getTipoBiglietto() == TipoVagone.RISTORANTE){
			// occupo un posto a tavola
			for(int i = 0; i < tavoli.size(); i ++){
				Tavolo tavolo = tavoli.get(i);
				if(tavolo.postiOccupati < Tavolo.postiTavolo){
					tavolo.postiOccupati ++;
					return super.salePassegero(passeggero);
				}
			}
		}
		return false;
	}

	@Override
	public boolean scendePassegero(Passeggero passeggero) {
		for(int i = 0; i < tavoli.size(); i ++) {
			Tavolo tavolo = tavoli.get(i);
			if (tavolo.postiOccupati > 0) {
				tavolo.postiOccupati--;
			}
		}
		return super.scendePassegero(passeggero);
	}

	private void initTavoli(){
		int capienzaMassima = this.getCapienzaMassima();
		int numTavoli = capienzaMassima / Tavolo.postiTavolo + ((capienzaMassima % Tavolo.postiTavolo == 0) ? 0 : 1);
		for(int i = 0; i < numTavoli; i ++){
			tavoli.add(new Tavolo());
		}
	}

	private class Tavolo{
		private static final int postiTavolo = 4;
		private int postiOccupati;

		Tavolo(){
			this.postiOccupati = 0;
		}
	}
}
