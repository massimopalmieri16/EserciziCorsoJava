package SpoTreefy;

import java.util.*;

public class Playlist {
	private final String nomePlaylist;
	private final Utente proprietario;
	private HashSet<Canzone> canzoni;

	public Playlist(Utente proprietario, String nomePlaylist, Canzone[] canzoni) {
		this.nomePlaylist = nomePlaylist;
		this.proprietario = proprietario;
		this.canzoni = (canzoni != null) ? (new HashSet<>(Arrays.asList(canzoni))) : (new HashSet<>());
	}

	public boolean aggiungiCanzone(Canzone canzone){
		return canzoni.add(canzone);
	}

	public boolean rimuoviCanzone(Canzone canzone){
		return canzoni.remove(canzone);
	}

	public Utente getProprietario() {
		return proprietario;
	}

	public HashSet<Canzone> getCanzoni() {
		return canzoni;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Playlist playlist = (Playlist) o;
		return Objects.equals(nomePlaylist, playlist.nomePlaylist);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomePlaylist);
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("Playlist: ").append(nomePlaylist);
		for (Canzone canzone : canzoni) {
			out.append(System.lineSeparator()).append(canzone.toString());
		}
		return out.toString();
	}
}
