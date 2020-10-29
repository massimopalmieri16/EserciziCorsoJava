package ClassificaSerieA;

public class ClassificaSerieA {
	Squadra[] squadre = new	Squadra[20];
	int nextId = 0;

	public ClassificaSerieA() {}

	public void AggiungiSquadra(String nomeSquadra){
		squadre[nextId] = new Squadra(nextId + 1, nomeSquadra);
		nextId ++;
	}

	public void EsitoPartita(String squadraCasa, int golCasa, String squadraTrasferta, int golTrasferta){
		Squadra casa = CercaSquadra(squadraCasa);
		Squadra trasferta = CercaSquadra(squadraTrasferta);

		if(golCasa > golTrasferta){
			// vittoria casa
			casa.UpdateSquadra(3,golCasa,golTrasferta);
			trasferta.UpdateSquadra(0,golTrasferta,golCasa);
		}else if(golCasa < golTrasferta){
			// vitoria trasferta
			casa.UpdateSquadra(0,golCasa,golTrasferta);
			trasferta.UpdateSquadra(3,golTrasferta,golCasa);
		}else{
			// pareggio
			casa.UpdateSquadra(1,golCasa,golTrasferta);
			trasferta.UpdateSquadra(1,golTrasferta,golCasa);
		}
	}

	public void StampaClassifica(){
		squadre = MergeSortSquadre.mergeSort(squadre,nextId);

		for (Squadra i:squadre) {
			if(i != null) System.out.println("ID: " + i.id + " Nome: " + i.nome + " Punti: " + i.punteggio + " Gol fatti: " + i.golFatti + " Gol subiti: " + i.golSubiti);
		}
		System.out.println("");
	}

	public String getMigliorAttacco(){
		int maxGol = Integer.MIN_VALUE;
		String nomeSquadra = "";

		for(Squadra i:squadre){
			if(i != null && i.golFatti > maxGol){
				maxGol = i.golFatti;
				nomeSquadra = i.getNome();
			}
		}
		return nomeSquadra;
	}

	public String getPeggiorDifesa(){
		int maxGol = Integer.MIN_VALUE;
		String nomeSquadra = "";

		for(Squadra i:squadre){
			if(i != null && i.golSubiti > maxGol){
				maxGol = i.golSubiti;
				nomeSquadra = i.getNome();
			}
		}
		return nomeSquadra;
	}

	private Squadra CercaSquadra(String nomeSquadra){
		for(Squadra i:squadre){
			if(i != null && i.nome.compareTo(nomeSquadra) == 0) return i;
		}
		return null;
	}
}
