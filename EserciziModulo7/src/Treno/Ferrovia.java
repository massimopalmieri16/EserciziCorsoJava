package Treno;

import java.util.ArrayList;

public class Ferrovia {
	private Treno treno;
	private ArrayList<Binario> binari;
	private int indiceBinarioAttuale;

	Ferrovia(Treno treno, ArrayList<Binario> binari){
		this.treno = treno;
		this.binari = binari;
		indiceBinarioAttuale = -1;
	}

	public Binario percorri(Treno treno){
		Binario out = getSuccessivo();
		indiceBinarioAttuale ++;
		return out;
	}

	private Binario getSuccessivo(){
		return binari.get(indiceBinarioAttuale + 1);
	}

}
