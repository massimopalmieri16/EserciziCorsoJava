package Questionari;

import java.util.ArrayList;

public class Questionario {
	private String nomeQuestionario;
	private ArrayList<Domanda> domande;

	public Questionario(String nomeQuestionario, ArrayList<Domanda> domande) {
		this.nomeQuestionario = nomeQuestionario;
		this.domande = domande;
	}

	public String getNomeQuestionario() {
		return nomeQuestionario;
	}

	public ArrayList<Domanda> getDomande() {
		return domande;
	}
}
