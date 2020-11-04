package Treno;

public class BinarioStazione extends Binario{
	private String idStazione;
	BinarioStazione(String idBinario, String idStazione) {
		super(idBinario);
		this.idStazione = idStazione;
	}
}
