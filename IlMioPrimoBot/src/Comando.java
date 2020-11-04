public enum Comando {
	SALUTA("saluta"), MONOPATTINO("\uD83D\uDEF4"), SCOOTER("\uD83D\uDEF5"),
	MOTO("\uD83C\uDFCD️"), TASTIERA("tastiera"), ERRORE("errore"), START("/start");
	private String stringaComando;

	Comando(String stringaComando){
		this.stringaComando = stringaComando;
	}


	@Override
	public String toString(){
		return stringaComando;
	}

	public static Comando fromString(String text) {
		if (text != null) {
			for (Comando c : Comando.values()) {
				if (text.equals(c.stringaComando) || text.toLowerCase().equals(c.stringaComando)) {
					return c;
				}
			}
		}
		return Comando.ERRORE;
	}
}
