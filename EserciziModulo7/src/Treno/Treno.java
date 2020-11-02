package Treno;

import java.util.ArrayList;

public class Treno {
	private String codice;
	private int velAttuale;
	private int maxVagoni;
	private int numPasseggeri;
	private StatoPorte statoPorte;

	Treno(String codice, int maxVagoni){
		this.codice = codice;
		this.maxVagoni = maxVagoni;
		velAttuale = 0;
		statoPorte = StatoPorte.CHIUSE;
	}

	public void parti(){
		chiudiPorte();
		velAttuale = 100;
	}

	public void entraInStazione(){
		fermati();
		apriPorte();
	}

	public void fermati(){
		velAttuale = 0;
	}

	public void apriPorte(){
		statoPorte = StatoPorte.APERTE;
	}

	public void chiudiPorte(){
		statoPorte = StatoPorte.CHIUSE;
	}

	public boolean salePassegero(){
		// se porte aperte
		if(statoPorte == StatoPorte.APERTE) {
			numPasseggeri ++;
			return true;
		}else {
			return false;
		}
	}
	public boolean scendePassegero(){
		// se porte aperte e almeno un passeggero a bordo
		if(statoPorte == StatoPorte.APERTE && numPasseggeri > 0) {
			numPasseggeri --;
			return true;
		}else {
			return false;
		}
	}
}
