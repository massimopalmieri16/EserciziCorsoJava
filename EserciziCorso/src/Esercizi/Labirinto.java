package Esercizi;

import java.util.Arrays;
import java.util.Scanner;

public class Labirinto {
	public static char labirinto[][] = {{'-', 'W', '-', '-', '-'},
			{'-', 'W', '-', '-', '-'},
			{'P', 'W', 'W', 'W', 'W'},
			{'-', '-', '-', '-', 'E'},
			{'-', 'W', '-', '-', '-'}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean vittoria = false;
		while(!vittoria){
			stampaLabirinto(labirinto);
			System.out.println("Muoviti con WASD");
			vittoria = muovi(sc.next().charAt(0));
		}
	}

	public static boolean muovi(char command) {
		int incremento_righe = 0;
		int incremento_colonne = 0;
		switch (command){
			case 'w':
				incremento_righe = -1;
				break;
			case 'a':
				incremento_colonne = -1;
				break;
			case 's':
				incremento_righe = 1;
				break;
			case 'd':
				incremento_colonne = 1;
				break;
			default:
				System.out.println("Input non valido.");
				return false;
		}

		int[] P_coord = trova('P');
		int[] Next_coord = new int[2];
		Next_coord[0] = P_coord[0] + incremento_righe;
		Next_coord[1] = P_coord[1] + incremento_colonne;
		//System.out.println("Coordinate P " + Arrays.toString(P_coord));



		if((Next_coord[0] >= labirinto.length || Next_coord[1] >= labirinto[0].length)
		|| (Next_coord[0] < 0 || Next_coord[1] < 0)
		|| (labirinto[Next_coord[0]][Next_coord[1]] == 'W'))
			return false;

		if(labirinto[Next_coord[0]][Next_coord[1]] == 'E'){
			System.out.println("Hai vinto!");
			return true;
		}
		labirinto[P_coord[0]][P_coord[1]] = '-';
		labirinto[Next_coord[0]][Next_coord[1]] = 'P';
		return false;

	}

	public static int[] trova(char carattere) {
		int[] coord = {-1,-1};
		for(int row = 0; row < labirinto.length; row ++){
			for(int col = 0; col < labirinto[0].length; col ++){
				if(labirinto[row][col] == carattere) {
					coord[0] = row;
					coord[1] = col;
					return coord;
				}
			}
		}
		return coord;
	}

	public static void stampaLabirinto(char[][] arrayInt) {
		for(int i = 0; i < arrayInt.length; i ++) {
			//System.out.print("[");
			for (int j = 0; j < arrayInt[0].length; j++) {
				System.out.print(arrayInt[i][j]);
				if (j != arrayInt[0].length - 1) System.out.print("  ");
			}
			System.out.println("");
		}
	}
}
