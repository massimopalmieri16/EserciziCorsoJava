package Anagrafe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Persona {
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String codiceFiscale;
	private String residenza;
	private ArrayList<Persona> figli;

	public Persona(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String residenza) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.residenza = residenza;
		this.figli = new ArrayList<>();
	}

	public String getCF() {
		return codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getData() {
		return dataNascita;
	}

	public String getResidenza() {
		return residenza;
	}

	public ArrayList<Persona> getFigli() {
		return figli;
	}

	public boolean aggiungiFiglio(Persona p){
		if(!figli.contains(p)){
			return figli.add(p);
		}else {
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
  		if (!(o instanceof Persona)) return false;
  		Persona p = (Persona) o;
		return this.codiceFiscale.equals(p.codiceFiscale);
	}

	@Override
	public String toString() {
		return nome + " " + cognome + " " + codiceFiscale;
	}
}
