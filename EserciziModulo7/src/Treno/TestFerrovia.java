package Treno;

import java.util.ArrayList;

public class TestFerrovia {
	public static void main(String[] args) {
		ArrayList<Binario> binari = new ArrayList<>();
		binari.add(new BinarioSemplice("1"));
		binari.add(new BinarioSemplice("1"));
		binari.add(new BinarioSemplice("1"));
		binari.add(new BinarioStazione("1", "Stazione1"));

		Treno trenoRegionale = new TrenoRegionale("Treno1");
		Ferrovia ferrovia = new Ferrovia(trenoRegionale, binari);

		ferrovia.percorri(trenoRegionale);
		ferrovia.percorri(trenoRegionale);

	}
}
