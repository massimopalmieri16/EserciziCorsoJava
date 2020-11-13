package Facebook;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class Utente {
	private UUID idUtente;
	private String nome;
	private String cognome;
	private LocalDateTime dataIscrizione;
	private HashSet<Utente> amici;

	public Utente(String nome, String cognome) {
		idUtente = UUID.randomUUID();
		this.nome = nome;
		this.cognome = cognome;
		dataIscrizione = LocalDateTime.now();
		amici = new HashSet<>();
	}

	public void aggiungiAmicoRecursion(Utente utente){
		if(amici.add(utente)) {
			utente.aggiungiAmicoRecursion(this);
		}
	}

	public boolean aggiungiAmico(Utente utente){
		return amici.add(utente);
	}

	public boolean rimuoviAmico(Utente utente){
		return amici.remove(utente);
	}

	public boolean rimuoviAmicoRecursion(Utente utente){
		if(amici.remove(utente)){
			if(utente != this) utente.rimuoviAmico(this);
			return true;
		}else {
			return false;
		}
	}

	public void setNomeCognome(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNomeCognome() {
		return nome + " " + cognome;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("Utente: ").append(nome).append(" ").append(cognome).append(", ").append(amici.size())
				.append(" amici, data iscrizione ").append(dataIscrizione.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)))
				.append(" ").append(dataIscrizione.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));

		return out.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Utente)) {
			return false;
		}
		Utente u = (Utente) o;
		return this.nome.equals(u.nome) && this.cognome.equals(u.cognome) && this.idUtente.equals(u.idUtente) && this.dataIscrizione.equals(u.dataIscrizione);
	}
}
