package Treno;

public class VagoneLetto extends Vagone{
	VagoneLetto(int capienzaMassima) {
		super(capienzaMassima, TipoVagone.LETTO);
	}

	@Override
	public boolean salePassegero(Passeggero passeggero) {
		if(passeggero.getTipoBiglietto() != TipoVagone.LETTO) return false;
		return super.salePassegero(passeggero);
	}

}
