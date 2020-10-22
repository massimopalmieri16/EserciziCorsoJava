package Esercizi;

public class CercaParola {
	public static void main(String[] args) {
		char matrice[][] = {{'h', 's', 'u', 't'},
							{'o', 'o', 'c', 'd'},
							{'l', 's', 'l', 'f'},
							{'a', 'l', 'o', 'h'}};

		System.out.println("Matrice di input:");
		printArray2D(matrice);

		cercaParole(matrice,"hola");
		//cercaParole(matrice,"haaa");

	}

	public static boolean cercaParole(char[][] matrice, String parola) {
		String parola_trovata = "";
		int indice = 0;
		int firstCol = 0;
		int firstRow = 0;

		System.out.println("Cerco parola " + parola);

		for(int row = 0; row < matrice.length; row ++){
			for(int col = 0; col < matrice[0].length; col ++){
				// cerco il primo carattere
				if(matrice[row][col] == parola.charAt(0)){
					parola_trovata = String.valueOf(matrice[row][col]);
					indice = 1;
					firstRow = row;
					firstCol = col;

					System.out.println("Primo carattere '" + parola.charAt(0) + "' trovato a riga " + firstRow + " colonna " + firstCol);

					cerca(' ', '+', firstRow, firstCol, matrice, parola);
					cerca('+', ' ', firstRow, firstCol, matrice, parola);
					/*cerca(' ', '-', firstRow, firstCol, matrice, parola);
					cerca('-', ' ', firstRow, firstCol, matrice, parola);
					cerca('+', '+', firstRow, firstCol, matrice, parola);
					cerca('+', '-', firstRow, firstCol, matrice, parola);
					cerca('-', '+', firstRow, firstCol, matrice, parola);
					cerca('-', '-', firstRow, firstCol, matrice, parola);*/

					/*// Questa versione funziona ma è brutta
					// ciclo sulle colonne +
					for(int i = col + 1; i < matrice[0].length; i ++) {
						if(matrice[row][i] == parola.charAt(indice)){
							System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + row + " colonna " + i);

							parola_trovata += matrice[row][i];
							indice ++;

							if(parola_trovata.length() == parola.length()){
								System.out.println("\"" +parola + "\" trovata a riga " + firstRow + " colonna " + firstCol);
								return true;
							}
						}else{
							System.out.println("Trovato carattere '" + matrice[row][i] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + row + " colonna " + i);
							break;
						}
					}
					// ciclo sulle colonne -
					for(int i = col - 1; i >= 0; i --) {
						if(matrice[row][i] == parola.charAt(indice)){
							System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + row + " colonna " + i);

							parola_trovata += matrice[row][i];
							indice ++;

							if(parola_trovata.length() == parola.length()){
								System.out.println("\"" +parola + "\" trovata a riga " + firstRow + " colonna " + firstCol);
								return true;
							}
						}else{
							System.out.println("Trovato carattere '" + matrice[row][i] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + row + " colonna " + i);
							break;
						}
					}

					// ciclo sulle righe +
					for(int i = row + 1; i < matrice.length; i ++) {
						if(matrice[i][col] == parola.charAt(indice)){
							System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + i + " colonna " + col);

							parola_trovata += matrice[i][col];
							indice ++;

							if(parola_trovata.length() == parola.length()){
								System.out.println("\"" +parola + "\" trovata a riga " + firstRow + " colonna " + firstCol);
								return true;
							}
						}else{
							System.out.println("Trovato carattere '" + matrice[i][col] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + i + " colonna " + col);
							break;
						}
					}
					// ciclo sulle righe -
					for(int i = row - 1; i >= 0; i --) {
						if(matrice[i][col] == parola.charAt(indice)){
							System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + i + " colonna " + col);

							parola_trovata += matrice[i][col];
							indice ++;

							if(parola_trovata.length() == parola.length()){
								System.out.println("\"" +parola + "\" trovata a riga " + firstRow + " colonna " + firstCol);
								return true;
							}
						}else{
							System.out.println("Trovato carattere '" + matrice[i][col] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + i + " colonna " + col);
							break;
						}
					}

					// ciclo in diagonale incrementando sia righe e colonne
					int i = 0;
					int j = 0;
					i = row + 1;
					j = col + 1;

					//cerca('+', '+', matrice);

					while(i < matrice.length && j < matrice[0].length){
						if(matrice[i][j] == parola.charAt(indice)){
							System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);

							parola_trovata += matrice[i][j];
							indice ++;

							if(parola_trovata.length() == parola.length()){
								System.out.println("\"" +parola + "\" trovata a riga " + firstRow + " colonna " + firstCol);
								return true;
							}
						}else{
							System.out.println("Trovato carattere '" + matrice[i][j] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);
							break;
						}
						i ++;
						j ++;
					}
					for(int i = row + 1; i < matrice.length; i ++){
						if(matrice[i][j] == parola.charAt(indice)){
							System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);

							parola_trovata += matrice[i][j];
							indice ++;

							if(parola_trovata.length() == parola.length()){
								System.out.println("\"" +parola + "\" trovata a riga " + firstRow + " colonna " + firstCol);
								return true;
							}
						}else{
							System.out.println("Trovato carattere '" + matrice[i][j] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);
							break;
						}
						j ++;
					}

					// ciclo in diagonale incrementando righe e diminuendo colonne
					*/

				}
			}
		}

		return true;
	}


