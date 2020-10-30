package GestoreVeicoli;

public class Automobile extends Veicolo{
	private int numPorte;

	public Automobile(String targa, String marca, String modello, int numPosti, int numPorte) {
		super(targa, marca, modello, numPosti);
		this.numPorte = numPorte;
	}

	@Override
	public String toString(){
		return targa + " : " + numPorte;
	}
}
