package CarSharing;

import java.util.Objects;

public class Utente {
	private String email;
	private int credito;

	public Utente(String email, int credito) {
		this.email = email;
		this.credito = credito;
	}

	public String getEmail() {
		return email;
	}

	public int getCredito() {
		return credito;
	}

	public void pagaNoleggio(int importo){
		credito -= importo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Utente utente = (Utente) o;
		return Objects.equals(email, utente.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
}
