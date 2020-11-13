package SpoTreefy;

import java.util.Objects;

public class Canzone {
	private String titolo;
	private String artista;
	private String album;
	private String genere;

	public Canzone(String titolo, String artista, String album, String genere) {
		this.titolo = titolo;
		this.artista = artista;
		this.album = album;
		this.genere = genere;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getArtista() {
		return artista;
	}

	public String getAlbum() {
		return album;
	}

	public String getGenere() {
		return genere;
	}

	@Override
	public String toString() {
		return titolo + " - " + artista + " - " + album + " - " + genere;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Canzone canzone = (Canzone) o;
		/*return Objects.equals(titolo, canzone.titolo) &&
				Objects.equals(artista, canzone.artista) &&
				Objects.equals(album, canzone.album) &&
				Objects.equals(genere, canzone.genere);*/
		return titolo.equals(canzone.titolo) &&
				artista.equals(canzone.artista) &&
				album.equals(canzone.album) &&
				genere.equals(canzone.genere);
	}

	@Override
	public int hashCode() {
		return Objects.hash(titolo, artista, album, genere);
	}
}
