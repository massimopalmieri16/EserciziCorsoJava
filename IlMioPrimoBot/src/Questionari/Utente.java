package Questionari;

public class Utente {
	private Questionario questionarioCorrente;
	private Domanda domandaCorrente;
	private int punteggioCorrente;
	private long iDUtente;

	public Utente(Long iDUtente) {
		this.iDUtente = iDUtente;
		questionarioCorrente = null;
		domandaCorrente = null;
		punteggioCorrente = 0;
	}

	public long getiDUtente() {
		return iDUtente;
	}

	public Questionario getQuestionarioCorrente() {
		return questionarioCorrente;
	}

	public Domanda getDomandaCorrente() {
		return domandaCorrente;
	}

	public int getPunteggioCorrente() {
		return punteggioCorrente;
	}

	public void setQuestionarioCorrente(Questionario questionarioCorrente) {
		this.questionarioCorrente = questionarioCorrente;
	}

	public void setDomandaCorrente(Domanda domandaCorrente) {
		this.domandaCorrente = domandaCorrente;
	}

	public void setPunteggioCorrente(int punteggioCorrente) {
		this.punteggioCorrente = punteggioCorrente;
	}
}
