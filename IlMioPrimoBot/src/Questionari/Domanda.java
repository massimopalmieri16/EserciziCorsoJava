package Questionari;

import java.util.ArrayList;

public class Domanda {
	private String domanda;
	private ArrayList<Risposta> risposte;

	public Domanda(String domanda, ArrayList<Risposta> risposte) {
		this.domanda = domanda;
		this.risposte = risposte;
	}

	public String getDomanda() {
		return domanda;
	}

	public ArrayList<Risposta> getRisposte() {
		return risposte;
	}

	public boolean checkRispostaCorretta(String risposta){
		for(Risposta i: this.getRisposte()){
			if(risposta.equals(i.getRisposta()) && i.isCorretta()) return true;
		}
		return false;
	}

	public static ArrayList<Domanda> generateDomandeSport(){
		ArrayList<Domanda> domande = new ArrayList<>();
		ArrayList<Risposta> risposte = new ArrayList<>();
		risposte.add(new Risposta("MJ", false));
		risposte.add(new Risposta("LBJ", false));
		risposte.add(new Risposta("Black Mamba", false));
		risposte.add(new Risposta("White Mamba", true));
		domande.add(new Domanda("Who is the GOAT?", risposte));
		risposte = new ArrayList<>();
		risposte.add(new Risposta("Giosuè", false));
		risposte.add(new Risposta("Gigi Datome", true));
		risposte.add(new Risposta("Giovanni", false));
		risposte.add(new Risposta("Cristo", false));
		domande.add(new Domanda("Qual'è il vero nome di Gesù di Nazaret?", risposte));
		return domande;
	}

	public static ArrayList<Domanda> generateDomandeArte(){
		ArrayList<Domanda> domande = new ArrayList<>();
		ArrayList<Risposta> risposte = new ArrayList<>();
		risposte.add(new Risposta("Osvaldo Paniccia", true));
		risposte.add(new Risposta("Giacomo De Michelis", false));
		risposte.add(new Risposta("Fabrizio Spagiari", false));
		risposte.add(new Risposta("Athos Faccincani", false));
		domande.add(new Domanda("Miglior pittore del XXI secolo?", risposte));
		risposte = new ArrayList<>();
		risposte.add(new Risposta("Omayyadi", false));
		risposte.add(new Risposta("Farjid", true));
		risposte.add(new Risposta("Yazdgard", false));
		risposte.add(new Risposta("Abbasidi", false));
		domande.add(new Domanda("Chi era il sultano cha ha commissionato il famoso tappeto Keshan?", risposte));

		return domande;
	}
}
