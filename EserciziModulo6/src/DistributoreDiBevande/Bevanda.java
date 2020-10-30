package DistributoreDiBevande;

import java.util.Objects;

public class Bevanda {
	private final String nome;
	private final double prezzo;

	Bevanda(String nome, double prezzo){
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public double getPrezzo(){
		return prezzo;
	}

	public boolean comparaBevanda(String nome){
		return nome.equals(this.nome);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Bevanda bevanda = (Bevanda) o;
		return Double.compare(bevanda.prezzo, prezzo) == 0 &&
				Objects.equals(nome, bevanda.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, prezzo);
	}
}
