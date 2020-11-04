package ListaDellaSpesa;

import PrimoBot.ComandoPrimoBot;

public enum ComandoListaDellaSpesa {
	START("/start"), LISTA_DELLA_SPESA("Lista della spesa"),
	AGGIUNGI("Aggiungi"), RIMUOVI("Rimuovi"), ERRORE("Errore");
	private String stringaComando;

	ComandoListaDellaSpesa(String stringaComando){
		this.stringaComando = stringaComando;
	}


	@Override
	public String toString(){
		return stringaComando;
	}

	public static ComandoListaDellaSpesa fromString(String text) {
		if (text != null) {
			for (ComandoListaDellaSpesa c : ComandoListaDellaSpesa.values()) {
				if (text.equals(c.stringaComando)) {
					return c;
				}
			}
		}
		return ComandoListaDellaSpesa.ERRORE;
	}
}

