package DistributoreDiBevande;

public class DistributoreDiBevande {
	private Bevanda[] bevande;
	private double saldo;
	private int bevandeCount;

	DistributoreDiBevande(int numeriProdotti){
		this.bevande = new Bevanda[numeriProdotti];
		this.saldo = 0;
		this.bevandeCount = 0;
	}

	public double saldoAttuale(){
		return saldo;
	}

	public double getResto(){
		double resto = saldo;
		saldo = 0;
		return resto;
	}

	public void inserisciImporto(double importo){
		saldo += importo;
	}

	public void caricaProdotto(Bevanda bevanda){
		bevande[bevandeCount] = bevanda;
		bevandeCount ++;
	}

	public Bevanda scegliProdotto(String bevanda){
		int indicebevande = 0;
		for(Bevanda i:bevande){
			if(i != null && i.comparaBevanda(bevanda)){
				if (i.getPrezzo() <= saldo){
					saldo -= i.getPrezzo();
					bevande[indicebevande] = null;
					return i;
				}
			}
			indicebevande ++;
		}

		return null;
	}

}
