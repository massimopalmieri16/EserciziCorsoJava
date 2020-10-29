package ClassificaSerieA;

public class TestClassificaSerieA {
	public static void main(String[] args) {
		ClassificaSerieA classificaSerieA = new ClassificaSerieA();

		classificaSerieA.AggiungiSquadra("Crotone");
		classificaSerieA.AggiungiSquadra("SPAL");
		classificaSerieA.AggiungiSquadra("Torino");
		classificaSerieA.AggiungiSquadra("Sampdoria");
		classificaSerieA.AggiungiSquadra("Chievo");
		classificaSerieA.AggiungiSquadra("Parma");

		classificaSerieA.StampaClassifica();

		classificaSerieA.EsitoPartita("SPAL", 3,"Torino", 1);
		classificaSerieA.EsitoPartita("Chievo", 0,"Sampdoria", 2);
		classificaSerieA.EsitoPartita("Crotone", 1,"Parma", 1);

		classificaSerieA.StampaClassifica();

		System.out.println("Miglior attacco: " + classificaSerieA.getMigliorAttacco());
		System.out.println("Peggior difesa: " + classificaSerieA.getPeggiorDifesa());

	}
}
