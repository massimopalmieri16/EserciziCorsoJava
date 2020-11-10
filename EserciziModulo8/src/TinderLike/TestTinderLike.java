package TinderLike;

public class TestTinderLike {
	public static void main(String[] args) {
		TinderLike tinderLike = new TinderLike();
		tinderLike.aggiungiUtente("Mario", new String[]{"Banane", "Libri", "Mare", "Vino"});
		tinderLike.aggiungiUtente("Luigi", new String[]{"Libri", "Mare", "Cibo", "Vino"});
		tinderLike.aggiungiUtente("Renato", new String[]{"Cibo", "Badminton", "Banane"});
		tinderLike.aggiungiUtente("Astolfo", new String[]{"Programmazione"});
		tinderLike.aggiungiUtente("Paolo", new String[]{"Studiare", "Cibo", "Badminton", "Banane"});
		tinderLike.stampaUtenti();

		System.out.println("The match for Mario is \"" + tinderLike.getMatch("Mario") + "\"");
		System.out.println("The match for Paolo is \"" + tinderLike.getMatch("Paolo") + "\"");
		System.out.println("The match for Astolfo is \"" + tinderLike.getMatch("Astolfo") + "\"");
		System.out.println("The match for Renato is \"" + tinderLike.getMatch("Renato") + "\"");
	}
}
