package GestoreVeicoli;

public class Autocarro extends Veicolo{
	private int maxCarico;

	public Autocarro(String targa, String marca, String modello, int numPosti, int maxCarico) {
		super(targa, marca, modello, numPosti);
		this.maxCarico = maxCarico;
	}

	@Override
	public String toString(){
		return targa + " : " + maxCarico;
	}
}
