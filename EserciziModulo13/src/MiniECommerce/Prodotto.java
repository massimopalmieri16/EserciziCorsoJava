package MiniECommerce;

import java.util.Objects;
import java.util.UUID;

public class Prodotto {
	private UUID id;
	private String nome;
	private String descrizione;
	private int quantitaDisponibile;
	private double prezzo;

	public Prodotto(String nome, String descrizione, int quantitaDisponibile, double prezzo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.quantitaDisponibile = quantitaDisponibile;
		this.prezzo = prezzo;
		this.id = UUID.randomUUID();
	}

	public void genId() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public int getQuantita() {
		return quantitaDisponibile;
	}

	public void incrQuantita(int quantita){
		this.quantitaDisponibile += quantita;
	}

	public void acquista(int quantita){
		this.quantitaDisponibile -= quantita;
	}

	@Override
	public String toString() {
		return "Prodotto: " + nome + " quantità: " + quantitaDisponibile + " prezzo: " + prezzo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Prodotto prodotto = (Prodotto) o;
		return Objects.equals(nome, prodotto.nome) &&
				Objects.equals(descrizione, prodotto.descrizione) &&
				Objects.equals(prezzo, prodotto.prezzo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}
}
