package CarSharing;

public class TestCarSharing {
	public static void main(String[] args) {
		CarSharing carSharing = new CarSharing();
		Parcheggio parcheggio1 = new Parcheggio("Via Giovanni Brombeis", 50);
		Parcheggio parcheggio2 = new Parcheggio("Via delle vie", 2);
		Utente utente1 = new Utente("mail1", 500);
		Utente utente2 = new Utente("mail2", 200);
		Vettura auto1 = new Automobile("aa01", 4, 5, parcheggio1);
		Vettura auto2 = new Automobile("aa02", 4, 10, parcheggio1);
		Vettura furgone1 = new Furgone("bb01", 2, 6, parcheggio1);
		Vettura furgone2 = new Furgone("bb02", 3, 10, parcheggio1);

		carSharing.aggiungiUtente(utente1);
		carSharing.aggiungiUtente(utente2);
		carSharing.aggiungiVettura(auto1);
		carSharing.aggiungiVettura(auto2);
		carSharing.aggiungiVettura(furgone1);
		carSharing.aggiungiVettura(furgone2);

		System.out.println(carSharing.noleggiaVettura(utente1, auto2, 5));
		carSharing.terminaNoleggio(auto2, parcheggio1);
		System.out.println(carSharing.noleggiaVettura(utente1, auto1, 10));
		carSharing.terminaNoleggio(auto1, parcheggio1);
		System.out.println(carSharing.noleggiaVettura(utente1, furgone1, 10));
		carSharing.terminaNoleggio(furgone1, parcheggio1);
		carSharing.stampaNoleggiUtente(utente1);
		carSharing.stampaStatoVetture();
	}
}
