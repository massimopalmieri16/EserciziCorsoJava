package ClassificaSerieA;

public class Squadra {
	int id;
	String nome;
	Giocatore[] giocatori = new Giocatore[24];
	int punteggio;
	int golFatti;
	int golSubiti;

	Squadra(int id, String nome){
		this.id = id;
		this.nome = nome;
	}

	public void UpdateSquadra(int incrPunt, int incrGolFat, int incrGolSub){
		this.punteggio += incrPunt;
		this.golFatti += incrGolFat;
		this.golSubiti += incrGolSub;
	}

	public String getNome(){
		return this.nome;
	}
}
