package Treno;

public class TestTreno {
	public static void main(String[] args) {
		Treno trenoRegionale = new TrenoRegionale("Treno1");
		trenoRegionale.entraInStazione();
		System.out.println(trenoRegionale.addVagone(new VagonePasseggeri(20)));
		System.out.println(!trenoRegionale.addVagone(new VagoneLetto(25)));
		System.out.println(trenoRegionale.addVagone(new VagonePasseggeri(15)));
		System.out.println(trenoRegionale.removeVagone(1));
		System.out.println(trenoRegionale.addVagone(new VagonePasseggeri(20)));
		System.out.println(trenoRegionale.addVagone(new VagonePasseggeri(20)));
		System.out.println(trenoRegionale.addVagone(new VagonePasseggeri(20)));
		Passeggero passeggero1 = new Passeggero("Andrea", "aaa001", TipoVagone.PASSEGGERO);
		System.out.println(trenoRegionale.salePassegero(passeggero1, 0));
		System.out.println(trenoRegionale.scendePassegero(passeggero1, 0));
		System.out.println(trenoRegionale.salePassegero(new Passeggero("p1", "aaa012", TipoVagone.PASSEGGERO), 0));
		System.out.println(trenoRegionale.salePassegero(new Passeggero("p2", "aaa013", TipoVagone.PASSEGGERO), 0));
		System.out.println(trenoRegionale.salePassegero(new Passeggero("p3", "aaa014", TipoVagone.LETTO), 1));
		System.out.println(trenoRegionale.salePassegero(new Passeggero("p4", "aaa015", TipoVagone.RISTORANTE), 1));
		trenoRegionale.parti();

		Treno frecciaRossa = new FrecciaRossa("Treno2");
		frecciaRossa.entraInStazione();
		System.out.println(frecciaRossa.addVagone(new VagoneRistorante(20)));
		System.out.println(frecciaRossa.addVagone(new VagoneLetto(20)));
		System.out.println(frecciaRossa.addVagone(new VagonePasseggeri(20)));
		Passeggero passeggero2 = new Passeggero("Luigi", "aaa002", TipoVagone.RISTORANTE);
		System.out.println(frecciaRossa.salePassegero(passeggero2, 0));
		System.out.println(frecciaRossa.scendePassegero(passeggero2, 0));
		System.out.println(!frecciaRossa.salePassegero(new Passeggero("Mario", "aaa003", TipoVagone.PASSEGGERO), 1));
		System.out.println(frecciaRossa.salePassegero(new Passeggero("Marco", "aaa004", TipoVagone.LETTO), 1));
		System.out.println(!frecciaRossa.salePassegero(new Passeggero("Giovanni", "aaa005", TipoVagone.RISTORANTE), 1));
	}
}
