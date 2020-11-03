package Treno;

public class Passeggero {
	private String nome;
	private String codiceBiglietto;
	private TipoVagone vagoneBiglietto;

	Passeggero(String nome, String codiceBiglietto, TipoVagone vagoneBiglietto){
		this.nome = nome;
		this.codiceBiglietto = codiceBiglietto;
		this.vagoneBiglietto = vagoneBiglietto;
	}

	public TipoVagone getTipoBiglietto() {
		return vagoneBiglietto;
	}
}
