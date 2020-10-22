package Esercizi;

public class Tombola {
	public static void main(String[] args) {
		int[][] cartella = {{5,10,7},{27,24,21},{35,48,52},{62,57,56},{74,80,85}};
		System.out.println("Numeri cartella");
		printArray2D(cartella);

		int[] estratti = {1,5,3,23,34,61,48,63,39,24,13,17,60,52,18,53,37,67,74};
		System.out.println("Numeri cartella");
		printArray(estratti);

		tombola(cartella,estratti);
		printArray2D(cartella);

	}

	public static void tombola(int[][] cartella, int[] estratti) {
		int cont_ambo = 0;
		int cont_tern = 0;
		int cont_quat = 0;
		int cont_cinq = 0;

		// ciclo numeri estratti
		for(int i = 0; i < estratti.length - 1; i++){
			// ciclo matrice
			for(int j = 0; j < cartella[0].length - 1; j ++){
				for(int k = 0; k < cartella.length; k ++){
					if(estratti[i] == cartella[k][j]){
						cartella[k][j] = -1;
					}
				}
			}
		}

		// controllo ambi terni ecc.
		for(int j = 0; j < cartella[0].length - 1; j ++){
			for(int k = 0; k < cartella.length - 1; k ++){
				//cartella[k][j];
			}
		}


	}





	public static void printArray2D(int[][] arrayInt) {
			for(int i = 0; i < arrayInt.length; i ++) {
			System.out.print("[");
			for (int j = 0; j < arrayInt[0].length; j++) {
				System.out.print(arrayInt[i][j]);
				if (j != arrayInt[0].length - 1) System.out.print(",");
			}
			System.out.println("]");
		}
	}
	public static void printArray(int[] arrayInt) {
		System.out.print("[");
		for(int i=0; i < arrayInt.length; i ++){
			System.out.print(arrayInt[i]);
			if(i != arrayInt.length - 1) System.out.print(",");
		}
		System.out.println("]");
	}
}
