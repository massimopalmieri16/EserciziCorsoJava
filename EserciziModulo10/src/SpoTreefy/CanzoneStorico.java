package SpoTreefy;

public class CanzoneStorico extends Canzone implements Comparable<CanzoneStorico> {
	private int numAscolti;

	public CanzoneStorico(String titolo, String artista, String album, String genere) {
		super(titolo, artista, album, genere);
		numAscolti = 0;
	}

	public void incrAscolti(){
		numAscolti ++;
	}

	public int getNumAscolti() {
		return numAscolti;
	}

	@Override
	public int compareTo(CanzoneStorico c) {
		return -Integer.compare(this.numAscolti, c.numAscolti);
	}
}
