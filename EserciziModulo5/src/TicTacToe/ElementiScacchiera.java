package TicTacToe;

public enum ElementiScacchiera {
	VUOTO('▯'),PLAYER1('X'),PLAYER2('O');
	private char elemento;

	ElementiScacchiera(char elemento){
		this.elemento = elemento;
	}

	public char toChar(){
		return elemento;
	}
}
