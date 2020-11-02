package Treno;

public class TestTreno {
	public static void main(String[] args) {
		Treno treno1 = new TrenoRegionale("Treno1");

		treno1.entraInStazione();
		treno1.salePassegero();
		treno1.parti();
		treno1.fermati();
		treno1.parti();
		treno1.entraInStazione();
		treno1.scendePassegero();
		treno1.parti();
	}
}
