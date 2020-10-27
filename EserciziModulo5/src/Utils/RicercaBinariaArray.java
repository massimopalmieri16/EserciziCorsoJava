package Utils;

public class RicercaBinariaArray {
		public static int ricercaBinaria(int [] array, int n, int inizio, int fine){

		int centro = inizio + (fine - inizio) / 2;

		if(centro == inizio || centro == fine) return -1;
		if(array[centro] == n ){
			return centro;
		}else {
			if (array[centro] > n) {
				return ricercaBinaria(array, n, inizio, centro);
			}else {
				return ricercaBinaria(array, n, centro, fine);
			}
		}
	}
}