	public static boolean cerca(char operatore_righe, char operatore_colonne, int first_row, int first_col, char matrice[][], String parola) {
		int i = 0;
		int j = 0;
		i = first_row;
		j = first_col;
		int indice = 1;
		String parola_trovata = String.valueOf(matrice[first_row][first_col]);

		//while(i < matrice.length && j < matrice[0].length && i >= 0 && j >= 0) {
		while(true){
			// incrementare o decrementare indici
			if(operatore_righe == '+') i ++;
			if(operatore_righe == '-') i --;
			if(operatore_colonne == '+') j ++;
			if(operatore_colonne == '-') j --;

			if(i >= matrice.length || j >= matrice[0].length) break;
			if(i < 0 || j < 0) break;

			if(matrice[i][j] == parola.charAt(indice)){
				System.out.println("Trovato carattere '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);

				parola_trovata += matrice[i][j];
				indice ++;

				System.out.println(parola_trovata);

				if(parola_trovata.length() == parola.length()){
					System.out.println("\"" +parola + "\" trovata a riga " + first_row + " colonna " + first_col);
					return true;
				}
			}else{
				System.out.println("Trovato carattere '" + matrice[i][j] + "' diverso da quello in input '" + parola.charAt(indice) + "' a riga " + i + " colonna " + j);
				break;
			}
		}
		return false;
	}

	public static void printArray2D(char[][] arrayInt) {
		for(int i = 0; i < arrayInt.length; i ++) {
			System.out.print("[");
			for (int j = 0; j < arrayInt[0].length; j++) {
				System.out.print(arrayInt[i][j]);
				if (j != arrayInt[0].length - 1) System.out.print(",");
			}
			System.out.println("]");
		}
	}


	// versione vecchia
	/*public static boolean cercaParole(char[][] matrice, String parola) {
		String parola_trovata = "";
		int indice = 0;
		int indiceCol = 0;
		int indiceRow = 0;

		for(int row = 0; row < matrice.length; row ++){
			for(int col = 0; col < matrice[0].length; col ++){
				if(matrice[row][col] == parola.charAt(indice)){
					if(indice == 0){
						indiceCol = col;
						indiceRow = row;
					}
					parola_trovata += matrice[row][col];
					if(indice < parola.length() - 1){
						indice ++;
					}

				}
			}
			if(parola_trovata.length() == parola.length()){
				System.out.println(parola + " trovata a riga " + indiceRow + " colonna " + indiceCol);
				return true;
			}else{
				return false;
			}
		}

		return true;
	}*/
}