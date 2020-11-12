package Facebook;

public class TestFacebook {
	public static void main(String[] args) {
		Facebook facebook = new Facebook();

		Utente mario = new Utente("Mario", "Rossi");
		Utente luigi = new Utente("Luigi", "Rossi");
		Utente paolo = new Utente("Paolo", "Paoli");
		facebook.aggiungiUtente(mario);
		facebook.aggiungiUtente(luigi);
		facebook.aggiungiUtente(paolo);
		facebook.aggiungiAmico(mario, luigi);
		facebook.aggiungiAmico(mario, paolo);
		//facebook.stampaUtenti();
		facebook.rimuoviAmico(mario, luigi);
		//facebook.stampaUtenti();
		facebook.aggiungiAmico(mario, luigi);
		mario.setNomeCognome("Mario", "It's me");
		facebook.stampaUtenti();
		Post post1 = new Post(mario, "Primo post");
		facebook.scriviPost(post1);
		facebook.likePost(luigi, post1);
		post1.aggiungiCommento(luigi, "Commento bello");
		facebook.stampaPostUtente(mario);
		facebook.stampaCommentiUtente(luigi);
	}
}
