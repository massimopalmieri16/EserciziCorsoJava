package SpoTreefy;

import java.util.Comparator;

public class CanzoneStorico extends Canzone implements Comparator<CanzoneStorico>, Comparable<CanzoneStorico> {
	private int numAscolti;

	public CanzoneStorico(String titolo, String artista, String album, String genere) {
		super(titolo, artista, album, genere);
		this.numAscolti = 0;
	}

	public void incrAscolti(){
		this.numAscolti ++;
	}

	public int getNumAscolti() {
		return this.numAscolti;
	}

	@Override
	public int compare(CanzoneStorico c1, CanzoneStorico c2) {
		return Integer.compare(c1.getNumAscolti(), c2.getNumAscolti());
	}

	@Override
	public int compareTo(CanzoneStorico c) {
		return Integer.compare(c.getNumAscolti(), this.getNumAscolti());
	}
}
