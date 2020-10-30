package GestoreVeicoli;

public class GestoreVeicoli {
	public static void main(String[] args) {
		Automobile auto1 = new Automobile("aa000aa", "a", "modello a", 4, 5);
		Automobile auto2 = new Automobile("aa001aa", "a", "modello b", 5, 5);
		Autocarro autocarro = new Autocarro("aa111bb", "c", "modello a", 3, 1000);

		System.out.println(auto1.toString());
		System.out.println(auto2.toString());
		System.out.println(autocarro.toString());
	}
}
