package Supermarket;

public class Cliente implements Comparable<Cliente>{
	private int iDCliente;
	private String nome;
	private String coognome;
	private int eta;

	public Cliente(int iDCliente, String nome, String coognome, int eta) {
		this.iDCliente = iDCliente;
		this.nome = nome;
		this.coognome = coognome;
		this.eta = eta;
	}

	@Override
	public String toString() {
		return nome + " " + coognome + " - età: " + eta;
	}

	@Override
	public int compareTo(Cliente o) {
		if(this.eta < o.eta)
			return 1;
		if(this.eta > o.eta)
			return -1;
		return 0;
	}
}
