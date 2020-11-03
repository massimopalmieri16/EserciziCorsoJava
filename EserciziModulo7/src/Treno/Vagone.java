package Treno;

import java.util.ArrayList;

public abstract class Vagone {
	private int idVagone;
	private int capienzaMassima;
	private final TipoVagone tipoVagone;
	private StatoPorte[] porte;
	private ArrayList<Passeggero> passeggeri = new ArrayList<>();

	Vagone(int capienzaMassima, TipoVagone tipoVagone){
		this.capienzaMassima = capienzaMassima;
		this.tipoVagone = tipoVagone;
		porte = new StatoPorte[4];
		apriPorte();
	}

	public void apriPorte(){
		for(int i = 0; i < porte.length; i ++){
			if(porte[i] != StatoPorte.GUASTE) porte[i] = StatoPorte.APERTE;
		}
	}

	public void chiudiPorte(){
		for(int i = 0; i < porte.length; i ++){
			if(porte[i] != StatoPorte.GUASTE) porte[i] = StatoPorte.CHIUSE;
		}
	}

	public boolean vagoneVuoto(){
		return passeggeri.size() == 0;
	}

	public boolean salePassegero(Passeggero passeggero){
		if(passeggeri.size() < capienzaMassima) {
			return passeggeri.add(passeggero);
		}else{
			return false;
		}
	}

	public boolean scendePassegero(Passeggero passeggero){
		if(passeggeri.size() > 0) {
			return passeggeri.remove(passeggero);
		}else{
			return false;
		}
	}

	public int getCapienzaMassima() {
		return capienzaMassima;
	}

	public TipoVagone getTipoVagone() {
		return tipoVagone;
	}
}
