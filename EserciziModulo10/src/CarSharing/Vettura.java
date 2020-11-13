package CarSharing;

import java.util.Objects;

public class Vettura {
	private String targa;
	private int postiDisponibili;
	private int livelloCarburante;
	private int prezzoMinuto;
	private Parcheggio parcheggio; // if null vettura in movimento

	public Vettura(String targa, int postiDisponibili, int prezzoMinuto, Parcheggio parcheggio) {
		this.targa = targa;
		this.postiDisponibili = postiDisponibili;
		this.prezzoMinuto = prezzoMinuto;
		this.parcheggio = parcheggio;
		parcheggio.occupaPosto();
		livelloCarburante = 100;
	}

	public int getPrezzoMinuto(){
		return prezzoMinuto;
	}

	public Parcheggio getParcheggio() {
		return parcheggio;
	}
	public void setParcheggio(Parcheggio parcheggio) {
		this.parcheggio = parcheggio;
	}

	public String getTarga(){
		return targa;
	}

	public boolean parcheggiaVettura(Parcheggio parcheggio) {
		if(parcheggio.occupaPosto()) {
			this.parcheggio = parcheggio;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vettura vettura = (Vettura) o;
		return Objects.equals(targa, vettura.targa);
	}

	@Override
	public int hashCode() {
		return Objects.hash(targa);
	}
}
