package ListaDellaSpesa;

public class Prodotto {
	private String nome;
	private int quantita;

	public Prodotto(String nome, int quantita) {
		this.nome = nome;
		this.quantita = quantita;
	}

	public String toString(){
		return nome + " " + quantita;
	}

	public String getNome() {
		return nome;
	}
}
