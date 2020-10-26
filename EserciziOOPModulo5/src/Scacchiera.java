import java.util.Scanner;

public class Scacchiera {
	char[][] scacchiera = new char[3][3];
	Scanner sc = new Scanner(System.in);

	Scacchiera(){
		for(int row = 0; row < scacchiera.length; row ++){
			for(int col = 0; col < scacchiera[0].length; col ++){
				scacchiera[row][col] = ElementiScacchiera.VUOTO.toChar();
			}
		}
	}

	// metodo che ritorna true se la partita è finita
	public boolean finePartita(){
		char charP1 = ElementiScacchiera.PLAYER1.toChar();
		char charP2 = ElementiScacchiera.PLAYER2.toChar();
		if(trovaTris(charP1) || trovaTris(charP2) || !cercaVuoto()) {
			stampaScacchiera();
			System.out.println("Fine partita");
			return true;
		}
		return false;
	}

	// metodo che cerca l'elemento VUOTO
	public boolean cercaVuoto() {
		for(int row = 0; row < scacchiera.length; row ++){
			for(int col = 0; col < scacchiera[0].length; col ++){
				if(scacchiera[row][col] == ElementiScacchiera.VUOTO.toChar()) return true;
			}
		}
		return false;
	}

	public boolean trovaTris(char elemento) {
		if(scacchiera[0][0] == elemento && scacchiera[0][1] == elemento && scacchiera[0][2] == elemento) return true;
		if(scacchiera[1][0] == elemento && scacchiera[1][1] == elemento && scacchiera[1][2] == elemento) return true;
		if(scacchiera[2][0] == elemento && scacchiera[2][1] == elemento && scacchiera[2][2] == elemento) return true;
		if(scacchiera[0][0] == elemento && scacchiera[1][0] == elemento && scacchiera[2][0] == elemento) return true;
		if(scacchiera[0][1] == elemento && scacchiera[1][1] == elemento && scacchiera[2][1] == elemento) return true;
		if(scacchiera[0][2] == elemento && scacchiera[1][2] == elemento && scacchiera[2][2] == elemento) return true;
		if(scacchiera[0][0] == elemento && scacchiera[1][1] == elemento && scacchiera[2][2] == elemento) return true;
		if(scacchiera[2][0] == elemento && scacchiera[1][1] == elemento && scacchiera[0][2] == elemento) return true;
		return false;
	}
	public boolean inserisciElementoP1(){
		return inserisciElemento(1);
	}
	public boolean inserisciElementoP2(){
		return inserisciElemento(2);
	}
	private boolean inserisciElemento(int player) {
		System.out.println("Turno del Player " + player + ", inserisci riga");

		int row = sc.nextInt();
		System.out.println("Inserisci colonna");
		int col = sc.nextInt();
		if(row >= 0 && col >= 0 && row < scacchiera.length && col < scacchiera[0].length && scacchiera[row][col] == ElementiScacchiera.VUOTO.toChar()){
			if(player == 1){
				scacchiera[row][col] = ElementiScacchiera.PLAYER1.toChar();
			}else{
				scacchiera[row][col] = ElementiScacchiera.PLAYER2.toChar();
			}
			return true;
		}else{
			System.out.println("Input errati");
			return inserisciElemento(player);
		}
	}

	public void stampaScacchiera(){
		for(int row = 0; row < scacchiera.length; row ++){
			for(int col = 0; col < scacchiera[0].length; col ++){
				System.out.print(scacchiera[row][col] + "  ");
			}
			System.out.println("");
		}
	}
}
