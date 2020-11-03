package Treno;

import java.util.ArrayList;

public abstract class Treno {
	private String codice;
	private int velAttuale;
	private int maxVagoni;
	private boolean inStazione;
	private ArrayList<Vagone> vagoni = new ArrayList<>();

	Treno(String codice, int maxVagoni){
		this.codice = codice;
		this.maxVagoni = maxVagoni;
		velAttuale = 0;
		inStazione = false;
	}

	public void parti(){
		chiudiPorte();
		velAttuale = 100;
		inStazione = false;
	}

	public void entraInStazione(){
		fermati();
		inStazione = true;
		apriPorte();
	}

	public void fermati(){
		velAttuale = 0;
	}

	public boolean addVagone(Vagone vagone){
		if(vagoni.size() < maxVagoni && inStazione){
			vagoni.add(vagone);
			return true;
		}else {
			return false;
		}
	}

	public boolean removeVagone(int indiceVagone){
		if(vagoni.size() > 0 && inStazione && indiceVagone < vagoni.size()){
			Vagone vagone = vagoni.get(indiceVagone);
			return vagone.vagoneVuoto() && vagoni.remove(vagone);
		}else {
			return false;
		}
	}

	public void apriPorte(){
		for(Vagone i:vagoni){
			i.apriPorte();
		}
	}

	public void chiudiPorte(){
		for(Vagone i:vagoni){
			i.chiudiPorte();
		}
	}

	public boolean salePassegero(Passeggero passeggero, int indiceVagone){
		if(inStazione && indiceVagone < vagoni.size()) {
			Vagone vagone = vagoni.get(indiceVagone);
			return vagone.salePassegero(passeggero);
		}else {
			return false;
		}
	}
	public boolean scendePassegero(Passeggero passeggero, int indiceVagone){
		if(inStazione && indiceVagone < vagoni.size()) {
			Vagone vagone = vagoni.get(indiceVagone);
			return vagone.scendePassegero(passeggero);
		}else {
			return false;
		}
	}
}
