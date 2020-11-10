package Dictionary;

public class TestDizionario {
	public static void main(String[] args) {
		Dizionario dizionario = new Dizionario();
		dizionario.aggiungiParola("ciao", "significato1");
		dizionario.aggiungiSignificato("ciao", "significato2");
		dizionario.aggiungiParola("cappuccio", "significato1");
		dizionario.aggiungiParola("prova", "significato1");
		dizionario.aggiungiSignificato("sternoicledomastoideo", "significato1");

		dizionario.stampaDizionario();
	}
}
