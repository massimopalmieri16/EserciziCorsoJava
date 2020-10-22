package Esercizi;

import java.util.Scanner;

public class cercaParolaFinale {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char matricepiccola[][] = {{'a', 'd', 'g', 'u'},
								   {'t', 'l', 'a', 'k'},
								   {'t', 's', 'o', 'k'},
								   {'a', 'l', 'o', 'h'}};
		char matricegrande[][] = {{'h', 'd', 'g', 'u', 'p', 'y', 's', 'p', 'a', 'o',},
							{'t', 's', 'a', 'k', 'o', 'y', 'o', 'l', 'p', 's'},
							{'r', 'c', 'm', 'c', 'n', 'r', 'i', 'a', 'a', 'b'},
							{'i', 'o', 'b', 'a', 'i', 's', 'c', 't', 'l', 'a'},
							{'g', 'r', 'e', 'l', 'f', 'a', 'c', 'e', 'o', 'l'},
							{'l', 'f', 'r', 'a', 'l', 'l', 'u', 's', 'i', 'e'},
							{'i', 'a', 'e', 'm', 'e', 'm', 'l', 's', 'l', 'n'},
							{'a', 'n', 't', 'a', 'd', 'o', 'c', 'a', 'g', 'a'},
							{'j', 'o', 't', 'r', 'b', 'n', 'd', 'g', 'o', 'd'},
							{'l', 'y', 'o', 'o', 'u', 'e', 's', 'm', 's', 'm'}};

		printArray2D(matricegrande);

		while(true) {
			System.out.print("Inserire parola da cercare (0 per uscire): ");
			String parola = sc.nextLine();
			if(parola.compareTo("0") == 0) return;
			if(parola.compareTo("") == 0) continue;

			cercaParole(matricegrande, parola);
		}
	}

	public static int cercaParole(char[][] matrice, String parola) {
		int cont_parole = 0;
		int firstCol = 0;
		int firstRow = 0;

		//System.out.println("Cerco parola \"" + parola + "\"");

		for (int row = 0; row < matrice.length; row++) {
			for (int col = 0; col < matrice[0].length; col++) {
				// cerco il primo carattere
				if (matrice[row][col] == parola.charAt(0)) {
					firstRow = row;
					firstCol = col;

					//System.out.println("Primo carattere '" + parola.charAt(0) + "' trovato a riga " + firstRow + " colonna " + firstCol);

					if(cerca(' ', '+', firstRow, firstCol, matrice, parola)) cont_parole ++;
					if(cerca('+', ' ', firstRow, firstCol, matrice, parola)) cont_parole ++;
					if(cerca(' ', '-', firstRow, firstCol, matrice, parola)) cont_parole ++;
					if(cerca('-', ' ', firstRow, firstCol, matrice, parola)) cont_parole ++;
					if(cerca('+', '+', firstRow, firstCol, matrice, parola)) cont_parole ++;
					if(cerca('+', '-', firstRow, firstCol, matrice, parola)) cont_parole ++;
					if(cerca('-', '+', firstRow, firstCol, matrice, parola)) cont_parole ++;
					if(cerca('-', '-', firstRow, firstCol, matrice, parola)) cont_parole ++;
				}
			}
		}

		if(cont_parole > 0) {
			System.out.println("Ho trovato \"" + parola + "\" " + cont_parole + " volte");
		}else{
			System.out.println("Non ho trovato la parola \"" + parola + "\"");
		}

		return cont_parole;
	}

	// Metodo per cercare genericamente
	public static boolean cerca(char operatore_righe, char operatore_colonne, int first_row, int first_col, char matrice[][], String parola) {
		int i = 0;
		int j = 0;
		i = first_row;
		j = first_col;
		int indice = 1;
		String parola_trovata = String.valueOf(matrice[first_row][first_col]);

		while(true){
			// incrementare o decrementare indici
			if(operatore_righe == '+') i ++;
			if(operatore_righe == '-') i --;
			if(operatore_colonne == '+') j ++;
			if(operatore_colonne == '-') j --;

			if((i >= matrice.length || j >= matrice[0].length) || (i < 0 || j < 0)) break;
			//if(i < 0 || j < 0) break;

			if(matrice[i][j] == parola.charAt(indice)){
				//System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);

				parola_trovata += matrice[i][j];
				indice ++;

				//System.out.println(parola_trovata);

				if(parola_trovata.length() == parola.length()){
					System.out.println("\"" +parola + "\" trovata a riga " + first_row + " colonna " + first_col);
					return true;
				}
			}else{
				//System.out.println("Trovato carattere '" + matrice[i][j] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);
				break;
			}
		}
		return false;
	}

	// Metodo per stampare un array 2D
	public static void printArray2D(char[][] arrayInt) {
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
