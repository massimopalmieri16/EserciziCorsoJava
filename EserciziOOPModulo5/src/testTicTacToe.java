public class testTicTacToe {
	public static void main(String[] args) {
		Scacchiera scacchiera = new Scacchiera();

		while(true) {
			scacchiera.stampaScacchiera();
			scacchiera.inserisciElementoP1();
			if(scacchiera.finePartita()) break;
			scacchiera.stampaScacchiera();
			scacchiera.inserisciElementoP2();
			if(scacchiera.finePartita()) break;
		}
	}
}
